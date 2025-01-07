package com.ll.chatai.domain.chatRoom.dto.response;

import com.ll.chatai.domain.chatRoom.dto.ChatRoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomResponse {
    private ChatRoomDTO chatRoom;
}
