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

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');






DROP TABLE IF EXISTS questions CASCADE;
CREATE TABLE questions
(
    id uuid UNIQUE NOT NULL,
    org_id uuid NOT NULL,
    difficulty difficulty NOT NULL,
    name text NOT NULL,
    question_text text,
    general_feedback text,
    default_mark numeric(5,2) NOT NULL,
    qtype qtype NOT NULL,
    created_by uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_by uuid NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT question_pkey PRIMARY KEY (id)
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
);

DROP TABLE IF EXISTS qtype_code_questions CASCADE;
CREATE TABLE qtype_code_questions(
    id uuid UNIQUE NOT NULL,
    question_id uuid UNIQUE NOT NULL,
    dsl_template text,
    problem_statement text,
    input_format text,
    output_format text,
    copy_state CopyState,
    failure_messages text,
    constraints text,
    CONSTRAINT qtype_code_questions_pk PRIMARY KEY (id),
        CONSTRAINT qtype_code_questions_questions_id_fk FOREIGN KEY (question_id)
        REFERENCES questions (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
    );

DROP TABLE IF EXISTS test_cases CASCADE;
CREATE TABLE test_cases(
    id uuid UNIQUE NOT NULL ,
    code_question_id uuid UNIQUE NOT NULL ,
    input_data text,
    output_data text,
    is_sample boolean,
    score double precision,
    CONSTRAINT qcq_tc_fk FOREIGN KEY (code_question_id)
                       REFERENCES qtype_code_questions (id) MATCH SIMPLE
                        ON DELETE CASCADE ON UPDATE NO ACTION
);

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





