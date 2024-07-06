package com.backend.programming.learning.system.socket.emitter.module;

import com.backend.programming.learning.system.socket.emitter.utils.JwtUtils;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SocketModule {
    public SocketModule(SocketIOServer server) {
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
    }

    private ConnectListener onConnected() {
        return (client) -> {
            String token = client.getHandshakeData().getSingleUrlParam("token");
            String email = JwtUtils.getEmailFromJwtString(token);
            if (email == null) {
                log.error("Client[{}] - Invalid token", client.getSessionId().toString());
                client.disconnect();
            } else {
                log.info("Client[{}] - Connected to socket", client.getSessionId().toString());
                client.joinRoom("email_" + email);
            }
        };
    }

    private DisconnectListener onDisconnected() {
        return client -> {
            log.info("Client[{}] - Disconnected from socket", client.getSessionId().toString());
        };
    }

}