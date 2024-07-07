package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.*;
import com.backend.programming.learning.system.core.service.domain.ports.output.redis.CertificateCourseRedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;
import java.util.UUID;

@Service
@Validated
@Slf4j
class CertificateCourseRedisServiceImpl implements CertificateCourseRedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public CertificateCourseRedisServiceImpl(
            RedisTemplate<String, Object> redisTemplate,
            ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    private String getKeyFrom(String courseName, UUID filterTopicId) {
        return String.format("%s:%s", "certificate_courses", filterTopicId);
    }

    @Override
    public void clearAllCertificateCourses() {
        log.info("Clearing all certificate courses from redis");
        try {
            Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().flushAll();
        } catch (Exception e) {
            log.error("Error while clearing certificate courses from redis", e);
        }
    }

    @Override
    public QueryAllCertificateCoursesResponse getAllCertificateCourses(
            String courseName,
            UUID filterTopicId) {
        String key = getKeyFrom(courseName, filterTopicId);
        String json = (String) redisTemplate.opsForValue().get(key);
        try {
            return json != null ? objectMapper.readValue(json, QueryAllCertificateCoursesResponse.class) : null;
        } catch (JsonProcessingException e) {
            log.error("Error while getting chapters from redis", e);
        }
        return null;
    }

    @Override
    public void saveAllCertificateCourses(
            QueryAllCertificateCoursesResponse queryAllCertificateCoursesResponse,
            String courseName,
            UUID filterTopicId) {
        String key = getKeyFrom(courseName, filterTopicId);
        try {
            String json = objectMapper.writeValueAsString(queryAllCertificateCoursesResponse);
//            Object test = objectMapper.readValue(json, QueryAllCertificateCoursesResponse.class);
            redisTemplate.opsForValue().set(key, json);
        } catch (JsonProcessingException e) {
            log.error("Error while saving certificate courses to redis", e);
        }
    }
}
