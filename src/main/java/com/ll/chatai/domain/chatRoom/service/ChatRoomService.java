package com.ll.chatai.domain.chatRoom.service;


import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.domain.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom create(String name) {
        ChatRoom chatRoom=ChatRoom.builder()
                .name(name)
                .build();

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

    public ChatRoom find(Long roomId) {
        ChatRoom chatRoom=chatRoomRepository.findById(roomId).orElse(null);
        return chatRoom;
    }
}
