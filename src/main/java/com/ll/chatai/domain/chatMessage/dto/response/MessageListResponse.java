package com.ll.chatai.domain.chatMessage.dto.response;


import com.ll.chatai.domain.chatMessage.dto.ChatMessageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageListResponse {
    List<ChatMessageDTO> chatMessages;
}
