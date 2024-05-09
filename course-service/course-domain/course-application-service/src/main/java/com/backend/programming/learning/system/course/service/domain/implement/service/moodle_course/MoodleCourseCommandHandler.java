package com.backend.programming.learning.system.course.service.domain.implement.service.moodle_course;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.ListCourseMoodle;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.quiz.ListQuizModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.moodle_course.MoodleCourseMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.implement.service.moodle_course
 * Create by Dang Ngoc Tien
 * Date 5/6/2024 - 11:16 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MoodleCourseCommandHandler {
    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final MoodleCourseMapper moodleCourseMapper;
    private String GET_COURSES = "core_course_get_courses";
    private String GET_QUIZZES = "mod_quiz_get_quizzes_by_courses";
    private String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
    private String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";

//    @Transactional
    public void syncCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CourseModel> listCourseMoodle = null;
        try {
            listCourseMoodle = List.of(objectMapper.readValue(model, CourseModel[].class));
            log.info("Course model: {}", listCourseMoodle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Course> result = new ArrayList<>();
        Map<String, Course> courseIdsMap = new HashMap<>();
        listCourseMoodle.forEach(courseModel -> {
            Optional<Course> courseResult = courseRepository.findByName(courseModel.getFullname());
            if (courseResult.isPresent()) {
                Course courseUpdate = moodleCourseMapper.updateCourse(courseModel, courseResult.get());
                Course res = courseRepository.save(courseUpdate);
                result.add(res);
                courseIdsMap.put(courseModel.getId(), res);
            } else {
                Optional<User> userSave = userRepository.findUserByEmail("dcthong852@gmail.com");
                Course course = moodleCourseMapper.createCourse(courseModel, userSave.get());
                Course res = courseRepository.save(course);
                result.add(res);
                courseIdsMap.put(courseModel.getId(), res);
            }
        });

        List<String> courseIds = listCourseMoodle
                .stream()
                .map(CourseModel::getId)
                .filter(id -> !id.equals("1"))
                .toList();

        String courseIdsString = String.join(",", courseIds);
        String apiURLQuiz = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_QUIZZES);
        String modelQuiz = restTemplate.getForObject(apiURLQuiz, String.class);
        ListQuizModel listQuizModel = null;
        try {
            listQuizModel = objectMapper.readValue(modelQuiz, ListQuizModel.class);
            log.info("Quiz model: {}", listQuizModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Exam> exams = new ArrayList<>();
        listQuizModel.getQuizzes().forEach(quizModel -> {
            Optional<Exam> examResult = examRepository.findByName(quizModel.getName());
            if (examResult.isPresent()) {
                Exam examUpdate = moodleCourseMapper.updateExam(quizModel,
                        examResult.get(),
                        courseIdsMap.get(quizModel.getCourse().toString()));
                Exam res = examRepository.save(examUpdate);
                exams.add(res);
            } else {
                Exam exam = moodleCourseMapper.createExam(quizModel,
                        courseIdsMap.get(quizModel.getCourse().toString()));
                Exam res = examRepository.save(exam);
                exams.add(res);
            }
        });





    }
}
