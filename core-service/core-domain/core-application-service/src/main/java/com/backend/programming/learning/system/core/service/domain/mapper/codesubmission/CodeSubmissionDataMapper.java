package com.backend.programming.learning.system.core.service.domain.mapper.codesubmission;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.codesubmission.CodeSubmissionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CodeSubmissionDataMapper {
    public CodeSubmission codeSubmissionResponseEntityToCodeSubmission(CodeSubmissionResponseEntity codeSubmissionResponseEntity) {
        return CodeSubmission.builder()
                .id(new CodeSubmissionId(codeSubmissionResponseEntity.getCodeSubmissionId()))
                .codeQuestionId(new QtypeCodeQuestionId(codeSubmissionResponseEntity.getCodeQuestionId()))
                .userId(new UserId(codeSubmissionResponseEntity.getUserId()))
                .programmingLanguageId(new ProgrammingLanguageId(codeSubmissionResponseEntity.getProgrammingLanguageId()))
                .sourceCode(codeSubmissionResponseEntity.getSourceCode())
                .grade(codeSubmissionResponseEntity.getGrade())
                .pass(codeSubmissionResponseEntity.getPass())
                .createdAt(codeSubmissionResponseEntity.getCreatedAt())
                .build();
    }

   public CodeSubmissionResponseEntity codeSubmissionToCodeSubmissionResponseEntity(CodeSubmission codeSubmission) {
        return CodeSubmissionResponseEntity.builder()
                .codeSubmissionId(codeSubmission.getId().getValue())
                .userId(codeSubmission.getUserId().getValue())
                .codeQuestionId(codeSubmission.getCodeQuestionId().getValue())
                .programmingLanguageId(codeSubmission.getProgrammingLanguageId().getValue())
                .sourceCode(codeSubmission.getSourceCode())
                .grade(codeSubmission.getGrade())
                .pass(codeSubmission.getPass())
                .createdAt(codeSubmission.getCreatedAt())
                .build();
    }
}
