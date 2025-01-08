package com.ll.chatai.domain.chatMessage.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chatai.domain.chatRoom.entity.ChatRoom;
import com.ll.chatai.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    private String author;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ChatRoom chatRoom;

    private String client;
}
