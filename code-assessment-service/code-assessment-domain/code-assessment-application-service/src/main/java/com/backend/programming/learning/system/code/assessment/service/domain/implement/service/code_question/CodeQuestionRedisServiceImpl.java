package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionRedisService;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Validated
@Slf4j
class CodeQuestionRedisServiceImpl implements CodeQuestionRedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public CodeQuestionRedisServiceImpl(
            RedisTemplate<String, Object> redisTemplate,
            ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    private String getKeyFrom(Integer pageNo,
                              Integer pageSize,
                              QueryOrderBy orderBy,
                              QuestionDifficulty difficulty) {
        return String.format("%d:%d:%s:%s",
                pageNo,
                pageSize,
                orderBy != null ? orderBy.name() : null,
                difficulty != null ? difficulty.name() : null);
    }

    @Override
    public void clearAllCodeQuestions() {
        log.info("Clearing all code questions from redis");
        try {
            Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushAll();
        } catch (Exception e) {
            log.error("Error while clearing code questions from redis", e);
        }
    }

    @Override
    public GetCodeQuestionsResponse getAllCodeQuestions(
            Integer pageNo,
            Integer pageSize,
            QueryOrderBy orderBy,
            QuestionDifficulty difficulty) {
        String key = getKeyFrom(pageNo, pageSize, orderBy, difficulty);
        String json = (String) redisTemplate.opsForValue().get(key);
        try {
            return json != null ? objectMapper.readValue(json, GetCodeQuestionsResponse.class) : null;
        } catch (JsonProcessingException e) {
            log.error("Error while getting code questions from redis", e);
        }
        return null;
    }

    @Override
    public void saveAllCodeQuestions(
            GetCodeQuestionsResponse getCodeQuestionsResponse,
            Integer pageNo,
            Integer pageSize,
            QueryOrderBy orderBy,
            QuestionDifficulty difficulty) {
        String key = getKeyFrom(pageNo, pageSize, orderBy, difficulty);
        try {
            String json = objectMapper.writeValueAsString(getCodeQuestionsResponse);
            redisTemplate.opsForValue().set(key, json);
        } catch (JsonProcessingException e) {
            log.error("Error while saving code questions to redis", e);
        }
    }
}
