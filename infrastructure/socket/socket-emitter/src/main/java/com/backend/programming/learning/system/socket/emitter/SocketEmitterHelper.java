package com.backend.programming.learning.system.socket.emitter;

import com.backend.programming.learning.system.socket.emitter.service.SocketEmitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketEmitterHelper<K> {

    private final SocketEmitterService<K> socketEmitterService;

    public SocketEmitterHelper(SocketEmitterService<K> socketEmitterService) {
        this.socketEmitterService = socketEmitterService;
    }

    public void emitMessage(String room, String eventName, K message) {
        log.info("Emitting message to room: {} with event name: {} and message: {}", room, eventName, message);
        socketEmitterService.sendMessage(room, eventName, message);
    }
}
