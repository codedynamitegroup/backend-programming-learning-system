package com.backend.programming.learning.system.course.service.socket;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SocketServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOServer socketIOServer;

    @Override
    public void run(String[] args) {
        try {
            socketIOServer.start();
        } catch (Exception e) {
            log.error("Socket server host not found", e);
        }
    }
}
