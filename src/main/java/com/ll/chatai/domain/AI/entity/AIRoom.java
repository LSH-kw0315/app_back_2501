package com.ll.chatai.domain.AI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chatai.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class AIRoom extends BaseEntity {
    String name;

    @OneToMany(mappedBy = "aiRoom")
    @JsonIgnore
    List<AIChat> chatList;
}
