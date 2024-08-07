package com.backend.programming.learning.system.course.service.domain.implement.service.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.AssignmentMaxGradeInfo;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.StudentAssignmentListResponse;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.*;
import com.backend.programming.learning.system.course.service.domain.implement.service.assignment.AssignmentQueryHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.file.FileMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.domain.valueobject.FileType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class FileHelper {
    private final RestTemplate responseTemplate;
    private final FileMapper fileMapper;
    private final UserRepository userRepository;
    private final QuestionSubmissionFileRepository questionSubmissionFileRepository;
    private final QuestionSubmissionRepository questionSubmissionRepository;
    private final AssignmentQueryHelper assignmentQueryHelper;
    private final ExamRepository examRepository;
    private final AssignmentDataMapper assignmentDataMapper;
    private final CourseRepository courseRepository;

    public FileHelper(RestTemplate responseTemplate, FileMapper fileMapper, UserRepository userRepository,
                      QuestionSubmissionFileRepository questionSubmissionFileRepository,
                      QuestionSubmissionRepository questionSubmissionRepository,
                      AssignmentQueryHelper assignmentQueryHelper,
                      ExamRepository examRepository, AssignmentDataMapper assignmentDataMapper,
                      CourseRepository courseRepository) {
        this.responseTemplate = responseTemplate;
        this.fileMapper = fileMapper;
        this.userRepository = userRepository;
        this.questionSubmissionFileRepository = questionSubmissionFileRepository;
        this.questionSubmissionRepository = questionSubmissionRepository;
        this.assignmentQueryHelper = assignmentQueryHelper;
        this.examRepository = examRepository;
        this.assignmentDataMapper = assignmentDataMapper;
        this.courseRepository = courseRepository;
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

    public DownloadFileResponse exportGrade(String courseId, FileType fileType) {
        log.info("Query assignment grade command received");

        Course course = courseRepository.findBy(UUID.fromString(courseId));

        if (course == null) {
            log.error("Course not found with id: {}", courseId);
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }
        log.info("Writing grade to file");

        List<Assignment> assignments = assignmentQueryHelper.findAllGradeStudentAssignment(UUID.fromString(courseId));
        Page<User> users = userRepository.findAllByCourseId(UUID.fromString(courseId), 0, 999999, "");
        List<Exam> exams = examRepository.findAllByCourseId(UUID.fromString(courseId));
        StudentAssignmentListResponse assignmentListResponse = assignmentDataMapper.assignmentsToStudentAssignmentList(assignments, exams, users);
        File csvOutputFile = new File(course.getName());
        String[] assignmentNameList = assignmentListResponse.getAssignments()
                .stream()
                .map(AssignmentMaxGradeInfo::getName)
                .toArray(String[]::new);
        String[] headingList = new String[]{"Full name", "Email"};
        String heading = convertToCSV(Stream
                .concat(Stream.of(headingList), Stream.of(assignmentNameList))
                .toArray(String[]::new));

        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(csvOutputFile), StandardCharsets.UTF_8))) {
            pw.println(heading);

            List<String[]> dataLines = new ArrayList<>();

            assignmentListResponse.getStudents().forEach(studentGrade -> {
                dataLines
                        .add(Stream.concat(
                                Stream.of(studentGrade.getFullName(),
                                studentGrade.getEmail()),
                                studentGrade.getGrades().stream().map(String::valueOf)).toArray(String[]::new));
            });

            dataLines
                    .stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);

            Resource resource = new UrlResource(csvOutputFile.toURI());

            String type = "text/csv";
//            if(fileType.equals(FileType.XLSX)){
//                type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//            }
//            else if(fileType.equals(FileType.XML)) {
//                type = "application/xml";
//            }

            return fileMapper.resourceToDownloadFileResponse(resource, csvOutputFile.getName(), type);
        }
        catch (Exception e) {
            log.error("Error while writing grade to file", e);
            throw new CourseDomainException("Error while writing grade to file", e);
        }
    }

    private String escapeSpecialCharacters(String data) {
        if (data == null || data.equals("null"))
            return "-";

        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
}