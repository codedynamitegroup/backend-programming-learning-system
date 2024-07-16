package com.backend.programming.learning.system.socket.emitter.service;


public interface SocketEmitterService<K> {
    void sendMessage(String room, String eventName, K message);
    void broadcastMessage(String eventName, K message);
}
