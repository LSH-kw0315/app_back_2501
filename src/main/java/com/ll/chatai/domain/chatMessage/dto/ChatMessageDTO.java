package com.ll.chatai.domain.chatMessage.dto;


import com.ll.chatai.domain.chatMessage.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {

    private Long id;
    private String writerName;
    private String content;
    private LocalDateTime createDate;

    public ChatMessageDTO(ChatMessage chatMessage){
        this.id=chatMessage.getId();
        this.writerName=chatMessage.getAuthor();
        this.content=chatMessage.getContent();
        this.createDate=chatMessage.getCreatedAt();
    }
}
