package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.question;

import com.backend.programming.learning.system.core.service.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionRequestMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class QuestionKafkaMessagePublisher implements QuestionRequestMessagePublisher {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final KafkaProducer<String, QuestionRequestAvroModel> kafkaProducer;
    private final CoreServiceConfigData coreServiceConfigData;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;
    private final ObjectMapper objectMapper;

    public QuestionKafkaMessagePublisher(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            KafkaProducer<String, QuestionRequestAvroModel> kafkaProducer,
            CoreServiceConfigData coreServiceConfigData,
            QuestionKafkaMessageHelper questionKafkaMessageHelper,
            ObjectMapper objectMapper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.coreServiceConfigData = coreServiceConfigData;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(
            QuestionOutboxMessage questionOutboxMessage,
            BiConsumer<QuestionOutboxMessage, OutboxStatus> outboxCallback) {

        QuestionEventPayload questionEventPayload = getQuestionEventPayload(questionOutboxMessage.getPayload());
        String sagaId = questionOutboxMessage.getSagaId().toString();
        String topicName;

        log.info("Received QuestionOutboxMessage for question id: {} and saga id: {}",
                questionEventPayload.getId(),
                sagaId);

        if (questionOutboxMessage.getServiceName() == ServiceName.CODE_ASSESSMENT_SERVICE)
            topicName = coreServiceConfigData.getQuestionRequestCodeAssessmentTopicName();
        else
            topicName = coreServiceConfigData.getQuestionRequestTopicName();

        try {
            switch (questionEventPayload.getCopyState()) {
                case CREATING, DELETING, UPDATING:
                    QuestionRequestAvroModel questionRequestAvroModel = questionMessagingDataMapper
                            .questionEventPayloadToQuestionRequestAvroModel(sagaId, questionEventPayload);

                    kafkaProducer.send(topicName,
                            sagaId,
                            questionRequestAvroModel,
                            questionKafkaMessageHelper.getKafkaCallback(topicName,
                                    questionRequestAvroModel,
                                    questionOutboxMessage,
                                    outboxCallback,
                                    sagaId, "QuestionRequestAvroModel"));
                    break;

            }
            log.info("QuestionRequestAvroModel sent to Kafka for question id: {} and saga id: {}", questionEventPayload.getId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending QuestionRequestAvroModel message" +
                    " to kafka with question id: {} and saga id: {}, error: {}", questionEventPayload.getId(), sagaId, e.getMessage());
        }
    }

    private QuestionEventPayload getQuestionEventPayload(String payload) {
        try {
            return objectMapper.readValue(payload, QuestionEventPayload.class);
        } catch (JsonProcessingException e) {
            log.error("Could not read QuestionCreatedEventPayload object:", e);
            throw new CoreDomainException("Could not read QuestionEventPayload object: {}", e);
        }
    }
}
