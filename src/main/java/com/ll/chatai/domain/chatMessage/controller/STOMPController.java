package com.ll.chatai.domain.chatMessage.controller;

import com.ll.chatai.domain.chatMessage.dto.request.ChatMessageSTOMPRequest;
import com.ll.chatai.domain.chatMessage.entity.ChatMessage;
import com.ll.chatai.domain.chatMessage.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        origins = {"https://cdpn.io/","http://localhost:5173/"}
)
public class STOMPController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/{roomId}")
    public void writeMessageSTOMP(@DestinationVariable("roomId") Long roomId,
                                  @RequestBody ChatMessageSTOMPRequest request
    ){ //추후 RequestBody로 메시지를 받음
        System.out.println("메시지 매핑");
        ChatMessage chatMessage=chatMessageService.write(roomId,request.getAuthor(),request.getContent());
        String link="/app/chat/"+roomId;
        messagingTemplate.convertAndSend(link,chatMessage);
    }
}
