package ru.mipt.rea.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.mipt.rea.models.chat.ChatMessage;
import ru.mipt.rea.models.chat.ChatNotification;
import ru.mipt.rea.service.ChatRoomService;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatId(chatMessage.getSenderId(), chatMessage.getRecipientId());
        chatMessage.setChatId(chatId);
        int messageId = chatMessage.getId();
        int senderId = chatMessage.getSenderId();
        int recipientId = chatMessage.getRecipientId();
        messagingTemplate.convertAndSendToUser(String.valueOf(chatMessage.getRecipientId()),
                                     "/queue/messages",
                                               new ChatNotification(messageId, senderId, recipientId));
    }



}
