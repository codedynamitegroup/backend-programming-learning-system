package com.backend.programming.learning.system.code.assessment.service.messaging.listener.kafka.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.code_submission.CodeSubmissionReceiver;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.codequestion.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.programming_language.ProgrammingLanguageNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.CodeSubmissionReceiverMessageListener;
import com.backend.programming.learning.system.code.assessment.service.messaging.mapper.CodeSubmissionMessagingDataMapper;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateResponseAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import com.backend.programming.learning.system.kafka.course.code_submission_sender.avro_model.CodeSubmissionSenderRequestAvroModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CodeSubmissionReceiverKafkaListener implements KafkaConsumer<CodeSubmissionSenderRequestAvroModel> {
    private final CodeSubmissionReceiverMessageListener listener;
    private final CodeSubmissionMessagingDataMapper dataMapper;

    @Override
    @KafkaListener(id = "${kafka-consumer-config.code-assessment-service-group-id}",
    topics = "${code-assessment-service.code-submission-sender-request-topic-name}")
    public void receive(@Payload List<CodeSubmissionSenderRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} code submission messages received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(avroModel -> {
            try {
                CodeSubmissionReceiver receiver = dataMapper.codeSubmissionSenderRequestAvroModelToCodeSubmissionReceiver(avroModel);
                listener.createCodeSubmission(receiver);
            } catch (OptimisticLockingFailureException e) {
                log.error("Caught optimistic locking exception in CodeSubmissionReceiverKafkaListener for code submission id: {}",
                        avroModel.getSubmissionId());
            } catch (UserNotFoundException | CodeQuestionNotFoundException | ProgrammingLanguageNotFoundException e){

                log.error("something could not be found {} in submission id {}", e.getMessage(), avroModel.getSubmissionId());
            }
        });
    }
}
