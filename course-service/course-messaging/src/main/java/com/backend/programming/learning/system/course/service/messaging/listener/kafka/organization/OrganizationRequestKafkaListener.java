package com.backend.programming.learning.system.course.service.messaging.listener.kafka.organization;

import com.backend.programming.learning.system.core.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.CourseApplicationServiceException;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.organization.OrganizationRequestMessageListener;
import com.backend.programming.learning.system.course.service.messaging.mapper.OrganizationMessagingDataMapper;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.OrganizationRequestAvroModel;
import com.backend.programming.learning.system.kafka.auth.avro.model.organization.ServiceName;
import com.backend.programming.learning.system.kafka.consumer.KafkaConsumer;
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
public class OrganizationRequestKafkaListener implements KafkaConsumer<OrganizationRequestAvroModel> {
    private final OrganizationRequestMessageListener organizationRequestMessageListener;
    private final OrganizationMessagingDataMapper organizationMessagingDataMapper;

    public OrganizationRequestKafkaListener(OrganizationRequestMessageListener organizationRequestMessageListener, OrganizationMessagingDataMapper organizationMessagingDataMapper) {
        this.organizationRequestMessageListener = organizationRequestMessageListener;
        this.organizationMessagingDataMapper = organizationMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.course-service-organization-request-group-id}",
            topics = "${course-service.course-organization-request-topic-name}")
    public void receive(@Payload List<OrganizationRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of organization requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(organizationRequestAvroModel -> {
            try {
                switch (organizationRequestAvroModel.getCopyState()) {
                    case CREATING -> {
                        log.info("Creating organization: {}",
                                organizationRequestAvroModel);
                        organizationRequestMessageListener
                                .organizationCreated(organizationMessagingDataMapper
                                        .organizationCreatedRequestAvroModelToOrganizationRequest(organizationRequestAvroModel));
                    }
                    case DELETING -> {
                        log.info("Deleting organization: {}",
                                organizationRequestAvroModel);
                        organizationRequestMessageListener
                                .organizationDeleted(organizationMessagingDataMapper
                                        .organizationDeletedRequestAvroModelToOrganizationRequest(organizationRequestAvroModel));
                    }
                    case UPDATING -> {
                        log.info("Updating organization: {}",
                                organizationRequestAvroModel);
                        organizationRequestMessageListener
                                .organizationUpdated(organizationMessagingDataMapper
                                        .organizationUpdatedRequestAvroModelToOrganizationRequest(organizationRequestAvroModel));
                    }
                }
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null &&
                        PSQLState.UNIQUE_VIOLATION.getState().equals(sqlException.getSQLState())) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in OrganizationRequestKafkaListener for organization id: {}",
                            sqlException.getSQLState(), organizationRequestAvroModel.getOrganizationId());
                } else {
                    throw new CourseApplicationServiceException("Throwing DataAccessException in" +
                            " UserRequestKafkaListener: " + e.getMessage(), e);
                }
            } catch (OrganizationNotFoundException e) {
                //NO-OP for OrderNotFoundException
                log.error("No organization found for organization id: {}", organizationRequestAvroModel.getOrganizationId());
            }
        });
    }
}
