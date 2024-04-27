package com.backend.programming.learning.system.course.service.socket.emitter.message;

import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import com.backend.programming.learning.system.socket.emitter.SocketEmitterHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationMessageEmitterImpl<T> implements NotificationMessageEmitter<T> {

    private final SocketEmitterHelper<T> socketEmitterHelper;

    public NotificationMessageEmitterImpl(SocketEmitterHelper<T> socketEmitterHelper) {
        this.socketEmitterHelper = socketEmitterHelper;
    }

    @Override
    public void emit(String room, String eventName, T message) {
        log.info("Emitting message to room: {} with event name: {} and message: {}", room, eventName, message);
        socketEmitterHelper.emitMessage(room, eventName, message);
    }
}
