package com.backend.programming.learning.system.course.service.domain.mapper.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.user.CreateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentResourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.coure_type.CourseTypeModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.module.ModuleModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.quiz.QuizModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.submission_assignment.*;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.user.UserModel;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class MoodleDataMapper {
    private final CourseTypeRepository courseTypeRepository;
    private final IntroFileRepository introFileRepository;

    private final IntroAttachmentRepository introAttachmentRepository;

    private final ActivityAttachmentRepository activityAttachmentRepository;

    private final OrganizationRepository organizationRepository;

    public MoodleDataMapper(CourseTypeRepository courseTypeRepository, IntroFileRepository introFileRepository, IntroAttachmentRepository introAttachmentRepository, ActivityAttachmentRepository activityAttachmentRepository, OrganizationRepository organizationRepository) {
        this.courseTypeRepository = courseTypeRepository;
        this.introFileRepository = introFileRepository;
        this.introAttachmentRepository = introAttachmentRepository;
        this.activityAttachmentRepository = activityAttachmentRepository;
        this.organizationRepository = organizationRepository;
    }

    public Course createCourse(CourseModel courseModel,Organization organization) {
        Optional<CourseType> courseType = courseTypeRepository.findByMoodleId(Integer.valueOf(courseModel.getCategoryid()));
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .courseIdMoodle(Integer.valueOf(courseModel.getId()))
                .organization(organization)
                .name(courseModel.getFullname())
                .courseType(courseType.get())
                .key(courseModel.getIdnumber())
                .visible(courseModel.getVisible()==1)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }


    public CourseUser createCourseUser(Course course, User user,RoleMoodle roleMoodle) {
        return CourseUser.builder()
                .id(new CourseUserId(UUID.randomUUID()))
                .course(course)
                .user(user)
                .roleMoodle(roleMoodle)
                .build();
    }
    public IntroFile createIntroFile(Assignment assignment, AssignmentResourseModel assignmentResourseModel)
    {
        return IntroFile.builder()
                .id(new IntroFileId(UUID.randomUUID()))
                .assignment(assignment)
                .fileName(assignmentResourseModel.getFilename())
                .fileSize(assignmentResourseModel.getFilesize())
                .fileUrl(assignmentResourseModel.getFileurl())
                .mimetype(assignmentResourseModel.getMimetype())
                .timemodified(Instant.ofEpochSecond(assignmentResourseModel.getTimemodified()).atZone(ZoneId.of("UTC")))
                .build();
    }

    public IntroAttachment createIntroAttachment(Assignment assignment, AssignmentResourseModel assignmentResourseModel)
    {
        return IntroAttachment.builder()
                .id(new IntroAttachmentId(UUID.randomUUID()))
                .assignment(assignment)
                .fileName(assignmentResourseModel.getFilename())
                .fileSize(assignmentResourseModel.getFilesize())
                .fileUrl(assignmentResourseModel.getFileurl())
                .mimetype(assignmentResourseModel.getMimetype())
                .timemodified(Instant.ofEpochSecond(assignmentResourseModel.getTimemodified()).atZone(ZoneId.of("UTC")))
                .build();
    }

    public ActivityAttachment createActivityAttachment(Assignment assignment, AssignmentResourseModel assignmentResourseModel)
    {
        return ActivityAttachment.builder()
                .id(new ActivityAttachmentId(UUID.randomUUID()))
                .assignment(assignment)
                .fileName(assignmentResourseModel.getFilename())
                .fileSize(assignmentResourseModel.getFilesize())
                .fileUrl(assignmentResourseModel.getFileurl())
                .mimetype(assignmentResourseModel.getMimetype())
                .timemodified(Instant.ofEpochSecond(assignmentResourseModel.getTimemodified()).atZone(ZoneId.of("UTC")))
                .build();
    }

    public Assignment  createAssignment(Course course, AssignmentModel assignmentModel) {
        List<String> types= Arrays.asList("file","onlinetext");
        AtomicReference<Type> type= new AtomicReference<>(Type.FILE);
        AtomicReference<Boolean> fileType= new AtomicReference<>(false);
        AtomicReference<Boolean> onlineTextType= new AtomicReference<>(false);
        assignmentModel.getConfigs().forEach(config->{
            if(config.getPlugin().equals("file")){
                type.set(Type.FILE);
                fileType.set(true);
            }
            else if(config.getPlugin().equals("onlinetext")){
                type.set(Type.TEXT_ONLINE);
                onlineTextType.set(true);
            }

            if(fileType.get() && onlineTextType.get()){
                type.set(Type.BOTH);
            }
        });

        String activity=null;

        if(assignmentModel.getActivity()!=null){
            activity=assignmentModel.getActivity();
        }


        if(assignmentModel.getIntrofiles()!=null){
            assignmentModel.getIntrofiles().forEach(introFile->{


            });
        }
        if(assignmentModel.getIntroattachments()!=null){
            assignmentModel.getIntroattachments().forEach(introAttachment->{
            });
        }
        if(assignmentModel.getActivityattachments()!=null){
            assignmentModel.getActivityattachments().forEach(activityAttachment->{
            });
        }


        return Assignment.builder()
                .id(new AssignmentId(UUID.randomUUID()))
                .assignmentIdMoodle(Integer.valueOf(assignmentModel.getId()))
                .title(assignmentModel.getName())
                .course(course)
                .intro(assignmentModel.getIntro())
                .activity(activity)
                .maxScores(assignmentModel.getGrade().floatValue())
                .type(type.get())
                .time_open(Instant.ofEpochSecond(assignmentModel.getAllowsubmissionsfromdate()).atZone(ZoneId.of("UTC")))
                .time_close(Instant.ofEpochSecond(assignmentModel.getDuedate()).atZone(ZoneId.of("UTC")))
                .time_limit(Instant.ofEpochSecond(assignmentModel.getTimelimit()).atZone(ZoneId.of("UTC")))
                .visible(false)
                .build();
    }

    public SubmissionAssignment createSubmissionAssignment(Assignment assignment, User user, LastAttempt lastAttempt, Feedback feedback) {
        Boolean isGraded=false;
        float grade=(float)-1;
        String content="";
        String feedbackContent="";
        ZonedDateTime submittedAt=null;
        ZonedDateTime timemodified=null;

        submittedAt=Instant.ofEpochSecond(lastAttempt.getSubmission().getTimecreated()).atZone(ZoneId.of("UTC"));
        timemodified=Instant.ofEpochSecond(lastAttempt.getSubmission().getTimemodified()).atZone(ZoneId.of("UTC"));


        if(lastAttempt.getGradingstatus().equals("graded"))
        {
            isGraded=true;
        }
        if(feedback!=null)
        {
            grade= Float.parseFloat(feedback.getGrade().getGrade());
            feedbackContent=feedback.getPlugins().get(0).getEditorfields().get(0).getText();
        }
        return SubmissionAssignment.builder()
                .id(new SubmissionAssignmentId(UUID.randomUUID()))
                .assignment(assignment)
                .user(user)
                .isGraded(isGraded)
                .content(content)
                .feedback(feedbackContent)
                .grade(grade)
                .timemodified(timemodified)
                .submittedAt(submittedAt)
                .build();
    }

    public SubmissionAssignmentFile createSubmissionAssignmentFile(SubmissionAssignment submissionAssignment, File file) {
        return SubmissionAssignmentFile.builder()
                .id(new AssignmentSubmissionFileId(UUID.randomUUID()))
                .assignmentSubmission(submissionAssignment)
                .fileName(file.getFilename())
                .fileSize(file.getFilesize())
                .fileUrl(file.getFileurl())
                .timemodified(ZonedDateTime.ofInstant(
                                Instant.ofEpochSecond(file.getTimemodified()),
                                ZoneId.of("UTC")))
                .mimetype(file.getMimetype())
                .build();
    }
    public CourseResponseEntity courseToCourseResponseEntity(Course course) {
        return CourseResponseEntity.builder()
                .id(course.getId().getValue())
                .name(course.getName())
                .visible(course.getVisible())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }


    public Section createSection(Course course, SectionModel sectionModel) {
        return Section.builder()
                .id(new SectionId(UUID.randomUUID()))
                .sectionMoodleId(Integer.valueOf(sectionModel.getId()))
                .name(sectionModel.getName())
                .visible(sectionModel.getVisible())
                .courseId(course.getId())
                .build();
    }

    public Module createModule(Section section, ModuleModel module) {
        ZonedDateTime timeOpen=null;
        ZonedDateTime timeClose=null;
        if(module.getDates().size()!=0)
        {
            timeOpen=Instant.ofEpochSecond(module.getDates().get(0).getTimestamp()).atZone(ZoneId.of("UTC"));
            timeClose=Instant.ofEpochSecond(module.getDates().get(1).getTimestamp()).atZone(ZoneId.of("UTC"));
        }
        String content=null;
        if (module.getContents() != null && !module.getContents().isEmpty()) { // Sửa lỗi ở đây
            content = module.getContents().get(0).getFileurl();
            content=content.replace("/webservice","");
        }

        return Module.builder()
                .id(new ModuleId(UUID.randomUUID()))
                .cmid(Integer.valueOf(module.getId()))
                .section(section)
                .name(module.getName())
                .visible(module.getVisible())
                .typeModule(TypeModule.fromLabel(module.getModplural()))
                .content(content)
                .timeOpen(timeOpen)
                .timeClose(timeClose)
                .build();

    }

    public UpdateUserCommand updateUser(UserModel userModel, User user) {
        return UpdateUserCommand.builder()
                .userId(user.getId().getValue())
                .username(userModel.getUsername())
                .userIdMoodle(Integer.valueOf(userModel.getId()))
                .dob(user.getDob())
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .address(userModel.getAddress())
                .avatarUrl(userModel.getProfileimageurl())
                .build();
    }

    public CreateUserCommand createUser(UserModel userModel) {
        return CreateUserCommand.builder()
                .email(userModel.getEmail())
                .username(userModel.getUsername())
                .userIdMoodle(Integer.valueOf(userModel.getId()))
                .password("")
                .firstName(userModel.getFirstname())
                .lastName(userModel.getLastname())
                .phone(userModel.getPhone1())
                .build();
    }

    public Course updateCourseByCourseMoodle(CourseModel courseModel, Course course) {
        return Course.builder()
                .id(course.getId())
                .name(courseModel.getFullname())
                .organization(course.getOrganization())
//                .courseType("MOODLE")
                .visible(courseModel.getVisible().equals("1"))
                .posts(course.getPosts())
                .exams(course.getExams())
                .assignments(course.getAssignments())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public Course createCourseByCourseMoodle(CourseModel courseModel, User user) {
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .name(courseModel.getFullname())
//                .courseType("MOODLE")
                .organization(user.getOrganization())

                .visible(courseModel.getVisible().equals("1"))
                .build();
    }

    public Exam updateExam(QuizModel quizModel, Exam exam, Course course) {
        return Exam.builder()
                .id(exam.getId())
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(quizModel.getShuffleanswers().equals("0") ? false : true)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .createdAt(exam.getCreatedAt())
                .updatedAt(exam.getUpdatedAt())
                .build();
    }

    public Exam createExam(QuizModel quizModel, Course course) {
        return Exam.builder()
                .id(new ExamId(UUID.randomUUID()))
                .course(course)
                .name(quizModel.getName())
                .score(quizModel.getGrade().floatValue())
                .maxScore(quizModel.getGrade().floatValue())
                .timeOpen(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeopen()),
                        ZoneId.of("UTC")))
                .timeClose(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(quizModel.getTimeclose()),
                        ZoneId.of("UTC")))
                .timeLimit(quizModel.getTimelimit().intValue())
                .intro(quizModel.getIntro())
                .overdueHandling(OverdueHandling.AUTOSUBMIT)
                .canRedoQuestions(quizModel.getCanredoquestions().equals("0") ? false : true)
                .maxAttempts(quizModel.getAttemptonlast())
                .shuffleAnswers(quizModel.getShuffleanswers().equals("0") ? false : true)
                .gradeMethod("QUIZ_GRADEHIGHEST")
                .build();
    }

    public CourseType createCourseType(CourseTypeModel courseTypeModel,Organization organization) {
        Integer moodleId = Integer.valueOf(courseTypeModel.getId());
        return CourseType.builder()
                .id(new CourseTypeId(UUID.randomUUID()))
                .name(courseTypeModel.getName())
                .moodleId(moodleId)
                .organization(organization)
                .build();
    }

    public CourseType updateCourseType(CourseTypeModel courseTypeModel, CourseType courseType, Organization organization) {
        return CourseType.builder()
                .id(courseType.getId())
                .name(courseTypeModel.getName())
                .moodleId(Integer.valueOf(courseTypeModel.getId()))
                .organization(organization)
                .build();
    }

    public Course updateCourse(CourseModel courseModel, Course course, Organization organization) {
        return Course.builder()
                .id(course.getId())
                .name(courseModel.getFullname())
                .organization(organization)
                .visible(courseModel.getVisible().equals("1"))
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public Assignment updateAssignment(Course course, AssignmentModel assignmentModel, Assignment assignment) {
        return Assignment.builder()
                .id(assignment.getId())
                .course(course)
                .title(assignmentModel.getName())
                .intro(assignmentModel.getIntro())
                .activity(assignmentModel.getActivity())
                .maxScores(assignmentModel.getGrade().floatValue())
                .type(Type.FILE)
                .time_open(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(assignmentModel.getAllowsubmissionsfromdate()),
                        ZoneId.of("UTC")))
                .time_close(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(assignmentModel.getDuedate()),
                        ZoneId.of("UTC")))
                .time_limit(ZonedDateTime.ofInstant(
                        Instant.ofEpochSecond(assignmentModel.getTimelimit()),
                        ZoneId.of("UTC")))
                .visible(false)
                .build();
    }

    public Section updateSection(Course course, SectionModel sectionModel, Section section) {
        return Section.builder()
                .id(section.getId())
                .sectionMoodleId(Integer.valueOf(sectionModel.getId()))
                .name(sectionModel.getName())
                .visible(sectionModel.getVisible())
                .courseId(course.getId())
                .build();
    }

    public Module updateModule(Section sectionUpdate, ModuleModel module, Module module1) {
        ZonedDateTime timeOpen=null;
        ZonedDateTime timeClose=null;
        if(module.getDates().size()!=0)
        {
            timeOpen=Instant.ofEpochSecond(module.getDates().get(0).getTimestamp()).atZone(ZoneId.of("UTC"));
            timeClose=Instant.ofEpochSecond(module.getDates().get(1).getTimestamp()).atZone(ZoneId.of("UTC"));
        }
        String content=null;
        if (module.getContents() != null && !module.getContents().isEmpty()) { // Sửa lỗi ở đây
            content = module.getContents().get(0).getFileurl();
            content=content.replace("/webservice","");
        }

        return Module.builder()
                .id(module1.getId())
                .cmid(Integer.valueOf(module.getId()))
                .section(sectionUpdate)
                .name(module.getName())
                .visible(module.getVisible())
                .typeModule(TypeModule.fromLabel(module.getModplural()))
                .content(content)
                .timeOpen(timeOpen)
                .timeClose(timeClose)
                .build();
    }

    public SubmissionAssignment updateSubmissionAssignment(Assignment assignment, User user, LastAttempt lastattempt, Feedback feedback, SubmissionAssignment checkSubmissionAssignment) {
        Boolean isGraded=false;
        float grade=(float)-1;
        String content="";
        String feedbackContent="";
        ZonedDateTime submittedAt=null;
        ZonedDateTime timemodified=null;

        submittedAt=Instant.ofEpochSecond(lastattempt.getSubmission().getTimecreated()).atZone(ZoneId.of("UTC"));
        timemodified=Instant.ofEpochSecond(lastattempt.getSubmission().getTimemodified()).atZone(ZoneId.of("UTC"));

        if(lastattempt.getGradingstatus().equals("graded"))
        {
            isGraded=true;
        }

        if(feedback!=null)
        {
            grade= Float.parseFloat(feedback.getGrade().getGrade());
            feedbackContent=feedback.getPlugins().get(0).getEditorfields().get(0).getText();
        }

        return SubmissionAssignment.builder()
                .id(checkSubmissionAssignment.getId())
                .assignment(assignment)
                .user(user)
                .isGraded(isGraded)
                .content(content)
                .feedback(feedbackContent)
                .grade(grade)
                .timemodified(timemodified)
                .submittedAt(submittedAt)
                .build();
    }

    public SubmissionGrade updateSubmissionGrade(SubmissionAssignment submissionAssignment, SubmissionGrade submissionGrade) {
        return SubmissionGrade.builder()
                .id(submissionGrade.getId())
                .submissionAssignment(submissionAssignment)
                .grade(submissionGrade.getGrade())
                .build();
    }
}
