package com.backend.programming.learning.system.course.service.domain.mapper.intro_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_file.QueryAllIntroFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_file.IntroFileResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.IntroFile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntroFileDataMapper {

    QueryAllIntroFileResponse introFileToQueryAllIntroFileResponse(List<IntroFile> introFile) {
        return QueryAllIntroFileResponse.builder()
                .files(introFile.stream().map(this::introFileToIntroFileResponseEntity).toList())
                .build();
    }


    public IntroFileResponseEntity introFileToIntroFileResponseEntity(IntroFile introFile) {
        return IntroFileResponseEntity.builder()
                .id(introFile.getId().getValue())
                .fileName(introFile.getFileName())
                .fileSize(introFile.getFileSize())
                .timemodified(introFile.getTimemodified())
                .mimetype(introFile.getMimetype())
                .fileUrl(introFile.getFileUrl())
                .build();
    }

    public QueryAllIntroFileResponse introFilesToQueryAllIntroFileResponse(List<IntroFile> introFiles) {
        return QueryAllIntroFileResponse.builder()
                .files(introFiles.stream().map(this::introFileToIntroFileResponseEntity).toList())
                .build();
    }
}
