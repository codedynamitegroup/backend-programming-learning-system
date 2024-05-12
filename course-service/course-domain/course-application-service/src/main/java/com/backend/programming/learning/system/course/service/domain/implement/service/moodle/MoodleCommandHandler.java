package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.ListAssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.ListCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.ListSectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.ListSubmissionAssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.SubmissionAssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.SubmissionPlugin;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.ListUserModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course.ListUserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user_course.UserCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.quiz.ListQuizModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.user.UserApplicationService;
import com.backend.programming.learning.system.course.service.domain.mapper.moodle.MoodleDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
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
    private final UserApplicationService userApplicationService;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseUserRepository courseUserRepository;
    private final AssignmentRepository assignmentRepository;
    private final SubmissionAssignmentRepository submissionAssignmentRepository;
    private final SubmissionAssignmentFileRepository submissionAssignmentFileRepository;
    private final SubmissionAssignmentOnlineTextRepository submissionAssignmentOnlineTextRepository;
    private final ExamRepository examRepository;
    private final SectionRepository sectionRepository;
    private final ModuleRepository moduleRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    Map<String, Course> courseIdsMap = new HashMap<>();
    private String GET_COURSES = "core_course_get_courses";
    private String GET_QUIZZES = "mod_quiz_get_quizzes_by_courses";

    String GET_ASSIGNMENTS = "mod_assign_get_assignments";
    String GET_ENROLLED_USERS = "core_enrol_get_enrolled_users";
    String GET_CONTENTS = "core_course_get_contents";
    String GET_SUBMISSION_ASSIGNMENTS = "mod_assign_get_submissions";

    String GET_USER_PROFILE = "core_user_get_course_user_profiles";

    String GET_USER_COURSES = "core_enrol_get_users_courses";
    String GET_USERS = "core_user_get_users";
//    String MOODLE_URL = "http://62.171.185.208/webservice/rest/server.php";
        String MOODLE_URL = "http://localhost/moodle/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
