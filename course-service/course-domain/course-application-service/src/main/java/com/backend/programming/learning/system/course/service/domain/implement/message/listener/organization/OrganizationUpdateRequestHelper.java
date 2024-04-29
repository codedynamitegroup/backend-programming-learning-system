package com.backend.programming.learning.system.course.service.domain.implement.message.listener.organization;


import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationUpdateFailedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.organization.OrganizationUpdatedSuccessMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrganizationUpdateRequestHelper {
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationRepository organizationRepository;
    private final CourseDomainService courseDomainService;
    private final OrganizationUpdatedSuccessMessagePublisher organizationUpdatedSuccessMessagePublisher;
    private final OrganizationUpdateFailedMessagePublisher organizationUpdateFailedMessagePublisher;

    public OrganizationUpdateRequestHelper(OrganizationDataMapper organizationDataMapper, OrganizationRepository organizationRepository, CourseDomainService courseDomainService, OrganizationUpdatedSuccessMessagePublisher organizationUpdatedSuccessMessagePublisher, OrganizationUpdateFailedMessagePublisher organizationUpdateFailedMessagePublisher) {
        this.organizationDataMapper = organizationDataMapper;
        this.organizationRepository = organizationRepository;
        this.courseDomainService = courseDomainService;
        this.organizationUpdatedSuccessMessagePublisher = organizationUpdatedSuccessMessagePublisher;
        this.organizationUpdateFailedMessagePublisher = organizationUpdateFailedMessagePublisher;
    }

    @Transactional
    public OrganizationEvent persistOrganization(OrganizationUpdateRequest organizationUpdateRequest) {
        Organization organization = organizationDataMapper.organizationUpdateRequestToOrganization(organizationUpdateRequest);
        Optional<Organization> organizationFound = organizationRepository.findOrganizationById(organization.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find organization with id
        if (organizationFound.isEmpty()) {
            log.error("Not found organization with id: {}", organization.getId().getValue());
            failureMessages.add("Not found organization with id: " + organization.getId().getValue());
            return courseDomainService.updateOrganizationFail(organization,
                    organizationUpdateFailedMessagePublisher,
                    failureMessages);
        }

        //Update organization
        Organization organizationUpdated = organizationFound.get();

        organizationUpdated.setUpdatedAt(organization.getUpdatedAt());

        if (organizationUpdateRequest.getName() != null) {
            organizationUpdated.setName(organization.getName());
        }

        if(organizationUpdated.getDescription() !=null){
            organizationUpdated.setDescription(organization.getDescription());//Save organization
        }
        Organization organizationSaved = organizationRepository.saveOrganization(organizationUpdated);
        if (organizationSaved == null) {
            log.error("Could not update organization with id: {}", organization.getId().getValue());
            failureMessages.add("Could not update organization with id: " + organization.getId().getValue());
            return courseDomainService.updateOrganizationFail(organization,
                    organizationUpdateFailedMessagePublisher,
                    failureMessages);
        }

        return courseDomainService.updateOrganizationSuccess(organizationSaved,
                organizationUpdatedSuccessMessagePublisher);
    }
}
