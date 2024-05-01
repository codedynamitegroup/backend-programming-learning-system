package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.question;

import com.backend.programming.learning.system.core.service.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionUpdatedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateQuestionKafkaMessagePublisher implements QuestionUpdatedMessagePublisher {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaProducer<String, QuestionUpdateRequestAvroModel> kafkaProducer;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;

    public UpdateQuestionKafkaMessagePublisher(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            CoreServiceConfigData coreServiceConfigData,
            KafkaProducer<String, QuestionUpdateRequestAvroModel> kafkaProducer,
            QuestionKafkaMessageHelper questionKafkaMessageHelper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
    }


    @Override
    public void publish(QuestionUpdatedEvent domainEvent) {
        String questionId = domainEvent.getQuestion().getId().getValue().toString();

        log.info("Received question deleted event for question id: {}", questionId);

        try {
            QuestionUpdateRequestAvroModel questionUpdateRequestAvroModel = questionMessagingDataMapper
                    .questionUpdatedToQuestionUpdateRequestAvroModel(domainEvent);

            kafkaProducer.send(coreServiceConfigData.getQuestionUpdatedRequestTopicName(), questionId,
                    questionUpdateRequestAvroModel,
                    questionKafkaMessageHelper.getKafkaCallback(coreServiceConfigData.getQuestionDeletedRequestTopicName(),
                            questionUpdateRequestAvroModel,
                            questionId,
                            "QuestionUpdateRequestAvroModel"));

            log.info("QuestionUpdateRequestAvroModel sent to kafka for question id: {}", questionId);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", coreServiceConfigData.getQuestionDeletedRequestTopicName(), domainEvent, e);
        }
    }
}
