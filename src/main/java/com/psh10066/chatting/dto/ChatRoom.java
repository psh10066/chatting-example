package com.psh10066.chatting.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ChatRoom {

    private String roomId;
    private String name;

    public ChatRoom(String name) {
        this.roomId = UUID.randomUUID().toString();
        this.name = name;
    }
}
