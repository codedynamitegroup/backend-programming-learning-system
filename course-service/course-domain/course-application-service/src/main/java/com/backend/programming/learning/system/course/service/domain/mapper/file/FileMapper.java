package com.backend.programming.learning.system.course.service.domain.mapper.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class FileMapper {
    public DownloadFileResponse resourceToDownloadFileResponse(Resource resource, String fileName, String fileType) {
        return DownloadFileResponse.builder()
                .fileData(resource)
                .fileName(fileName)
                .fileType(fileType)
                .build();
    }
}
