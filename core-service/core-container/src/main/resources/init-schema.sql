DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS skill_level;
CREATE TYPE skill_level AS ENUM ('BASIC', 'INTERMEDIATE', 'ADVANCED');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');

DROP TABLE IF EXISTS "public".user CASCADE;

CREATE TABLE "public".user
(
    id uuid NOT NULL,
    email text NOT NULL,
    dob date NOT NULL,
    name text NOT NULL,
    display_name text NOT NULL,
    avatar_url text NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".topic CASCADE;

CREATE TABLE "public".topic
(
    id uuid NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT topic_pkey PRIMARY KEY (id),
    CONSTRAINT topic_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT topic_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".certificate_course CASCADE;

CREATE TABLE "public".certificate_course
(
    id uuid NOT NULL,
    name text NOT NULL,
    skill_level skill_level NOT NULL,
    avg_rating numeric(2,1) NOT NULL,
    topic_id uuid NOT NULL,
    start_time TIMESTAMP WITH TIME ZONE NOT NULL,
    end_time TIMESTAMP WITH TIME ZONE NOT NULL,
    is_deleted bool NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT certificate_course_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_topic_id_fkey FOREIGN KEY (topic_id)
        REFERENCES "public".topic (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".chapter CASCADE;

CREATE TABLE "public".chapter
(
    id uuid NOT NULL,
    certificate_course_id uuid NOT NULL,
    no int4 NOT NULL,
    title text NOT NULL,
    description text NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT chapter_pkey PRIMARY KEY (id),
    CONSTRAINT chapter_certificate_course_id_fkey FOREIGN KEY (certificate_course_id)
        REFERENCES "public".certificate_course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chapter_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chapter_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".certificate_course_user CASCADE;

CREATE TABLE "public".certificate_course_user
(
    id uuid NOT NULL,
    certificate_course_id uuid NOT NULL,
    user_id uuid NOT NULL,
    is_completed bool NOT NULL,
    completed_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT certificate_course_user_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_user_certificate_course_id_fkey FOREIGN KEY (certificate_course_id)
        REFERENCES "public".certificate_course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_user_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".review CASCADE;

CREATE TABLE "public".review
(
    id uuid NOT NULL,
    certificate_course_id uuid NOT NULL,
    rating numeric(2,1) NOT NULL,
    content text NOT NULL,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT review_pkey PRIMARY KEY (id),
    CONSTRAINT review_certificate_course_id_fkey FOREIGN KEY (certificate_course_id)
        REFERENCES "public".certificate_course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT review_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT review_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".programming_language CASCADE;

CREATE TABLE "public".programming_language
(
    id uuid NOT NULL,
    name text NOT NULL,
    compiler_api_id int8 NOT NULL,
    time_limit int4 NOT NULL,
    memory_limit int4 NOT NULL,
    head_code text NOT NULL,
    body_code text NOT NULL,
    tail_code text NOT NULL,
    is_active bool NOT NULL,
    CONSTRAINT programming_language_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".certificate_course_programming_language CASCADE;

CREATE TABLE "public".certificate_course_programming_language
(
    id uuid NOT NULL,
    certificate_course_id uuid NOT NULL,
    programming_language_id uuid NOT NULL,
    CONSTRAINT certificate_course_programming_language_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_id_fkey FOREIGN KEY (certificate_course_id)
        REFERENCES "public".certificate_course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT programming_language_id_fkey FOREIGN KEY (programming_language_id)
        REFERENCES "public".programming_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".contest CASCADE;

CREATE TABLE "public".contest
(
    id uuid NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    start_time TIMESTAMP WITH TIME ZONE NOT NULL,
    end_time TIMESTAMP WITH TIME ZONE NOT NULL,
    is_deleted bool NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT contest_pkey PRIMARY KEY (id),
    CONSTRAINT contest_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".user_contest CASCADE;

CREATE TABLE "public".user_contest
(
    id uuid NOT NULL,
    contest_id uuid NOT NULL,
    user_id uuid NOT NULL,
    is_completed bool NOT NULL,
    completed_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT user_contest_pkey PRIMARY KEY (id),
    CONSTRAINT user_contest_contest_id_fkey FOREIGN KEY (contest_id)
        REFERENCES "public".contest (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT user_contest_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".organization CASCADE;

CREATE TABLE "public".organization
(
    id uuid NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    moodle_url text NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT organization_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".question CASCADE;

CREATE TABLE "public".question
(
    id uuid NOT NULL,
    org_id uuid NOT NULL,
    difficulty difficulty NOT NULL,
    name text NOT NULL,
    question_text text NOT NULL,
    general_feedback text NOT NULL,
    default_mark numeric(2,2) NOT NULL,
    qtype qtype NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT question_org_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".question_chapter CASCADE;

CREATE TABLE "public".question_chapter
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    chapter_id uuid NOT NULL,
    grade numeric(2,2) NOT NULL,
    pass bool NOT NULL,
    CONSTRAINT question_chapter_pkey PRIMARY KEY (id),
    CONSTRAINT question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chapter_id_fkey FOREIGN KEY (chapter_id)
        REFERENCES "public".chapter (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".answer_of_question CASCADE;

CREATE TABLE "public".answer_of_question
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    feedback text NOT NULL,
    answer text NOT NULL,
    fraction numeric(2,2) NOT NULL,
    CONSTRAINT answer_of_question_pkey PRIMARY KEY (id),
    CONSTRAINT answer_of_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_code_question CASCADE;

CREATE TABLE "public".qtype_code_question
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    dsl_template text NOT NULL,
    CONSTRAINT qtype_code_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_code_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_shortanswer_question CASCADE;

CREATE TABLE "public".qtype_shortanswer_question
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    case_sensitive bool NOT NULL,
    CONSTRAINT qtype_shortanswer_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_shortanswer_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_essay_question CASCADE;

CREATE TABLE "public".qtype_essay_question
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    response_format text NOT NULL,
    response_required int4 NOT NULL,
    response_field_lines int4 NOT NULL,
    min_word_limit int4 NOT NULL,
    max_word_limit int4 NOT NULL,
    attachments int4 NOT NULL,
    attachments_required int4 NOT NULL,
    grader_info text NOT NULL,
    grader_info_format text NOT NULL,
    response_template text NOT NULL,
    max_bytes int4 NOT NULL,
    file_types_list text NOT NULL,
    CONSTRAINT qtype_essay_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_essay_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_multichoice_question CASCADE;

CREATE TABLE "public".qtype_multichoice_question
(
    id uuid NOT NULL,
    question_id uuid NOT NULL,
    single bool NOT NULL,
    shuffle_answers bool NOT NULL,
    correct_feedback text NOT NULL,
    partially_correct_feedback text NOT NULL,
    incorrect_feedback text NOT NULL,
    answer_numbering text NOT NULL,
    show_num_correct int4 NOT NULL,
    show_standard_instruction text NOT NULL,
    CONSTRAINT qtype_multichoice_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_multichoice_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".notification CASCADE;

CREATE TABLE "public".notification
(
    id uuid NOT NULL,
    user_id_from uuid NOT NULL,
    user_id_to uuid NOT NULL,
    subject text NOT NULL,
    full_message text NOT NULL,
    small_message text NOT NULL,
    component text NOT NULL,
    event_type text NOT NULL,
    context_url text NOT NULL,
    context_url_name text NOT NULL,
    is_read bool NOT NULL,
    time_read TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT notification_pkey PRIMARY KEY (id),
    CONSTRAINT notification_user_id_from_fkey FOREIGN KEY (user_id_from)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT notification_user_id_to_fkey FOREIGN KEY (user_id_to)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);