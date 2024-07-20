package com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message;


public interface NotificationMessageEmitter<T> {
    void emit(String room, String eventName, T message);
    void broadcast(String eventName, T message);
}
