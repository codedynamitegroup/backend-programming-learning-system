package com.backend.programming.learning.system.kafka.config.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * com.backend.programming.learning.system.kafka.config.data
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:34 PM
 * Description: ...
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfigData {
    private String bootstrapServers;
    private String schemaRegistryUrlKey;
    private String schemaRegistryUrl;
    private Integer numOfPartitions;
    private Short replicationFactor;
}