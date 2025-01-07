package com.ll.chatai.domain.AI.repository;

import com.ll.chatai.domain.AI.entity.AIChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIChatRepository extends JpaRepository<AIChat,Long> {
}
