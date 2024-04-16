package com.backend.programming.learning.system.course.service.dataaccess.post.repository;

import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostJpaRepository extends JpaRepository<PostEntity, UUID> {
    Optional<PostEntity> findById(UUID id);
}
