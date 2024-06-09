package com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import jakarta.validation.Valid;

public interface ChapterResourceUserApplicationService {
    CreateChapterResourceUserResponse createChapterResourceUser(
            @Valid CreateChapterResourceUserCommand createChapterResourceUserCommand);
}
