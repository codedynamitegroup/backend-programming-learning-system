package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import javax.validation.Valid;
import java.util.List;

public interface OrganizationApplicationService {
    CreateOrganizationResponse createOrganization(@Valid CreateOrganizationCommand createOrganizationCommand);
    QueryOrganizationResponse findOrganizationById(@Valid QueryOrganizationCommand queryOrganizationCommand);
    List<QueryOrganizationResponse> findAllOrganizations();
    DeleteOrganizationResponse deleteOrganizationById(@Valid DeleteOrganizationCommand deleteOrganizationCommand);
}
