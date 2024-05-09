package com.backend.programming.learning.system.course.service.domain.implement.service.webhook;

import com.backend.programming.learning.system.course.service.domain.dto.method.webhook.WebhookCommand;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.course.CourseUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.listener.user.UserRequestHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.webhook.WebhookDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.WebhookEventName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class WebhookHelper {
    private final WebhookDataMapper webhookDataMapper;
    //    private final WebhookApiFunctionRepository webhookApiFunctionRepository;
    private final UserRequestHelper userRequestHelper;
    private final OrganizationRepository organizationRepository;
    private final CourseCreateHelper courseCreateHelper;
    private final CourseUpdateHelper courseUpdateHelper;


    public WebhookHelper(
            WebhookDataMapper webhookDataMapper,
            UserRequestHelper userRequestHelper,
            OrganizationRepository organizationRepository,
            CourseCreateHelper courseCreateHelper,
            CourseUpdateHelper courseUpdateHelper) {
        this.webhookDataMapper = webhookDataMapper;
        this.userRequestHelper = userRequestHelper;
        this.organizationRepository = organizationRepository;
        this.courseCreateHelper = courseCreateHelper;
        this.courseUpdateHelper = courseUpdateHelper;
    }

    public void processWebhook(WebhookCommand webhookCommand) {
        WebhookMessage webhookMessage = webhookDataMapper.webhookCommandToWebhookMessage(webhookCommand);
        Organization organization = findOrganization(webhookCommand.getHost());

        switch (webhookMessage.getEventName()) {
            case COURSE_CREATED:
                createCourse(webhookMessage);
                break;
            case COURSE_UPDATED:
                updateCourse(webhookMessage);
                break;
            case COURSE_DELETED:
//                courseRequestHelper.deleteCourse(webhookMessage, organization);
                break;
            case USER_CREATED:
//                userRequestHelper.createUser(webhookMessage, organization);
                break;
            case USER_UPDATED:
//                userRequestHelper.updateUser(webhookMessage, organization);
                break;
            case USER_DELETED:
//                userRequestHelper.deleteUser(webhookMessage, organization);
                break;
            default:
                log.info("Event not found: {}", webhookMessage.getEventName());
        }


//        log.info("Webhook host organization: {}", organization.getName());
    }

    private void updateCourse(WebhookMessage webhookMessage) {
//        courseUpdateHelper.updateCourse(webhookMessage);
    }

    private void createCourse(WebhookMessage webhookMessage) {
        courseCreateHelper.createCourse(webhookMessage);
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
