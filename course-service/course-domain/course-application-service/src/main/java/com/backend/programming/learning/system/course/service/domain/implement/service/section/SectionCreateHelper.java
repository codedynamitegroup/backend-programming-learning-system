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
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class SectionCreateHelper {
    private final SectionRepository sectionRepository;

    private final SectionDataMapper sectionDataMapper;
    private final CourseDomainService courseDomainService;
    private final MoodleCommandHandler moodleCommandHandler;
    private final SectionUpdateHelper sectionUpdateHelper;


    public SectionCreateHelper(SectionRepository sectionRepository,
                               SectionDataMapper sectionDataMapper,
                               CourseDomainService courseDomainService,
                               MoodleCommandHandler moodleCommandHandler, SectionUpdateHelper sectionUpdateHelper) {
        this.sectionRepository = sectionRepository;
        this.sectionDataMapper = sectionDataMapper;
        this.courseDomainService = courseDomainService;
        this.moodleCommandHandler = moodleCommandHandler;
        this.sectionUpdateHelper = sectionUpdateHelper;
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
    public Boolean createSection(WebhookMessage webhookMessage, Course course) {
        Organization organization = course.getOrganization();
        String apiKey = organization.getApiKey();
        String moodleUrl = organization.getMoodleUrl();
        List<SectionModel> sectionModels = moodleCommandHandler.getAllSection(webhookMessage.getCourseId(),apiKey, moodleUrl);
        // lay phan tu cuoi cung
        SectionModel sectionModel = sectionModels.get(sectionModels.size() - 1);
        Section section = sectionDataMapper.sectionModelToSection(sectionModel, course);
        courseDomainService.createSection(section);
        Section createResult = sectionRepository.save(section);
        List<Section> sections = sectionRepository.findByCourseId(new CourseId(course.getId().getValue()));
//        sectionModels.forEach(sectionModel1 -> {
//           if(!sectionModel1.getId().equals(sectionModel.getId())){
//                Optional<Section> sectionOptional = sections.stream().filter(section1 -> section1.getSectionMoodleId().equals(Integer.valueOf(sectionModel1.getId()))).findFirst();
//                if(sectionOptional.isPresent()){
//                     Section section1 = sectionOptional.get();
//                     sectionDataMapper.setSection(section1,sectionModel1);
//                     sectionRepository.save(section1);
//                }
//           }
//        }
//        );
        log.info("Section is created with id: {}", createResult.getId());
        return true;
    }
}
