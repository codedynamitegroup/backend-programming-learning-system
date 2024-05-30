package com.backend.programming.learning.system.course.service.dataaccess.intro_file.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.intro_file.mapper.IntroFileDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.intro_file.repository.IntroFileJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.IntroFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class IntroFileRepositoryImpl implements IntroFileRepository {

    private final IntroFileJpaRepository introFileJpaRepository;
    private final IntroFileDataAccessMapper introFileDataAccessMapper;


    @Override
    public Optional<IntroFile> findById(UUID introFileId) {
        return introFileJpaRepository.findById(introFileId)
                .map(introFileDataAccessMapper::introFileEntityToIntroFile);
    }

    @Override
    public List<IntroFile> findAllByAssignmentId(UUID assignmentId) {
        return introFileDataAccessMapper.introFileEntityListToIntroFileList(introFileJpaRepository.findAllByAssignmentId(assignmentId));
    }

    @Override
    public IntroFile save(IntroFile introFile) {
        return introFileDataAccessMapper.introFileEntityToIntroFile(introFileJpaRepository
                .saveAndFlush(introFileDataAccessMapper
                        .introFileToIntroFileEntity(introFile)));
    }

    @Override
    public void deleteById(UUID introFileId) {
        introFileJpaRepository.deleteById(introFileId);
    }

}
