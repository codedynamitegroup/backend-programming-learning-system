package com.backend.programming.learning.system.core.service.messaging.listener.kafka;

import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingMapper;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import com.backend.programming.learning.system.ports.input.message.listener.question.QuestionMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuestionCreateRequestKafkaListener implements KafkaConsumer<QuestionCreateRequestAvroModel> {
    private final QuestionMessagingMapper questionMessagingDataMapper;
    private final QuestionMessageListener questionMessageListener;

    public QuestionCreateRequestKafkaListener(QuestionMessagingMapper questionMessagingDataMapper,
                                              QuestionMessageListener questionMessageListener) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.questionMessageListener = questionMessageListener;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.question-create-consumer-group-id}", topics = "${course-service.question-created-request-topic-name}")
    public void receive(
            @Payload List<QuestionCreateRequestAvroModel> messages,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
            @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of question create request received with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(questionCreateRequestAvroModel -> {
            log.info("Creating question with id {}", questionCreateRequestAvroModel.getId());

            questionMessageListener.createQuestion(questionMessagingDataMapper
                    .questionCreateRequestAvroModelToQuestionCreateRequest(questionCreateRequestAvroModel));
        });
    }
}
