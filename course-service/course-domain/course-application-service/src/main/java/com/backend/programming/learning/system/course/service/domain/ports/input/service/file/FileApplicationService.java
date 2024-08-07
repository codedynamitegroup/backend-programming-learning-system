package com.backend.programming.learning.system.course.service.domain.ports.input.service.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.domain.valueobject.FileType;

public interface FileApplicationService {
    DownloadFileResponse downloadFile(String fileId, String token);
    DownloadFileResponse exportGrade(String courseId, FileType fileType);
}
