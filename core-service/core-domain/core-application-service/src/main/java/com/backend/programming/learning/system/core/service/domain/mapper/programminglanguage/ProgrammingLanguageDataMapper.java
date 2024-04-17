package com.backend.programming.learning.system.core.service.domain.mapper.programminglanguage;

import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.topic.CreateTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.programminglanguage.QueryProgrammingLanguageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryAllTopicsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.topic.QueryTopicResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProgrammingLanguageDataMapper {

    public QueryProgrammingLanguageResponse programmingLanguageToQueryProgrammingLanguageResponse(
            ProgrammingLanguage programmingLanguage) {
        return QueryProgrammingLanguageResponse.builder()
                .programmingLanguageId(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .compilerApiId(programmingLanguage.getCompilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .build();
    }

    public List<QueryProgrammingLanguageResponse> programmingLanguagesToQueryProgrammingLanguageResponses(
            List<ProgrammingLanguage> programmingLanguages) {
        return programmingLanguages.stream()
                .map(this::programmingLanguageToQueryProgrammingLanguageResponse)
                .collect(Collectors.toList());
    }

}
