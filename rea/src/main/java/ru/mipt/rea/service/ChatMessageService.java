package ru.mipt.rea.service;

import org.springframework.stereotype.Service;
import ru.mipt.rea.models.chat.ChatMessage;
import ru.mipt.rea.repos.ChatMessageRepo;

@Service
public class ChatMessageService {

    private ChatMessageRepo chatMessageRepo;

    private ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessageRepo.save(chatMessage);
        return chatMessage;
    }

}
