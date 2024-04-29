package com.backend.programming.learning.system.course.service.domain.implement.message.listener.organization;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationCreateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationCreateFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationCreatedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrganizationCreateRequestHelper {
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationRepository organizationRepository;
    private final CourseDomainService courseDomainService;
    private final OrganizationCreatedSuccessMessagePublisher organizationCreatedSuccessMessagePublisher;
    private final OrganizationCreateFailedMessagePublisher organizationCreateFailedMessagePublisher;


    public OrganizationCreateRequestHelper(OrganizationDataMapper organizationDataMapper,
                                           OrganizationRepository organizationRepository,
                                           CourseDomainService courseDomainService,
                                           OrganizationCreatedSuccessMessagePublisher organizationCreatedSuccessMessagePublisher,
                                           OrganizationCreateFailedMessagePublisher organizationCreateFailedMessagePublisher) {
        this.organizationDataMapper = organizationDataMapper;
        this.organizationRepository = organizationRepository;
        this.courseDomainService = courseDomainService;
        this.organizationCreatedSuccessMessagePublisher = organizationCreatedSuccessMessagePublisher;
        this.organizationCreateFailedMessagePublisher = organizationCreateFailedMessagePublisher;
    }

    @Transactional
    public OrganizationEvent persistOrganization(OrganizationCreateRequest OrganizationRequest) {
        Organization organization = organizationDataMapper.organizationCreateRequestToOrganization(OrganizationRequest);
        Optional<Organization> organizationResult = organizationRepository.findOrganizationByName(organization.getName());
        List<String> failureMessages = new ArrayList<>();
        //Find organization with name
        if (organizationResult.isPresent()) {
            log.error("Found organization with name: {}", organization.getName());
            failureMessages.add("Found organization with name: " + organization.getName());
            return courseDomainService.createOrganizationFail(organization,
                    organizationCreateFailedMessagePublisher,
                    failureMessages);
        }

        //Save organization
        Organization organizationSaved = organizationRepository.saveOrganization(organization);
        if (organizationSaved == null) {
            log.error("Could not create organization with id: {}", organization.getId().getValue());
            failureMessages.add("Could not create organization with id: " + organization.getId().getValue());
            return courseDomainService.createOrganizationFail(organization,
                    organizationCreateFailedMessagePublisher,
                    failureMessages);
        }
        log.info("Organization is created with id: {}", organizationSaved.getId().getValue());
        return courseDomainService.createOrganizationSuccess(organizationSaved, organizationCreatedSuccessMessagePublisher);
    }
}
