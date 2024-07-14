package com.backend.programming.learning.system.course.service.domain.entity;

import com.backend.programming.learning.system.course.service.domain.valueobject.ModuleId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import com.backend.programming.learning.system.course.service.domain.valueobject.TypeModule;
import com.backend.programming.learning.system.domain.entity.AggregateRoot;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Module extends AggregateRoot<ModuleId> {
    private Section section;
    private Assignment assignment;
    private Exam exam;
    private Integer cmid;

    private TypeModule typeModule;

    private Module(Builder builder) {
        super.setId(builder.id);
        assignment = builder.assignment;
        cmid = builder.cmid;
        setSection(builder.section);
        setTypeModule(builder.typeModule);
        setExam(builder.exam);
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public TypeModule getTypeModule() {
        return typeModule;
    }

    public void setTypeModule(TypeModule typeModule) {
        this.typeModule = typeModule;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initializeModule() {
        setId(new ModuleId(UUID.randomUUID()));
    }


    public static final class Builder {
        private ModuleId id;

        private Assignment assignment;
        private Exam exam;
        private Integer cmid;
        private Section section;
        private TypeModule typeModule;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(ModuleId val) {
            id = val;
            return this;
        }

        public Builder assignment(Assignment val) {
            assignment = val;
            return this;
        }

        public Builder exam(Exam val) {
            exam = val;
            return this;
        }

        public Builder cmid(Integer val) {
            cmid = val;
            return this;
        }

        public Builder section(Section val) {
            section = val;
            return this;
        }

        public Builder typeModule(TypeModule val) {
            typeModule = val;
            return this;
        }


        public Module build() {
            return new Module(this);
        }
    }
}
