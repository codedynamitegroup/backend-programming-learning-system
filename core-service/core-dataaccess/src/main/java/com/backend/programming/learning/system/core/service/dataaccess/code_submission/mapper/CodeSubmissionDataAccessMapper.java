package com.backend.programming.learning.system.core.service.dataaccess.code_submission.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.entity.ChapterEntity;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionDataAccessMapper {

    public CodeSubmissionEntity codeSubmissionToCodeSubmissionEntity(
            com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission codeSubmission) {
        return CodeSubmissionEntity.builder()
                .id(codeSubmission.getId().getValue())
                .codeQuestionId(codeSubmission.getCodeQuestionId().getValue())
                .userId(codeSubmission.getUserId().getValue())
                .programmingLanguageId(codeSubmission.getProgrammingLanguageId().getValue())
                .sourceCode(codeSubmission.getSourceCode())
                .grade(codeSubmission.getGrade())
                .pass(codeSubmission.getPass())
                .build();
    }

    public CodeSubmission codeSubmissionEntityToCodeSubmission(CodeSubmissionEntity codeSubmissionEntity) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(codeSubmissionEntity.getId()))
                .codeQuestionId(new QtypeCodeQuestionId(codeSubmissionEntity.getCodeQuestionId()))
                .userId(new UserId(codeSubmissionEntity.getUserId()))
                .programmingLanguageId(new ProgrammingLanguageId(codeSubmissionEntity.getProgrammingLanguageId()))
                .sourceCode(codeSubmissionEntity.getSourceCode())
                .grade(codeSubmissionEntity.getGrade())
                .pass(codeSubmissionEntity.getPass())
                .build();
    }
}
