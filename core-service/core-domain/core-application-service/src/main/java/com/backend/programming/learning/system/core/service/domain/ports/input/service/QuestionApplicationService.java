package com.backend.programming.learning.system.core.service.domain.ports.input.service;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;

import javax.validation.Valid;

public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(@Valid CreateQuestionCommand createQuestionCommand);
}
