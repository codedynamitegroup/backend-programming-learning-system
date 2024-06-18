package com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter_resource.DeleteChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter_resource.DeleteChapterResourceResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import jakarta.validation.Valid;

public interface ChapterResourceApplicationService {
    CreateChapterResourceResponse createChapterResource(
            @Valid CreateChapterResourceCommand createChapterResourceCommand);
    DeleteChapterResourceResponse deleteChapterResource(
            @Valid DeleteChapterResourceCommand deleteChapterResourceCommand);
}
