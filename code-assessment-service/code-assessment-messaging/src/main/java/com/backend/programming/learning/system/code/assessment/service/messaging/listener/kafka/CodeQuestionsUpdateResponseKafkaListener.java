package com.backend.programming.learning.system.code.assessment.service.messaging.listener.kafka;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.codequestion.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.CodeQuestionMessagingDataMapper;

import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeQuestionUpdateResponseMessageListener;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class CodeQuestionsUpdateResponseKafkaListener
        implements KafkaConsumer<CodeQuestionUpdateResponseAvroModel> {

    private final CodeQuestionUpdateResponseMessageListener codeQuestionUpdateResponseMessageListener;
    private final CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper;

    public CodeQuestionsUpdateResponseKafkaListener
            (CodeQuestionUpdateResponseMessageListener codeQuestionUpdateResponseMessageListener,
             CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper) {
        this.codeQuestionUpdateResponseMessageListener = codeQuestionUpdateResponseMessageListener;
        this.codeQuestionMessagingDataMapper = codeQuestionMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.create-code-question-consumer-group-id}",
    topics = "${code-assessment-service.code-question-update-response-from-core-service-topic-name}")
    public void receive(@Payload List<CodeQuestionUpdateResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of customer create messages received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(codeQuestionUpdateResponseAvroModel -> {

            try {
                CodeQuestionsUpdateResponse codeQuestionsUpdateResponse =
                        codeQuestionMessagingDataMapper
                                .codeQuestionUpdateResponseAvroModelToCodeQuestionUpdateResponse
                                        (codeQuestionUpdateResponseAvroModel);

                switch (codeQuestionUpdateResponseAvroModel.getCopyState()){
                    case CREATED, UPDATED, DELETED->
                        codeQuestionUpdateResponseMessageListener
                                .codeQuestionCreatedUpdatedOrDeletedSuccess(codeQuestionsUpdateResponse);

                    case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED ->
                            codeQuestionUpdateResponseMessageListener
                                    .codeQuestionCreatedUpdatedOrDeletedFail(codeQuestionsUpdateResponse);
                }
            } catch (OptimisticLockingFailureException e) {
                log.error("Caught optimistic locking exception in CodeQuestionsUpdateResponseKafkaListener for code question id: {}",
                        codeQuestionUpdateResponseAvroModel.getCodeQuestionId());
            } catch (CodeQuestionNotFoundException e){
                log.error("No code question founded for id: {}", codeQuestionUpdateResponseAvroModel.getCodeQuestionId());
            }
        });
    }

    // rollback cần trả về data cũ nên response ở đây phải có data cũ.
}
