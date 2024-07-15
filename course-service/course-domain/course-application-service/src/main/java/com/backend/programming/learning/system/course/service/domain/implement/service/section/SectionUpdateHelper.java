package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.section.SectionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class SectionUpdateHelper {
    private final SectionRepository sectionRepository;

    private final SectionDataMapper sectionDataMapper;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;

    public SectionUpdateHelper(SectionRepository sectionRepository,
                               SectionDataMapper sectionDataMapper,
                               CourseDomainService courseDomainService,
                               MoodleCommandHandler moodleCommandHandler) {
        this.sectionRepository = sectionRepository;
        this.sectionDataMapper = sectionDataMapper;
        this.courseDomainService = courseDomainService;
        this.moodleCommandHandler = moodleCommandHandler;
    }

    @Transactional
    public Section updateSection(UUID sectionId, UpdateSectionCommand updateSectionCommand) {
        Optional<Section> section = sectionRepository.findById(sectionId);
        if (section.isEmpty()) {
            log.error("Section is not found with id: {}", sectionId);
            throw new CourseDomainException("Section is not found with id: " + sectionId);
        }
        Section sectionFound = section.get();
        sectionFound.setName(updateSectionCommand.getName());
        sectionFound.setVisible(updateSectionCommand.getVisible());
        Section response = sectionRepository.save(sectionFound);
        log.info("Section is updated with id: {}", sectionFound.getId());
        return response;
    }

    @Transactional
    public Section updateSection(WebhookMessage webhookMessage, Course course) {
        Organization organization = course.getOrganization();
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();
        List<SectionModel> sectionModels = moodleCommandHandler.getAllSection(webhookMessage.getCourseId(),apiKey, moodleUrl);
        for (SectionModel sectionModel : sectionModels) {
            if (sectionModel.getId().equals(webhookMessage.getObjectId())) {
                Optional<Section> previousSection = sectionRepository.
                        findBySectionMoodleId(Integer.valueOf(sectionModel.getId()));
                sectionDataMapper.setSection(previousSection.get(), sectionModel);
                Section result = sectionRepository.save(previousSection.get());
                return  result;
            }
        }
        return null;
    }
}
