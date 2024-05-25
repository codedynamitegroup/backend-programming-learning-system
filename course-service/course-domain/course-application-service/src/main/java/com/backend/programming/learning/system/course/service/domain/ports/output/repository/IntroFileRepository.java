package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IntroFileRepository {

    Optional<IntroFile> findById(UUID introFileId);

    List<IntroFile> findAllByAssignmentId(UUID assignmentId);

    IntroFile save(IntroFile introFile);

    void deleteById(UUID introFileId);
}
