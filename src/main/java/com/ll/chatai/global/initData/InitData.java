package com.ll.chatai.global.initData;

import com.ll.chatai.domain.chatMessage.service.ChatMessageService;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.domain.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Random;
import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class InitData {

    //@Bean
    public ApplicationRunner init(ChatRoomService chatRoomService, ChatMessageService chatMessageService){
        return args->{
            ChatRoom chatRoom1=chatRoomService.create("공부");
            ChatRoom chatRoom2=chatRoomService.create("운동");
            ChatRoom chatRoom3=chatRoomService.create("취미");

            ChatRoom[] rooms={chatRoom1,chatRoom2,chatRoom3};

            Random random=new Random(System.currentTimeMillis());
            IntStream.rangeClosed(1,100)
                    .forEach( i-> {
                                Long roomId = rooms[random.nextInt(3)].getId();
                                chatMessageService.write(roomId,"유저"+i,"내용"+i);
                            }
                    );
        };

    }
}
