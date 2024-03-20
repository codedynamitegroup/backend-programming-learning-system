package com.backend.programming.learning.system.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

/**
 * com.backend.programming.learning.system.kafka.consumer
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:42 PM
 * Description: ...
 */
public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receive(List<T> messages, List<String> keys, List<Integer> partitions, List<Long> offsets);
}
