package com.ll.chatai.domain.chatMessage.controller;

import com.ll.chatai.domain.chatMessage.dto.request.ChatMessageRequest;
import com.ll.chatai.domain.chatMessage.entity.ChatMessage;
import com.ll.chatai.domain.chatMessage.service.ChatMessageService;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.domain.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms")
@CrossOrigin(
        origins = {"https://cdpn.io/","http://localhost:5173/","https://app-front-2501.vercel.app/"}
)
public class APIV1ChatMessageController {
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @GetMapping("/{chatRoomId}/messages")
    public List<ChatMessage> getMessages(@PathVariable("chatRoomId") Long roomId,
                                                   @RequestParam(value = "afterChatMessageId",defaultValue = "0") long afterMessageId){
        ChatRoom chatRoom=chatRoomService.find(roomId);
        List<ChatMessage> messages=chatRoom.getChatMessages();

        List<ChatMessage> result= new ArrayList<>(messages);

//        List<ChatMessageDTO> resultList=
//                messages.stream()
//                        .map(msg->new ChatMessageDTO(msg))
//                        .collect(Collectors.toList());

        int afterIdIdx=
        IntStream.range(0,messages.size())
                .filter(i -> messages.get(i).getId().equals(afterMessageId))
                .findFirst()
                .orElse(-1);

        if(afterIdIdx != -1){
            result=result.subList(afterIdIdx+1,messages.size());
        }

        return result;
    }

    @PostMapping("/{chatRoomId}/messages")
    public ChatMessage writeMessageHTTP(@PathVariable("chatRoomId") Long roomId,
                                                    @RequestBody ChatMessageRequest request
                               ){ //추후 RequestBody로 메시지를 받음
        System.out.println("여기로 포스트 매핑이 들어옴");
        ChatMessage chatMessage=chatMessageService.write(roomId,request.getAuthor(),request.getContent());
        return chatMessage;
    }




}
