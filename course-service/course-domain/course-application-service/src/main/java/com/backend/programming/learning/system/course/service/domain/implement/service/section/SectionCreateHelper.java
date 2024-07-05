package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
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
import java.util.UUID;

@Component
@Slf4j
public class SectionCreateHelper {
    private final SectionRepository sectionRepository;

    private final SectionDataMapper sectionDataMapper;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;


    public SectionCreateHelper(SectionRepository sectionRepository,
                               SectionDataMapper sectionDataMapper,
                               CourseDomainService courseDomainService,
                               MoodleCommandHandler moodleCommandHandler) {
        this.sectionRepository = sectionRepository;
        this.sectionDataMapper = sectionDataMapper;
        this.courseDomainService = courseDomainService;
        this.moodleCommandHandler = moodleCommandHandler;
    }

    @Transactional
    public Section createSection(CreateSectionCommand createSectionCommand) {
        Section section = sectionDataMapper.createSectionCommandToSection(createSectionCommand);
        courseDomainService.createSection(section);
        Section createResult = sectionRepository.save(section);
        log.info("Section is created with id: {}", createResult.getId());
        return createResult;
    }

    @Transactional
    public void createSection(WebhookMessage webhookMessage, Course course) {
        Organization organization = course.getOrganization();
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();
        List<SectionModel> sectionModels = moodleCommandHandler.getAllSection(webhookMessage.getCourseId(),apiKey, moodleUrl);
        // lay phan tu cuoi cung
        SectionModel sectionModel = sectionModels.get(sectionModels.size() - 1);
        Integer topic = Integer.valueOf(sectionModel.getSection()) + 1;
        SectionModel newSectionModel= SectionModel.builder()
                .id(String.valueOf(Integer.valueOf(sectionModel.getId())+1))
                .name("Topic "+topic)
                .visible(1)
                .uservisible(true)
                .summaryformat("1")
                .summary("")
                .section(sectionModel.getSection()+1)
                .hiddenbynumsections("0")
                .modules(List.of())
                .build();
        Section section = sectionDataMapper.sectionModelToSection(newSectionModel, course);

        courseDomainService.createSection(section);
        Section createResult = sectionRepository.save(section);
        log.info("Section is created with id: {}", createResult.getId());
    }
}
