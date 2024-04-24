package com.backend.programming.learning.system.core.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.core.service.domain.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.QuestionDeletedMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeleteQuestionKafkaMessagePublisher implements QuestionDeletedMessagePublisher {
    private final QuestionMessagingDataMapper questionMessagingDataMapper;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaProducer<String, QuestionDeleteRequestAvroModel> kafkaProducer;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;

    public DeleteQuestionKafkaMessagePublisher(
            QuestionMessagingDataMapper questionMessagingDataMapper,
            CoreServiceConfigData coreServiceConfigData,
            KafkaProducer<String, QuestionDeleteRequestAvroModel> kafkaProducer,
            QuestionKafkaMessageHelper questionKafkaMessageHelper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
    }

    @Override
    public void publish(QuestionDeletedEvent domainEvent) {
        String questionId = domainEvent.getQuestion().getId().getValue().toString();

        log.info("Received question deleted event for question id: {}", questionId);

        try {
            QuestionDeleteRequestAvroModel questionDeleteRequestAvroModel = questionMessagingDataMapper
                    .questionDeletedToQuestionDeleteRequestAvroModel(domainEvent);

            kafkaProducer.send(coreServiceConfigData.getQuestionDeletedRequestTopicName(), questionId,
                    questionDeleteRequestAvroModel,
                    questionKafkaMessageHelper.getKafkaCallback(coreServiceConfigData.getQuestionDeletedRequestTopicName(),
                            questionDeleteRequestAvroModel,
                            questionId,
                            "QuestionDeleteRequestAvroModel"));

            log.info("QuestionDeleteRequestAvroModel sent to kafka for question id: {}", questionId);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", coreServiceConfigData.getQuestionDeletedRequestTopicName(), domainEvent, e);
        }
    }
}
