package com.backend.programming.learning.system.core.service.messaging.pulisher.kafka;

import com.backend.programming.learning.system.course.service.domain.config.CourseServiceConfigData;
import com.backend.programming.learning.system.core.service.messaging.mapper.QuestionMessagingMapper;
import com.backend.programming.learning.system.course.service.domain.event.question.event.QuestionCreateFailedEvent;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QuestionCreateFailedResponseMessagePublisher implements com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.QuestionCreateFailedResponseMessagePublisher {
    private final QuestionMessagingMapper questionMessagingDataMapper;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer;
    private final QuestionKafkaMessageHelper questionKafkaMessageHelper;

    public QuestionCreateFailedResponseMessagePublisher(
            QuestionMessagingMapper questionMessagingDataMapper,
            CourseServiceConfigData courseServiceConfigData,
            KafkaProducer<String, QuestionResponseAvroModel> kafkaProducer,
            QuestionKafkaMessageHelper questionKafkaMessageHelper) {
        this.questionMessagingDataMapper = questionMessagingDataMapper;
        this.courseServiceConfigData = courseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.questionKafkaMessageHelper = questionKafkaMessageHelper;
    }

    @Override
    public void publish(QuestionCreateFailedEvent domainEvent) {
        String questionId = domainEvent.getQuestion().getId().getValue().toString();

        log.info("Received question create failed event for question id: {}", questionId);

        try {
            QuestionResponseAvroModel questionResponseAvroModel = questionMessagingDataMapper
                    .questionResponseToQuestionResponseAvroModel(domainEvent);
            kafkaProducer.send(courseServiceConfigData.getQuestionResponseTopicName(), questionId,
                    questionResponseAvroModel,
                    questionKafkaMessageHelper.getKafkaCallback(courseServiceConfigData.getQuestionResponseTopicName(),
                            questionResponseAvroModel, questionId, "QuestionResponseAvroModel"));
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}",
                    courseServiceConfigData.getQuestionResponseTopicName(),
                    domainEvent,
                    e);
        }

    }
}
