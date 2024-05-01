DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS skill_level;
CREATE TYPE skill_level AS ENUM ('BASIC', 'INTERMEDIATE', 'ADVANCED');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');

DROP TYPE IF EXISTS plagiarism_detection_report_status;
CREATE TYPE plagiarism_detection_report_status AS ENUM ('PROCESSING', 'COMPLETED', 'FAILED');

DROP TYPE IF EXISTS update_state;
CREATE TYPE update_state AS ENUM (
    'CREATING',
    'CREATED',
    'UPDATING',
    'UPDATED',
    'DELETING',
    'DELETED',
    'DELETE_FAILED',
    'UPDATE_FAILED',
    'CREATE_FAILED');

DROP TYPE IF EXISTS CopyState;
CREATE TYPE CopyState AS ENUM (
    'CREATING',
    'CREATED',
    'UPDATING',
    'UPDATED',
    'DELETING',
    'DELETED',
    'CREATE_PROPAGATING',
    'UPDATE_PROPAGATING',
    'DELETE_PROPAGATING',
    'CREATE_ROLLBACKING',
    'UPDATE_ROLLBACKING',
    'DELETE_ROLLBACKING',
    'DELETE_FAILED',
    'UPDATE_FAILED',
    'CREATE_FAILED');

DROP TYPE IF EXISTS outbox_status;
CREATE TYPE outbox_status AS ENUM ('STARTED', 'COMPLETED', 'FAILED');

DROP TYPE IF EXISTS saga_status;
CREATE TYPE saga_status AS ENUM ('STARTED', 'FAILED', 'SUCCEEDED', 'PROCESSING', 'COMPENSATING', 'COMPENSATED');

DROP TABLE IF EXISTS "public".user CASCADE;
CREATE TABLE "public".user
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    email text UNIQUE NOT NULL,
    dob date,
    first_name character varying,
    last_name character varying,
	phone character varying,
	address character varying,
	avatar_url text,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
	is_deleted boolean NOT NULL DEFAULT false,
	copy_state CopyState,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".topic CASCADE;
CREATE TABLE "public".topic
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text UNIQUE NOT NULL,
    description text,
    created_by uuid,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    topic_id uuid NOT NULL,
    name text UNIQUE,
    skill_level skill_level,
    description text,
    avg_rating numeric(2,1) DEFAULT 0.0,
    start_time TIMESTAMP WITH TIME ZONE,
    end_time TIMESTAMP WITH TIME ZONE,
    is_deleted bool DEFAULT FALSE NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT certificate_course_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_topic_id_fkey FOREIGN KEY (topic_id)
        REFERENCES "public".topic (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE INDEX certificate_course_name_idx ON "public".certificate_course (name);

DROP TABLE IF EXISTS "public".chapter CASCADE;
CREATE TABLE "public".chapter
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    certificate_course_id uuid NOT NULL,
    no int4,
    title text,
    description text,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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
        ON DELETE CASCADE,
    CONSTRAINT chapter_certificate_course_id_no_key UNIQUE (certificate_course_id, no)
);

DROP TABLE IF EXISTS "public".certificate_course_user CASCADE;
CREATE TABLE "public".certificate_course_user
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    certificate_course_id uuid NOT NULL,
    user_id uuid NOT NULL,
    is_completed bool DEFAULT FALSE,
    completed_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT certificate_course_user_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_user_certificate_course_id_fkey FOREIGN KEY (certificate_course_id)
        REFERENCES "public".certificate_course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_user_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT certificate_course_user_certificate_course_id_user_id_key UNIQUE (certificate_course_id, user_id)
);

DROP TABLE IF EXISTS "public".review CASCADE;
CREATE TABLE "public".review
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    certificate_course_id uuid NOT NULL,
    rating numeric(2,1) DEFAULT 0.0 NOT NULL,
    content text,
    created_by uuid NOT NULL,
    updated_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text,
    compiler_api_id int8,
    time_limit int4,
    memory_limit int4,
    CONSTRAINT programming_language_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".topic_programming_language CASCADE;
CREATE TABLE "public".topic_programming_language
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    topic_id uuid NOT NULL,
    programming_language_id uuid NOT NULL,
    CONSTRAINT certificate_course_programming_language_pkey PRIMARY KEY (id),
    CONSTRAINT certificate_course_id_fkey FOREIGN KEY (topic_id)
        REFERENCES "public".topic (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT programming_language_id_fkey FOREIGN KEY (programming_language_id)
        REFERENCES "public".programming_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT topic_id_programming_language_id_key UNIQUE (topic_id, programming_language_id)
);

DROP TABLE IF EXISTS "public".contest CASCADE;
CREATE TABLE "public".contest
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text,
    description text,
    start_time TIMESTAMP WITH TIME ZONE,
    end_time TIMESTAMP WITH TIME ZONE,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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

CREATE INDEX contest_name_idx ON "public".contest (name);

DROP TABLE IF EXISTS "public".contest_user CASCADE;
CREATE TABLE "public".contest_user
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    contest_id uuid NOT NULL,
    user_id uuid NOT NULL,
    calendar_event_id uuid,
    update_calendar_event_state update_state,
    is_completed bool DEFAULT FALSE NOT NULL,
    completed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT contest_user_pkey PRIMARY KEY (id),
    CONSTRAINT contest_user_contest_id_fkey FOREIGN KEY (contest_id)
        REFERENCES "public".contest (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_user_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_user_contest_id_user_id_key UNIQUE (contest_id, user_id)
);

