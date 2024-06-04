DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS skill_level;
CREATE TYPE skill_level AS ENUM ('BASIC', 'INTERMEDIATE', 'ADVANCED');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY', 'TRUE_FALSE');

DROP TYPE IF EXISTS grade_method;
CREATE TYPE grade_method AS ENUM ('QUIZ_GRADEHIGHEST', 'QUIZ_GRADEAVERAGE', 'QUIZ_ATTEMPTFIRST', 'QUIZ_ATTEMPTLAST');

DROP TYPE IF EXISTS type;
CREATE TYPE type AS ENUM ('TEXT_ONLINE', 'FILE', 'BOTH');

DROP TYPE IF EXISTS overdue_handling;
CREATE TYPE overdue_handling AS ENUM ('AUTOSUBMIT', 'GRACEPERIOD', 'AUTOABANDON');

DROP TYPE IF EXISTS status;
CREATE TYPE status AS ENUM ('SUBMITTED', 'NOT_SUBMITTED');

DROP TYPE IF EXISTS notification_event_type;
CREATE TYPE notification_event_type AS ENUM ('USER', 'COURSE');

DROP TYPE IF EXISTS notification_component_type;
CREATE TYPE notification_component_type AS ENUM ('ASSIGNMENT', 'EXAM', 'POST', 'CONTEST', 'REMINDER');

DROP TYPE IF EXISTS type_module;
CREATE TYPE type_module AS ENUM ('ASSIGNMENT', 'FILE', 'URL','QUIZ');

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

DROP TYPE IF EXISTS saga_status;
CREATE TYPE saga_status AS ENUM ('STARTED', 'FAILED', 'SUCCEEDED', 'PROCESSING', 'COMPENSATING', 'COMPENSATED');

DROP TYPE IF EXISTS outbox_status;
CREATE TYPE outbox_status AS ENUM ('STARTED', 'COMPLETED', 'FAILED');

DROP TYPE IF EXISTS notification_notify_time;
CREATE TYPE notification_notify_time AS ENUM ('TWENTY_FOUR_HOURS', 'TWELVE_HOURS', 'SIX_HOURS', 'THREE_HOURS', 'ONE_HOUR');

DROP TABLE IF EXISTS "public".organization CASCADE;
CREATE TABLE "public".organization
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    description text,
    name        text                           NOT NULL,
    api_key     text                           ,
    moodle_url  text                           ,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    is_deleted boolean NOT NULL DEFAULT false,
    CONSTRAINT organization_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".role_moodle CASCADE;
