package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryGeneralCourseStatisticsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryLineChartResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.course.QueryPieChartResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.RecentAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.RecentExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * com.backend.programming.learning.system.implement.course
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 8:23 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseQueryHelper {
    private final CourseRepository courseRepository;
    private final CourseUserRepository courseUserRepository;
    private final CourseTypeRepository courseTypeRepository;
    private final ExamRepository examRepository;
    private final AssignmentRepository assignmentRepository;

    public Page<Course> findAll(String search,String[] courseType, Integer pageNo, Integer pageSize) {
        Page<Course> courses = courseRepository.findAll(search,courseType, pageNo, pageSize);
        log.info("Courses found successfully");
        return courses;
    }

    public Course findById(UUID courseId) {
        Course course = courseRepository.findBy(courseId);
        log.info("Course found successfully");
        return course;
    }

    @Transactional(readOnly = true)
    public QueryGeneralCourseStatisticsResponse getCourseStatistics() {
        List <Course> courseList =  courseRepository.findAll("", null, 0, 999999999).getContent();
        List<CourseUser> courseUserList = courseUserRepository.findAll();
        List<CourseType> courseTypeList =  courseTypeRepository.findAll();

        long totalCourse = courseList.size();
        long totalEnrollments = courseUserList.size();
        long activeCourses = courseList.stream().filter(Course::getVisible).count();
        long inactiveCourses = totalCourse - activeCourses;

        return QueryGeneralCourseStatisticsResponse.builder()
                .totalCourse(totalCourse)
                .totalEnrollments(totalEnrollments)
                .activeCourse(activeCourses)
                .inactiveCourse(inactiveCourses)
                .userEnrollments(calculateEnrollment(courseUserList))
                .activeInactiveCourse(calculateActiveInactiveCourseChart(activeCourses, inactiveCourses))
                .courseType(calculateCourseTypeChart(courseList, courseTypeList))
                .recentExam(getRecentExams())
                .recentAssignments(getRecentAssignments(courseList))
                .build();
    }

    private List<QueryLineChartResponse> calculateEnrollment(List<CourseUser> users) {
        if(users.isEmpty()) {
            return new ArrayList<>();
        }

        List<QueryLineChartResponse> result = new ArrayList<>();
        QueryLineChartResponse filterByDaysInWeek = null;
        QueryLineChartResponse filterByDaysInMonth = null;
        QueryLineChartResponse filterByDaysInYear = null;

        final long[] daysInWeekRegisterData = new long[7];
        final long[] daysInMonthRegisterData = new long[ZonedDateTime.now().getMonth().length(ZonedDateTime.now().toLocalDate().isLeapYear())];
        final long[] daysInYearRegisterData = new long[12];

        // Days in week
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() ||
                    registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }

            long differenceInDays = Duration.between(registerDate, currentDate).toDays();

            if(differenceInDays <= 7) {
                daysInWeekRegisterData[registerDate.getDayOfWeek().getValue() - 1]++;
            }
        });

        filterByDaysInWeek = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInWeekRegisterData)
                .build();


        // Days in month
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() || registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }
            daysInMonthRegisterData[registerDate.getDayOfMonth() - 1]++;
        });

        filterByDaysInMonth = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInMonthRegisterData)
                .build();

        // Days in year
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear()) {
                return;
            }
            daysInYearRegisterData[registerDate.getMonth().getValue() - 1]++;
        });
        filterByDaysInYear = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInYearRegisterData)
                .build();

        result.add(filterByDaysInWeek);
        result.add(filterByDaysInMonth);
        result.add(filterByDaysInYear);

        return result;
    }

    private List<QueryPieChartResponse> calculateActiveInactiveCourseChart(long activeCourse, long inactiveCourse) {
        List<QueryPieChartResponse> result = new ArrayList<>();

        result.add(QueryPieChartResponse.builder()
                .label("Active")
                .value(activeCourse)
                .build());
        result.add(QueryPieChartResponse.builder()
                .label("Inactive")
                .value(inactiveCourse)
                .build());

        return result;
    }

    private List<QueryPieChartResponse> calculateCourseTypeChart(List<Course> courses, List<CourseType> courseTypes) {
        int[] courseTypeData = new int[courseTypes.size()];

        courses.forEach(course -> {
            courseTypeData[courseTypes.indexOf(course.getCourseType())]++;
        });

        List<QueryPieChartResponse> result = new ArrayList<>();
        for(int i = 0; i < courseTypes.size(); i++) {
            result.add(QueryPieChartResponse.builder()
                    .index(i)
                    .label(courseTypes.get(i).getName())
                    .value(courseTypeData[i])
                    .build());
        }

        return result;
    }

    private List<RecentExamResponseEntity> getRecentExams() {
        List<RecentExamResponseEntity> recentExam = new ArrayList<>();
        List<Exam> exams = examRepository.findRecentExam();

        if(exams.isEmpty())
            return recentExam;

        examRepository.findRecentExam().forEach(exam -> {
            recentExam.add(RecentExamResponseEntity.builder()
                    .id(exam.getId().getValue())
                    .courseId(exam.getCourse().getId().getValue())
                    .courseName(exam.getCourse().getName())
                    .examName(exam.getName())
                    .createdAt(exam.getCreatedAt())
                    .build());
        });

        return recentExam;
    }

    private List<RecentAssignmentResponseEntity> getRecentAssignments(List<Course> courses) {
        List<RecentAssignmentResponseEntity> recentAssignments = new ArrayList<>();
        List<Assignment> assignments = assignmentRepository.findRecentAssignment();

        Map<CourseId, String> courseNameMap = courses
                .stream()
                .collect(Collectors.toMap(Course::getId, Course::getName));

        if(assignments.isEmpty())
            return recentAssignments;

        assignmentRepository.findRecentAssignment().forEach(assignment -> {
            recentAssignments.add(RecentAssignmentResponseEntity.builder()
                    .id(assignment.getId().getValue())
                    .courseId(assignment.getCourse().getId().getValue())
                    .courseName(courseNameMap.get(assignment.getCourse().getId().getValue()))
                    .title(assignment.getTitle())
                    .type(assignment.getType().name())
                    .createdAt(assignment.getCreatedAt())
                    .build());
        });

        return recentAssignments;
    }

    public QueryGeneralCourseStatisticsResponse getCourseStatisticsAdminOrg(String orgId) {
        List <Course> courseList =  courseRepository
                .findAll("", null, 0, 999999999)
                .getContent()
                .stream()
                .filter(course -> Objects.nonNull(course.getOrganization()) && course.getOrganization().getId().getValue().toString().equals(orgId))
                .collect(Collectors.toList());;
        List<CourseUser> courseUserList = courseUserRepository
                .findAll()
                .stream()
                .filter(courseUser -> courseList
                        .stream()
                        .anyMatch(course -> course.getId().getValue().equals(courseUser.getCourse().getId().getValue())))
                .collect(Collectors.toList());
        List<CourseType> courseTypeList =  courseTypeRepository.findAll();

        long totalCourse = courseList.size();
        long totalEnrollments = courseUserList.size();
        long activeCourses = courseList.stream().filter(Course::getVisible).count();
        long inactiveCourses = totalCourse - activeCourses;

        return QueryGeneralCourseStatisticsResponse.builder()
                .totalCourse(totalCourse)
                .totalEnrollments(totalEnrollments)
                .activeCourse(activeCourses)
                .inactiveCourse(inactiveCourses)
                .userEnrollments(calculateEnrollment(courseUserList))
                .activeInactiveCourse(calculateActiveInactiveCourseChart(activeCourses, inactiveCourses))
                .courseType(calculateCourseTypeChart(courseList, courseTypeList))
                .recentExam(getRecentExams())
                .recentAssignments(getRecentAssignments(courseList))
                .build();
    }
}
