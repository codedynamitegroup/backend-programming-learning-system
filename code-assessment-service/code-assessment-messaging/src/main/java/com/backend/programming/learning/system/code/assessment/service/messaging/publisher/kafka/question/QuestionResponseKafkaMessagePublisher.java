package com.backend.programming.learning.system.code.assessment.service.messaging.publisher.kafka.question;

import com.backend.programming.learning.system.code.assessment.service.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.QuestionResponseMessagePublisher;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class QuestionResponseKafkaMessagePublisher implements QuestionResponseMessagePublisher {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;
    private final ObjectMapper objectMapper;

    public QuestionResponseKafkaMessagePublisher(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer,
            CodeAssessmentServiceConfigData codeAssessmentServiceConfigData,
            QuestionKafkaMessageHelper questionKafkaMessageHelper,
            ObjectMapper objectMapper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(
            QuestionOutboxMessage questionOutboxMessage,
            BiConsumer<QuestionOutboxMessage, OutboxStatus> outboxCallback) {
        QuestionEventPayload questionEventPayload = getQuestionEventPayload(questionOutboxMessage.getPayload());

        log.info("Received QuestionOutboxMessage for question id: {} and saga id: {}",
                questionEventPayload.getId(),
                questionEventPayload.getSagaId());

        QuestionResponseAvroModel questionResponseAvroModel = questionMessagingDataMapper
                .questionEventPayloadToQuestionResponseAvroModel(questionEventPayload);

        kafkaProducer.send(codeAssessmentServiceConfigData.getQuestionResponseCodeAssessmentTopicName(),
                questionEventPayload.getSagaId(),
                questionResponseAvroModel,
                questionKafkaMessageHelper.getKafkaCallback(codeAssessmentServiceConfigData.getQuestionResponseCodeAssessmentTopicName(),
                        questionResponseAvroModel, questionOutboxMessage, outboxCallback,
                        questionEventPayload.getSagaId(), "QuestionResponseAvroModel"));
    }

    private QuestionEventPayload getQuestionEventPayload(String payload) {
        try {
            return objectMapper.readValue(payload, QuestionEventPayload.class);
        } catch (JsonProcessingException e) {
            log.error("Could not read QuestionCreatedEventPayload object:", e);
            throw new CodeAssessmentDomainException("Could not read QuestionEventPayload object: {}", e);
        }
    }
}
