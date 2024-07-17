package com.backend.programming.learning.system.socket.emitter.service.impl;

import com.backend.programming.learning.system.socket.emitter.model.Message;
import com.backend.programming.learning.system.socket.emitter.model.MessageType;
import com.backend.programming.learning.system.socket.emitter.service.SocketEmitterService;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketEmitterServiceImpl<K> implements SocketEmitterService<K> {

    private final SocketIOServer server;

    public SocketEmitterServiceImpl(SocketIOServer server) {
        this.server = server;
    }

    public void sendMessage(String room, String eventName, K message) {
        server.getRoomOperations(room).sendEvent(eventName, new Message<K>(MessageType.SERVER, message));
    }

    public void broadcastMessage(String eventName, K message) {
        server.getBroadcastOperations().sendEvent(eventName, new Message<K>(MessageType.SERVER, message));
    }
}
