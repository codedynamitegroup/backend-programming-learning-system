package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.mapper.AssignmentDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.exam.mapper.ExamDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CalendarEventId;
import org.springframework.stereotype.Component;

@Component
public class CalendarEventDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;
    private final ExamDataAccessMapper examDataAccessMapper;
    private final AssignmentDataAccessMapper assignmentDataAccessMapper;
    private final CourseDataAccessMapper courseDataAccessMapper;

    public CalendarEventDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                         ExamDataAccessMapper examDataAccessMapper,
                                         AssignmentDataAccessMapper assignmentDataAccessMapper,
                                         CourseDataAccessMapper courseDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.examDataAccessMapper = examDataAccessMapper;
        this.assignmentDataAccessMapper = assignmentDataAccessMapper;
        this.courseDataAccessMapper = courseDataAccessMapper;
    }

    public CalendarEvent calendarEventEntityToCalendarEvent(CalendarEventEntity calendarEventEntity) {
        return CalendarEvent.builder()
                .id(new CalendarEventId(calendarEventEntity.getId()))
                .name(calendarEventEntity.getName())
                .description(calendarEventEntity.getDescription())
                .eventType(calendarEventEntity.getEventType())
                .startTime(calendarEventEntity.getStartTime())
                .endTime(calendarEventEntity.getEndTime())
                .user(
                        calendarEventEntity.getUser() != null ?
                                userDataAccessMapper.userEntityToUser(calendarEventEntity.getUser()) :
                                null
                )
                .course(
                        calendarEventEntity.getCourse() != null ?
                                courseDataAccessMapper.courseEntityToCourse(calendarEventEntity.getCourse()) :
                                null
                )
                .contestId(calendarEventEntity.getContestId())
                .exam(
                        calendarEventEntity.getExam() != null ?
                                examDataAccessMapper.examEntityToExam(calendarEventEntity.getExam()) :
                                null
                )
                .assignment(
                        calendarEventEntity.getAssignment() != null ?
                                assignmentDataAccessMapper.assignmentEntityToAssignment(calendarEventEntity.getAssignment()) :
                                null
                )
                .component(calendarEventEntity.getComponent())
                .notificationNotifyTime(calendarEventEntity.getNotificationNotifyTime())
                .createdAt(calendarEventEntity.getCreatedAt())
                .build();
    }

    public CalendarEventEntity calendarEventToCalendarEventEntity(CalendarEvent calendarEvent) {
        return CalendarEventEntity.builder()
                .id(calendarEvent.getId().getValue())
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(calendarEvent.getEventType())
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .user(
                        calendarEvent.getUser() != null ?
                                userDataAccessMapper.userToUserEntity(calendarEvent.getUser()) :
                                null
                )
                .course(
                        calendarEvent.getCourse() != null ?
                                courseDataAccessMapper.courseToCourseEntityHideSensitiveData(calendarEvent.getCourse()) :
                                null
                )
                .contestId(calendarEvent.getContestId())
                .exam(
                        calendarEvent.getExam() != null ?
                                examDataAccessMapper.examToExamEntity(calendarEvent.getExam()) :
                                null
                )
                .assignment(
                        calendarEvent.getAssignment() != null ?
                                assignmentDataAccessMapper.assignmentToAssignmentEntity(calendarEvent.getAssignment()) :
                                null
                )
                .component(calendarEvent.getComponent())
                .notificationNotifyTime(calendarEvent.getNotificationNotifyTime())
                .createdAt(calendarEvent.getCreatedAt())
                .build();
    }
}
