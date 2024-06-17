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
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
//        log.info("damn u i am here {}", request.toString());
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
    }

    @Transactional
    public void updateCodeSubmission(CodeSubmissionUpdateRequest request) {
        CodeSubmission codeSubmission = codeSubmissionDataMapper.CodeSubmissionUpdateRequestToCodeSubmission(request);
        codeSubmissionRepository.saveCodeSubmission(codeSubmission);
    }

    @Transactional
    public void saveContest(UUID contestId, UUID codeSubmissionId){
        if(contestId != null)
            codeSubmissionContestRepository.saveCodeSubmissionContest(CodeSubmissionContest.builder()
                    .id(new CodeSubmissionId(codeSubmissionId))
                    .contestId(new ContestId(contestId))
                    .build());
    }
    @Transactional
    public void saveCerCourse(UUID cerCourseId, UUID codeSubmissionId){
        if(cerCourseId != null)
            codeSubmissionCertificateCourseRepository.saveCodeSubmissionCertificateCourse(CodeSubmissionCertificateCourse.builder()
                    .id(new CodeSubmissionId(codeSubmissionId))
                    .certificateCourseId(new CertificateCourseId(cerCourseId))
                    .build());
    }
}
