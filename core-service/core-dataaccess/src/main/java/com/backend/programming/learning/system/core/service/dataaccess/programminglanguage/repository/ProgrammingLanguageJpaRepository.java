package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProgrammingLanguageJpaRepository extends JpaRepository<ProgrammingLanguageEntity, UUID> {
    Optional<ProgrammingLanguageEntity> findById(UUID id);

    @Query(value = """
            select pl.*
            from programming_language pl
            where (cast(?1 as text) IS NULL or UPPER(pl.name) like UPPER(concat('%', cast(?1 as text), '%')))
            and (?2 IS NULL or pl.id not in ?2)
            order by pl.name
            """, nativeQuery = true)
    Page<ProgrammingLanguageEntity> findAllWithSearch(String search, List<UUID> selectedProgrammingLanguages, Pageable paging);

    @Query(value = """
            select pl.*
            from programming_language pl
            where (cast(?1 as text) IS NULL or UPPER(pl.name) like UPPER(concat('%', cast(?1 as text), '%')))
                        and pl.id in ?2
            order by pl.name
            """, nativeQuery = true)
    Page<ProgrammingLanguageEntity> findAllWithSearchById(String search, List<UUID> selectedProgrammingLanguageIds, Pageable paging);
}
