DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS CopyState;
CREATE TYPE CopyState AS ENUM ('CREATING',
    'CREATED',
    'UPDATING',
    'UPDATED',
    'DELETING',
    'DELETED',
    'DELETING_FAIL',
    'UPDATING_FAIL',
    'CREATING_FAIL');

DROP TYPE IF EXISTS difficulty;
CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');

DROP TYPE IF EXISTS qtype;
CREATE TYPE qtype AS ENUM ('MULTIPLE_CHOICE', 'SHORT_ANSWER', 'CODE', 'ESSAY');

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
    CONSTRAINT qtype_code_questions_pk PRIMARY KEY (id));

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

DROP TABLE IF EXISTS questions CASCADE;

CREATE TABLE questions
(
    id uuid UNIQUE NOT NULL,
    org_id uuid UNIQUE NOT NULL,
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