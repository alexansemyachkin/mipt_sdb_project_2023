package ru.mipt.rea.models.chat;

import java.util.Date;

public class ChatMessage {

    private Long id;
    private String chatId;
    private int senderId;
    private int recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private Date timestamp;
    private MessageStatus status;
}
