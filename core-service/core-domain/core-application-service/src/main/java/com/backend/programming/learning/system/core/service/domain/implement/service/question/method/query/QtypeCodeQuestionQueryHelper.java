package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeCodeQuestionQueryHelper {
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;
    private final UserRepository userRepository;

    public QtypeCodeQuestionQueryHelper(QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                        QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper,
                                        UserRepository userRepository) {
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
        this.userRepository = userRepository;
    }

    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtCodeQuestionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQtypeCodeQuestion(qtCodeQuestionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", qtCodeQuestionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + qtCodeQuestionId + " not found");
        }

        QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionResponse = qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(qtypeCodeQuestion.get());

        log.info("Query Qtype Code Question with id: {}", qtypeCodeQuestion.get().getId().getValue());

        return queryQtypeCodeQuestionResponse;
    }

    @Transactional(readOnly = true)
    public Page<QtypeCodeQuestion> queryAllQtypeCodeQuestionsForAdmin(
            String search,
            QuestionDifficulty difficulty,
            Boolean isPublic,
            Integer pageNo,
            Integer pageSize,
            String email
    ) {
        User user = getUserByEmail(email);

        Page<QtypeCodeQuestion> qtypeCodeQuestions =
                qtypeCodeQuestionRepository.findAllAdminQtypeCodeQuestions(
                        search,
                        difficulty,
                        isPublic,
                        user.getId().getValue(),
                        pageNo,
                        pageSize);
        log.info("Query all Qtype Code Questions for Admin");

        return qtypeCodeQuestions;
    }

    @Transactional(readOnly = true)
    public Page<QtypeCodeQuestion> queryAllQtypeCodeQuestionsForOrgAdmin(
            UUID orgId,
            String search,
            QuestionDifficulty difficulty,
            Boolean isPublic,
            Integer pageNo,
            Integer pageSize,
            String email
    ) {
        User user = getUserByEmail(email);

        Page<QtypeCodeQuestion> qtypeCodeQuestions =
                qtypeCodeQuestionRepository.findAllOrgAdminQtypeCodeQuestions(
                        orgId,
                        search,
                        difficulty,
                        isPublic,
                        user.getId().getValue(),
                        pageNo,
                        pageSize);
        log.info("Query all Qtype Code Questions for Org Admin");

        return qtypeCodeQuestions;
    }

    public QueryQtypeCodeQuestionResponse queryQuestionById(UUID questionId) {
        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository.findQuestionId(questionId);

        if (qtypeCodeQuestion.isEmpty()) {
            log.error("Qtype Code Question not found with id: {}", questionId);

            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question with id " + questionId + " not found");
        }

        QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionResponse = qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(qtypeCodeQuestion.get());

        log.info("Query Qtype Code Question with id: {}", qtypeCodeQuestion.get().getId().getValue());

        return queryQtypeCodeQuestionResponse;
    }

    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestions() {
        List<QtypeCodeQuestion> qtypeCodeQuestions = qtypeCodeQuestionRepository.findAllQtypeCodeQuestions();

        return qtypeCodeQuestionDataMapper.qtypeCodeQuestionsToQueryQtypeCodeQuestionResponses(qtypeCodeQuestions);
    }

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }
}
