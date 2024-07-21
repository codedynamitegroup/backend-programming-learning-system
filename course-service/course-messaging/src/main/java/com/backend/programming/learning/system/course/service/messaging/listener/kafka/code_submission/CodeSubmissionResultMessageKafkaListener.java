package com.backend.programming.learning.system.course.service.messaging.listener.kafka.code_submission;

import com.backend.programming.learning.system.course.service.domain.exception.CourseApplicationServiceException;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.code_submission.CodeSubmissionResultMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.CodeSubmissionMessagingDataMapper;
import com.backend.programming.learning.system.kafka.code.assessment.code.question.avro.model.CodeQuestionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.code.assessment.code.submission.avro.model.CodeSubmissionUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLState;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionResultMessageKafkaListener implements KafkaConsumer<CodeSubmissionUpdateRequestAvroModel> {
    final CodeSubmissionMessagingDataMapper dataMapper;
    final CodeSubmissionResultMessageListener listener;

    @Override
    @KafkaListener(id = "${kafka-consumer-config.course-group-id}",
            topics = "${course-service.code-submission-update-request-to-core-service-topic-name}")
    public void receive(@Payload List<CodeSubmissionUpdateRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of code-submission-result-request received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(avroModel -> {
            try {
                listener.handleCodeSubmissionResultRequest(dataMapper.codeSubmissionUpdateRequestAvroModelToCodeSubmissionResultRequest(avroModel));
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null &&
                        PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in CodeSubmissionResultMessageKafkaListener for code submission id: {}",
                            sqlException.getSQLState(), avroModel.getCodeSubmisisonId());
                } else {
                    throw new CourseApplicationServiceException("Throwing DataAccessException in" +
                            " CodeSubmissionResultMessageKafkaListener: " + e.getMessage(), e);
                }
            }

        });
    }

}
