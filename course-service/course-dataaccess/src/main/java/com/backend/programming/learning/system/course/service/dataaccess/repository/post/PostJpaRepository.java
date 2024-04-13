package com.backend.programming.learning.system.course.service.dataaccess.repository.post;

import com.backend.programming.learning.system.course.service.dataaccess.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.post
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 1:13 AM
 * Description: ...
 */
@Repository
public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {
}
