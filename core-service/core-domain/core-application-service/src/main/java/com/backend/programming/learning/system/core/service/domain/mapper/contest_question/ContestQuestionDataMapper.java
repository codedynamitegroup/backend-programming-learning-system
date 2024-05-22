package com.backend.programming.learning.system.core.service.domain.mapper.contest_question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_question.ContestQuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContestQuestionDataMapper {
    public ContestQuestionResponseEntity contestQuestionToContestQuestionResponseEntity(ContestQuestion contestQuestion) {


        return ContestQuestionResponseEntity.builder()
                .questionId(contestQuestion.getQuestion().getId().getValue())
                .codeQuestionId(contestQuestion.getCodeQuestionId())
                .difficulty(contestQuestion.getQuestion().getDifficulty())
                .name(contestQuestion.getQuestion().getName())
                .questionText(contestQuestion.getQuestion().getQuestionText())
                .generalFeedback(contestQuestion.getQuestion().getGeneralFeedback())
                .defaultMark(contestQuestion.getQuestion().getDefaultMark())
                .build();
    }
}
