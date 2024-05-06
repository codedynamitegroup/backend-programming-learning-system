package com.backend.programming.learning.system.core.service.messaging.listener.kafka.question;

import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.question.course.QuestionResponseMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.persistence.OptimisticLockException;
import java.util.List;

@Slf4j
@Component
public class CodeQuestionResponseKafkaListener implements KafkaConsumer<QuestionResponseAvroModel> {
    private final QuestionResponseMessageListener questionResponseMessageListener;
    private final QuestionMessagingDataMapper questionMessagingDataMapper;

    public CodeQuestionResponseKafkaListener(
            QuestionResponseMessageListener questionResponseMessageListener,
            QuestionMessagingDataMapper questionMessagingDataMapper) {
        this.questionResponseMessageListener = questionResponseMessageListener;
        this.questionMessagingDataMapper = questionMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-code-question-consumer-group-id}",
            topics = "${core-service.question-response-code-assessment-topic-name}")
    public void receive(@Payload List<QuestionResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of question response received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(questionResponseAvroModel -> {
            try {
                switch (questionResponseAvroModel.getCopyState()) {
                    case DELETED: {
                        log.info("Success to delete question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionDeleted(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case DELETE_FAILED: {
                        log.info("Fail to delete question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionDeleteFailed(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                }
            } catch (OptimisticLockException e) {
                //NO-OP for optimistic lock. This means another thread finished the work, do not throw error to prevent reading the data from kafka again!
                log.error("Caught optimistic locking exception in PaymentResponseKafkaListener for order id: {}",
                        questionResponseAvroModel.getId());
            } catch (QuestionNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No question found for question id: {}", questionResponseAvroModel.getId());
            }
        });
    }
}
