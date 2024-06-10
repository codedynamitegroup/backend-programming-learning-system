package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestRedisService;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
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
class ContestRedisServiceImpl implements ContestRedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public ContestRedisServiceImpl(
            RedisTemplate<String, Object> redisTemplate,
            ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    private String getKeyFrom(ContestStartTimeFilter startTimeFilter, Integer pageNo, Integer pageSize, Boolean isAdmin) {
        return String.format("%s:%s:%d:%d:%b", "contests:", startTimeFilter.toString(), pageNo, pageSize, isAdmin);
    }

    @Override
    public void clearAllContests() {
        redisTemplate.getConnectionFactory().getConnection().flushAll();
    }

    @Override
    public QueryAllContestsResponse getAllContests(
            ContestStartTimeFilter startTimeFilter,
            Integer pageNo,
            Integer pageSize,
            Boolean isAdmin) {
        String key = getKeyFrom(
                startTimeFilter,
                pageNo,
                pageSize,
                isAdmin);
        String json = (String) redisTemplate.opsForValue().get(key);
        log.info("key: {}", key);
        log.info("json: {}", json);
        try {
            return json != null ? objectMapper.readValue(json, QueryAllContestsResponse.class) : null;
        } catch (JsonProcessingException e) {
            log.error("Error while getting chapters from redis", e);
        }
        return null;
    }

    @Override
    public void saveAllContests(
            QueryAllContestsResponse queryAllContestsResponse,
            ContestStartTimeFilter startTimeFilter,
            Integer pageNo,
            Integer pageSize,
            Boolean isAdmin) {
        String key = getKeyFrom(
                startTimeFilter,
                pageNo,
                pageSize,
                isAdmin);
        try {
            String json = objectMapper.writeValueAsString(queryAllContestsResponse);
            redisTemplate.opsForValue().set(key, json);
        } catch (JsonProcessingException e) {
            log.error("Error while saving contests to redis", e);
        }
    }
}
