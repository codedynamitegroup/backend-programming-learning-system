package com.backend.programming.learning.system.course.service.domain.implement.service.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmissionFile;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.NotAuthorizedException;
import com.backend.programming.learning.system.course.service.domain.exception.QuestionSubmissionFileNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.file.FileMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionFileRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionSubmissionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class FileDownloadHelper {
    private final RestTemplate responseTemplate;
    private final FileMapper fileMapper;
    private final UserRepository userRepository;
    private final QuestionSubmissionFileRepository questionSubmissionFileRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;

    public FileDownloadHelper(RestTemplate responseTemplate, FileMapper fileMapper, UserRepository userRepository,
                              QuestionSubmissionFileRepository questionSubmissionFileRepository,
                              QuestionSubmissionRepository questionSubmissionRepository) {
        this.responseTemplate = responseTemplate;
        this.fileMapper = fileMapper;
        this.userRepository = userRepository;
        this.questionSubmissionFileRepository = questionSubmissionFileRepository;
        this.questionSubmissionRepository = questionSubmissionRepository;
    }

    public DownloadFileResponse downloadFile(String fileId, String token) {
        log.info("Downloading file with id: {}", fileId);

        String email = getEmailFromJwtString(token);

        // Get user request this file upload
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            log.error("User not found with email: {}", email);

            return new UserNotFoundException("User not found with email: " + email);
        });

        // Get file from DB
        QuestionSubmissionFile questionSubmissionFile = questionSubmissionFileRepository
                .getQuestionSubmissionFile(UUID.fromString(fileId))
                .orElseThrow(() -> {
                    log.error("File not found with id: {}", fileId);

                    return new QuestionSubmissionFileNotFoundException("File not found with id: " + fileId);
                });

        // Get question submission of this file
        QuestionSubmission questionSubmission = questionSubmissionRepository
                .findById(questionSubmissionFile.getQuestionSubmission().getId().getValue())
                .orElseThrow(() -> {
                    log.error("Exam submission not found with id: {}", questionSubmissionFile.getQuestionSubmission().getId().getValue());

                    return new QuestionSubmissionFileNotFoundException("Exam submission not found with id: " + questionSubmissionFile.getQuestionSubmission().getId().getValue());
                });

        // Check if user is the owner of this file
        if (!questionSubmission.getUser().getId().equals(user.getId())) {
            // check if user is lecturer of the course that contains this question submission
           if( true) {
               // Remove this if and only throw exception
           }
           else{
               log.warn("User with id: {} is not authorized to download this file", user.getId());
               throw new NotAuthorizedException("User is not authorized to download this file");
           }
        }

        // Download file from Url
        Resource resource = responseTemplate
                .getForObject(questionSubmissionFile.getUrl(), Resource.class);

        log.info("Downloaded file with id: {}", fileId);

        return fileMapper.resourceToDownloadFileResponse(resource, questionSubmissionFile.getName(), questionSubmissionFile.getType());
    }

    private JsonObject getPayloadFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String[] splitString = jwtString.split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();
        String payload = new String(decoder.decode(splitString[1]));
        JsonObject convertedObject = null;

        try {
            convertedObject = new Gson().fromJson(payload, JsonObject.class);
        } catch (Exception e) {
            throw new CourseDomainException("Error while converting jwt payload to json object");
        }
        return convertedObject;
    }

    private String getEmailFromJwtString(String jwtString) {
        if (jwtString == null || jwtString.isEmpty()) {
            return null;
        }
        String email = null;
        JsonObject jwtPayloadMap = getPayloadFromJwtString(jwtString);
        if (jwtPayloadMap != null && jwtPayloadMap.has("exp")) {
            String exp = jwtPayloadMap.get("exp").toString();
            if (Long.parseLong(exp) < System.currentTimeMillis() / 1000) {
                return null;
            } else {
                if (jwtPayloadMap.has("preferred_username")) {
                    email = jwtPayloadMap.get("preferred_username").toString().replace("\"", "");
                }
            }
        }
        return email;
    }
}
