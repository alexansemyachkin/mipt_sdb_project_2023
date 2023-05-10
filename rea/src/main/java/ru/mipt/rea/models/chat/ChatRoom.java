package ru.mipt.rea.models.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mipt.rea.models.Role;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChatRoom {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String chatId;

    @Column(nullable = false)
    private int senderId;

    @Column(nullable = false)
    private int recipientId;

}