package com.ll.chatai.domain.AI.service;

import com.ll.chatai.domain.AI.entity.AIRoom;
import com.ll.chatai.domain.AI.repository.AIRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIRoomService {
    private final AIRoomRepository aiRoomRepository;

    public AIRoom findByName(String roomName) {
        return aiRoomRepository.findAIRoomByName(roomName);
    }

    public AIRoom create(String roomName) {
        AIRoom aiRoom= AIRoom.builder()
                .name(roomName)
                .build();
        aiRoomRepository.save(aiRoom);
        return aiRoom;
    }
}
