package com.ll.chatai.domain.chatRoom.dto.response;

import com.ll.chatai.domain.chatRoom.dto.ChatRoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomListResponse {
    List<ChatRoomDTO> chatRooms;
}
