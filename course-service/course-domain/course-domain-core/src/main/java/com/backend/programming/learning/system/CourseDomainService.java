package com.backend.programming.learning.system;

import com.backend.programming.learning.system.entity.*;


import java.util.List;
import com.backend.programming.learning.system.entity.Question;

public interface CourseDomainService {
    void createExam(Exam exam);

    void createCourse(Course course);

    void createQuestion(Question question);

    void createAssignment(Assignment assignment);

    void createPost(Post post);

    void createSubmissionAssignment(SubmissionAssignment submissionAssignment);

    void createSubmissionAssignmentOnlineText(SubmissionAssignmentOnlineText submissionAssignmentOnlineText);

    void createSubmissionAssignmentFile(SubmissionAssignmentFile submissionAssignmentFile);
    void createCourseUsers(List<CourseUser> courseUsers);

    void createExamQuestions(List<ExamQuestion> examQuestions);

    void createOrganization(Organization organization);

    void createQuestionBankCategory(QuestionBankCategory questionBankCategory);
}
