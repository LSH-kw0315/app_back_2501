package com.ll.chatai.domain.chatMessage.service;

import com.ll.chatai.domain.chatMessage.entity.ChatMessage;
import com.ll.chatai.domain.chatMessage.repository.ChatMessageRepository;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.domain.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatMessage write(Long roomId, String writerName, String content) {
        ChatRoom chatRoom=chatRoomRepository.findById(roomId).orElse(null);
        if(chatRoom==null){
            return null;
        }

        ChatMessage message=ChatMessage.builder()
                .chatRoom(chatRoom)
                .author(writerName)
                .content(content)
                .build();

        chatMessageRepository.save(message);
        return message;


    }
}
