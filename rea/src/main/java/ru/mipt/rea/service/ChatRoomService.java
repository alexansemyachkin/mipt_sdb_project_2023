package ru.mipt.rea.service;

import org.springframework.stereotype.Service;
import ru.mipt.rea.models.chat.ChatRoom;
import ru.mipt.rea.repos.ChatRoomRepo;

@Service
public class ChatRoomService {

    private ChatRoomRepo chatRoomRepo;

    public String getChatId(int senderId, int recipientId) {
        ChatRoom ChatRoom = chatRoomRepo.findBySenderIdAndRecipientId(senderId, recipientId);
        return ChatRoom.getChatId();
    }
}
