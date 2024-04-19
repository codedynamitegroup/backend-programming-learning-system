package com.backend.programming.learning.system.socket.config.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "socket-config")
public class SocketConfigData {
    private String host;
    private Integer port;
}
