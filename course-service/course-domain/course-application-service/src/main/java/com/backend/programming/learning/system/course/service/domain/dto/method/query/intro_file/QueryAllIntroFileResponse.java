package com.backend.programming.learning.system.course.service.domain.dto.method.query.intro_file;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.intro_file.IntroFileResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllIntroFileResponse {

    private List<IntroFileResponseEntity> files;
}