DROP TABLE IF EXISTS "public".organization CASCADE;
CREATE TABLE "public".organization
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text,
    description text,
    moodle_url text,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT organization_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".question CASCADE;
CREATE TABLE "public".question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    org_id uuid NOT NULL,
    difficulty difficulty NOT NULL,
    name text NOT NULL,
    question_text text NOT NULL,
    general_feedback text NOT NULL,
    default_mark numeric(5,2) NOT NULL,
    qtype qtype NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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

DROP TABLE IF EXISTS "public".chapter_question CASCADE;
CREATE TABLE "public".chapter_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    question_id uuid NOT NULL,
    chapter_id uuid NOT NULL,
    CONSTRAINT chapter_question_pkey PRIMARY KEY (id),
    CONSTRAINT question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chapter_id_fkey FOREIGN KEY (chapter_id)
        REFERENCES "public".chapter (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chapter_question_question_id_chapter_id_key UNIQUE (question_id, chapter_id)
);

DROP TABLE IF EXISTS "public".contest_question CASCADE;
CREATE TABLE "public".contest_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    contest_id uuid NOT NULL,
    question_id uuid NOT NULL,
    CONSTRAINT contest_question_pkey PRIMARY KEY (id),
    CONSTRAINT contest_question_contest_id_fkey FOREIGN KEY (contest_id)
        REFERENCES "public".contest (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_question_contest_id_question_id_key UNIQUE (contest_id, question_id)
);

DROP TABLE IF EXISTS "public".answer_of_question CASCADE;
CREATE TABLE "public".answer_of_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    question_id uuid NOT NULL,
    feedback text,
    answer text,
    fraction numeric(5,2) DEFAULT 0.0 NOT NULL,
    CONSTRAINT answer_of_question_pkey PRIMARY KEY (id),
    CONSTRAINT answer_of_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_code_question CASCADE;
CREATE TABLE "public".qtype_code_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    question_id uuid NOT NULL,
    dsl_template text,
    CONSTRAINT qtype_code_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_code_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_shortanswer_question CASCADE;
CREATE TABLE "public".qtype_shortanswer_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    question_id uuid NOT NULL,
    case_sensitive bool DEFAULT FALSE NOT NULL,
    CONSTRAINT qtype_shortanswer_question_pkey PRIMARY KEY (id),
    CONSTRAINT qtype_shortanswer_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".qtype_essay_question CASCADE;
CREATE TABLE "public".qtype_essay_question
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
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
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
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

DROP TABLE IF EXISTS "public".code_submission CASCADE;
CREATE TABLE "public".code_submission
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    user_id uuid NOT NULL,
    code_question_id uuid NOT NULL,
    programming_language_id uuid NOT NULL,
    source_code text,
    grade numeric(5,2) DEFAULT 0.0 NOT NULL,
    pass bool DEFAULT FALSE NOT NULL,
    CONSTRAINT code_submission_pkey PRIMARY KEY (id),
    CONSTRAINT code_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT code_submission_code_question_id_fkey FOREIGN KEY (code_question_id)
        REFERENCES "public".qtype_code_question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT code_submission_programming_language_id_fkey FOREIGN KEY (programming_language_id)
        REFERENCES "public".programming_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".plagiarism_detection_report CASCADE;
CREATE TABLE "public".plagiarism_detection_report
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    programming_language_id uuid NOT NULL,
    exam_id uuid NOT NULL,
    question_id uuid NOT NULL,
    name text,
    status plagiarism_detection_report_status NOT NULL,
    pairs_json_content text,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT plagiarism_detection_report_pkey PRIMARY KEY (id),
    CONSTRAINT plagiarism_detection_report_programming_language_id_fkey FOREIGN KEY (programming_language_id)
        REFERENCES "public".programming_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT plagiarism_detection_report_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE UNIQUE INDEX plagiarism_detection_report_exam_id_question_id
    ON "public".plagiarism_detection_report
        (exam_id, question_id, programming_language_id);

DROP TABLE IF EXISTS "public".contest_user_update_outbox CASCADE;

CREATE TABLE "public".contest_user_update_outbox
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    saga_status saga_status NOT NULL,
    update_calendar_event_state update_state,
    version integer NOT NULL,
    CONSTRAINT contest_user_outbox_pkey PRIMARY KEY (id)
);

CREATE INDEX contest_user_outbox_saga_status
    ON "public".contest_user_update_outbox
        (type, outbox_status, saga_status);

CREATE UNIQUE INDEX contest_user_outbox_saga_id
    ON "public".contest_user_update_outbox
        (type, saga_id, saga_status);


DROP TABLE IF EXISTS "public".user_outbox CASCADE;

CREATE TABLE "public".user_outbox
(
    id uuid NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    copy_state CopyState NOT NULL,
    version integer NOT NULL,
    CONSTRAINT user_outbox_pkey PRIMARY KEY (id)
);

CREATE INDEX "user_outbox_saga_status"
    ON "public".user_outbox
    (type, outbox_status);

CREATE UNIQUE INDEX "user_outbox_saga_id"
    ON "public".user_outbox
    (type, saga_id, copy_state, outbox_status);