//    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";
    String TOKEN = "c22b03ca9c0a3c8431cd6b57bd4c8b04";


    @Transactional
    public String syncCourse() {

        List<CourseResponseEntity> allCourse = getAllCourse();
        createCourseUser();
        return "Sync course success";
    }

    @Transactional
    public void createSection() {
        for (Map.Entry<String, Course> entry : courseIdsMap.entrySet()) {
            String courseId = entry.getKey();
            Course course = entry.getValue();
            if (course.getCourseIdMoodle() == null || course.getName().equals("code dynamite"))
                continue;
            List<SectionModel> allSection = getAllSection(course.getCourseIdMoodle().toString());
            if (allSection.isEmpty()) {
                continue;
            }

            allSection.forEach(sectionModel -> {
                Section section = moodleDataMapper.createSection(course, sectionModel);
                sectionRepository.save(section);
                // create module
                for (ModuleModel module : sectionModel.getModules()) {
                    Module moduleCreate = moodleDataMapper.createModule(section, module);
                    moduleRepository.save(moduleCreate);
                }
            });
        }
    }

    private List<SectionModel> getAllSection(String courseId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=%s",
                MOODLE_URL, TOKEN, GET_CONTENTS, courseId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListSectionModel listSectionModel = null;
        if (model.equals("[{}]"))
            return new ArrayList<>();
        try {
            SectionModel[] sectionModels = objectMapper.readValue(model, SectionModel[].class);
            log.info("Course models: {}", Arrays.asList(sectionModels));
            return Arrays.asList(sectionModels);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public List<AssignmentCourseModel> getAllAssignments(String courseId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseids[0]=%s",
                MOODLE_URL, TOKEN, GET_ASSIGNMENTS, courseId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListAssignmentCourseModel listAssignmentCourseModel = null;
        if (model.equals("{\"courses\":[{}]}"))
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
    public List<SubmissionAssignmentModel> getAllSubmissionAssignment(String assignmentId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignmentids[0]=%s",
                MOODLE_URL, TOKEN, GET_SUBMISSION_ASSIGNMENTS, assignmentId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListSubmissionAssignmentModel listSubmissionAssignmentModel = null;
        if (model.equals("{\"assignments\":[{}]}"))
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
    public void createSubmissionAssignment(Assignment assignmentCreate, AssignmentModel assignmentModel) {
        List<SubmissionAssignmentModel> listSubmissionAssignmentModel = getAllSubmissionAssignment(assignmentModel.getId());
        listSubmissionAssignmentModel.forEach(submissionAssignmentModel -> {
            submissionAssignmentModel.getSubmissions().forEach(submissionModel -> {
                Optional<User> user = userRepository.findUserByEmail("duongchithong2002@gmail.com");
                if (submissionModel.getStatus().equals("submitted")) {
                    SubmissionAssignment submissionCreate = moodleDataMapper.createSubmissionAssignment(assignmentCreate, user.get(), submissionModel);
                    submissionAssignmentRepository.saveSubmissionAssignment(submissionCreate);
                    SubmissionPlugin submissionPlugin = submissionModel.getPlugins().get(0);
                    if (assignmentCreate.getType().equals(Type.FILE)) {
                        SubmissionAssignmentFile submissionAssignmentFile = moodleDataMapper.
                                createSubmissionAssignmentFile(submissionCreate, submissionPlugin);
                        submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
                    } else if (assignmentCreate.getType().equals(Type.TEXT_ONLINE)) {
                        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = moodleDataMapper.
                                createSubmissionAssignmentOnlineText(submissionCreate, submissionPlugin);
                        submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
                    } else {
                        for (SubmissionPlugin plugin : submissionModel.getPlugins()) {
                            if (plugin.getType().equals("file")) {
                                SubmissionAssignmentFile submissionAssignmentFile = moodleDataMapper.
                                        createSubmissionAssignmentFile(submissionCreate, plugin);
                                submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
                            } else if (plugin.getType().equals("onlinetext")) {
                                SubmissionAssignmentOnlineText submissionAssignmentOnlineText = moodleDataMapper.
                                        createSubmissionAssignmentOnlineText(submissionCreate, plugin);
                                submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
                            }
                        }
                    }

                }
            });
        });
    }

    @Transactional
    public void createAssignment() {
        for (Map.Entry<String, Course> entry : courseIdsMap.entrySet()) {
            String courseId = entry.getKey();
            Course course = entry.getValue();
            List<AssignmentCourseModel> listAssignmentCourseModel = getAllAssignments(courseId);
            listAssignmentCourseModel.forEach(assignmentCourseModel -> {
                assignmentCourseModel.getAssignments().forEach(assignmentModel -> {
                    Assignment assignmentCreate = moodleDataMapper.createAssignment(course, assignmentModel);
                    assignmentRepository.saveAssignment(assignmentCreate);
                    createSubmissionAssignment(assignmentCreate, assignmentModel);
                });
            });
        }
    }

    @Transactional
    public List<CourseResponseEntity> getAllCourse() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":" + model + "}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;
        if (model.equals("{\"courses\":[]}"))
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

        createAssignment();
        createSection();


        courseIdsMap.values().forEach(course -> result.add(moodleDataMapper.courseToCourseResponseEntity(course)));
        return result;
    }

    public ListCourseModel getCourses() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                MOODLE_URL, TOKEN, GET_COURSES);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":" + model + "}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;
        if (model.equals("{\"courses\":[]}"))
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
        model = "{\"courses\":" + model + "}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListCourseModel listCourseModel = null;

        if (model.equals("{\"courses\":[]}"))
            return null;

        try {
            listCourseModel = objectMapper.readValue(model, ListCourseModel.class);
            log.info("Course model: {}", listCourseModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return listCourseModel.getCourses().get(0);
    }

    // Get user by id
    public UserModel getUser(String userId) {
        String apiUrl = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&userlist[0][courseid]=1&userlist[0][userid]=%s",
                MOODLE_URL, TOKEN, GET_USER_PROFILE, userId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiUrl, String.class);
        model = "{\"users\":"+model+"}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListUserModel listUserModel = null;

        if(model.equals("{\"users\":[]}"))
            return null;

        try {
            listUserModel = objectMapper.readValue(model, ListUserModel.class);
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return listUserModel.getUsers().get(0);
    }

    @Transactional
    public List<UserCourseModel> getCoursesByUser(String userId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&userid=%s",
                MOODLE_URL, TOKEN, GET_USER_COURSES, userId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        model = "{\"courses\":" + model + "}";
        ObjectMapper objectMapper = new ObjectMapper();
        ListUserCourseModel listUserCourseModel = null;
        if (model.equals("{\"courses\":[]}"))
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
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=1",
                MOODLE_URL, TOKEN, GET_ENROLLED_USERS);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<UserModel> listUserModel = null;
        try {
            listUserModel = List.of(objectMapper.readValue(model, UserModel[].class));
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return listUserModel;
    }

    @Transactional
    public String syncUser() {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=1",
                MOODLE_URL, TOKEN, GET_ENROLLED_USERS);
        String model = restTemplate.getForObject(apiURL, String.class);
        List<UserModel> listUserModel = null;
        try {
            listUserModel = List.of(objectMapper.readValue(model, UserModel[].class));
            log.info("User model: {}", listUserModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        List<Role> roles = roleRepository
//                .findAllRolesByOrganizationId(new OrganizationId(UUID.fromString("3ead3b08-afdd-442f-b544-fdbd86eaa186")), 0, 9999)
//                .getContent();
//
//        Map<String, Role> roleMap = roles.stream()
//                .collect(Collectors.toMap(role -> role.getName().toLowerCase(), role -> role));

        listUserModel.forEach(userModel -> {
            Optional<User> userResult = userRepository.findByEmail(userModel.getEmail());
            if (userResult.isPresent()) {
                UpdateUserCommand userUpdate = moodleDataMapper.updateUser(userModel, userResult.get());
                UpdateUserResponse updateUserResponse = userApplicationService.updateUser(userUpdate);
//                List<Role> rolesMoodle = userModel.getRoles();
//                rolesMoodle.forEach(role -> {
//                    CreateUserRoleCommand createRole = moodleDataMapper.createRole(role, roleMap, updateUserResponse.getUserId());
//                    userRoleApplicationService.createUserRole(createRole);
//                });
            } else {
                CreateUserCommand user = moodleDataMapper.createUser(userModel);
                CreateUserResponse createUserResponse = userApplicationService.createUser(user);
//                List<Role> rolesMoodle = userModel.getRoles();
//                rolesMoodle.forEach(role -> {
//                    CreateUserRoleCommand createRole = moodleDataMapper.createRole(role, roleMap, createUserResponse.getUserId());
//                    userRoleApplicationService.createUserRole(createRole);
//                });
            }
        });
        log.info("Sync user successfully");
        return "Sync user successfully";
    }

    public String syncCourseExam() {
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
                Course courseUpdate = moodleDataMapper.updateCourseByCourseMoodle(courseModel, courseResult.get());
                Course res = courseRepository.save(courseUpdate);
                result.add(res);
                courseIdsMap.put(courseModel.getId(), res);
            } else {
                Optional<User> userSave = userRepository.findUserByEmail("dcthong852@gmail.com");
                Course course = moodleDataMapper.createCourseByCourseMoodle(courseModel, userSave.get());
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
                Exam examUpdate = moodleDataMapper.updateExam(quizModel,
                        examResult.get(),
                        courseIdsMap.get(quizModel.getCourse().toString()));
                Exam res = examRepository.save(examUpdate);
                exams.add(res);
            } else {
                Exam exam = moodleDataMapper.createExam(quizModel,
                        courseIdsMap.get(quizModel.getCourse().toString()));
                Exam res = examRepository.save(exam);
                exams.add(res);
            }
        });
        return "Sync course successfully";
    }
}
