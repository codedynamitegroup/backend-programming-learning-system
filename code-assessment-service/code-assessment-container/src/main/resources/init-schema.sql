DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

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

DROP TYPE IF EXISTS vote_type;
CREATE TYPE vote_type AS ENUM ('UPVOTE', 'DOWNVOTE');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');

DROP TYPE IF EXISTS grading_status;
CREATE TYPE grading_status AS ENUM ('GRADING', 'GRADED', 'GRADING_SYSTEM_UNAVAILABLE');

DROP TABLE IF EXISTS tag CASCADE;
CREATE TABLE tag(
    id uuid unique not null ,
    name text unique not null ,
    CONSTRAINT tag_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "public".user CASCADE;
CREATE TABLE "public".user
(
    id uuid UNIQUE NOT NULL,
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
    CONSTRAINT user_pkey PRIMARY KEY (id)
);


-- DROP TABLE IF EXISTS questions CASCADE;
-- CREATE TABLE questions
-- (
--     id uuid UNIQUE NOT NULL,
--     org_id uuid NOT NULL,
--     difficulty difficulty NOT NULL,
--     name text NOT NULL,
--     question_text text,
--     general_feedback text,
--     default_mark numeric(5,2) NOT NULL,
--     qtype qtype NOT NULL,
--     created_by uuid NOT NULL,
--     created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
--     updated_by uuid NOT NULL,
--     updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
--     CONSTRAINT question_pkey PRIMARY KEY (id)
--     CONSTRAINT question_org_id_fkey FOREIGN KEY (org_id)
--         REFERENCES organization (id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE,
--     CONSTRAINT question_created_by_fkey FOREIGN KEY (created_by)
--         REFERENCES user (id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE,
--     CONSTRAINT question_updated_by_fkey FOREIGN KEY (updated_by)
--         REFERENCES user (id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
-- );

DROP TABLE IF EXISTS programming_language CASCADE;
CREATE TABLE programming_language(
    id uuid UNIQUE NOT NULL ,
    name text not null ,
    compiler_api_id int not null ,
    time_limit float not null,
    memory_limit float check(memory_limit >= 2048) not null ,
    is_actived boolean default false,
    copy_state CopyState not null ,
    CONSTRAINT pr_la_pk PRIMARY KEY (id)

);

DROP TABLE IF EXISTS qtype_code_questions CASCADE;
CREATE TABLE qtype_code_questions(
    id uuid UNIQUE NOT NULL,
    question_id uuid NOT NULL,
    dsl_template text,
    name text NOT NULL,
    problem_statement text,
    input_format text,
    output_format text,
    copy_state CopyState,
    failure_messages text,
    constraints text,
    max_grade float default 10,
    CONSTRAINT qtype_code_questions_pk PRIMARY KEY (id)
--         CONSTRAINT qtype_code_questions_questions_id_fk FOREIGN KEY (question_id)
--         REFERENCES questions (id) MATCH SIMPLE
--         ON UPDATE CASCADE
--         ON DELETE CASCADE
    );

DROP TABLE IF EXISTS tag_code_question CASCADE;
CREATE TABLE tag_code_question(
    code_question_id uuid not null ,
    tag_id uuid not null ,
    constraint tcq_pk PRIMARY KEY (code_question_id, tag_id),
    constraint tag_fk foreign key (tag_id)
                              references tag (id) match simple on UPDATE cascade on delete cascade ,
    constraint c_qu_fk foreign key (code_question_id)
                              references qtype_code_questions (id) match simple on update cascade on delete cascade
);

DROP TABLE IF EXISTS shared_solution cascade;
CREATE TABLE shared_solution(
    id uuid not null ,
    code_question_id uuid not null ,
    user_id uuid not null ,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE,
    content text not null ,
    view_number int default 0 check(view_number >= 0),
    title text not null ,
    constraint ss_pk primary key (id),
    constraint co_qu_fk foreign key (code_question_id)
        references qtype_code_questions (id) match simple on update cascade on delete cascade,
    constraint user_fk foreign key (user_id)
                            references "public".user (id) match simple on update cascade on delete cascade

);

DROP TABLE IF EXISTS shared_solution_tag cascade;
CREATE TABLE shared_solution_tag(
    shared_solution_id uuid not null ,
    tag_id uuid not null ,
    constraint sst_id primary key (shared_solution_id, tag_id)
--    constraint ssx2_t_fk foreign key (shared_solution_id)
--                                references shared_solution(id) match simple on update cascade on delete cascade ,
--    constraint ss_tx2_fk foreign key (tag_id)
--                                references tag(id) match simple on update cascade on delete cascade
);

 DROP TABLE IF EXISTS comment cascade;
 CREATE TABLE comment(
     id uuid not null ,
     shared_solution_id uuid not null ,
     user_id uuid not null ,
     reply_id uuid,
     content text not null,
     created_at TIMESTAMP WITH TIME ZONE NOT NULL,
     constraint comment_pk primary key (id),
     constraint c_ss_fk foreign key (shared_solution_id)
        references shared_solution(id) match simple on update cascade on delete cascade,
     constraint c_u_fk foreign key (user_id)
        references "public".user(id) match simple on update cascade on delete cascade,
     constraint reply_fk foreign key(reply_id)
        references comment(id) match simple on update cascade on delete cascade
 );

DROP TABLE IF EXISTS vote_comment cascade;
CREATE TABLE vote_comment (
    user_id uuid not null,
    comment_id uuid not null,
    vote_type vote_type not null,
    constraint vc_pk primary key(user_id, comment_id),
    constraint c_vc_fk foreign key (comment_id)
            references comment(id) match simple on update cascade on delete cascade,
    constraint vc_u_fk foreign key (user_id)
            references "public".user(id) match simple on update cascade on delete cascade
);

DROP TABLE IF EXISTS vote_shared_solution cascade;
CREATE TABLE vote_shared_solution (
    user_id uuid not null,
    shared_solution_id uuid not null,
    vote_type vote_type not null,
    constraint vss_pk primary key(user_id, shared_solution_id),
    constraint ss_vss_fk foreign key (shared_solution_id)
            references shared_solution(id) match simple on update cascade on delete cascade,
    constraint vss_u_fk foreign key (user_id)
            references "public".user(id) match simple on update cascade on delete cascade
);

DROP TABLE IF EXISTS programming_language_code_question CASCADE;
CREATE TABLE programming_language_code_question(
    programming_language_id uuid NOT NULL ,
    code_question_id uuid not null ,
    time_limit float not null,
    memory_limit float check(memory_limit >= 2048) not null ,
    active boolean default true,
    CONSTRAINT pr_la_co_qu_pk PRIMARY KEY (programming_language_id, code_question_id),
    CONSTRAINT prl_fk FOREIGN KEY (programming_language_id)
        REFERENCES programming_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT cq_fk FOREIGN KEY (code_question_id)
        REFERENCES qtype_code_questions (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS test_cases CASCADE;
CREATE TABLE test_cases(
    id uuid UNIQUE NOT NULL ,
    code_question_id uuid NOT NULL ,
    input_data text not null ,
    output_data text not null ,
    is_sample boolean default false,
    score double precision default 1.0,
    CONSTRAINT te_ca_pk PRIMARY KEY (id),
    CONSTRAINT qcq_tc_fk FOREIGN KEY (code_question_id)
        REFERENCES qtype_code_questions (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);


DROP TABLE  IF EXISTS code_submission CASCADE;
CREATE TABLE code_submission(
    id uuid UNIQUE NOT NULL ,
    code_question_id uuid not null ,
    user_id uuid not null ,
    language_id uuid not null,
    grade double precision,
    avg_runtime double precision,
    avg_memory double precision,
    ai_assessment text,
    sonaque_assessment text,
    source_code text not null ,
    number_of_test_case_sent int not null ,
    number_of_test_case_graded int default 0,
    grading_status grading_status not null ,
    copy_state CopyState not null ,
--     version integer default 0 NOT NULL,
    CONSTRAINT co_su_pk PRIMARY KEY (id),
    CONSTRAINT co_qu_co_su_fk FOREIGN KEY (code_question_id)
        REFERENCES qtype_code_questions (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
    CONSTRAINT cc_fk FOREIGN KEY (user_id)
        REFERENCES "public".user (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
    CONSTRAINT pr_la_co_su_fk FOREIGN KEY (language_id)
        REFERENCES programming_language (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION

);

DROP TABLE IF EXISTS code_submission_test_case CASCADE;
CREATE TABLE code_submission_test_case(
    id uuid UNIQUE NOT NULL ,
    test_case_id uuid not null ,
    code_submission_id uuid not null ,
    actual_output text,
    compile_output text,
    message text,
    stderr text,
    status_description text,
    runtime float,
    memory float,
--     passed boolean,
    judge_token text,
    CONSTRAINT co_su_te_ca_pk PRIMARY KEY (id),
    CONSTRAINT co_su_te_cax2_fk FOREIGN KEY (test_case_id)
        REFERENCES test_cases (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
    CONSTRAINT co_sux2_te_ca_fk FOREIGN KEY (code_submission_id)
        REFERENCES code_submission (id) MATCH SIMPLE
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);
-- outbox

DROP TABLE IF EXISTS code_questions_update_outbox CASCADE;
CREATE TABLE code_questions_update_outbox
(
    id uuid NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    saga_status saga_status NOT NULL,
    copy_state CopyState NOT NULL,
    version integer NOT NULL,
    CONSTRAINT cquo_pk PRIMARY KEY (id)
);

CREATE INDEX "code_questions_update_outbox_saga_status"
ON code_questions_update_outbox
(type, outbox_status, saga_status);
CREATE INDEX "code_questions_update_outbox_saga_id"
ON code_questions_update_outbox
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
