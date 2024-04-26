package com.backend.programming.learning.system.core.service.messaging.listener.kafka;

import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.question.course.QuestionResponseMessageListener;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class QuestionResponseKafkaListener implements KafkaConsumer<QuestionResponseAvroModel> {
    private final QuestionResponseMessageListener questionResponseMessageListener;
    private final QuestionMessagingDataMapper questionMessagingDataMapper;

    public QuestionResponseKafkaListener(QuestionResponseMessageListener questionResponseMessageListener,
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
            switch (questionResponseAvroModel.getQuestionResponseStatus()){
                case CREATED:{
                    log.info("Created question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionCreated(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
                case CREATE_FAILED:{
                    log.info("Create failed with question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionCreateFailed(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
                case DELETED: {
                    log.info("Deleted question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionDeleted(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
                case DELETE_FAILED: {
                    log.info("Delete failed with question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionDeleteFailed(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
                case UPDATED: {
                    log.info("Updated question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionUpdated(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
                case UPDATE_FAILED: {
                    log.info("Update failed with question with id: {}",
                            questionResponseAvroModel.getId());
                    questionResponseMessageListener
                            .questionUpdateFailed(questionMessagingDataMapper.questionResponseAvroModelToQuestionResponse(questionResponseAvroModel));
                    break;
                }
            }
        });
    }
}
