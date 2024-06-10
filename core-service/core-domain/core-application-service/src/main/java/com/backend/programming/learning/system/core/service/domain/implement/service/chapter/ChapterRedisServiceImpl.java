package com.backend.programming.learning.system.core.service.domain.implement.service.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterRedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
class ChapterRedisServiceImpl implements ChapterRedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public ChapterRedisServiceImpl(
            RedisTemplate<String, Object> redisTemplate,
            ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    private String getKeyFrom(String certificateCourseId) {
        return String.format("%s:%s", "chapters:", certificateCourseId);
    }

    @Override
    public void clearAllChapters() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

    @Override
    public QueryAllChaptersResponse getAllChapters(UUID certificateCourseId) {
        String key = getKeyFrom(certificateCourseId.toString());
        String json = (String) redisTemplate.opsForValue().get(key);
        log.info("key: {}", key);
        log.info("json: {}", json);
        try {
            return json != null ? objectMapper.readValue(json, QueryAllChaptersResponse.class) : null;
        } catch (JsonProcessingException e) {
            log.error("Error while getting chapters from redis", e);
        }
        return null;
    }

    @Override
    public void saveAllChapters(QueryAllChaptersResponse queryAllChaptersResponse, UUID certificateCourseId) {
        String key = getKeyFrom(certificateCourseId.toString());
        try {
            String json = objectMapper.writeValueAsString(queryAllChaptersResponse);
            redisTemplate.opsForValue().set(key, json);
        } catch (JsonProcessingException e) {
            log.error("Error while saving chapters to redis", e);
        }
    }
}
