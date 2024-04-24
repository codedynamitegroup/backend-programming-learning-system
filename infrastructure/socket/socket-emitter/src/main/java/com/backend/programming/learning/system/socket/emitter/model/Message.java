package com.backend.programming.learning.system.socket.emitter.model;

import lombok.Data;

@Data
public class Message<K> {
    private MessageType type;
    private K message;
    private String room;

    public Message() {
    }

    public Message(MessageType type, K message) {
        this.type = type;
        this.message = message;
    }
}
