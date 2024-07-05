package com.backend.programming.learning.system.course.service.domain.implement.service.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentResourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.ListAssignmentCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.coure_type.CourseTypeModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.ListCourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.ListSectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.EnrolledCourse;
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
import com.backend.programming.learning.system.course.service.domain.valueobject.SubmissionGradeId;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class MoodleCommandHandler {
    private final MoodleDataMapper moodleDataMapper;
    private final UserApplicationService userApplicationService;
    private final OrganizationRepository organizationRepository;
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
    private final CourseTypeRepository courseTypeRepository;
    private final IntroFileRepository introFileRepository;
    private final IntroAttachmentRepository introAttachmentRepository;
    private final ActivityAttachmentRepository activityAttachmentRepository;

    private final  RoleMoodleRepository roleMoodleRepository;

    private final SubmissionGradeRepository submissionGradeRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    Map<String, Course> courseIdsMap = new HashMap<>();
    private String GET_COURSES = "core_course_get_courses";
    private String GET_QUIZZES = "mod_quiz_get_quizzes_by_courses";

    String GET_ASSIGNMENTS = "mod_assign_get_assignments";
    String GET_ASSIGNMENTS_USER = "mod_assign_get_user_mappings";

    String GET_SUBMISSION_STATUS = "mod_assign_get_submission_status";
    String GET_ENROLLED_USERS = "core_enrol_get_enrolled_users";
    String GET_CONTENTS = "core_course_get_contents";


    String GET_CATEGORY = "core_course_get_categories";
    String GET_SUBMISSION_ASSIGNMENTS = "mod_assign_get_submissions";

    String GET_GRADE="mod_assign_get_grades";

    String GET_USER_PROFILE = "core_user_get_course_user_profiles";

    String GET_USER_COURSES = "core_enrol_get_users_courses";

    String GET_MODULE="core_course_get_course_module";
    String GET_USERS = "core_user_get_users";
    String MOODLE_URL = "http://62.171.185.208:8081/webservice/rest/server.php";
    //    String MOODLE_URL = "http://localhost/moodle/webservice/rest/server.php";
    String MOODLE_URL_TOKEN = "http://62.171.185.208/login/token.php";
    String TOKEN = "cdf90b5bf53bcae577c60419702dbee7";
//    String TOKEN = "c22b03ca9c0a3c8431cd6b57bd4c8b04";
//    String TOKEN = "60d437ef3f02dded9a7b097a8a81bf61";


    @Transactional
    public String syncCourse(UUID organizationId){

        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }
        String apiKey = organization.get().getApiKey();
        String moodleUrl = organization.get().getMoodleUrl();
        createCourseType(apiKey, moodleUrl);
        List<CourseResponseEntity> allCourse = getAllCourse(apiKey,moodleUrl);
        createCourseUser();
        return "Sync course success";
    }

    @Transactional
    public String syncResource(UUID organizationId){
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization.isEmpty()) {
            throw new RuntimeException("Organization not found");
        }
        String apiKey = organization.get().getApiKey();
        String moodleUrl = organization.get().getMoodleUrl();
        Page<Course> courses = courseRepository.findAllByOrganizationId(organizationId,"",null,0,999);
        List<Course> courseList = courses.getContent();
        createSection(courseList,apiKey, moodleUrl);
        createAssignment(courseList,apiKey, moodleUrl);
        createCourseExam(courseList,apiKey, moodleUrl);
        return "Sync resource success";
    }

    private void createCourseExam(List<Course> courseList, String apiKey, String moodleUrl) {
        String apiURLQuiz = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                moodleUrl,apiKey, GET_QUIZZES);
        String modelQuiz = restTemplate.getForObject(apiURLQuiz, String.class);
        ListQuizModel listQuizModel = null;
        try {
            listQuizModel = objectMapper.readValue(modelQuiz, ListQuizModel.class);
            log.info("Quiz model: {}", listQuizModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Exam> exams = new ArrayList<>();

        ListQuizModel finalListQuizModel = listQuizModel;
        courseList.forEach(course ->
                finalListQuizModel.getQuizzes().forEach(quizModel -> {
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
            })
        );
    }

    @Transactional
    public void createCourseType(String apiKey, String moodleUrl)
    {
        List<CourseTypeModel> courseTypeModels = getAllCourseType(apiKey, moodleUrl);
        courseTypeModels.forEach(courseTypeModel -> {
            CourseType courseType = moodleDataMapper.createCourseType(courseTypeModel);
            courseTypeRepository.save(courseType);
        });
    }

    private List<CourseTypeModel> getAllCourseType(String apiKey, String moodleUrl) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                moodleUrl,apiKey, GET_CATEGORY);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        CourseTypeModel[] listCourseTypeModel = null;
        if (model.equals("[]"))
            return new ArrayList<>();
        try {
            listCourseTypeModel = objectMapper.readValue(model, CourseTypeModel[].class);
            log.info("Course model: {}", listCourseTypeModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Arrays.stream(listCourseTypeModel).toList();

    }

    @Transactional
    public void createSection(List<Course>courseList,String apiKey, String moodleUrl){
        courseList.forEach(course -> {
            List<SectionModel> allSection = getAllSection(course.getCourseIdMoodle().toString(),apiKey,moodleUrl);
            if (allSection.isEmpty()) {
                return;
            }

            allSection.forEach(sectionModel -> {
                Section section = moodleDataMapper.createSection(course, sectionModel);
                sectionRepository.save(section);
                // create module
                for (ModuleModel module : sectionModel.getModules()) {
                    if(module.getModplural().equals("Assignments"))
//                            ||
//                            module.getModplural().equals("Quizzes")||
//                            module.getModplural().equals("URLs")||
//                            module.getModplural().equals("Files"))
                    {
                        Module moduleCreate = moodleDataMapper.createModule(section, module);
                        moduleRepository.save(moduleCreate);
                    }
                }
            });
        });
    }

    @Transactional
    public List<SubmissionAssignmentUser> getAssignmentUser(Integer assignmentId) {

        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignmentids[0]=%s",
                MOODLE_URL, TOKEN, GET_ASSIGNMENTS_USER, assignmentId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ListSubmissionAssignmentUser listSubmissionAssignmentUser = null;
        if (model.contains("{\"assignments\":[]"))
            return new ArrayList<>();
        try {
            listSubmissionAssignmentUser = objectMapper.readValue(model, ListSubmissionAssignmentUser.class);
            log.info("Course model: {}", listSubmissionAssignmentUser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listSubmissionAssignmentUser.getAssignments();
    }

    @Transactional
    public SubmissionAssignmentStatus getSubmissionStatus(String assignmentId, String userId) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignid=%s&userid=%s",
                MOODLE_URL, TOKEN, GET_SUBMISSION_STATUS, assignmentId, userId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SubmissionAssignmentStatus listSubmissionAssignmentStatus = null;
        if (model.contains("{\"assignments\":[]}"))
            return null;
        try {
            listSubmissionAssignmentStatus = objectMapper.readValue(model, SubmissionAssignmentStatus.class);
            log.info("Course model: {}", listSubmissionAssignmentStatus);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listSubmissionAssignmentStatus;
    }
    @Transactional
    public void createSubmissionAssignmentUser(Assignment assignment)
    {
            List<SubmissionAssignmentUser> submissionAssignmentUsers = getAssignmentUser(assignment.getAssignmentIdMoodle());
            if(submissionAssignmentUsers.size()==0)
                return;
            submissionAssignmentUsers.get(0).getMappings().forEach(submissionAssignmentUser -> {
                SubmissionAssignmentStatus submissionAssignmentStatus = getSubmissionStatus(assignment.getAssignmentIdMoodle().toString(),
                        submissionAssignmentUser.getUserid().toString());
                Optional<User> user = userRepository.findByUserIdMoodle(submissionAssignmentUser.getUserid());
                if(submissionAssignmentStatus.getLastattempt()==null)
                    return;
                if(submissionAssignmentStatus.getLastattempt().getSubmission().getStatus().equals("submitted"))
                {
                    submissionAssignmentStatus.getLastattempt().getSubmission().setGradingstatus(submissionAssignmentStatus.getLastattempt().getGradingstatus());
                    SubmissionAssignment submissionAssignment =
                           moodleDataMapper.createSubmissionAssignment(assignment,user.get(),
                                   submissionAssignmentStatus.getLastattempt(),submissionAssignmentStatus.getFeedback());

                    submissionAssignmentRepository.saveSubmissionAssignment(submissionAssignment);

                    if(submissionAssignment.getGradedStatus())
                    {
                        ZonedDateTime timeCreated = Instant.ofEpochSecond(submissionAssignmentStatus.getFeedback().getGrade().getTimecreated()).atZone(ZoneId.of("UTC"));
                        ZonedDateTime timeModified = Instant.ofEpochSecond(submissionAssignmentStatus.getFeedback().getGrade().getTimemodified()).atZone(ZoneId.of("UTC"));
                        SubmissionGrade submissionGrade = SubmissionGrade.builder()
                                .id(new SubmissionGradeId(UUID.randomUUID()))
                                .grade(submissionAssignment.getGrade())
                                .submissionAssignment(submissionAssignment)
                                .timeCreated(timeCreated)
                                .timeModified(timeModified)
                                .build();

                        submissionGradeRepository.save(submissionGrade);
                    }

                    for (SubmissionPlugin plugin : submissionAssignmentStatus.getLastattempt().getSubmission().getPlugins()) {
                        if (plugin.getType().equals("file")) {
                            plugin.getFileareas().forEach(fileArea -> {
                                fileArea.getFiles().forEach(file -> {
                                    SubmissionAssignmentFile submissionAssignmentFile = moodleDataMapper.
                                            createSubmissionAssignmentFile(submissionAssignment, file);
                                    submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
                                });
                            });
                        } else if (plugin.getType().equals("onlinetext")) {
                            submissionAssignment.setContent(plugin.getEditorfields().get(0).getText());
                            SubmissionAssignmentOnlineText submissionAssignmentOnlineText = moodleDataMapper.
                                    createSubmissionAssignmentOnlineText(submissionAssignment, plugin);
                            submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
                        }
                    }
                }
                else {
                    SubmissionAssignment submissionAssignment =
                            moodleDataMapper.createSubmissionAssignment(assignment,user.get(),
                                    submissionAssignmentStatus.getLastattempt(),submissionAssignmentStatus.getFeedback());
                    submissionAssignmentRepository.saveSubmissionAssignment(submissionAssignment);
                }

            });

    }


    public List<SectionModel>  getAllSection(String courseId,String apiKey, String moodleUrl) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=%s",
                moodleUrl,apiKey, GET_CONTENTS, courseId);
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
    public List<AssignmentCourseModel> getAllAssignments(String courseId,String apiKey, String moodleUrl) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseids[0]=%s",
                moodleUrl,apiKey, GET_ASSIGNMENTS, courseId);
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
    public List<SubmissionAssignmentModel> getAllSubmissionAssignment(String assignmentId,String apiKey, String moodleUrl) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignmentids[0]=%s",
                moodleUrl,apiKey, GET_SUBMISSION_ASSIGNMENTS, assignmentId);
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
    public List<GradeSubmissionAssignment> getGrade(String assignmentId,String apiKey, String moodleUrl)
    {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&assignmentids[0]=%s",
                moodleUrl,apiKey, GET_GRADE, assignmentId);
        RestTemplate restTemplate = new RestTemplate();
        String model = restTemplate.getForObject(apiURL, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        GradeSubmissionAssignmentResponse listGradeSubmissionAssignment = null;
        if (model.contains("{\"assignments\":[]"))
            return new ArrayList<>();
        try {
            listGradeSubmissionAssignment = objectMapper.readValue(model, GradeSubmissionAssignmentResponse.class);
            log.info("Course model: {}", listGradeSubmissionAssignment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listGradeSubmissionAssignment.getAssignments();
    }

    @Transactional
    public void createCourseUser() {
        for (Map.Entry<String, Course> entry : courseIdsMap.entrySet()) {
            String courseId = entry.getKey();
            Course course = entry.getValue();
            if (course.getCourseIdMoodle() == null || course.getName().equals("code dynamite"))
                continue;
            List<UserModel> allUser = getAllUser(course.getCourseIdMoodle().toString());
            for (UserModel userModel : allUser) {
                Optional<User> userResult = userRepository.findUserByEmail(userModel.getEmail());
                if (userResult.isEmpty()) {
                    continue;
                }
                RoleMoodle roleMoodle = roleMoodleRepository.findById(userModel.getRoles().get(0).getRoleid()).get();
                CourseUser courseUser = moodleDataMapper.createCourseUser(course, userResult.get(), roleMoodle);
                courseUserRepository.saveCourseUser(courseUser);
            }
        }
    }

//    @Transactional
//    public void createSubmissionAssignment(Assignment assignmentCreate, AssignmentModel assignmentModel) {
//        List<SubmissionAssignmentModel> listSubmissionAssignmentModel = getAllSubmissionAssignment(assignmentModel.getId());
//        listSubmissionAssignmentModel.forEach(submissionAssignmentModel -> {
//            submissionAssignmentModel.getSubmissions().forEach(submissionModel -> {
//                Optional<User> user = userRepository.findByUserIdMoodle(Integer.valueOf(submissionModel.getUserid()));
//                if (submissionModel.getStatus().equals("submitted")) {
//                    SubmissionAssignment submissionCreate = moodleDataMapper.createSubmissionAssignment(assignmentCreate, user.get(), submissionModel);
//                    submissionAssignmentRepository.saveSubmissionAssignment(submissionCreate);
//
//                    List<SubmissionPlugin> submissionPlugins = submissionModel.getPlugins();
////                    if (assignmentCreate.getType().equals(Type.FILE)) {
////                        SubmissionAssignmentFile submissionAssignmentFile = moodleDataMapper.
////                                createSubmissionAssignmentFile(submissionCreate, submissionPlugin);
////                        submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
////                        submissionModel.getPlugins().get(0).getFileareas().forEach(fileArea -> {
////                            fileArea.getFiles().forEach(file -> {
////                                SubmissionFile submissionFile = moodleDataMapper.createSubmissionFile(submissionAssignmentFile, file);
////                                submissionFileRepository.save(submissionFile);
////                            });
////                        });
////                    } else if (assignmentCreate.getType().equals(Type.TEXT_ONLINE)) {
////                        SubmissionAssignmentOnlineText submissionAssignmentOnlineText = moodleDataMapper.
////                                createSubmissionAssignmentOnlineText(submissionCreate, submissionPlugin);
////                        submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
////                    } else {
//                        for (SubmissionPlugin plugin : submissionModel.getPlugins()) {
//                            if (plugin.getType().equals("file")) {
//                                SubmissionAssignmentFile submissionAssignmentFile = moodleDataMapper.
//                                        createSubmissionAssignmentFile(submissionCreate, plugin);
//                                submissionAssignmentFileRepository.saveSubmissionAssignmentFile(submissionAssignmentFile);
//                                plugin.getFileareas().forEach(fileArea -> {
//                                    fileArea.getFiles().forEach(file -> {
//                                        SubmissionFile submissionFile = moodleDataMapper.createSubmissionFile(submissionAssignmentFile, file);
//                                        submissionFileRepository.save(submissionFile);
//                                    });
//                                });
//                            } else if (plugin.getType().equals("onlinetext")) {
//                                SubmissionAssignmentOnlineText submissionAssignmentOnlineText = moodleDataMapper.
//                                        createSubmissionAssignmentOnlineText(submissionCreate, plugin);
//                                submissionAssignmentOnlineTextRepository.saveAssignmentSubmissionOnlineText(submissionAssignmentOnlineText);
//                            }
//                        }
////                    }
//
//                }
//            });
//        });
//    }

    @Transactional
    public void createAssignment(List<Course>courseList,String apiKey, String moodleUrl) {
        courseList.forEach(course -> {
                    List<AssignmentCourseModel> allAssignment = getAllAssignments(course.getCourseIdMoodle().toString(),apiKey,moodleUrl);
                    allAssignment.forEach(assignmentCourseModel -> {
                        assignmentCourseModel.getAssignments().forEach(assignmentModel -> {
                            Assignment assignmentCreate = moodleDataMapper.createAssignment(course, assignmentModel);
                            assignmentRepository.saveAssignment(assignmentCreate);
                            createSubmissionAssignmentUser(assignmentCreate);
                            if(assignmentModel.getIntrofiles()!=null) {
                                assignmentModel.getIntrofiles().forEach(introFileModel -> {
                                    IntroFile introFile = moodleDataMapper.createIntroFile(assignmentCreate, introFileModel);
                                    introFileRepository.save(introFile);
                                });
                            }

                            if(assignmentModel.getIntroattachments()!=null) {
                                assignmentModel.getIntroattachments().forEach(introAttachmentModel -> {
                                    IntroAttachment introAttachment = moodleDataMapper.createIntroAttachment(assignmentCreate, introAttachmentModel);
                                    introAttachmentRepository.save(introAttachment);
                                });
                            }
                            if(assignmentModel.getActivityattachments()!=null) {
                                assignmentModel.getActivityattachments().forEach(activityAttachmentModel -> {
                                    ActivityAttachment activityAttachment = moodleDataMapper.createActivityAttachment(assignmentCreate, activityAttachmentModel);
                                    activityAttachmentRepository.save(activityAttachment);
                                });
                            }
                        });
                    });
                }
        );
    }

    @Transactional
    public List<CourseResponseEntity> getAllCourse(String apiKey,String moodleUrl){
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s",
                moodleUrl,apiKey, GET_COURSES);
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
        Optional<User> userResult = userRepository.findByEmail("kayonkiu@gmail.com");
        listCourseModel.getCourses().forEach(courseModel -> {
            if(courseModel.getCategoryid()!=0&&courseModel.getId()!="1") {
                Course courseCreate = moodleDataMapper.createCourse(courseModel, userResult.get().getOrganization());
                courseCreate.setCreatedBy(userResult.get());
                courseCreate.setUpdatedBy(userResult.get());
                Course res = courseRepository.save(courseCreate);
                courseIdsMap.put(courseModel.getId(), res);
            }
        });
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
    public List<UserModel> getAllUser(String id) {
        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=%s",
                MOODLE_URL, TOKEN, GET_ENROLLED_USERS,id);
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
    public String syncUser(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);

        String moodleURL = organization.get().getMoodleUrl();
        String token = organization.get().getApiKey();

        String apiURL = String.format("%s?wstoken=%s&moodlewsrestformat=json&wsfunction=%s&courseid=1",
                moodleURL, token, GET_ENROLLED_USERS);
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

        listUserModel.stream()
                .filter(userModel -> !userModel.getId().equals("1"))
                .forEach(userModel -> {
            Optional<User> userResult = userRepository.findByEmail(userModel.getEmail());
            if (userResult.isPresent()) {
                UpdateUserCommand userUpdate = moodleDataMapper.updateUser(userModel, userResult.get());
                UpdateUserResponse updateUserResponse = userApplicationService.updateUser(userUpdate);

                Integer roleId = userModel.getRoles().isEmpty() ? 5 : userModel.getRoles().get(0).getRoleid();
                RoleMoodle roleMoodle = roleMoodleRepository.findById(roleId).orElse(null);
                userResult.get().setRoleMoodle(roleMoodle);
                userRepository.save(userResult.get());
//                List<Role> rolesMoodle = userModel.getRoles();
//                rolesMoodle.forEach(role -> {
//                    CreateUserRoleCommand createRole = moodleDataMapper.createRole(role, roleMap, updateUserResponse.getUserId());
//                    userRoleApplicationService.createUserRole(createRole);
//                });
            } else {
                CreateUserCommand user = moodleDataMapper.createUser(userModel);
                CreateUserResponse createUserResponse = userApplicationService.createUser(user);


                Integer roleId = userModel.getRoles().isEmpty() ? 5 : userModel.getRoles().get(0).getRoleid();
                RoleMoodle roleMoodle = roleMoodleRepository.findById(roleId).orElse(null);
                userRepository.save(User.builder()
                                .id(new UserId(UUID.randomUUID()))
                                .organization(organization.get())
                                .roleMoodle(roleMoodle)
                                .username(user.getUsername())
                                .email(user.getEmail())
                                .userIdMoodle(user.getUserIdMoodle())
                                .firstName(user.getFirstName())
                                .lastName(user.getLastName())
                                .phone(user.getPhone())
                        .build());
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
            if(!courseModel.getId().equals(1)){
                Optional<Course> courseResult = courseRepository.findByName(courseModel.getFullname());
                if (courseResult.isPresent()) {
                    Course courseUpdate = moodleDataMapper.updateCourseByCourseMoodle(courseModel, courseResult.get());
                    Course res = courseRepository.save(courseUpdate);
                    result.add(res);
                    courseIdsMap.put(courseModel.getId(), res);
                } else {
                    Optional<User> userSave = userRepository.findByEmail("kayonkiu@gmail.com");
                    Course course = moodleDataMapper.createCourseByCourseMoodle(courseModel, userSave.get());
                    Course res = courseRepository.save(course);
                    result.add(res);
                    courseIdsMap.put(courseModel.getId(), res);
                }
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
