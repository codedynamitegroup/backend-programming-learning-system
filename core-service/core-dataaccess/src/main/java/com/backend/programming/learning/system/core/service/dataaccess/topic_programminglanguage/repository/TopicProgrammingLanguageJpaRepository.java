package com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TopicProgrammingLanguageJpaRepository extends JpaRepository<TopicProgrammingLanguageEntity, UUID> {
    Optional<TopicProgrammingLanguageEntity> findById(UUID id);
    List<TopicProgrammingLanguageEntity> findAllByTopicId(UUID topicId);
    Optional<TopicProgrammingLanguageEntity> findByTopicIdAndProgrammingLanguageId(UUID topicId, UUID programmingLanguageId);

    @Modifying
    @Query("delete from TopicProgrammingLanguageEntity tple where tple.topic.id = :topicId")
    void deleteAllByTopicId(UUID topicId);
}
