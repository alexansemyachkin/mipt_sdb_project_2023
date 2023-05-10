package ru.mipt.rea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mipt.rea.models.chat.ChatRoom;
import ru.mipt.rea.repos.ChatRoomRepository;

import java.util.Optional;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public String getChatId(int senderId, int recipientId) {
        ChatRoom ChatRoom = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        return ChatRoom.getChatId();
    }
}
