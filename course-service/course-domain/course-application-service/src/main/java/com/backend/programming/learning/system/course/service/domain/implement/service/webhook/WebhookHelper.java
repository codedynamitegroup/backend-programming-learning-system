package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course_user.CourseUserCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course_user.CourseUserDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.user.UserHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.webhook.WebhookDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class WebhookHelper {
    private final WebhookDataMapper webhookDataMapper;
    private final OrganizationRepository organizationRepository;
    private final CourseCreateHelper courseCreateHelper;
    private final CourseUpdateHelper courseUpdateHelper;
    private final CourseDeleteHelper courseDeleteHelper;
    private final CourseUserCreateHelper courseUserCreateHelper;
    private final CourseUserDeleteHelper courseUserDeleteHelper;
    private final UserHelper userHelper;

    public WebhookHelper(
            WebhookDataMapper webhookDataMapper,
            OrganizationRepository organizationRepository,
            CourseCreateHelper courseCreateHelper,
            CourseUpdateHelper courseUpdateHelper, CourseDeleteHelper courseDeleteHelper,
            CourseUserCreateHelper courseUserCreateHelper, CourseUserDeleteHelper courseUserDeleteHelper,
            UserHelper userHelper) {
        this.webhookDataMapper = webhookDataMapper;
        this.organizationRepository = organizationRepository;
        this.courseCreateHelper = courseCreateHelper;
        this.courseUpdateHelper = courseUpdateHelper;
        this.courseDeleteHelper = courseDeleteHelper;
        this.courseUserCreateHelper = courseUserCreateHelper;
        this.courseUserDeleteHelper = courseUserDeleteHelper;
        this.userHelper = userHelper;
    }

    public void processWebhook(WebhookCommand webhookCommand) {
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
                break;
            case COURSE_SECTION_CREATED:
                break;
            case COURSE_SECTION_UPDATED:
                break;
            case COURSE_SECTION_DELETED:
                break;
            case COURSE_MODULE_CREATED:
                break;
            case COURSE_MODULE_UPDATED:
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
//            case ENROL_INSTANCE_CREATED:
//                break;
//            case ENROL_INSTANCE_UPDATED:
//                break;
//            case ENROL_INSTANCE_DELETED:
//                break;
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

    private Organization findOrganization(String moodleUrl) {
        Optional<Organization> organization = organizationRepository.findOrganizationByMoodleUrl(moodleUrl);

        if(organization.isEmpty()){
            log.info("Organization not found with moodleUrl: {}", moodleUrl);
            throw new OrganizationNotFoundException("Organization not found with moodleUrl: " + moodleUrl);
        }
        return organization.get();
    }
}
