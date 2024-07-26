package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.CourseNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course_user.CourseUserCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course_user.CourseUserDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.section.SectionDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.section.SectionCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.section.SectionUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.submission_assignment.SubmissionAssignmentCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.user.UserHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.webhook.WebhookDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateDetailRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.SynchronizeStateDetailId;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronize;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class WebhookHelper {
    private static final String ORGANIZATION_NOT_FOUND = "Organization not found with moodleUrl: ";
    private static final String COURSE_NOT_FOUND = "Course not found with courseId: ";

    private final WebhookDataMapper webhookDataMapper;
    private final OrganizationRepository organizationRepository;
    private final SynchronizeStateDetailRepository synchronizeStateDetailRepository;
    private final CourseRepository courseRepository;
    private final CourseCreateHelper courseCreateHelper;
    private final CourseUpdateHelper courseUpdateHelper;
    private final CourseDeleteHelper courseDeleteHelper;
    private final CourseUserCreateHelper courseUserCreateHelper;
    private final CourseUserDeleteHelper courseUserDeleteHelper;
    private final UserHelper userHelper;
    private final SectionCreateHelper sectionCreateHelper;
    private final SectionUpdateHelper sectionUpdateHelper;
    private final SectionDeleteHelper sectionDeleteHelper;
    private final ModuleCreateHelper moduleCreateHelper;
    private final ModuleUpdateHelper moduleUpdateHelper;
    private final SubmissionAssignmentCreateHelper submissionAssignmentCreateHelper;

    public WebhookHelper(
            WebhookDataMapper webhookDataMapper,
            OrganizationRepository organizationRepository,
            SynchronizeStateDetailRepository synchronizeStateDetailRepository,
            CourseRepository courseRepository,
            CourseCreateHelper courseCreateHelper,
            CourseUpdateHelper courseUpdateHelper,
            CourseDeleteHelper courseDeleteHelper,
            CourseUserCreateHelper courseUserCreateHelper,
            CourseUserDeleteHelper courseUserDeleteHelper,
            UserHelper userHelper,
            SectionCreateHelper sectionCreateHelper,
            SectionUpdateHelper sectionUpdateHelper,
            SectionDeleteHelper sectionDeleteHelper,
            ModuleCreateHelper moduleCreateHelper,
            ModuleUpdateHelper moduleUpdateHelper,
            SubmissionAssignmentCreateHelper submissionAssignmentCreateHelper
    ) {
        this.webhookDataMapper = webhookDataMapper;
        this.organizationRepository = organizationRepository;
        this.synchronizeStateDetailRepository = synchronizeStateDetailRepository;
        this.courseRepository = courseRepository;
        this.courseCreateHelper = courseCreateHelper;
        this.courseUpdateHelper = courseUpdateHelper;
        this.courseDeleteHelper = courseDeleteHelper;
        this.courseUserCreateHelper = courseUserCreateHelper;
        this.courseUserDeleteHelper = courseUserDeleteHelper;
        this.userHelper = userHelper;
        this.sectionCreateHelper = sectionCreateHelper;
        this.sectionUpdateHelper = sectionUpdateHelper;
        this.sectionDeleteHelper = sectionDeleteHelper;
        this.moduleCreateHelper = moduleCreateHelper;
        this.moduleUpdateHelper = moduleUpdateHelper;
        this.submissionAssignmentCreateHelper = submissionAssignmentCreateHelper;
    }

    public void processWebhook(WebhookCommand webhookCommand) throws JsonProcessingException {
        WebhookMessage webhookMessage = webhookDataMapper.webhookCommandToWebhookMessage(webhookCommand);
        Organization organization = findOrganization(webhookCommand.getHost());

        switch (webhookMessage.getEventName()) {
            case COURSE_CREATED -> createCourse(webhookMessage, organization);
            case COURSE_UPDATED -> updateCourse(webhookMessage, organization);
            case COURSE_DELETED -> deleteCourse(webhookMessage, organization);
            case USER_CREATED -> createUser(webhookMessage, organization);
            case USER_UPDATED -> updateUser(webhookMessage, organization);
            case USER_DELETED -> deleteUser(webhookMessage, organization);
            case COURSE_SECTION_CREATED -> createSynchronizeStateDetail(webhookMessage, organization, TypeSynchronize.SECTION);
            case COURSE_SECTION_UPDATED -> updateSection(webhookMessage, findCourse(Integer.valueOf(webhookMessage.getCourseId()), organization.getId().getValue()));
            case COURSE_SECTION_DELETED -> deleteSection(webhookMessage, getCourseIdByMoodleId(webhookMessage, organization));
            case COURSE_MODULE_CREATED -> createSynchronizeStateDetail(webhookMessage, organization, TypeSynchronize.MODULE);
            case COURSE_MODULE_UPDATED -> updateModule(webhookMessage, organization);
            case ASSIGN_SUBMISSION_FILE_CREATED, ASSIGN_SUBMISSION_FILE_UPDATED, ASSIGN_SUBMISSION_ONLINETEXT_CREATED, ASSIGN_SUBMISSION_ONLINETEXT_UPDATED -> createSubmissionAssignment(webhookMessage, organization, findCourse(Integer.valueOf(webhookMessage.getCourseId()), organization.getId().getValue()));
            case USER_ENROLLMENT_CREATED -> enrollUserToCourse(webhookMessage, organization);
            case USER_ENROLLMENT_DELETED -> unenrollUserToCourse(webhookMessage, organization);
            case ROLE_ASSIGNED, USER_ENROLLMENT_UPDATED -> log.info("Event not handled: {}", webhookMessage.getEventName());
            default -> log.info("Event not found: {}", webhookMessage.getEventName());
        }
    }

    private void updateCourse(WebhookMessage webhookMessage, Organization organization) {
        courseUpdateHelper.updateCourse(webhookMessage, organization);
    }

    private void createCourse(WebhookMessage webhookMessage, Organization organization) {
        courseCreateHelper.createCourse(webhookMessage, organization);
    }

    private void deleteCourse(WebhookMessage webhookMessage, Organization organization) {
        courseDeleteHelper.deleteCourse(Integer.valueOf(webhookMessage.getCourseId()), organization.getId().getValue());
    }

    private void updateSection(WebhookMessage webhookMessage, Course course) {
        sectionUpdateHelper.updateSection(webhookMessage, course);
    }

    private void deleteSection(WebhookMessage webhookMessage, UUID courseId) {
        sectionDeleteHelper.deleteSection(webhookMessage.getObjectId(), courseId);
    }

    private void updateModule(WebhookMessage webhookMessage, Organization organization) {
        moduleUpdateHelper.updateModule(webhookMessage, organization);
    }

    private void createSubmissionAssignment(WebhookMessage webhookMessage, Organization organization,Course course) {
        submissionAssignmentCreateHelper.createSubmissionAssignment(webhookMessage, organization,course);
    }

    private void enrollUserToCourse(WebhookMessage webhookMessage,Organization organization) {
        courseUserCreateHelper.enrollUserToCourse(webhookMessage,organization);
    }

    private void unenrollUserToCourse(WebhookMessage webhookMessage,Organization organization) {
        courseUserDeleteHelper.unenrollUserToCourse(webhookMessage,organization);
    }

    private void createUser(WebhookMessage webhookMessage, Organization organization) {
        userHelper.createUser(webhookMessage, organization);
    }

    private void updateUser(WebhookMessage webhookMessage, Organization organization) {
        userHelper.updateUser(webhookMessage, organization);
    }

    private void deleteUser(WebhookMessage webhookMessage, Organization organization) {
        userHelper.deleteUser(webhookMessage, organization);
    }

    private Organization findOrganization(String moodleUrl) {
        return organizationRepository.findOrganizationByMoodleUrl(moodleUrl)
                .orElseThrow(() -> {
                    log.info(ORGANIZATION_NOT_FOUND + moodleUrl);
                    return new OrganizationNotFoundException(ORGANIZATION_NOT_FOUND + moodleUrl);
                });
    }

    private Course findCourse(Integer courseId,UUID organizationId) {
        return courseRepository.findByCourseIdMoodleAndOrganizationId(courseId, organizationId)
                .orElseThrow(() -> {
                    log.info(COURSE_NOT_FOUND + courseId);
                    return new CourseNotFoundException(COURSE_NOT_FOUND + courseId);
                });
    }

    private UUID getCourseIdByMoodleId(WebhookMessage webhookMessage,Organization organization) {
        return courseRepository.findByCourseIdMoodleAndOrganizationId(Integer.valueOf(webhookMessage.getCourseId()), organization.getId().getValue())
                .orElseThrow(() -> new CourseNotFoundException(COURSE_NOT_FOUND + webhookMessage.getCourseId()))
                .getId()
                .getValue();
    }

    private void createSynchronizeStateDetail(WebhookMessage webhookMessage, Organization organization, TypeSynchronize typeSynchronize) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            String webhookMessageJson = objectMapper.writeValueAsString(webhookMessage);
            SynchronizeStateDetail synchronizeStateDetail = SynchronizeStateDetail.builder()
                    .id(new SynchronizeStateDetailId(UUID.randomUUID()))
                    .organization(organization)
                    .typeSynchronize(typeSynchronize)
                    .webhookMessage(webhookMessageJson)
                    .status(TypeSynchronizeStatus.PENDING)
                    .timeCreated(webhookMessage.getTimeCreated())
                    .build();
            synchronizeStateDetailRepository.save(synchronizeStateDetail);
        } catch (JsonProcessingException e) {
            log.error("Error serializing webhookMessage: {}", webhookMessage, e);
        }
    }
}
