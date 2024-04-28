package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_submission.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="code_submission")
public class CodeSubmissionEntity {
    @Id
    private UUID id;
}
