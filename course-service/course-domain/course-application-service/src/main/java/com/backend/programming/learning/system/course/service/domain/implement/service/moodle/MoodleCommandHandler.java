package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.ListAssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.ListCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.ListSubmissionAssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.SubmissionAssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course.ListUserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course.UserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.ListUserModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.moodle.MoodleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class MoodleCommandHandler {
    private final MoodleDataMapper moodleDataMapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseUserRepository courseUserRepository;
    private final AssignmentRepository assignmentRepository;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    Map<String, Course> courseIdsMap = new HashMap<>();

    String GET_ASSIGNMENTS = "mod_assign_get_assignments";
    String GET_SUBMISSION_ASSIGNMENTS = "mod_assign_get_submissions";
    String GET_COURSES = "core_course_get_courses";
    String GET_COURSE_BY_FIELD = "core_course_get_courses_by_field";

    String GET_USER_COURSES = "core_enrol_get_users_courses";

    String GET_USERS = "core_user_get_users";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";


    @Transactional
    public String syncCourse() {

        List<CourseResponseEntity> result = new ArrayList<>();
        List<CourseResponseEntity> allCourse = getAllCourse();
        result.addAll(allCourse);
        createCourseUser();
        return "Sync course success";
    }

    @Transactional
    public void syncAssignment()
    {



    }
    @Transactional
    public List<AssignmentCourseModel> getAllAssignments(String courseId)
    {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseids[0]=%s",
                MOODLE_URL, TOKEN, GET_ASSIGNMENTS, courseId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListAssignmentCourseModel listAssignmentCourseModel = null;
        if(model.equals("{\"courses\":[{}]}"))
            return new ArrayList<>();

        try {
            listAssignmentCourseModel = objectMapper.readValue(model, ListAssignmentCourseModel.class);
            log.info("Course model: {}", listAssignmentCourseModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listAssignmentCourseModel.getCourses();
    }

    @Transactional
    public List<SubmissionAssignmentModel> getAllSubmissionAssignment(String assignmentId)
    {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignmentids[0]=%s",
                MOODLE_URL, TOKEN, GET_SUBMISSION_ASSIGNMENTS,assignmentId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListSubmissionAssignmentModel listSubmissionAssignmentModel = null;
        if(model.equals("{\"assignments\":[{}]}"))
            return new ArrayList<>();
        try {
            listSubmissionAssignmentModel = objectMapper.readValue(model, ListSubmissionAssignmentModel.class);
            log.info("Course model: {}", listSubmissionAssignmentModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listSubmissionAssignmentModel.getAssignments();
    }

    @Transactional
    public void createCourseUser() {
        List<UserModel> allUser = getAllUser();
        for (UserModel userModel : allUser) {
            List<UserCourseModel> allCourse = getCoursesByUser(userModel.getId());
            if (allCourse.isEmpty()) {
                continue;
            }

            Optional<User> userResult = userRepository.findUserByEmail(userModel.getEmail());
            if (userResult.isEmpty()) {
                continue;
            }

            allCourse.parallelStream().forEach(userCourseModel -> {
                Optional<Course> courseResult = courseRepository.findByCourseIdMoodle(Integer.valueOf(userCourseModel.getId()));
                if (courseResult.isPresent()) {
                    CourseUser courseUser = moodleDataMapper.createCourseUser(courseResult.get(), userResult.get());
                    courseUserRepository.saveCourseUser(courseUser);
                }
            });
        }
    }

    @Transactional
    public List<CourseResponseEntity> getAllCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":"+model+"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;
        if(model.equals("{\"courses\":[]}"))
            return new ArrayList<>();
        try {
            listCourseModel = objectMapper.readValue(model, ListCourseModel.class);
            log.info("Course model: {}", listCourseModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<CourseResponseEntity> result = new ArrayList<>();
        Optional<User> userResult = userRepository.findUserByEmail("kayonkiu@gmail.com");
        listCourseModel.getCourses().forEach(courseModel -> {
            Course courseCreate = moodleDataMapper.createCourse(courseModel);
            courseCreate.setCreatedBy(userResult.get());
            courseCreate.setUpdatedBy(userResult.get());
            Course res = courseRepository.save(courseCreate);
            courseIdsMap.put(courseModel.getId(), res);
        });

        for (Map.Entry<String, Course> entry : courseIdsMap.entrySet()) {
            String courseId = entry.getKey();
            Course course = entry.getValue();
            List<AssignmentCourseModel> listAssignmentCourseModel = getAllAssignments(courseId);
            listAssignmentCourseModel.forEach(assignmentCourseModel -> {
                assignmentCourseModel.getAssignments().forEach(assignmentModel -> {
                    Assignment assignmentCreate = moodleDataMapper.createAssignment(course, assignmentModel);
                    assignmentRepository.saveAssignment(assignmentCreate);

                    List<SubmissionAssignmentModel> listSubmissionAssignmentModel = getAllSubmissionAssignment(assignmentModel.getId());
                    listSubmissionAssignmentModel.forEach(submissionAssignmentModel -> {
                        submissionAssignmentModel.getSubmissions().forEach(submissionModel -> {
                            Optional<User> user = userRepository.findUserByEmail("duongchithong2002@gmail.com");
                            if(submissionModel.getStatus().equals("submitted")) {
                                SubmissionAssignment submissionCreate = moodleDataMapper.createSubmissionAssignment(assignmentCreate, user.get(), submissionModel);
                                submissionAssignmentRepository.saveSubmissionAssignment(submissionCreate);


                            }
                        });
                    });
                });
            });
        }


        courseIdsMap.values().forEach(course -> result.add(moodleDataMapper.courseToCourseResponseEntity(course)));
        return result;
    }

    public ListCourseModel getCourses() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":"+model+"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;
        if(model.equals("{\"courses\":[]}"))
            return null;
        try {
            listCourseModel = objectMapper.readValue(model, ListCourseModel.class);
            log.info("Course model: {}", listCourseModel);

            return listCourseModel;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public CourseModel getCourse(String courseId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&options[ids][0]=%s",
                MOODLE_URL, TOKEN, GET_COURSES, courseId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":"+model+"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;

        if(model.equals("{\"courses\":[]}"))
            return null;

        try {
            listCourseModel = objectMapper.readValue(model, ListCourseModel.class);
            log.info("Course model: {}", listCourseModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return listCourseModel.getCourses().get(0);
    }

    @Transactional
    public List<UserCourseModel> getCoursesByUser(String userId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&userid=%s",
                MOODLE_URL, TOKEN, GET_USER_COURSES, userId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":"+model+"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListUserCourseModel listUserCourseModel = null;
        if(model.equals("{\"courses\":[]}"))
            return new ArrayList<>();
        try {
            listUserCourseModel = objectMapper.readValue(model, ListUserCourseModel.class);
            log.info("Course model: {}", listUserCourseModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listUserCourseModel.getCourses();
    }

    @Transactional
    public List<UserModel> getAllUser() {
        // tôi muốn lấy tất cả người dùng từ moodle

        String criteria = "criteria[0][key]=auth&criteria[0][value]=manual";
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&%s",
                MOODLE_URL, TOKEN, GET_USERS, criteria);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListUserModel listUserModel = null;
        try {
            listUserModel = objectMapper.readValue(model, ListUserModel.class);
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        
        return listUserModel.getUsers();
    }
}
