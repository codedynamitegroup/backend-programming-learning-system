package com.backend.programming.learning.system.code.assessment.messaging.publisher.kafka;

import com.backend.programming.learning.system.code.assessment.messaging.mapper.CodeAssessmentDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.config.CodeAssessmentServiceConfigData;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.codequestion.CodeQuestionCreateMessagePublisher;
import com.backend.programming.learning.system.kafka.code.assessment.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
@Slf4j
public class CreateCodeQuestionKafkaMessagePublisher implements CodeQuestionCreateMessagePublisher {
    private final CodeAssessmentDataMapper codeAssessmentDataMapper;
    private final CodeAssessmentServiceConfigData codeAssessmentServiceConfigData;
    private final KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer;
    private final CodeQuestionKafkaMessageHelper  codeQuestionKafkaMessageHelper;

    public CreateCodeQuestionKafkaMessagePublisher
            (CodeAssessmentDataMapper codeAssessmentDataMapper,
             CodeAssessmentServiceConfigData codeAssessmentServiceConfigData,
             KafkaProducer<String, CodeQuestionUpdateRequestAvroModel> kafkaProducer,
             CodeQuestionKafkaMessageHelper codeQuestionKafkaMessageHelper) {
        this.codeAssessmentDataMapper = codeAssessmentDataMapper;
        this.codeAssessmentServiceConfigData = codeAssessmentServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.codeQuestionKafkaMessageHelper = codeQuestionKafkaMessageHelper;
    }

    @Override
    public void publish(CodeQuestionCreatedEvent domainEvent) {
        String codeQuestionId = domainEvent.getCodeQuestion().getQuestionId().getValue().toString();
        String topicName = codeAssessmentServiceConfigData.getCodeQuestionCreateRequestTopicName();
        log.info("received CodeQuestionCreateEvent for code question id: {}"
                , codeQuestionId);
        try {
            CodeQuestionUpdateRequestAvroModel codeQuestionUpdateRequestAvroModel
                    = codeAssessmentDataMapper
                    .codeQuestionCreatedEventToCodeQuestionUpdateRequestAvroModel(domainEvent);

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
            log.error("Error while sending CodeQuestionUpdateRequestAvroModel with id {}", codeQuestionId);
        }
    }
}
