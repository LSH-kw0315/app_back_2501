package com.ll.chatai.domain.AI.controller;


import com.ll.chatai.domain.AI.dto.request.AIChatRequest;
import com.ll.chatai.domain.AI.dto.response.AIChatResponse;
import com.ll.chatai.domain.AI.entity.AIChat;
import com.ll.chatai.domain.AI.entity.AIRoom;
import com.ll.chatai.domain.AI.service.AIChatService;
import com.ll.chatai.domain.AI.service.AIRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/ai")
@RequiredArgsConstructor
@CrossOrigin(
        origins = {"https://cdpn.io/","http://localhost:5173/","https://app-front-2501.vercel.app/"}
)
public class AIChatController {
    private final OpenAiChatModel openAiChatModel;
    private final AIChatService aiChatService;
    private final AIRoomService aiRoomService;

    @PostMapping("/{roomName}")
    public AIChatResponse chat(@PathVariable("roomName") String roomName,@RequestBody AIChatRequest request){
        AIRoom aiRoom=aiRoomService.findByName(roomName);

        aiChatService.saveUserMessage(request.getContent(),aiRoom);

        int id=Integer.parseInt(request.getId().substring(3));
        String resp_id="msg"+(id+1);
        String openAiResponse=openAiChatModel.call(request.getContent());

        AIChat msg=aiChatService.saveAIMessage(openAiResponse,aiRoom);
        return new AIChatResponse(resp_id,msg.getContent(), msg.getCreatedAt(),msg.getIsMyMessage());
    }

    @GetMapping("/{roomName}")
    public List<AIChat> showChats(@PathVariable("roomName") String roomName){
        AIRoom aiRoom=aiRoomService.findByName(roomName);
        if(aiRoom==null){
            aiRoom=aiRoomService.create(roomName);
        }
        return aiRoom.getChatList();
    }


}
