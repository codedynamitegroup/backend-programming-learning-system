package com.backend.programming.learning.system.course.service.domain.implement.service.exam;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.module.CreateExamModuleCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.course.DeleteCourseResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.exam.DeleteExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryAllGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.exam.UpdateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Exam;
import com.backend.programming.learning.system.course.service.domain.entity.ExamQuestion;
import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent.CalendarEventCommandHandler;
import com.backend.programming.learning.system.course.service.domain.implement.service.exam_question.ExamQuestionCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.exam_question.ExamQuestionDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleCreateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.module.ModuleQueryHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.question_bank_category.QuestionBankCategoryCreateHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ExamQuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.backend.programming.learning.system.implemtent.exam
 * Create by Dang Ngoc Tien
 * Date 4/16/2024 - 2:28 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExamCommandHandler {
    private final ExamCreateHelper examCreateHelper;
    private final ExamQueryHelper examQueryHelper;
    private final ExamDeleteHelper examDeleteHelper;
    private final ExamUpdateHelper examUpdateHelper;
    private final ExamDataMapper examDataMapper;
    private final ExamQuestionCreateHelper examQuestionCreateHelper;
    private final ExamQuestionDeleteHelper examQuestionDeleteHelper;
    private final CalendarEventCommandHandler calendarEventCommandHandler;
    private final ModuleCreateHelper moduleCreateHelper;
    private final ModuleQueryHelper moduleQueryHelper;
    private final QuestionBankCategoryCreateHelper questionBankCategoryCreateHelper;
    private final ExamQuestionRepository examQuestionRepository;
    private final UserRepository userRepository;

    @Transactional
    public CreateExamResponse createExam(CreateExamCommand createExamCommand) {
        Exam examCreated = examCreateHelper.persistExam(createExamCommand);
        examQuestionCreateHelper.assignExamToQuestions(
                CreateExamQuestionCommand.builder()
                        .examId(examCreated.getId().getValue())
                        .questionIds(createExamCommand.questionIds())
                        .build());
        CreateExamModuleCommand createExamModuleCommand = CreateExamModuleCommand.builder()
                .sectionId(createExamCommand.sectionId())
                .examId(examCreated.getId().getValue())
                .build();
        moduleCreateHelper.createExamModule(createExamModuleCommand);

        User user = userRepository.findById(new UserId(createExamCommand.createdBy()))
                .orElseThrow(() -> new RuntimeException("User not found"));
        CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand = CreateQuestionBankCategoryCommand.builder()
                .organizationId(user.getOrganization().getId().getValue())
                .name(String.format("%s - %s",examCreated.getCourse().getName(), examCreated.getName()))
                .description(examCreated.getIntro())
                .isOrgQuestionBank(true)
                .createdBy(createExamCommand.createdBy())
                .build();
        QuestionBankCategory category = questionBankCategoryCreateHelper.createQuestionBankCategory(createQuestionBankCategoryCommand);

        CreateCalendarEventCommand createCalendarEventCommand = CreateCalendarEventCommand.builder()
                .name(examCreated.getName())
                .description(examCreated.getIntro())
                .eventType(NotificationEventType.COURSE.name())
                .startTime(examCreated.getTimeOpen())
                .endTime(examCreated.getTimeClose())
                .courseId(createExamCommand.courseId())
                .examId(examCreated.getId().getValue())
                .component(NotificationComponentType.EXAM.name())
                .build();

        calendarEventCommandHandler.createCalendarEvent(createCalendarEventCommand);

        log.info("Exam is created with id: {}", examCreated.getId());
        return examDataMapper.examToCreateExamResponse(examCreated, category, "Exam created successfully");
    }

    @Transactional(readOnly = true)
    public ExamResponseEntity findBy(QueryExamCommand queryExamCommand) {
        Exam exam = examQueryHelper.findBy(new ExamId(queryExamCommand.getExamId()));
        Module module = moduleQueryHelper.findByExamId(queryExamCommand.getExamId());
        List<ExamQuestion> examQuestions = examQuestionRepository
                .findByExamId(new ExamId(queryExamCommand.getExamId()));
        Float totalMark = examQuestions.stream()
                .map(ExamQuestion::getQuestion)
                .map(Question::getDefaultMark)
                .reduce(0F, Float::sum);
        log.info("Returning exam: {}", exam);
        return examDataMapper.examToQueryExamResponse(exam, totalMark, module);
    }

    @Transactional(readOnly = true)
    public QueryAllExamResponse findAll(CourseId courseId, QueryAllExamCommand queryAllExamCommand) {
        Page<Exam> exams = examQueryHelper.findAll(
                courseId,
                queryAllExamCommand.getSearch(),
                queryAllExamCommand.getPageNo(),
                queryAllExamCommand.getPageSize());
        return examDataMapper.examsToQueryAllExamResponse(exams);
    }

    @Transactional
    public DeleteCourseResponse deleteExam(DeleteExamCommand deleteExamCommand) {
        examDeleteHelper.deleteExam(new ExamId(deleteExamCommand.examId()));

        CalendarEvent calendarEvent = calendarEventCommandHandler.findByExamId(deleteExamCommand.examId());
        if (calendarEvent != null) {
            DeleteCalendarEventCommand deleteCalendarEventCommand = DeleteCalendarEventCommand.builder()
                    .calendarEventId(calendarEvent.getId().getValue())
                    .build();
            calendarEventCommandHandler.deleteCalendarEvent(deleteCalendarEventCommand);
        }

        return new DeleteCourseResponse("Exam deleted successfully");
    }

    @Transactional
    public UpdateExamResponse updateExam(ExamId examId, UpdateExamCommand updateExamCommand) {
        Exam exam = examUpdateHelper.updateExam(examId, updateExamCommand);
//        examQuestionDeleteHelper.deleteByExamId(examId);
        examQuestionCreateHelper.assignExamToQuestions(
                CreateExamQuestionCommand.builder()
                        .examId(examId.getValue())
                        .questionIds(updateExamCommand.questionIds())
                        .build());

        CalendarEvent calendarEvent = calendarEventCommandHandler.findByExamId(examId.getValue());
        if (calendarEvent != null) {
            UpdateCalendarEventCommand updateCalendarEventCommand = UpdateCalendarEventCommand.builder()
                    .name(exam.getName() == null
                                    ? null
                                    : exam.getName())
                    .description(exam.getIntro() == null
                                    ? null
                                    : exam.getIntro())
                    .startTime(exam.getTimeOpen() == null
                                    ? null
                                    : exam.getTimeOpen())
                    .endTime(exam.getTimeClose() == null
                                    ? null
                                    : exam.getTimeClose())
                    .build();
            calendarEventCommandHandler.updateCalendarEvent(calendarEvent.getId().getValue(), updateCalendarEventCommand);
        }

        log.info("Exam updated with id: {}", exam.getId().getValue());
        return examDataMapper.examToUpdateExamResponse(exam, "Exam updated successfully");
    }

    public QueryOverviewResponse overviewExam(ExamId examId) {
        return examQueryHelper.overviewExam(examId);
    }

    public QueryAllGradeResponse gradeExam(ExamId examId, QueryGradeCommand queryGradeCommand) {
        return examQueryHelper.gradeExam(examId, queryGradeCommand);
    }
}
