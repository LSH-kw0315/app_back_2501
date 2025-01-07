package com.ll.chatai.domain.chatMessage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageSTOMPRequest {
    private Long id;
    private String author;
    private String content;
}
