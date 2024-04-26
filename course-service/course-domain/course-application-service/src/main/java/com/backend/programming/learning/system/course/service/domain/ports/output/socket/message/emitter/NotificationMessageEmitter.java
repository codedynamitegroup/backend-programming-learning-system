package com.backend.programming.learning.system.course.service.domain.ports.output.socket.message.emitter;

public interface NotificationMessageEmitter<T> {
    public void emit(String room, String eventName, T message);
}
