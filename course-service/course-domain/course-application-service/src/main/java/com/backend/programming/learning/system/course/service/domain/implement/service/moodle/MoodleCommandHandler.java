package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.ListCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.ListUserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.UserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.ListUserModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.moodle.MoodleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MoodleCommandHandler {
    private final MoodleDataMapper moodleDataMapper;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseUserRepository courseUserRepository;
    String GET_COURSES = "core_course_get_courses";

    String GET_USER_COURSES = "core_enrol_get_users_courses";

    String GET_USERS = "core_user_get_users";
    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";


    @Transactional
    public List<CourseResponseEntity> syncCourse() {

        List<CourseResponseEntity> result = new ArrayList<>();
        List<CourseResponseEntity> allCourse = getAllCourse();
        result.addAll(allCourse);
        createCourseUser();
        return result;
    }

    @Transactional
    public void createCourseUser() {
        List<UserModel> allUser = getAllUser();
        allUser.forEach(userModel -> {
            List<UserCourseModel> allCourse = getCoursesByUser(userModel.getId());
            Optional<User> userResult = userRepository.findUserByEmail(userModel.getEmail());
            allCourse.forEach(userCourseModel -> {
                Optional<Course> courseResult = courseRepository.findByName(userCourseModel.getFullname());
                if(courseResult.isPresent()) {
                    CourseUser courseUser = moodleDataMapper.createCourseUser(courseResult.get(), userResult.get());
                    courseUserRepository.saveCourseUser(courseUser);
                }
            });
        });
    }

    private List<CourseResponseEntity> getAllCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        //tôi muốn "{courses:"+model+"}" thành List<CourseModel>
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
        listCourseModel.getCourses().forEach(courseModel -> {
            Course courseCreate = moodleDataMapper.createCourse(courseModel);
            Optional<User> userResult = userRepository.findUserByEmail("kayonkiu@gmail.com");
            courseCreate.setCreatedBy(userResult.get());
            courseCreate.setUpdatedBy(userResult.get());
            Course res = courseRepository.save(courseCreate);

            result.add(moodleDataMapper.courseToCourseResponseEntity(res));

        });

        return result;
    }
    @Transactional
    public List<UserCourseModel> getCoursesByUser(String userId) {
        // tôi muốn lấy tất cả khóa học của người dùng từ moodle
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
