package com.backend.programming.learning.system.course.service.dataaccess.repository.question;

import com.backend.programming.learning.system.course.service.dataaccess.entity.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.question
 * Create by Dang Ngoc Tien
 * Date 3/26/2024 - 10:37 PM
 * Description: ...
 */
@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {

}
