package com.backend.programming.learning.system.course.service.domain.implement.message.listener.organization;


import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationDeleteFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationDeletedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrganizationDeleteRequestHelper {
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationRepository organizationRepository;
    private final CourseDomainService courseDomainService;
    private final OrganizationDeletedSuccessMessagePublisher organizationDeletedSuccessMessagePublisher;
    private final OrganizationDeleteFailedMessagePublisher organizationDeleteFailedMessagePublisher;

    public OrganizationDeleteRequestHelper(OrganizationDataMapper organizationDataMapper,
                                           OrganizationRepository organizationRepository,
                                           CourseDomainService courseDomainService,
                                           OrganizationDeletedSuccessMessagePublisher organizationDeletedSuccessMessagePublisher,
                                           OrganizationDeleteFailedMessagePublisher organizationDeleteFailedMessagePublisher) {
        this.organizationDataMapper = organizationDataMapper;
        this.organizationRepository = organizationRepository;
        this.courseDomainService = courseDomainService;
        this.organizationDeletedSuccessMessagePublisher = organizationDeletedSuccessMessagePublisher;
        this.organizationDeleteFailedMessagePublisher = organizationDeleteFailedMessagePublisher;
    }


    @Transactional
    public OrganizationEvent persistOrganization(OrganizationDeleteRequest organizationRequest) {
        Organization organization = organizationDataMapper.organizationDeleteRequestToOrganization(organizationRequest);
        Optional<Organization> organizationFound = organizationRepository.findOrganizationById(organization.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find organization with id
        if (organizationFound.isEmpty()) {
            log.error("Not found organization with id: {}", organization.getId().getValue());
            failureMessages.add("Not found organization with id: " + organization.getId().getValue());
            return courseDomainService.deleteOrganizationFail(organization,
                    organizationDeleteFailedMessagePublisher,
                    failureMessages);
        }

        //Deleting organization
        Organization organizationDeleted = organizationFound.get();

        organizationDeleted.setDeleted(organization.getDeleted());

        //Save organization
        Organization organizationSaved = organizationRepository.saveOrganization(organizationDeleted);
        if (organizationSaved == null) {
            log.error("Could not delete organization with id: {}", organization.getId().getValue());
            failureMessages.add("Could not delete organization with id: " + organization.getId().getValue());
            return courseDomainService.deleteOrganizationFail(organization,
                    organizationDeleteFailedMessagePublisher,
                    failureMessages);
        }
        log.info("Organization is deleted with id: {}", organizationSaved.getId().getValue());
        return courseDomainService.deleteOrganizationSuccess(organizationSaved,
                organizationDeletedSuccessMessagePublisher);
    }

}
