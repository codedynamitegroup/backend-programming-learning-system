package com.backend.programming.learning.system.course.service.socket.emitter.message;

import com.backend.programming.learning.system.socket.emitter.SocketEmitterHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationMessageEmitter<K> {

    private final SocketEmitterHelper<K> socketEmitterHelper;

    public NotificationMessageEmitter(SocketEmitterHelper<K> socketEmitterHelper) {
        this.socketEmitterHelper = socketEmitterHelper;
    }

    public void emit(String room, String eventName, K message) {
        log.info("Emitting notification message to room: {} with event name: {} and message: {}", room, eventName, message);
        socketEmitterHelper.emitMessage(room, eventName, message);
    }
}
