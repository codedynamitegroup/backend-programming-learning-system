package com.backend.programming.learning.system.kafka.producer.exception;

/**
 * com.backend.programming.learning.system.kafka.producer.exception
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:48 PM
 * Description: ...
 */
public class KafkaProducerException extends RuntimeException {
    public KafkaProducerException(String message) {
        super(message);
    }
}
