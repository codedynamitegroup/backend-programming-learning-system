package com.backend.programming.learning.system.course.service.dataaccess.submission_file.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.submission_file.mapper.SubmissionFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.submission_file.repository.SubmissionFileJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.entity.SubmissionFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SubmissionFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SubmissionFileRepositoryImpl implements SubmissionFileRepository {

    private final SubmissionFileJpaRepository submissionFileJpaRepository;
    private final SubmissionFileDataAccessMapper submissionFileDataAccessMapper;


    @Override
    public Optional<SubmissionFile> findById(UUID submissionFileId) {
        return submissionFileJpaRepository.findById(submissionFileId).map(submissionFileDataAccessMapper::submissionFileEntityToSubmissionFile);
    }

    @Override
    public SubmissionFile save(SubmissionFile submissionFile) {
        return submissionFileDataAccessMapper.submissionFileEntityToSubmissionFile(submissionFileJpaRepository
                .saveAndFlush(submissionFileDataAccessMapper
                        .submissionFileToSubmissionFileEntity(submissionFile)));
    }

    @Override
    public void deleteById(UUID submissionFileId) {
        submissionFileJpaRepository.deleteById(submissionFileId);

    }

    @Override
    public List<SubmissionFile> findBySubmissionAssignmentFileId(UUID submissionAssignmentFileId) {
        return submissionFileDataAccessMapper.submissionFileEntityListToSubmissionFileList(submissionFileJpaRepository.findAllBySubmissionAssignmentFileId(submissionAssignmentFileId));
    }


}
