package com.backend.programming.learning.system.course.service.domain.implement.service.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.file.FileApplicationService;
import com.backend.programming.learning.system.domain.valueobject.FileType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class FileApplicationImpl implements FileApplicationService {
    private final FileCommandHandler fileCommandHandler;

    @Override
    public DownloadFileResponse downloadFile(String fileId, String token) {
        return fileCommandHandler.downloadFile(fileId, token);
    }

    @Override
    public DownloadFileResponse exportGrade(String courseId, FileType fileType) {
        return fileCommandHandler.exportGrade(courseId, fileType);
    }
}
