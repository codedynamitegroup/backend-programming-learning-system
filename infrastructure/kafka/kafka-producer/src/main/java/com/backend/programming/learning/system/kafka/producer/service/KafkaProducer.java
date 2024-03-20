package com.backend.programming.learning.system.kafka.producer.service;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.Serializable;

/**
 * com.backend.programming.learning.system.kafka.producer.service
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:49 PM
 * Description: ...
 */
public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {
    void send(String topicName, K key, V message, ListenableFutureCallback<SendResult<K, V>> callback);
}
