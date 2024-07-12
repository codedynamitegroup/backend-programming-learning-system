package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.code_question;

import com.backend.programming.learning.system.core.service.config.CoreServiceConfigData;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.code_questions.CodeQuestionsUpdateResponseMessagePublisher;
import com.backend.programming.learning.system.core.service.messaging.mapper.CodeQuestionsMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CodeQuestionsUpdateResponseMessageKafkaPublisher
        implements CodeQuestionsUpdateResponseMessagePublisher {
    private final CodeQuestionsMessagingDataMapper dataMapper;
    private final KafkaProducer<String, CodeQuestionUpdateResponseAvroModel> kafkaProducer;
    private final CoreServiceConfigData coreServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CodeQuestionsUpdateResponseMessageKafkaPublisher(CodeQuestionsMessagingDataMapper dataMapper, KafkaProducer<String, CodeQuestionUpdateResponseAvroModel> kafkaProducer, CoreServiceConfigData coreServiceConfigData, KafkaMessageHelper kafkaMessageHelper) {
        this.dataMapper = dataMapper;
        this.kafkaProducer = kafkaProducer;
        this.coreServiceConfigData = coreServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(CodeQuestionsUpdateOutboxMessage outboxMessage,
                        BiConsumer<CodeQuestionsUpdateOutboxMessage, OutboxStatus> outboxCallback) {
        CodeQuestionsUpdatePayload payload = kafkaMessageHelper.getObjectEventPayload(
                outboxMessage.getPayload(),
                CodeQuestionsUpdatePayload.class,
                CoreDomainException.class
        );
        String sagaId = outboxMessage.getSagaId().toString();
        log.info("Received CodeQuestionsUpdateOutboxMessage for CodeQuestions id: {} and saga id: {}",
                payload.getCodeQuestionId(),
                sagaId);

        try {
            CodeQuestionUpdateResponseAvroModel avroModel = dataMapper
                    .codeQuestionsUpdatePayloadToCodeQuestionUpdateResponseAvroModel(payload);

            kafkaProducer.send(coreServiceConfigData.getCodeQuestionUpdateResponseFromCoreServiceTopicName(),
                    sagaId,
                    avroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(coreServiceConfigData.getCodeQuestionUpdateResponseFromCoreServiceTopicName(),
                            avroModel,
                            outboxMessage,
                            outboxCallback,
                            payload.getCodeQuestionId().toString(),
                            "CodeQuestionUpdateResponseAvroModel"));

            log.info("CodeQuestionUpdateResponseAvroModel sent to kafka for code question id: {} and saga id: {}",
                    avroModel.getCodeQuestionId(), sagaId);
        } catch (Exception e) {
            log.error("Error while sending CodeQuestionUpdateResponseAvroModel message" +
                            " to kafka with code question id: {} and saga id: {}, error: {}",
                    payload.getCodeQuestionId(), sagaId, e.getMessage());
        }

    }
}
