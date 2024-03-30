package com.psh10066.chatting.controller;

import com.psh10066.chatting.dto.ChatMessage;
import com.psh10066.chatting.dto.ChatOpenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChattingController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/enter")
    public void enter(ChatOpenDTO chatInfo) {
        ChatMessage chatMessage = new ChatMessage(chatInfo.getRoomId(), chatInfo.getWriter(), chatInfo.getWriter() + "님이 입장하셨습니다.");
        this.sendMessage(chatMessage);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessage chatMessage) {
        this.sendMessage(chatMessage);
    }

    private void sendMessage(ChatMessage chatMessage) {
        simpMessagingTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(), chatMessage);
    }
}
