package com.backend.programming.learning.system.core.service.dataaccess.code_submission.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.chapter.mapper.ChapterDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.chapter.repository.ChapterJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission.mapper.CodeSubmissionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.code_submission.repository.CodeSubmissionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionRepository;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionRepositoryImpl implements CodeSubmissionRepository {
    private final CodeSubmissionJpaRepository codeSubmissionJpaRepository;
    private final CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper;

    public CodeSubmissionRepositoryImpl(CodeSubmissionJpaRepository codeSubmissionJpaRepository,
                                         CodeSubmissionDataAccessMapper codeSubmissionDataAccessMapper) {
        this.codeSubmissionJpaRepository = codeSubmissionJpaRepository;
        this.codeSubmissionDataAccessMapper = codeSubmissionDataAccessMapper;
    }

    @Override
    public CodeSubmission saveCodeSubmission(CodeSubmission codeSubmission) {
        return codeSubmissionDataAccessMapper.codeSubmissionEntityToCodeSubmission(
                codeSubmissionJpaRepository.save(
                        codeSubmissionDataAccessMapper.
                                codeSubmissionToCodeSubmissionEntity(codeSubmission)));
    }
}
