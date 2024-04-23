package com.backend.programming.learning.system.core.service.messaging.listener.kafka;

import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingMapper;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuestionCreateRequestKafkaListener implements KafkaConsumer<QuestionCreateRequestAvroModel> {
    private final QuestionMessagingMapper questionMessagingDataMapper;

    public QuestionCreateRequestKafkaListener(QuestionMessagingMapper questionMessagingDataMapper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
    }


    @Override
    public void receive(
            List<QuestionCreateRequestAvroModel> messages,
            List<String> keys,
            List<Integer> partitions,
            List<Long> offsets) {

    }
}
