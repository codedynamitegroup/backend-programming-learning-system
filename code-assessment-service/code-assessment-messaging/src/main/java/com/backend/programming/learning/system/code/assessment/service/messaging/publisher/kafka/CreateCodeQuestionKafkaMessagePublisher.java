package com.backend.programming.learning.system.code.assessment.service.messaging.publisher.kafka;

import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.CodeQuestionMessagingDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.codequestion.CodeQuestionsUpdateMessagePublisher;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CreateCodeQuestionKafkaMessagePublisher implements CodeQuestionsUpdateMessagePublisher {
    private final CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer;
    private final CodeQuestionKafkaMessageHelper  codeQuestionKafkaMessageHelper;

    public CreateCodeQuestionKafkaMessagePublisher
            (CodeQuestionMessagingDataMapper codeQuestionMessagingDataMapper,
             CodeAssessmentServiceConfigData codeAssessmentServiceConfigData,
             KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer,
             CodeQuestionKafkaMessageHelper codeQuestionKafkaMessageHelper) {
        this.codeQuestionMessagingDataMapper = codeQuestionMessagingDataMapper;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.codeQuestionKafkaMessageHelper = codeQuestionKafkaMessageHelper;
    }

    @Override
    public void publish(CodeQuestionCreatedEvent domainEvent) {
        String codeQuestionId = domainEvent.getCodeQuestion().getQuestionId().getValue().toString();
        String topicName = codeAssessmentServiceConfigData.getCodeQuestionCreateRequestToCoreServiceTopicName();
        log.info("received CodeQuestionCreateEvent for code question id: {}"
                , codeQuestionId);
        try {
            CodeQuestionUpdateRequestAvroModel codeQuestionUpdateRequestAvroModel
                    = codeQuestionMessagingDataMapper
                    .codeQuestionCreatedEventToCodeQuestionUpdateRequestAvroModel(domainEvent);
            log.info(codeQuestionUpdateRequestAvroModel.toString());
            kafkaProducer.send(topicName,
                    codeQuestionId,
                    codeQuestionUpdateRequestAvroModel,
                    codeQuestionKafkaMessageHelper
                            .getKafkaCallback(topicName,
                                    codeQuestionUpdateRequestAvroModel,
                                    codeQuestionId,
                                    "CodeQuestionUpdateRequestAvroModel"));
            log.info("CodeQuestionUpdateRequestAvroModel sent to kafka for code question id: {}", codeQuestionId);
        } catch (Exception e) {
//            log.error(e.getMessage());
            log.error("Error while sending CodeQuestionUpdateRequestAvroModel with id {}", codeQuestionId);
            throw e;
        }
    }
}
