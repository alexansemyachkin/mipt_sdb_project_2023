package ru.mipt.rea.models.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChatMessage {

    @Id
    private int id;

    private String chatId;

    private int senderId;

    private int recipientId;

    private String senderName;

    private String recipientName;

    private String content;

    private Date timestamp;

    private MessageStatus status;

}
