package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.WebhookMessage;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.mapper.section.SectionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class SectionHelper {
    private final SectionRepository sectionRepository;

    private final SectionDataMapper sectionDataMapper;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;


    public SectionHelper(SectionRepository sectionRepository,
                         SectionDataMapper sectionDataMapper,
                         CourseDomainService courseDomainService,
                         MoodleCommandHandler moodleCommandHandler) {
        this.sectionRepository = sectionRepository;
        this.sectionDataMapper = sectionDataMapper;
        this.courseDomainService = courseDomainService;
        this.moodleCommandHandler = moodleCommandHandler;
    }
    @Transactional
    public void createSection(WebhookMessage webhookMessage, Course course) {
        List<SectionModel> sectionModels = moodleCommandHandler.getAllSection(webhookMessage.getCourseId());
       for(SectionModel sectionModel : sectionModels) {
           if (sectionModel.getId().equals(webhookMessage.getObjectId())) {
               Section section = sectionDataMapper.sectionModelToSection(sectionModel, course);
               courseDomainService.createSection(section);
               Section result = sectionRepository.save(section);
               log.info("Section created with id: {} and moodle id: {}", result.getId(), result.getId());
           }
       }

    }
}
