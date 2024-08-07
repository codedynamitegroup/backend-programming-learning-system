package com.backend.programming.learning.system.course.service.domain.implement.service.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.domain.valueobject.FileType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileCommandHandler {
    private final FileHelper fileHelper;

    @Transactional(readOnly = true)
    public DownloadFileResponse downloadFile(String fileId, String token) {
        return fileHelper.downloadFile(fileId, token);
    }

    public DownloadFileResponse exportGrade(String courseId, FileType fileType) {
        return fileHelper.exportGrade(courseId, fileType);
    }
}
