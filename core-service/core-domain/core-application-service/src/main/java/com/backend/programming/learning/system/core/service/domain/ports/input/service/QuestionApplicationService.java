package com.backend.programming.learning.system.core.service.domain.ports.input.service;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;

import javax.validation.Valid;

public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(@Valid CreateQuestionCommand createQuestionCommand);
}
