package com.backend.programming.learning.system.auth.service.dataaccess.user.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndIsDeletedFalse(String email);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByIdAndIsDeletedFalse(UUID id);
    Optional<UserEntity> findById(UUID id);
    @Query(value = """
        select u.*
        from main_user u
        where (cast(?1 as text) IS NULL or UPPER(u.email) like UPPER(concat('%', cast(?1 as text), '%')))
        order by u.email
        """, nativeQuery = true)
    Page<UserEntity> findAll(Pageable pageable, String searchName);

    @Query(value = """
        select u.*
        from main_user u, main_organization g
        where (u.organization_id = g.id and g.id = ?1)
        and (cast(?2 as text) IS NULL or UPPER(u.email) like UPPER(concat('%', cast(?2 as text), '%')))
        order by u.email
        """, nativeQuery = true)
    Page<UserEntity> findAllByOrganizationId(UUID organizationId, String searchName, Pageable pageable);

    @Query(value = """
        select u.*
        from main_user u
        where (u.organization_id is not null)
        and (cast(?1 as text) IS NULL or UPPER(u.email) like UPPER(concat('%', cast(?1 as text), '%')))
        order by u.email
        """, nativeQuery = true)
    Page<UserEntity> findAllByOrganizationIdNotNull(Pageable paging, String searchName);

    @Query(value = """
        select u.*
        from main_user u
        where (u.organization_id is null)
        and (cast(?1 as text) IS NULL or UPPER(u.email) like UPPER(concat('%', cast(?1 as text), '%')))
        order by u.email
        """, nativeQuery = true)
    Page<UserEntity> findAllByOrganizationIdNull(Pageable paging, String searchName);
}
