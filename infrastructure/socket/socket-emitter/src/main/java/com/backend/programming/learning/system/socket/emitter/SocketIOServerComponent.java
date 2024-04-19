package com.backend.programming.learning.system.socket.emitter;

import com.backend.programming.learning.system.socket.config.data.SocketConfigData;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerComponent {
    private final SocketConfigData socketConfigData;

    public SocketIOServerComponent(SocketConfigData socketConfigData) {
        this.socketConfigData = socketConfigData;
    }

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(socketConfigData.getHost());
        config.setPort(socketConfigData.getPort());
        return new com.corundumstudio.socketio.SocketIOServer(config);
    }
}
