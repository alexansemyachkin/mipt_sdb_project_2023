package ru.mipt.rea.models.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessage {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String chatId;

    @Column(nullable = false)
    private int senderId;

    @Column(nullable = false)
    private int recipientId;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String recipientName;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Date timestamp;

}
