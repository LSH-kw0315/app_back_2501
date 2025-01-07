package com.ll.chatai.domain.chatRoom.dto;


import com.ll.chatai.domain.chatMessage.dto.ChatMessageDTO;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDTO {
    private Long id;
    private String name;
    private LocalDateTime createDate;
    private List<ChatMessageDTO> chatMessages;

    public ChatRoomDTO(ChatRoom chatRoom){
        this.id=chatRoom.getId();
        this.name=chatRoom.getName();
        this.createDate=chatRoom.getCreatedAt();
        this.chatMessages= chatRoom.getChatMessages().stream()
                .map(msg->new ChatMessageDTO(msg))
                .collect(Collectors.toList());
    }
}
