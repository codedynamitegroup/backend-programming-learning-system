package com.backend.programming.learning.system.code.assessment.service.messaging.publisher.kafka.code_question;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.code_question.CodeQuestionsUpdateMessagePublisher;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.CodeQuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CodeQuestionsUpdateMessageKafkaPublisher
        implements CodeQuestionsUpdateMessagePublisher {
    private final CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper;
    private final KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CodeQuestionsUpdateMessageKafkaPublisher(
            CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper,
            KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer,
            CodeAssessmentServiceConfigData codeAssessmentServiceConfigData,
            KafkaMessageHelper kafkaMessageHelper) {
        this.codeQuestionMessagingDataMapper = codeQuestionMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage,
                        BiConsumer<CodeQuestionsUpdateOutboxMessage, OutboxStatus> outboxCallback) {
        CodeQuestionsUpdatePayload codeQuestionsUpdatePayload =
                kafkaMessageHelper.getObjectEventPayload(
                        codeQuestionsUpdateOutboxMessage.getPayload(),
                        CodeQuestionsUpdatePayload.class,
                        CodeAssessmentDomainException.class
                );
//                getCodeQuestionsUpdatePayload(codeQuestionsUpdateOutboxMessage.getPayload());

        String sagaId = codeQuestionsUpdateOutboxMessage.getSagaId().toString();

        log.info("Received CodeQuestionsUpdateOutboxMessage for code question id: {} and saga id: {}",
                codeQuestionsUpdatePayload.getId(),
                sagaId);
        CodeQuestionUpdateRequestAvroModel avroModel =
                codeQuestionMessagingDataMapper
                        .codeQuestionsUpdatePayloadToCodeQuestionUpdateRequestAvroModel(sagaId, codeQuestionsUpdatePayload);

        try {
            kafkaProducer.send(codeAssessmentServiceConfigData.getCodeQuestionUpdateRequestToCoreServiceTopicName(),
                    sagaId,
                    avroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(
                            codeAssessmentServiceConfigData.getCodeQuestionUpdateRequestToCoreServiceTopicName(),
                            avroModel,
                            codeQuestionsUpdateOutboxMessage,
                            outboxCallback,
                            codeQuestionsUpdatePayload.getId(),
                            "CodeQuestionUpdateRequestAvroModel"
                            ));
            log.info("CodeQuestionsUpdatePayload sent to Kafka for code question id: {} and saga id: {}",
                    codeQuestionsUpdatePayload.getId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending CodeQuestionsUpdatePayload" +
                            " to kafka with code question id: {} and saga id: {}, error: {}",
                    codeQuestionsUpdatePayload.getId(), sagaId, e.getMessage());
        }
    }

}
