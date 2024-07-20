package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.SynchronizeStateDetailScheduler;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.CourseNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.implement.service.section.SectionCommandHandler;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state_detail.SynchronizeStateDetailApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateDetailRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronize;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Component
public class SynchronizeStateDetailScheduler {

    private final SynchronizeStateDetailRepository synchronizeStateDetailRepository;
    private final SynchronizeStateDetailApplicationService synchronizeStateDetailApplicationService;

    private final ModuleCommandHandler moduleCommandHandler;
    private final SectionCommandHandler sectionCommandHandler;
    private final CourseRepository courseRepository;

    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}", initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        List<SynchronizeStateDetail> synchronizeStateDetails = synchronizeStateDetailRepository.findSynchronizeStateDetailByStatus(TypeSynchronizeStatus.PENDING);

        synchronizeStateDetails.forEach(synchronizeStateDetail -> {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            WebhookMessage webhookMessage = null;
            try {
                webhookMessage = objectMapper.readValue(synchronizeStateDetail.getWebhookMessage(), WebhookMessage.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            if(synchronizeStateDetail.getTypeSynchronize().equals(TypeSynchronize.MODULE)) {
                Boolean success = moduleCommandHandler.createModule(webhookMessage, synchronizeStateDetail.getOrganization());
                if (success) {
                    synchronizeStateDetail.setStatus(TypeSynchronizeStatus.SUCCESS);
                    synchronizeStateDetailRepository.save(synchronizeStateDetail);
                }
            }
            else if(synchronizeStateDetail.getTypeSynchronize().equals(TypeSynchronize.SECTION)) {

                Course course = findCourse(Integer.valueOf(webhookMessage.getCourseId()));

                Boolean success = sectionCommandHandler.createSection(webhookMessage,course);
                if (success) {
                    synchronizeStateDetail.setStatus(TypeSynchronizeStatus.SUCCESS);
                    synchronizeStateDetailRepository.save(synchronizeStateDetail);
                }
            }

        });
    }

    private Course findCourse(Integer courseId) {
        Optional<Course> course = courseRepository.findByCourseIdMoodle(courseId);
        if(course.isEmpty()){
            log.info("Course not found with courseId: {}", courseId);
            throw new CourseNotFoundException("Course not found with courseId: " + courseId);
        }
        return course.get();
    }
}
