package com.backend.programming.learning.system.code.assessment.service.messaging.publisher.kafka.code_submission;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.code_submission.CodeSubmissionUpdateMessagePublisher;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.CodeSubmissionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CodeSubmissionUpdateMessageKafkaPublisher implements CodeSubmissionUpdateMessagePublisher {
    private final CodeSubmissionMessagingDataMapper codeSubmissionMessagingDataMapper;
    private final KafkaProducer<String, CodeSubmissionUpdateRequestAvroModel> kafkaProducer;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CodeSubmissionUpdateMessageKafkaPublisher(CodeSubmissionMessagingDataMapper codeSubmissionMessagingDataMapper, KafkaProducer<String, CodeSubmissionUpdateRequestAvroModel> kafkaProducer, CodeAssessmentServiceConfigData codeAssessmentServiceConfigData, KafkaMessageHelper kafkaMessageHelper, ObjectMapper objectMapper) {
        this.codeSubmissionMessagingDataMapper = codeSubmissionMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(CodeSubmissionUpdateOutboxMessage codeSubmissionUpdateOutboxMessage,
                        BiConsumer<CodeSubmissionUpdateOutboxMessage, OutboxStatus> outboxCallback) {
        CodeSubmissionUpdatePayload codeSubmissionUpdatePayload =
                kafkaMessageHelper.getObjectEventPayload(
                        codeSubmissionUpdateOutboxMessage.getPayload(),
                        CodeSubmissionUpdatePayload.class,
                        CodeAssessmentDomainException.class
                );

        String sagaId = codeSubmissionUpdateOutboxMessage.getSagaId().toString();

        log.info("Received CodeSubmissionUpdateOutboxMessage for submission id: {} and saga id: {}",
                codeSubmissionUpdatePayload.getId(),
                sagaId);
        CodeSubmissionUpdateRequestAvroModel avroModel =
                codeSubmissionMessagingDataMapper
                        .codeSubmissionUpdatePayloadToCodeSubmissionUpdateRequestAvroModel(sagaId, codeSubmissionUpdatePayload);

        try {
            kafkaProducer.send(codeAssessmentServiceConfigData.getCodeSubmissionUpdateRequestToCoreServiceTopicName(),
                    sagaId,
                    avroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(
                            codeAssessmentServiceConfigData.getCodeQuestionUpdateRequestToCoreServiceTopicName(),
                            avroModel,
                            codeSubmissionUpdateOutboxMessage,
                            outboxCallback,
                            codeSubmissionUpdatePayload.getId(),
                            "CodeSubmissionUpdateRequestAvroModel"
                    ));
            log.info("codeSubmissionUpdatePayload sent to Kafka for code submission id: {} and saga id: {}",
                    codeSubmissionUpdatePayload.getId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending codeSubmissionUpdatePayload" +
                            " to kafka with code question id: {} and saga id: {}, error: {}",
                    codeSubmissionUpdatePayload.getId(), sagaId, e.getMessage());
        }
    }
}
