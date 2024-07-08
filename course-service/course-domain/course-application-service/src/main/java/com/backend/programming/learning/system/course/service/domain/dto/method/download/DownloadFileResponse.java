package com.backend.programming.learning.system.course.service.domain.dto.method.download;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.core.io.Resource;

@Getter
@Builder
@AllArgsConstructor
public class DownloadFileResponse {
    Resource fileData;
    String fileName;
    String fileType;
}
