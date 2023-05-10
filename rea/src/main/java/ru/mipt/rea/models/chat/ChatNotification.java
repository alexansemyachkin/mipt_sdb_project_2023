package ru.mipt.rea.models.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChatNotification {

    private String id;

    private int senderId;

    private int senderName;

}