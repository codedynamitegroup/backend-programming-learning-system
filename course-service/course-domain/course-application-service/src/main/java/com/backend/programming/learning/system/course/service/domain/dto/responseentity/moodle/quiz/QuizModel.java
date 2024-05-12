package com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle_course.quiz
 * Create by Dang Ngoc Tien
 * Date 5/7/2024 - 12:38 AM
 * Description: ...
 */
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizModel {
    String id;
    Integer coursemodule;
    Integer course;
    String name;
    String intro;
    Integer introformat;
    Object introfiles;
    Integer section;
    Boolean visible;
    Integer groupmode;
    Integer groupingid;
    String lang;
    Long timeopen;
    Long timeclose;
    Long timelimit;
    String overduehandling;
    Long graceperiod;
    String preferredbehaviour;
    Integer canredoquestions;
    Integer attempts;
    Integer attemptonlast;
    Integer grademethod;
    Integer decimalpoints;
    Integer questiondecimalpoints;
    Integer reviewattempt;
    Integer reviewcorrectness;
    Integer reviewmarks;
    Integer reviewspecificfeedback;
    Integer reviewgeneralfeedback;
    Integer reviewrightanswer;
    Integer reviewoverallfeedback;
    Integer questionsperpage;
    String navmethod;
    Integer shuffleanswers;
    Integer sumgrades;
    Integer grade;
    Long timecreated;
    Long timemodified;
    String password;
    String subnet;
    String browsersecurity;
    Long delay1;
    Long delay2;
    Integer showuserpicture;
    Integer showblocks;
    Integer completionattemptsexhausted;
    Integer completionpass;
    Integer allowofflineattempts;
    Integer autosaveperiod;
    Integer hasfeedback;
    Integer hasquestions;
}
