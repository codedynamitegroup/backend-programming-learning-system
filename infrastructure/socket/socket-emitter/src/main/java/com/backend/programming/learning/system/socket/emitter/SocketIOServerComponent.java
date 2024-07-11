package com.backend.programming.learning.system.socket.emitter;

import com.backend.programming.learning.system.socket.config.SocketConfigData;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Component
public class SocketIOServerComponent {
    private final SocketConfigData socketConfigData;

    public SocketIOServerComponent(SocketConfigData socketConfigData) {
        this.socketConfigData = socketConfigData;
    }

    @Autowired
    Environment environment;

    // Port via annotation
    @Value("${server.port}")
    int aPort;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(socketConfigData.getHost());
        config.setPort(socketConfigData.getPort());
        config.setOrigin("*");
        try {
            // Port
            environment.getProperty("server.port");

            // Local address
            log.info("Local address: {}", InetAddress.getLocalHost().getHostAddress());
            log.info("Local host name: {}", InetAddress.getLocalHost().getHostName());

            // Remote address
            log.info("Remote address: {}", InetAddress.getLoopbackAddress().getHostAddress());
            log.info("Remote host name: {}", InetAddress.getLoopbackAddress().getHostName());

            config.setHostname(InetAddress.getLoopbackAddress().getHostAddress());
        } catch (NumberFormatException | UnknownHostException e) {
            log.error("Error getting host address", e);
        }
        return new com.corundumstudio.socketio.SocketIOServer(config);
    }
}
