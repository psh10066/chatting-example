package com.psh10066.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatMessage {

    private String roomId;
    private String writer;
    private String message;
}
