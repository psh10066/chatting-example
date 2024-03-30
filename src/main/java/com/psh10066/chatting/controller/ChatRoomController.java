package com.psh10066.chatting.controller;

import com.psh10066.chatting.repository.ChatRoomRepository;
import com.psh10066.chatting.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", chatRoomRepository.findAll());
        return "chat/rooms";
    }

    @GetMapping("/room/{roomId}")
    public String room(@PathVariable String roomId, Model model) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId);
        if (chatRoom == null) {
            return "redirect:/chat/rooms";
        }
        model.addAttribute("room", chatRoom);
        return "chat/room";
    }
}
