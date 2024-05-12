package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.section.SectionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Section updateSection(WebhookMessage webhookMessage, Course course) {
        List<SectionModel> sectionModels = moodleCommandHandler.getAllSection(webhookMessage.getCourseId());
        for (SectionModel sectionModel : sectionModels) {
            if (sectionModel.getId().equals(webhookMessage.getObjectId())) {
                Section previousSection = sectionRepository.
                        findBySectionMoodleId(Integer.valueOf(sectionModel.getId()));
                Section section = sectionDataMapper.setSection(previousSection, sectionModel);
                Section result = sectionRepository.save(section);
                return  result;
            }
        }
        return null;
    }
}
