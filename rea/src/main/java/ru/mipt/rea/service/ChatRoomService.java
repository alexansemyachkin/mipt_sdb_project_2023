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

    public Optional<String> getChatId(int senderId, int recipientId) {
        Optional<ChatRoom> optionalChatRoom = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        if (optionalChatRoom.isPresent()) {
            ChatRoom chatRoom = optionalChatRoom.get();
            return Optional.ofNullable(chatRoom.getChatId());
        } else {
            return Optional.empty();
        }
    }
}
