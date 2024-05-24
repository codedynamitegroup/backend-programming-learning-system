package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
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
            List<UUID> filterTopicIds
    ) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty() ? String.join(" ", splitedSearch) : null;

        // Get rid of empty string in filterTopicIds
        List<UUID> finalFilterTopicIds = new ArrayList<>();
        for (UUID topicId: filterTopicIds) {
            if (topicId != null && !topicId.toString().isEmpty()) {
                finalFilterTopicIds.add(topicId);
            }
        }

        return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIds(
                        searchExcludeFinalWord, searchFinalWord,
                        finalFilterTopicIds)
                .stream()
                .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                .toList();
    }

    @Override
    public List<CertificateCourse> findAllCertificateCoursesByIsRegistered(String courseName,
                                                                           List<UUID> filterTopicIds,
                                                                           boolean isRegistered,
                                                                           UUID userId) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty() ? String.join(" ", splitedSearch) : null;

        // Get rid of empty string in filterTopicIds
        List<UUID> finalFilterTopicIds = new ArrayList<>();
        for (UUID topicId: filterTopicIds) {
            if (topicId != null && !topicId.toString().isEmpty()) {
                finalFilterTopicIds.add(topicId);
            }
        }

        if (isRegistered) {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                            searchExcludeFinalWord, searchFinalWord,
                            finalFilterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        } else {
            return certificateCourseJpaRepository.findAllByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                            searchExcludeFinalWord, searchFinalWord,
                            finalFilterTopicIds,
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
    public List<CertificateCourse> findMostEnrolledCertificateCourses(String courseName,
                                                                      List<UUID> filterTopicIds) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty() ? String.join(" ", splitedSearch) : null;

        // Get rid of empty string in filterTopicIds
        List<UUID> finalFilterTopicIds = new ArrayList<>();
        for (UUID topicId: filterTopicIds) {
            if (topicId != null && !topicId.toString().isEmpty()) {
                finalFilterTopicIds.add(topicId);
            }
        }

        return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIds(
                        searchExcludeFinalWord, searchFinalWord,
                        finalFilterTopicIds)
                        .stream()
                        .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                        .toList();
    }

    @Override
    public List<CertificateCourse> findMostEnrolledCertificateCoursesByIsRegistered(
            String courseName,
            List<UUID> filterTopicIds,
            boolean isRegistered,
            UUID userId) {
        List<String> splitedSearch = certificateCourseDataAccessMapper.splitWords(courseName);

        String searchFinalWord = splitedSearch != null && !splitedSearch.isEmpty()? splitedSearch.get(splitedSearch.size() - 1): null;

        if(splitedSearch != null && !splitedSearch.isEmpty())
            splitedSearch.remove(splitedSearch.size() - 1);

        String searchExcludeFinalWord =  splitedSearch != null && !splitedSearch.isEmpty() ? String.join(" ", splitedSearch) : null;

        // Get rid of empty string in filterTopicIds
        List<UUID> finalFilterTopicIds = new ArrayList<>();
        for (UUID topicId: filterTopicIds) {
            if (topicId != null && !topicId.toString().isEmpty()) {
                finalFilterTopicIds.add(topicId);
            }
        }

        if (isRegistered) {
            return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndRegisteredBy(
                            searchExcludeFinalWord, searchFinalWord,
                            finalFilterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        } else {
            return certificateCourseJpaRepository.findMostEnrolledCertificateCoursesByCourseNameAndByFilterTopicIdsAndNotRegisteredBy(
                            searchExcludeFinalWord, searchFinalWord,
                            finalFilterTopicIds,
                            userId)
                    .stream()
                    .map(certificateCourseDataAccessMapper::certificateCourseEntityToCertificateCourse)
                    .toList();
        }
    }

    @Override
    public int countNumOfCompletedQuestions(UUID certificateCourseId, UUID userId) {
        return certificateCourseJpaRepository.countNumOfCompletedQuestions(certificateCourseId, userId);
    }

    @Override
    public int countNumOfQuestionsByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfQuestionsByCertificateId(certificateCourseId);
    }

    @Override
    public int countNumOfStudentsByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfStudentsByCertificateId(certificateCourseId);
    }

    @Override
    public int countNumOfReviewsByCertificateId(UUID certificateCourseId) {
        return certificateCourseJpaRepository.countNumOfReviewsByCertificateId(certificateCourseId);
    }
}
