package com.ll.chatai.domain.AI.service;

import com.ll.chatai.domain.AI.entity.AIChat;
import com.ll.chatai.domain.AI.entity.AIRoom;
import com.ll.chatai.domain.AI.repository.AIChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIChatService {
    private final AIChatRepository aiChatRepository;

    public void saveUserMessage(String content, AIRoom aiRoom) {
        AIChat userMsg=AIChat.builder().isMyMessage(true)
                .aiRoom(aiRoom)
                .content(content)
                .build();

        aiChatRepository.save(userMsg);
    }

    public AIChat saveAIMessage(String content, AIRoom aiRoom) {
        AIChat aiMsg=AIChat.builder().isMyMessage(false)
                .aiRoom(aiRoom)
                .content(content)
                .build();

        aiChatRepository.save(aiMsg);

        return aiMsg;

    }

    public List<AIChat> findAll(){
        return aiChatRepository.findAll();
    }
}