CREATE TABLE "public".role_moodle
(
    id          integer NOT NULL,
    name        text UNIQUE,
    CONSTRAINT role_moodle_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".user CASCADE;
CREATE TABLE "public".user
(
    id         uuid                     DEFAULT gen_random_uuid() NOT NULL,
    user_id_moodle int,
    org_id    uuid                     ,
    role_moodle_id integer,
    username  text UNIQUE,
    email      text UNIQUE NOT NULL,
    dob        date,
    first_name text,
    last_name  text,
    phone      text,
    address    text,
    avatar_url text,
    last_login TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    is_deleted boolean DEFAULT '0',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_org_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT user_role_moodle_id_fkey FOREIGN KEY (role_moodle_id)
        REFERENCES "public".role_moodle (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

DROP TABLE IF EXISTS "public".question_bank_category CASCADE;
CREATE TABLE "public".question_bank_category
(
    id            uuid                     DEFAULT gen_random_uuid() NOT NULL,
    "name"        text                                               NOT NULL,
    "description" text,
    "created_by"  uuid                                               NOT NULL,
    "updated_by"  uuid                                               NOT NULL,
    "created_at"  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    "updated_at"  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT question_bank_category_pkey PRIMARY KEY (id),
    CONSTRAINT question_bank_category_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_bank_category_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE cascade
);

DROP TABLE IF EXISTS "public".question CASCADE;
CREATE TABLE "public".question
(
    "id"                        uuid                      DEFAULT gen_random_uuid() NOT NULL,
    "org_id"                    uuid             NOT NULL,
    "name"                      text             NOT NULL,
    "question_text"             text             NOT NULL,
    "general_feedback"          text             NOT NULL,
    "default_mark"              double precision NOT NULL,
    "created_by"                uuid             NOT NULL,
    "updated_by"                uuid             NOT NULL,
    "created_at"                TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    "updated_at"                TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    question_bank_category_id   uuid,
    is_org_question_bank        bool DEFAULT FALSE,
    "qtype"                     qtype            NOT NULL,
    "difficulty"                difficulty       NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT question_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE cascade,
    CONSTRAINT question_question_bank_category_id_fkey FOREIGN KEY (question_bank_category_id)
        references "public".question_bank_category (id) MATCH SIMPLE
        on update CASCADE

);

DROP TABLE IF EXISTS "public".course_type CASCADE;
CREATE TABLE "public".course_type
(
    id          uuid    DEFAULT gen_random_uuid() NOT NULL,
    moodle_id integer,
    name        text UNIQUE,
    org_id uuid,
    CONSTRAINT course_type_pkey PRIMARY KEY (id),
    CONSTRAINT course_type_org_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".course CASCADE;
CREATE TABLE "public".course
(
    id          uuid    DEFAULT gen_random_uuid() NOT NULL,
    course_id_moodle integer,
    course_type_id uuid,
    org_id uuid,
    name        text UNIQUE,
    visible     boolean DEFAULT '1',
    created_by  uuid,
    updated_by  uuid,
    created_at  TIMESTAMP WITH TIME ZONE,
    updated_at  TIMESTAMP WITH TIME ZONE,
    CONSTRAINT course_pkey PRIMARY KEY (id),
    CONSTRAINT course_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT course_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE cascade,
    CONSTRAINT org_id_fkey FOREIGN KEY (org_id)
	    REFERENCES "public".organization (id) MATCH SIMPLE
	    ON UPDATE CASCADE
	    ON DELETE CASCADE,
	 CONSTRAINT course_type_id_fkey FOREIGN KEY (course_type_id)
        REFERENCES "public".course_type (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".section CASCADE;
CREATE TABLE "public".section
(
    id          uuid    DEFAULT gen_random_uuid() NOT NULL,
    course_id uuid,
    section_moodle_id integer,
    name        text,
    visible integer,
    CONSTRAINT section_pkey PRIMARY KEY (id),
	CONSTRAINT section_course_id_fkey FOREIGN KEY (course_id)
	    REFERENCES "public".course (id) MATCH SIMPLE
	    ON UPDATE CASCADE
	    ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".module CASCADE;
CREATE TABLE "public".module
(
    id          uuid    DEFAULT gen_random_uuid() NOT NULL,
    cmid integer,
    section_id uuid,
    name        text,
    visible integer,
    content text,
    type_module type_module,
    time_open TIMESTAMP WITH TIME zone,
    time_close TIMESTAMP WITH TIME zone,
    CONSTRAINT module_pkey PRIMARY KEY (id),
	CONSTRAINT module_section_id_fkey FOREIGN KEY (section_id)
	    REFERENCES "public".section (id) MATCH SIMPLE
	    ON UPDATE CASCADE
	    ON DELETE CASCADE
);



DROP TABLE IF EXISTS "public".post CASCADE;
CREATE TABLE "public".post
(
    id            uuid                     DEFAULT gen_random_uuid() NOT NULL,
    course_id     uuid    NOT NULL,
    title         text    NOT NULL,
    summary       text,
    content       text,
    publish_state boolean NOT NULL         DEFAULT '1',
    created_by    uuid,
    updated_by    uuid,
    created_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT post_pkey PRIMARY KEY (id),
    CONSTRAINT post_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT post_created_by_fkey FOREIGN KEY (created_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT post_updated_by_fkey FOREIGN KEY (updated_by)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".course_user CASCADE;

CREATE TABLE "public".course_user
(
    id        uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id   uuid                           NOT NULL,
    course_id uuid                           NOT NULL,
    role_id   integer                        NOT NULL,
    CONSTRAINT course_user_pkey PRIMARY KEY (id),
    CONSTRAINT course_user_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT course_user_course_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT course_user_role_id_fkey FOREIGN KEY (role_id)
        REFERENCES "public".role_moodle (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
DROP TABLE IF EXISTS "public".exam CASCADE;

CREATE TABLE "public".exam
(
    id                 uuid                      DEFAULT gen_random_uuid() NOT NULL,
    course_id          uuid             NOT NULL,
    name               text             NOT NULL,
    intro              text,
    score              double precision NOT NULL DEFAULT '0',
    max_score          double precision NOT NULL DEFAULT '0',
    time_open          TIMESTAMP WITH TIME ZONE,
    time_close         TIMESTAMP WITH TIME ZONE,
    time_limit         INTEGER,
    overdue_handling   overdue_handling NOT NULL DEFAULT 'AUTOABANDON',
    can_redo_questions boolean          NOT NULL DEFAULT '0',
    max_attempts       bigint           NOT NULL DEFAULT '0',
    shuffle_answers    boolean          NOT NULL DEFAULT '0',
    grade_method       grade_method     NOT NULL DEFAULT 'QUIZ_GRADEHIGHEST',
    "max_page"                  integer,
    created_at         TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP WITH TIME ZONE  DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT exam_pkey PRIMARY KEY (id),
    CONSTRAINT exam_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_question CASCADE;
CREATE TABLE "public".exam_question
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    exam_id     uuid                           NOT NULL,
    question_id uuid                           NOT NULL,
    page        integer                        ,
    CONSTRAINT exam_question_pkey PRIMARY KEY (id),
    CONSTRAINT exam_question_exam_id_fkey FOREIGN KEY (exam_id)
        REFERENCES "public".exam (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_question_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_submission CASCADE;
CREATE TABLE "public".exam_submission
(
    id           uuid                     DEFAULT gen_random_uuid() NOT NULL,
    exam_id      uuid NOT NULL,
    user_id      uuid NOT NULL,
    submit_count bigint                   DEFAULT '0',
    start_time   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    submit_time  TIMESTAMP WITH TIME ZONE DEFAULT NULL,
    status status NOT NULL DEFAULT 'NOT_SUBMITTED',
    CONSTRAINT exam_submission_pkey PRIMARY KEY (id),
    CONSTRAINT exam_submission_exam_id_fkey FOREIGN KEY (exam_id)
        REFERENCES "public".exam (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".exam_question_submission CASCADE;
CREATE TABLE "public".exam_question_submission
(
    id               uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id          uuid NOT NULL,
    exam_question_id uuid NOT NULL,
    AI_assessment    text,
    pass_status      bigint,
    grade            double precision,
    content          text,
    right_answer     text,
    num_file         bigint,
    status          integer,
    CONSTRAINT exam_question_submission_pkey PRIMARY KEY (id),
    CONSTRAINT exam_question_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".USER (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT exam_question_submission_exam_submission_id_fkey FOREIGN KEY (exam_question_id)
        REFERENCES "public".exam_question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".assignment CASCADE;
CREATE TABLE "public".assignment
(
    id         uuid                      DEFAULT gen_random_uuid() NOT NULL,
    assignment_id_moodle integer,
    course_id  uuid             NOT NULL,
    title      text             NOT NULL,
    intro      text,
    activity text,
    score      double precision NOT NULL DEFAULT '0',
    max_score  double precision NOT NULL DEFAULT '0',
    time_open  TIMESTAMP WITH TIME ZONE,
    time_close TIMESTAMP WITH TIME ZONE,
    time_limit TIMESTAMP WITH TIME ZONE,
    type       type             NOT null,
    visible    boolean          NOT NULL DEFAULT '0',
    CONSTRAINT assignment_pkey PRIMARY KEY (id),
    CONSTRAINT assignment_course_id_fkey FOREIGN KEY (course_id)
        REFERENCES "public".course (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".intro_file CASCADE;
CREATE TABLE "public".intro_file
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    assignment_id uuid,
    file_name        text                           NOT NULL,
    file_size integer NOT NULL,
    file_url         text                           NOT NULL,
    timemodified TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mimetype text NOT NULL,
    CONSTRAINT intro_file_pkey PRIMARY KEY (id),
    CONSTRAINT intro_file_assignment_id_fkey FOREIGN KEY (assignment_id)
        REFERENCES "public".assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".intro_attachment CASCADE;
CREATE TABLE "public".intro_attachment
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    assignment_id uuid,
    file_name        text                           NOT NULL,
    file_size integer NOT NULL,
    file_url         text                           NOT NULL,
    timemodified TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mimetype text NOT NULL,
    CONSTRAINT intro_attachment_pkey PRIMARY KEY (id),
    CONSTRAINT intro_attachment_assignment_id_fkey FOREIGN KEY (assignment_id)
        REFERENCES "public".assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".activity_attachment CASCADE;
CREATE TABLE "public".activity_attachment
(
    id          uuid DEFAULT gen_random_uuid() NOT NULL,
    assignment_id uuid,
    file_name        text                           NOT NULL,
    file_size integer NOT NULL,
    file_url         text                           NOT NULL,
    timemodified TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mimetype text NOT NULL,
    CONSTRAINT activity_attachment_pkey PRIMARY KEY (id),
    CONSTRAINT activity_attachment_assignment_id_fkey FOREIGN KEY (assignment_id)
        REFERENCES "public".assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".question_submission CASCADE;
CREATE TABLE "public".question_submission
(
    id                 uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id            uuid                           NOT NULL,
    exam_submission_id uuid                           NOT NULL,
    question_id        uuid                           NOT NULL,
    pass_status        bigint,
    grade              double precision,
    content            text,
    right_answer       text,
    num_file           bigint,
    CONSTRAINT question_submission_pkey PRIMARY KEY (id),
    CONSTRAINT question_submission_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".USER (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_submission_exam_submission_id_fkey FOREIGN KEY (exam_submission_id)
        REFERENCES "public".exam_submission (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT question_submission_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES "public".question (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_assignment CASCADE;
CREATE TABLE "public".submission_assignment
(
    id            uuid DEFAULT gen_random_uuid() NOT NULL,
    user_id       uuid                           NOT NULL,
    assignment_id uuid                           NOT NULL,
    is_graded   boolean                        NOT NULL,
    grade         double precision               ,
    content       text                          ,
    submit_time   timestamp without time zone,
    timemodified  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT submission_assignment_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT submission_assignment_assignment_id_fkey FOREIGN KEY (assignment_id)
        REFERENCES "public".assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_grade CASCADE;
CREATE TABLE "public".submission_grade
(
    id                       uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_id uuid                           NOT NULL,
    grade                    double precision               NOT NULL,
    time_created             TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    time_modified            TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT submission_grade_pkey PRIMARY KEY (id),
    CONSTRAINT submission_grade_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_id)
        REFERENCES "public".submission_assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_assignment_file CASCADE;
CREATE TABLE "public".submission_assignment_file
(
    id                       uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_id uuid                           NOT NULL,
    num_file                 bigint                         NOT NULL,
    CONSTRAINT submission_assignment_file_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_file_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_id)
        REFERENCES "public".submission_assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".submission_file CASCADE;
CREATE TABLE "public".submission_file
(
    id            uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_file_id uuid                           NOT NULL,
    file_name     text                           NOT NULL,
    file_size     integer                        NOT NULL,
    file_url      text                           NOT NULL,
    timemodified  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mimetype      text                           NOT NULL,
    CONSTRAINT submission_file_pkey PRIMARY KEY (id),
    CONSTRAINT submission_file_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_file_id)
        REFERENCES "public".submission_assignment_file (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".submission_assignment_onlinetext CASCADE;
CREATE TABLE "public".submission_assignment_onlinetext
(
    id                       uuid DEFAULT gen_random_uuid() NOT NULL,
    submission_assignment_id uuid                           NOT NULL,
    content                  text                           NOT NULL,
    CONSTRAINT submission_assignment_onlinetext_pkey PRIMARY KEY (id),
    CONSTRAINT submission_assignment_onlinetext_submission_assignment_id_fkey FOREIGN KEY (submission_assignment_id)
        REFERENCES "public".submission_assignment (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".webhook_api_function CASCADE;
CREATE TABLE "public".webhook_api_function
(
    "id"          uuid DEFAULT gen_random_uuid() NOT NULL,
    "area"        text                           NULL,
    "name"        text                           NOT NULL,
    "description" text                           NOT NULL,
    CONSTRAINT webhook_api_function_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".webhook_function_organization CASCADE;
CREATE TABLE "public".webhook_function_organization
(
    "id"                      uuid DEFAULT gen_random_uuid() NOT NULL,
    "org_id"                  uuid                           NOT NULL,
    "webhook_api_function_id" uuid                           NOT NULL,
    CONSTRAINT webhook_function_organization_pkey PRIMARY KEY (id),
    CONSTRAINT webhook_function_organization_organizationn_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT webhook_function_organization_webhook_api_function_id_fkey FOREIGN KEY (webhook_api_function_id)
        REFERENCES "public".webhook_api_function (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE

);
DROP TABLE IF EXISTS "public".call_moodle_api_function CASCADE;
CREATE TABLE "public".call_moodle_api_function
(
    "id"         uuid DEFAULT gen_random_uuid() NOT NULL,
    "area"       text                           NOT NULL,
    "name"       text                           NOT NULL,
    "decription" text                           NOT NULL,
    CONSTRAINT call_moodle_api_function_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".call_organization CASCADE;
CREATE TABLE "public".call_organization
(
    "id"                   uuid DEFAULT gen_random_uuid() NOT NULL,
    "org_id"               uuid                           NOT NULL,
    "call_api_function_id" uuid                           NOT NULL,
    CONSTRAINT call_organization_pkey PRIMARY KEY (id),
    CONSTRAINT call_organization_organizationn_id_fkey FOREIGN KEY (org_id)
        REFERENCES "public".organization (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT call_organization_call_api_function_id_fkey FOREIGN KEY (call_api_function_id)
        REFERENCES "public".call_moodle_api_function (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".notification CASCADE;

CREATE TABLE "public".notification
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    user_id_from uuid,
    user_id_to uuid NOT NULL,
    subject text,
    full_message text,
    small_message text,
    component notification_component_type DEFAULT 'REMINDER',
    event_type notification_event_type NOT NULL,
    context_url text,
    context_url_name text,
    is_read bool DEFAULT FALSE NOT NULL,
    time_read TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
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

DROP TABLE IF EXISTS "public".calendar_event CASCADE;

CREATE TABLE "public".calendar_event
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name text,
    description text,
    event_type notification_event_type NOT NULL,
    start_time TIMESTAMP WITH TIME ZONE NOT NULL,
    end_time TIMESTAMP WITH TIME ZONE,
    user_id uuid NOT NULL,
    course_id uuid,
    contest_id uuid,
    component notification_component_type DEFAULT 'REMINDER',
    is_start_time_notified bool DEFAULT FALSE NOT NULL,
    is_end_time_notified bool DEFAULT FALSE NOT NULL,
    notification_notify_time notification_notify_time,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT calendar_event_pkey PRIMARY KEY (id),
    CONSTRAINT calendar_event_created_by_fkey FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT contest_user_id_no_key UNIQUE (user_id, contest_id)
);

DROP TABLE IF EXISTS "public".calendar_event_update_outbox CASCADE;

CREATE TABLE "public".calendar_event_update_outbox
(
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    update_calendar_event_state update_state,
    version integer NOT NULL,
    CONSTRAINT calendar_event_outbox_pkey PRIMARY KEY (id)
);

CREATE INDEX calendar_event_outbox_saga_status
    ON "public".calendar_event_update_outbox
        (type, update_calendar_event_state);

CREATE UNIQUE INDEX calendar_event_outbox_saga_id
    ON "public".calendar_event_update_outbox
        (type, saga_id, update_calendar_event_state, outbox_status);

DROP TABLE IF EXISTS "public".question_outbox CASCADE;
CREATE TABLE  "public".question_outbox
(
    id uuid NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    prev_payload jsonb NULL,
    outbox_status outbox_status NOT NULL,
    copy_state CopyState NOT NULL,
    version integer NOT NULL,
    CONSTRAINT question_outbox_pkey PRIMARY KEY (id)
);

CREATE  INDEX "question_outbox_status"
    ON "public".question_outbox
    (type, outbox_status);

CREATE INDEX "question_outbox_saga_id"
    ON "public".question_outbox
    (type, saga_id);

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

CREATE TABLE "public".organization_outbox
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
    CONSTRAINT organization_outbox_pkey PRIMARY KEY (id)
);

CREATE INDEX "organization_outbox_saga_status"
    ON "public".organization_outbox
    (type, outbox_status);

CREATE UNIQUE INDEX "organization_outbox_saga_id"
    ON "public".organization_outbox
    (type, saga_id, copy_state, outbox_status);