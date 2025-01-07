package com.ll.chatai.domain.AI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AIChatResponse {
    private String id;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isMyMessage;
}
