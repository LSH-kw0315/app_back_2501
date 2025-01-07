package com.ll.chatai.domain.AI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AIChatRequest {
    private String id;
    private String content;
}
