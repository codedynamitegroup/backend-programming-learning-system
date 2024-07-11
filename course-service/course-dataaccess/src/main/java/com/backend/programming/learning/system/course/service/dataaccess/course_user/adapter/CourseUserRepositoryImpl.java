package com.backend.programming.learning.system.course.service.dataaccess.course_user.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.mapper.CourseUserDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.course_user.repository.CourseUserJpaRepository;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam.QueryGradeCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CourseUserRepositoryImpl implements CourseUserRepository {
    private final CourseUserJpaRepository courseUserJpaRepository;
    private final CourseUserDataAccessMapper courseUserDataAccessMapper;

    public CourseUserRepositoryImpl(CourseUserJpaRepository courseUserJpaRepository, CourseUserDataAccessMapper courseUserDataAccessMapper) {
        this.courseUserJpaRepository = courseUserJpaRepository;
        this.courseUserDataAccessMapper = courseUserDataAccessMapper;
    }


    @Override
    public CourseUser saveCourseUser(CourseUser courseUser) {
        return courseUserDataAccessMapper.courseUserEntityToCourseUser(courseUserJpaRepository
                .save(courseUserDataAccessMapper
                        .courseUserToCourseUserEntity(courseUser)));
    }

    @Override
    public Optional<CourseUser> findByCourseIdAndUserId(UUID courseId, UUID userId) {
        return courseUserJpaRepository.findByCourseIdAndUserId(courseId, userId)
                .map(courseUserDataAccessMapper::courseUserEntityToCourseUser);
    }

    @Override
    public List<CourseUser> findAll() {
        return courseUserJpaRepository
                .findAll()
                .stream()
                .map(courseUserDataAccessMapper::courseUserEntityToCourseUser)
                .toList();
    }

    @Override
    public void saveAll(List<CourseUser> courseUsers) {
        courseUserJpaRepository.saveAll(courseUserDataAccessMapper.courseUserListToCourseUserEntityList(courseUsers));
    }

    @Override
    public List<CourseUser> findByCourseId(UUID courseUserId) {
        return courseUserDataAccessMapper
                .courseUserToCourseUserEntityList(courseUserJpaRepository.findByCourseId(courseUserId));
    }

    @Override
    public void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds) {
        courseUserJpaRepository.deleteByCourseIdAndUserIdIn(courseId, userIds);
    }

    @Override
    public void deleteByCourseIdAndUserId(UUID courseId, UUID userId) {
        courseUserJpaRepository.deleteByCourseIdAndUserId(courseId, userId);
    }

    @Override
    public List<CourseUser> findByCourseIdAndRoleTeacher(UUID courseId) {
        return courseUserDataAccessMapper
                .courseUserToCourseUserEntityList(courseUserJpaRepository.findByCourseIdAndRoleTeacher(courseId));
    }

    @Override
    public Page<CourseUser> findAllUserByCourseId(UUID id, String search, int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return courseUserDataAccessMapper
                .courseUserPageToCourseUserPage(courseUserJpaRepository.findAllUserByCourseId(id, search, pageRequest));
    }

    @Override
    public Integer countStudentByCourseId(UUID courseId) {
        return courseUserJpaRepository.countStudentByCourseId(courseId);
    }

    @Override
    public Page<CourseUser> findAllCourseByUserId(UUID userId, int pageNo, int pageSize, String search, String[] courseType) {
        return courseUserDataAccessMapper
                .courseUserPageToCourseUserPage(courseUserJpaRepository.findAllCourseByUserId(userId, search, courseType, PageRequest.of(pageNo, pageSize)));
    }

    @Override
    public Page<CourseUser> findByExamId(ExamId examId, QueryGradeCommand queryGradeCommand) {
        PageRequest pageRequest = PageRequest.of(queryGradeCommand.pageNo(), queryGradeCommand.pageSize());
        Page<CourseUserEntity> page = courseUserJpaRepository
                .findByExamId(examId.getValue(), pageRequest);
        return courseUserDataAccessMapper
                .courseUserPageToCourseUserPage(page);
    }
}
