package com.backend.programming.learning.system.core.service.domain.mapper.programminglanguage;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.programminglanguage.QueryProgrammingLanguageResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import org.springframework.stereotype.Component;

import java.util.List;
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
