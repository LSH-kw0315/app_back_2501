package com.ll.chatai.domain.AI.repository;

import com.ll.chatai.domain.AI.entity.AIRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIRoomRepository extends JpaRepository<AIRoom, Long> {
    AIRoom findAIRoomByName(String roomName);
}
