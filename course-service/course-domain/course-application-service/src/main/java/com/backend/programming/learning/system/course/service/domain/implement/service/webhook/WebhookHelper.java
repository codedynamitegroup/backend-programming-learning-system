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

    public WebhookHelper(
            WebhookDataMapper webhookDataMapper,
            OrganizationRepository organizationRepository,
            SynchronizeStateDetailRepository synchronizeStateDetailRepository, CourseRepository courseRepository, CourseCreateHelper courseCreateHelper,
            CourseUpdateHelper courseUpdateHelper, CourseDeleteHelper courseDeleteHelper,
            CourseUserCreateHelper courseUserCreateHelper, CourseUserDeleteHelper courseUserDeleteHelper,
            UserHelper userHelper, SectionCreateHelper sectionCreateHelper, SectionUpdateHelper sectionUpdateHelper, SectionDeleteHelper sectionDeleteHelper, ModuleCreateHelper moduleCreateHelper, ModuleUpdateHelper moduleUpdateHelper) {
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
    }

    public void processWebhook(WebhookCommand webhookCommand) throws JsonProcessingException {
        WebhookMessage webhookMessage = webhookDataMapper.webhookCommandToWebhookMessage(webhookCommand);
        Organization organization = findOrganization(webhookCommand.getHost());

        switch (webhookMessage.getEventName()) {
            case COURSE_CREATED:
                createCourse(webhookMessage, organization);
                break;
            case COURSE_UPDATED:
                updateCourse(webhookMessage);
                break;
            case COURSE_DELETED:
                deleteCourse(webhookMessage);
                break;
            case USER_CREATED:
                createUser(webhookMessage, organization);
                break;
            case USER_UPDATED:
                updateUser(webhookMessage);
                break;
            case USER_DELETED:
                deleteUser(webhookMessage);
                break;
            case COURSE_SECTION_CREATED:
                createSynchronizeStateDetail(webhookMessage, organization, TypeSynchronize.SECTION);
                break;
            case COURSE_SECTION_UPDATED:
                Course course_section=findCourse(Integer.valueOf(webhookMessage.getCourseId()));
                updateSection(webhookMessage, course_section);
                break;
            case COURSE_SECTION_DELETED:
                UUID courseId=courseRepository.findByCourseIdMoodle(Integer.valueOf(webhookMessage.getCourseId())).get().getId().getValue();
                deleteSection(webhookMessage,courseId);
                break;
            case COURSE_MODULE_CREATED:
               createSynchronizeStateDetail(webhookMessage, organization, TypeSynchronize.MODULE);
                break;
            case COURSE_MODULE_UPDATED:
                updateModule(webhookMessage,organization);
                break;
            case COURSE_MODULE_DELETED:
                break;
            case USER_ENROLLMENT_CREATED:
                enrollUserToCourse(webhookMessage);
                break;
            case USER_ENROLLMENT_DELETED:
                unenrollUserToCourse(webhookMessage);
                break;
            case USER_ENROLLMENT_UPDATED:
                break;
            case ROLE_ASSIGNED:
                break;
            default:
                log.info("Event not found: {}", webhookMessage.getEventName());
        }
    }

    private void updateCourse(WebhookMessage webhookMessage) {
        courseUpdateHelper.updateCourse(webhookMessage);
    }
    private void createCourse(WebhookMessage webhookMessage, Organization organization) {
        courseCreateHelper.createCourse(webhookMessage, organization);
    }
    private void deleteCourse(WebhookMessage webhookMessage) {
        courseDeleteHelper.deleteCourse(Integer.valueOf(webhookMessage.getCourseId()));
    }

    private void createSection(WebhookMessage webhookMessage, Course course) {
        sectionCreateHelper.createSection(webhookMessage, course);
    }

    private void updateSection(WebhookMessage webhookMessage, Course course) {
        sectionUpdateHelper.updateSection(webhookMessage, course);
    }

    private void createModule(WebhookMessage webhookMessage,Organization organization) {
        moduleCreateHelper.createModule(webhookMessage, organization);
    }

    private void updateModule(WebhookMessage webhookMessage,Organization organization) {
        moduleUpdateHelper.updateModule(webhookMessage,organization);
    }

    private void deleteSection(WebhookMessage webhookMessage,UUID courseId) {
        sectionDeleteHelper.deleteSection(webhookMessage.getObjectId(),courseId);
    }
    private void enrollUserToCourse(WebhookMessage webhookMessage) {
        courseUserCreateHelper.enrollUserToCourse(webhookMessage);
    }
    private void unenrollUserToCourse(WebhookMessage webhookMessage) {
        courseUserDeleteHelper.unenrollUserToCourse(webhookMessage);
    }

    private void createUser(WebhookMessage webhookMessage, Organization organization) {
        userHelper.createUser(webhookMessage, organization);
    }
    private void updateUser(WebhookMessage webhookMessage) {
            userHelper.updateUser(webhookMessage);
    }
    private void deleteUser(WebhookMessage webhookMessage) {
        userHelper.deleteUser(webhookMessage);
    }

    private Organization findOrganization(String moodleUrl) {
        Optional<Organization> organization = organizationRepository.findOrganizationByMoodleUrl(moodleUrl);

        if(organization.isEmpty()){
            log.info("Organization not found with moodleUrl: {}", moodleUrl);
            throw new OrganizationNotFoundException("Organization not found with moodleUrl: " + moodleUrl);
        }
        return organization.get();
    }

    private Course findCourse(Integer courseId) {
        Optional<Course> course = courseRepository.findByCourseIdMoodle(courseId);
        if(course.isEmpty()){
            log.info("Course not found with courseId: {}", courseId);
            throw new CourseNotFoundException("Course not found with courseId: " + courseId);
        }
        return course.get();
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
            // Save or process the synchronizeStateDetail as needed
            synchronizeStateDetailRepository.save(synchronizeStateDetail);

        } catch (JsonProcessingException e) {
            log.error("Error serializing webhookMessage: {}", webhookMessage, e);
            // Handle the exception appropriately
        }
    }

}
