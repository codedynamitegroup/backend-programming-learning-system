package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.MostEnrolledWithStudentResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Slf4j
@Component
public class CertificateCourseRepositoryImpl implements CertificateCourseRepository {
    private final CertificateCourseJpaRepository certificateCourseJpaRepository;
    private final CertificateCourseDataAccessMapper certificateCourseDataAccessMapper;

    public CertificateCourseRepositoryImpl(CertificateCourseJpaRepository certificateCourseJpaRepository,
                                           CertificateCourseDataAccessMapper certificateCourseDataAccessMapper) {
        this.certificateCourseJpaRepository = certificateCourseJpaRepository;
        this.certificateCourseDataAccessMapper = certificateCourseDataAccessMapper;
    }

    @Override
    public CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse) {
        return certificateCourseDataAccessMapper.certificateCourseEntityToCertificateCourse(
                certificateCourseJpaRepository.save(certificateCourseDataAccessMapper
                        .certificateCourseToCertificateCourseEntity(certificateCourse)));
    }

    @Override
    public Optional<CertificateCourse> findById(CertificateCourseId certificateCourseId) {
        return certificateCourseJpaRepository.findById(certificateCourseId.getValue())
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);

    }

    @Override
    public Optional<CertificateCourse> findByName(String name) {
        return certificateCourseJpaRepository.findByName(name)
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);
    }

    @Override
    public List<CertificateCourse> findAllCertificateCourses(
            String courseName,
            UUID filterTopicId
    ) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;
        return certificateCourseJpaRepository.findAllByCourseNameAndByTopicId(
                        courseName,
                        searchExcludeFinalWord,
                        searchFinalWord,
                        filterTopicId)
                .stream()
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                .toList();
    }

    @Override
    public List<CertificateCourse> findAllCertificateCoursesByIsRegistered(String courseName,
                                                                           UUID filterTopicId,
                                                                           boolean isRegistered,
                                                                           UUID userId) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty()? String.join(" ", splitedSearch) : null;

        if (isRegistered) {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                            courseName,
                            searchExcludeFinalWord,
                            searchFinalWord,
                            filterTopicId,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        } else {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                            courseName,
                            searchExcludeFinalWord,
                            searchFinalWord,
                            filterTopicId,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        }
    }

    @Override
    public void deleteCertificateCourse(UUID certificateCourseId) {
        certificateCourseJpaRepository.deleteById(certificateCourseId);
    }

    @Override
    public List<CertificateCourse> findMostEnrolledCertificateCourses() {
        return certificateCourseJpaRepository.findMostEnrolledCertificateCourses()
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
    }

    @Override
    public List<CertificateCourse> findMostEnrolledCertificateCoursesByTopicIds(List<UUID> topicIds) {
        return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByTopicIds(
                topicIds.isEmpty()
                        ? null
                        : topicIds
                )
                .stream()
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                .toList();
    }

    @Override
    public int countNumOfCompletedResources(UUID certificateCourseId, UUID userId) {
        return certificateCourseJpaRepository.countNumOfCompletedResources(certificateCourseId, userId);
    }

    @Override
    public int countNumOfResourcesByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfResourcesByCertificateId(certificateCourseId);
    }

    @Override
    public int countNumOfStudentsByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfStudentsByCertificateId(certificateCourseId);
    }

    @Override
    public int countNumOfReviewsByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfReviewsByCertificateId(certificateCourseId);
    }

    @Override
    public List<CertificateCourse> findAllCourse() {
        return certificateCourseJpaRepository.findAll()
                .stream()
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                .toList();
    }

    @Override
    public List<MostEnrolledWithStudentResponse> findMostEnrolledCertificateCourseWithStudentCount() {
        return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesWithNumStudentCount()
                .stream()
                .map(certificateCourseDataAccessMapper::MostEnrolledCertificateCourseProjectionToMostEnrolledWithStudentResponse)
                .toList();
    }

    @Override
    public Page<CertificateCourse> findAllCertificateCourses(Integer page, Integer size, String searchName) {
        Pageable paging = PageRequest.of(page, size);
        return certificateCourseJpaRepository.findAllCertificateCourse(searchName, paging)
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);
    }

    @Override
    public Page<CertificateCourse> findAllMyCompletedCertificateCourses(Integer page, Integer size, UUID userId) {
        Pageable paging = PageRequest.of(page, size);
        return certificateCourseJpaRepository.findAllMyCompletedCertificateCourses(userId, paging)
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse);
    }
}
