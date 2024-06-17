package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ChapterResourceDeleteHelper {
    private final UserRepository userRepository;
    private final ChapterResourceRepository chapterResourceRepository;

    public ChapterResourceDeleteHelper(UserRepository userRepository,
                                       ChapterResourceRepository chapterResourceRepository1) {
        this.userRepository = userRepository;
        this.chapterResourceRepository = chapterResourceRepository1;
    }



}





















