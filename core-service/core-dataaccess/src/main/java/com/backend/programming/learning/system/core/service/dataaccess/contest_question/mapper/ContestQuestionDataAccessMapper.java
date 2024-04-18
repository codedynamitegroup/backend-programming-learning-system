package com.backend.programming.learning.system.core.service.dataaccess.contest_question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest.entity.ContestEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest.mapper.ContestDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_question.entity.ContestQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContestQuestionDataAccessMapper {
    private final ContestDataAccessMapper contestDataAccessMapper;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public ContestQuestionDataAccessMapper(
            ContestDataAccessMapper contestDataAccessMapper, QuestionDataAccessMapper questionDataAccessMapper) {
        this.contestDataAccessMapper = contestDataAccessMapper;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public ContestQuestionEntity contestQuestionToContestQuestionEntity(ContestQuestion contestQuestion) {
        ContestEntity contestEntity = contestDataAccessMapper.contestToContestEntity(contestQuestion.getContest());
        QuestionEntity questionEntity = questionDataAccessMapper.questionToQuestionEntity(contestQuestion.getQuestion());

        return ContestQuestionEntity.builder()
                .id(contestQuestion.getId().getValue())
                .contest(contestEntity)
                .question(questionEntity)
                .build();

    }

    public ContestQuestion contestQuestionEntityToContestQuestion(ContestQuestionEntity contestQuestionEntity) {
        Contest contest = contestDataAccessMapper.contestEntityToContest(contestQuestionEntity.getContest());
        Question question = questionDataAccessMapper.questionEntityToQuestion(contestQuestionEntity.getQuestion());
        return ContestQuestion.builder()
                .id(new ContestQuestionId(contestQuestionEntity.getId()))
                .contest(contest)
                .question(question)
                .build();
    }

    public List<ContestQuestion> contestQuestionEntityListToContestQuestionList(List<ContestQuestionEntity> contestQuestionEntityList) {
        return contestQuestionEntityList.stream()
                .map(this::contestQuestionEntityToContestQuestion)
                .toList();
    }
}
