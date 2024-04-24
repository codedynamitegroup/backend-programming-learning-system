package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity;

import com.backend.programming.learning.system.core.service.dataaccess.topic_programminglanguage.entity.TopicProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.domain.entity.TopicProgrammingLanguage;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programming_language")
@Entity
public class ProgrammingLanguageEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    private String name;
    private Integer compilerApiId;
    private Float timeLimit;
    private Float memoryLimit;

//    @OneToMany(mappedBy = "programmingLanguage", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    private List<TopicProgrammingLanguageEntity> topicProgrammingLanguages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammingLanguageEntity that = (ProgrammingLanguageEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
