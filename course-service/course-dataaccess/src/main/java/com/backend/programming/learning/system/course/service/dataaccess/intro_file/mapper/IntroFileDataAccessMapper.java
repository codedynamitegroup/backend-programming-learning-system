package com.backend.programming.learning.system.course.service.dataaccess.intro_file.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.intro_file.entity.IntroFileEntity;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import com.backend.programming.learning.system.course.service.domain.valueobject.IntroFileId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IntroFileDataAccessMapper {

    private final AssignmentDataAccessMapper assignmentDataAccessMapper;


    public IntroFile introFileEntityToIntroFile(IntroFileEntity introFileEntity) {
        return IntroFile.builder()
                .id(new IntroFileId(introFileEntity.getId()))
                .assignment(assignmentDataAccessMapper.assignmentEntityToAssignment(introFileEntity.getAssignment()))
                .fileName(introFileEntity.getFileName())
                .fileSize(introFileEntity.getFileSize())
                .timemodified(introFileEntity.getTimemodified())
                .mimetype(introFileEntity.getMimetype())
                .fileUrl(introFileEntity.getFileUrl())
                .build();
    }

    public IntroFileEntity introFileToIntroFileEntity(IntroFile introFile) {
        return IntroFileEntity.builder()
                .id(introFile.getId().getValue())
                .assignment(assignmentDataAccessMapper.assignmentToAssignmentEntity(introFile.getAssignment()))
                .fileName(introFile.getFileName())
                .fileSize(introFile.getFileSize())
                .timemodified(introFile.getTimemodified())
                .mimetype(introFile.getMimetype())
                .fileUrl(introFile.getFileUrl())
                .build();
    }

    public List<IntroFile> introFileEntityListToIntroFileList(List<IntroFileEntity> introFileEntityList) {
        return introFileEntityList.stream()
                .map(this::introFileEntityToIntroFile)
                .toList();
    }
}
