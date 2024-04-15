package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.OrganizationsUpdate;

public interface OrganizationsUpdateMessageListener {
    void createOrganization(OrganizationsUpdate organizationsUpdate);
    void updateOrganization(OrganizationsUpdate organizationsUpdate);
    void deleteOrganization(OrganizationsUpdate organizationsUpdate);

}
