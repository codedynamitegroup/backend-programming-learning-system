package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.question;

import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.QuestionResponseMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.QuestionMessagingMapper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
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
    private final QuestionMessagingMapper questionMessageDataMapper;
    private final KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer;
    private final CourseServiceConfigData courseServiceConfigData;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;
    private final ObjectMapper objectMapper;

    public QuestionResponseKafkaMessagePublisher(QuestionMessagingMapper questionMessageDataMapper,
                                                 KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer,
                                                 CourseServiceConfigData courseServiceConfigData,
                                                 QuestionKafkaMessageHelper questionKafkaMessageHelper,
                                                 ObjectMapper objectMapper) {
        this.questionMessageDataMapper = questionMessageDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.courseServiceConfigData = courseServiceConfigData;
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

        QuestionResponseAvroModel questionResponseAvroModel = questionMessageDataMapper
                .questionEventPayloadToQuestionResponseAvroModel(questionEventPayload);

        kafkaProducer.send(courseServiceConfigData.getQuestionResponseTopicName(),
                questionEventPayload.getSagaId(),
                questionResponseAvroModel,
                questionKafkaMessageHelper.getKafkaCallback(courseServiceConfigData.getQuestionResponseTopicName(),
                        questionResponseAvroModel, questionOutboxMessage, outboxCallback,
                        questionEventPayload.getSagaId(), "QuestionResponseAvroModel"));
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
