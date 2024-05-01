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
public class QuestionResponseKafkaListener implements KafkaConsumer<QuestionResponseAvroModel> {
    private final QuestionResponseMessageListener questionResponseMessageListener;
    private final QuestionMessagingDataMapper questionMessagingDataMapper;

    public QuestionResponseKafkaListener(
            QuestionResponseMessageListener questionResponseMessageListener,
            QuestionMessagingDataMapper questionMessagingDataMapper) {
        this.questionResponseMessageListener = questionResponseMessageListener;
        this.questionMessagingDataMapper = questionMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.core-service-question-consumer-group-id}",
            topics = "${core-service.question-response-topic-name}")
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
                switch (questionResponseAvroModel.getCopyState()){
                    case CREATED:{
                        log.info("Success to create question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionCreated(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case CREATE_ROLLBACKING:{
                        log.info("Fail to create question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionCreateFailed(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case DELETED: {
                        log.info("Success to delete question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionDeleted(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case DELETE_ROLLBACKING:{
                        log.info("Fail to delete question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionDeleteFailed(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case UPDATED:{
                        log.info("Success to update question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionUpdated(questionMessagingDataMapper
                                        .questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                        break;
                    }
                    case UPDATE_ROLLBACKING:{
                        log.info("Fail to update question for id: {}",
                                questionResponseAvroModel.getId());
                        questionResponseMessageListener
                                .questionUpdateFailed(questionMessagingDataMapper
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
