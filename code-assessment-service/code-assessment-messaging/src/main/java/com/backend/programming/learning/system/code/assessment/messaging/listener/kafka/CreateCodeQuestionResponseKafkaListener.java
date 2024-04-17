package com.backend.programming.learning.system.code.assessment.messaging.listener.kafka;

import com.backend.programming.learning.system.code.assessment.messaging.mapper.CodeQuestionMessagingDataMapper;

import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeQuestionUpdateResponseMessageListener;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CopyState;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class CreateCodeQuestionResponseKafkaListener
        implements KafkaConsumer<CodeQuestionUpdateResponseAvroModel> {

    private final CodeQuestionUpdateResponseMessageListener codeQuestionUpdateResponseMessageListener;
    private final CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper;

    public CreateCodeQuestionResponseKafkaListener
            (CodeQuestionUpdateResponseMessageListener codeQuestionUpdateResponseMessageListener,
             CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper) {
        this.codeQuestionUpdateResponseMessageListener = codeQuestionUpdateResponseMessageListener;
        this.codeQuestionMessagingDataMapper = codeQuestionMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.create-code-question-consumer-group-id}",
    topics = "${code-assessment-service.code-question-create-response-from-core-service-topic-name}")
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
            CodeQuestionId codeQuestionId
                    = new CodeQuestionId(codeQuestionUpdateResponseAvroModel.getId());
            switch (codeQuestionUpdateResponseAvroModel.getCopyState()){
                case CREATED:{
                    log.info("Success to save code question to core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionCreateSuccess(codeQuestionId);
                    break;
                }
                case CREATING_FAIL:{
                    log.info("Fail to save code question to core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionCreateFail(codeQuestionId,
                                    codeQuestionUpdateResponseAvroModel.getFailureMessages());
                    break;
                }
                case DELETED: {
                    log.info("Success to delete code question from core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionDeleteSuccess(codeQuestionId);
                    break;
                }
                case DELETING_FAIL:{
                    log.info("Fail to delete code question from core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionDeleteFail(codeQuestionId,
                                    codeQuestionUpdateResponseAvroModel.getFailureMessages());
                    break;
                }
                case UPDATED:{
                    log.info("Success to update code question to core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionUpdatedSuccess(codeQuestionId);
                    break;
                }
                case UPDATING_FAIL:{
                    log.info("Fail to update code question to core service, id: {}",
                            codeQuestionId);
                    codeQuestionUpdateResponseMessageListener
                            .codeQuestionUpdatedFail(
                                    codeQuestionMessagingDataMapper
                                            .codeQuestionUpdateResponseAvroModelToCodeQuestionUpdateResponse
                                                    (codeQuestionUpdateResponseAvroModel),
                                    codeQuestionUpdateResponseAvroModel.getFailureMessages());
                    break;
                }
            }
        });
    }

    // rollback cần trả về data cũ nên response ở đây phải có data cũ.
}
