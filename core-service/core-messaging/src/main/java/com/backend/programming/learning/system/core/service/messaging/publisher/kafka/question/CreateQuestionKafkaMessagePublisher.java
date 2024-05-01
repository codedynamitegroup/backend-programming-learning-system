package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.question;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CreateQuestionKafkaMessagePublisher implements QuestionCreatedMessagePublisher {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaProducer<String, QuestionCreateRequestAvroModel> kafkaProducer;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;

    public CreateQuestionKafkaMessagePublisher(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            CoreServiceConfigData coreServiceConfigData,
            KafkaProducer<String, QuestionCreateRequestAvroModel> kafkaProducer,
            QuestionKafkaMessageHelper questionKafkaMessageHelper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
    }

    @Override
    public void publish(QuestionCreatedEvent domainEvent) {
        String questionId = domainEvent.getQuestion().getId().getValue().toString();

        log.info("Received question created event for question id: {}", questionId);

        try {
            QuestionCreateRequestAvroModel questionCreateRequestAvroModel = questionMessagingDataMapper
                    .questionCreatedToQuestionCreateRequestAvroModel(domainEvent);
            kafkaProducer.send(coreServiceConfigData.getQuestionCreatedRequestTopicName(), questionId,
                    questionCreateRequestAvroModel,
                    questionKafkaMessageHelper.getKafkaCallback(coreServiceConfigData.getQuestionCreatedRequestTopicName(),
                            questionCreateRequestAvroModel, questionId, "QuestionCreateRequestAvroModel"));

            log.info("QuestionCreateRequestAvroModel sent to kafka for question id: {}", questionId);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", coreServiceConfigData.getQuestionCreatedRequestTopicName(), domainEvent, e);
        }
    }
}
