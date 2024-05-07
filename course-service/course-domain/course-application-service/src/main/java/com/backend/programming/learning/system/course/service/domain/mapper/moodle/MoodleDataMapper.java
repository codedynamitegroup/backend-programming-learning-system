package com.backend.programming.learning.system.course.service.domain.mapper.moodle;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.assignment.AssignmentModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.course.CourseModel;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.AssignmentId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseUserId;
import com.backend.programming.learning.system.course.service.domain.valueobject.Type;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Component

public class MoodleDataMapper {

    public Course createCourse(CourseModel courseModel) {
        return Course.builder()
                .id(new CourseId(UUID.randomUUID()))
                .name(courseModel.getFullname())
                .courseType(courseModel.getShortname())
                .key(courseModel.getIdnumber())
                .visible(courseModel.getVisible()==1)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }


    public CourseUser createCourseUser(Course course, User user) {
        return CourseUser.builder()
                .id(new CourseUserId(UUID.randomUUID()))
                .course(course)
                .user(user)
                .build();
    }

    public Assignment createAssignment(Course course, AssignmentModel assignmentModel) {
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
        return Assignment.builder()
                .id(new AssignmentId(UUID.randomUUID()))
                .title(assignmentModel.getName())
                .courseId(course.getId())
                .intro(assignmentModel.getIntro())
                .maxScores(assignmentModel.getGrade().floatValue())
                .scores((float)0)
                .type(type.get())
                .time_open(Instant.ofEpochSecond(assignmentModel.getAllowsubmissionsfromdate()).atZone(ZoneId.of("UTC")))
                .time_close(Instant.ofEpochSecond(assignmentModel.getDuedate()).atZone(ZoneId.of("UTC")))
                .time_limit(Instant.ofEpochSecond(assignmentModel.getTimelimit()).atZone(ZoneId.of("UTC")))
                .visible(false)
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
}
