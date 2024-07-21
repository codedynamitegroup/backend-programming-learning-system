package com.backend.programming.learning.system.course.service.messaging.publisher.kafka.code_submission_sender;

import com.backend.programming.learning.system.course.service.config.CourseServiceConfigData;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.code_submission_sender.CodeSubmissionSenderMessagePublisher;
import com.backend.programming.learning.system.course.service.messaging.mapper.CodeSubmissionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.course.code_submission_sender.avro_model.CodeSubmissionSenderRequestAvroModel;
import com.backend.programming.learning.system.kafka.producer.KafkaMessageHelper;
import com.backend.programming.learning.system.kafka.producer.service.KafkaProducer;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionSenderEventKafkaPublisher implements CodeSubmissionSenderMessagePublisher {
    private final CodeSubmissionMessagingDataMapper messagingDataMapper;
    private final KafkaProducer<String, CodeSubmissionSenderRequestAvroModel> kafkaProducer;
    private final CourseServiceConfigData courseServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;
    @Override
    public void publish(CodeSubmissionSenderOutboxMessage outboxMessage, BiConsumer<CodeSubmissionSenderOutboxMessage, OutboxStatus> outboxCallback) {
        CodeSubmissionEventPayload payload =
                kafkaMessageHelper.getObjectEventPayload(
                        outboxMessage.getPayload(),
                        CodeSubmissionEventPayload.class);

        String sagaId = outboxMessage.getSagaId().toString();

        log.info("Received CodeSubmissionSenderOutboxMessage for submission id: {}, user id: {} and saga id: {}",
                payload.getSubmissionId(),
                payload.getUserId(),
                sagaId);

        try {
            CodeSubmissionSenderRequestAvroModel avroModel = messagingDataMapper.payloadToAvroModel(sagaId, payload);

            kafkaProducer.send(courseServiceConfigData.getCodeSubmissionSenderRequestTopicName(),
                    sagaId,
                    avroModel,
                    kafkaMessageHelper.getKafkaCallbackApplyOutbox(
                            courseServiceConfigData.getCodeSubmissionSenderRequestTopicName(),
                            avroModel,
                            outboxMessage,
                            outboxCallback,
                            payload.getSubmissionId(),
                            "CodeSubmissionSenderRequestAvroModel"));

            log.info("CodeSubmissionEventPayload sent to Kafka for submission id: {} and user id: {} with saga id: {}",
                    payload.getSubmissionId(),
                    payload.getUserId(),
                    sagaId);
        } catch (Exception e) {
            log.error("Error while sending CodeSubmissionEventPayload" +
                            " to Kafka for submission id: {} and user id: {} with saga id: {}",
                    payload.getSubmissionId(),
                    payload.getUserId(),
                    sagaId);
        }
    }
}
