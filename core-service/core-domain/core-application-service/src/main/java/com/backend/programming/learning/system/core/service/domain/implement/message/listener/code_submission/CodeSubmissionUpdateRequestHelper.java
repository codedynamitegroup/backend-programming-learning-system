package com.backend.programming.learning.system.core.service.domain.implement.message.listener.code_submission;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeSubmissionUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionCertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmissionContest;
import com.backend.programming.learning.system.core.service.domain.mapper.code_submission.CodeSubmissionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionCertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeSubmissionRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CodeSubmissionUpdateRequestHelper {
    final CodeSubmissionRepository codeSubmissionRepository;
    final CodeSubmissionDataMapper codeSubmissionDataMapper;
    final CodeSubmissionContestRepository codeSubmissionContestRepository;
    final CodeSubmissionCertificateCourseRepository codeSubmissionCertificateCourseRepository;

    public CodeSubmissionUpdateRequestHelper(CodeSubmissionRepository codeSubmissionRepository, CodeSubmissionDataMapper codeSubmissionDataMapper, CodeSubmissionContestRepository codeSubmissionContestRepository, CodeSubmissionCertificateCourseRepository codeSubmissionCertificateCourseRepository) {
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.codeSubmissionDataMapper = codeSubmissionDataMapper;
        this.codeSubmissionContestRepository = codeSubmissionContestRepository;
        this.codeSubmissionCertificateCourseRepository = codeSubmissionCertificateCourseRepository;
    }

    @Transactional
    public void persistCodeSubmission(CodeSubmissionUpdateRequest request) {
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
        if(request.getCerCourseId() != null)
            codeSubmissionCertificateCourseRepository.saveCodeSubmissionCertificateCourse(CodeSubmissionCertificateCourse.builder()
                            .id(codeSubmission.getId())
                            .certificateCourseId(new CertificateCourseId(request.getCerCourseId()))
                    .build());
        if(request.getContestId() != null)
            codeSubmissionContestRepository.saveCodeSubmissionContest(CodeSubmissionContest.builder()
                            .id(codeSubmission.getId())
                            .contestId(new ContestId(request.getContestId()))
                    .build());
    }

    @Transactional
    public void updateCodeSubmission(CodeSubmissionUpdateRequest request) {
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
        if(request.getCerCourseId() != null)
            codeSubmissionCertificateCourseRepository.saveCodeSubmissionCertificateCourse(CodeSubmissionCertificateCourse.builder()
                    .id(codeSubmission.getId())
                    .certificateCourseId(new CertificateCourseId(request.getCerCourseId()))
                    .build());
        if(request.getContestId() != null)
            codeSubmissionContestRepository.saveCodeSubmissionContest(CodeSubmissionContest.builder()
                    .id(codeSubmission.getId())
                    .contestId(new ContestId(request.getContestId()))
                    .build());
    }
}
