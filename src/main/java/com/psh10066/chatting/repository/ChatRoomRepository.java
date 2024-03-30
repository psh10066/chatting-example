package com.psh10066.chatting.repository;

import com.psh10066.chatting.dto.ChatRoom;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatRoomRepository {

    private final List<ChatRoom> chatRooms = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            ChatRoom chatRoom = new ChatRoom("채팅방" + i);
            this.chatRooms.add(chatRoom);
        }
    }

    public List<ChatRoom> findAll() {
        return this.chatRooms;
    }

    public ChatRoom findById(String roomId) {
        return chatRooms.stream().filter(chatRoom -> chatRoom.getRoomId().equals(roomId)).findFirst().orElse(null);
    }
}
