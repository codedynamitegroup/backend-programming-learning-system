package com.backend.programming.learning.system.course.service.dataaccess.post.repository;

import com.backend.programming.learning.system.course.service.dataaccess.post.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostJpaRepository extends JpaRepository<PostEntity, UUID> {
    Optional<PostEntity> findById(UUID id);

    @Query("""
            SELECT p
            FROM PostEntity p
            WHERE p.title LIKE %:search%
            """)
    Page<PostEntity> findAll(String search, Pageable pageable);
}
