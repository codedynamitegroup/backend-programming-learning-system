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

    private String getKeyFrom(ContestStartTimeFilter startTimeFilter,
                              Integer pageNo,
                              Integer pageSize,
                              Boolean isAdmin,
                              UUID orgId,
                              Boolean isOrgAdmin) {
        return String.format("%s:%s:%d:%d:%b:%s:%b", "contests:",
                startTimeFilter.toString(), pageNo, pageSize, isAdmin, orgId, isOrgAdmin);
    }

    @Override
    public void clearAllContests() {
        log.info("Clearing all contests from redis");
        try {
            redisTemplate.getConnectionFactory().getConnection().flushAll();
        } catch (Exception e) {
            log.error("Error while clearing contests from redis", e);
        }
    }

    @Override
    public QueryAllContestsResponse getAllContests(
            ContestStartTimeFilter startTimeFilter,
            Integer pageNo,
            Integer pageSize,
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin) {
        String key = getKeyFrom(
                startTimeFilter,
                pageNo,
                pageSize,
                isAdmin,
                orgId,
                isOrgAdmin);
        log.info("key: {}", key);
        String json = (String) redisTemplate.opsForValue().get(key);
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
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin) {
        String key = getKeyFrom(
                startTimeFilter,
                pageNo,
                pageSize,
                isAdmin,
                orgId,
                isOrgAdmin);
        try {
            String json = objectMapper.writeValueAsString(queryAllContestsResponse);
            redisTemplate.opsForValue().set(key, json);
        } catch (JsonProcessingException e) {
            log.error("Error while saving contests to redis", e);
        }
    }
}
