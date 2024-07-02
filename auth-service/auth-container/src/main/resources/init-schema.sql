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
    'DELETE_FAILED',
    'UPDATE_FAILED',
    'CREATE_FAILED');

DROP TYPE IF EXISTS service_name;
CREATE TYPE service_name AS ENUM (
    'CORE_SERVICE',
    'AUTH_SERVICE',
    'COURSE_SERVICE',
    'CODE_ASSESSMENT_SERVICE',
    'BACKGROUND_SERVICE');

DROP TYPE IF EXISTS saga_status;
CREATE TYPE saga_status AS ENUM ('STARTED', 'FAILED', 'SUCCEEDED', 'PROCESSING', 'COMPENSATING', 'COMPENSATED');

DROP TYPE IF EXISTS outbox_status;
CREATE TYPE outbox_status AS ENUM ('STARTED', 'COMPLETED', 'FAILED');


DROP TABLE IF EXISTS "public".main_user CASCADE;

CREATE TABLE "public".main_user (
	id uuid NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying,
    dob TIMESTAMP WITH TIME ZONE,
    organization_id uuid DEFAULT NULL,
	first_name character varying,
	last_name character varying,
	phone character varying,
	address character varying,
	avatar_url text,
	refresh_token character varying,
	last_login TIMESTAMP WITH TIME ZONE,
	is_linked_with_google boolean DEFAULT false,
	is_linked_with_microsoft boolean DEFAULT false,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	is_deleted boolean NOT NULL DEFAULT false,
	otp INTEGER DEFAULT NULL,
	otp_expire_at TIMESTAMP WITH TIME ZONE DEFAULT NULL,
	PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public".main_organization CASCADE;

CREATE TABLE "public".main_organization (
	id uuid NOT NULL,
	description text,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	email character varying COLLATE pg_catalog."default" NOT NULL,
	phone character varying,
	address character varying,
	api_key character varying,
	moodle_url text,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
	is_deleted boolean NOT NULL DEFAULT false,
	PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "public".role CASCADE;

CREATE TABLE "public".role (
	id uuid NOT NULL,
	description text,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	PRIMARY KEY ("id")
);


DROP TABLE IF EXISTS "public".user_role CASCADE;

CREATE TABLE "public".user_role (
	id uuid NOT NULL,
	user_id uuid NOT NULL,
	role_id uuid NOT NULL,
	PRIMARY KEY ("id"),
    CONSTRAINT user_role_fk1 FOREIGN KEY (user_id)
        REFERENCES "public".main_user (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT user_role_fk2 FOREIGN KEY (role_id)
        REFERENCES "public".role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

DROP TABLE IF EXISTS "public".user_outbox_auth_to_any_services CASCADE;

CREATE TABLE "public".user_outbox
(
    id uuid NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    saga_status saga_status NOT NULL,
    service_name service_name NOT NULL,
    copy_state CopyState NOT NULL,
    version integer NOT NULL,
    CONSTRAINT user_outbox_auth_to_any_services_pkey PRIMARY KEY (id)
);

CREATE INDEX "user_outbox_saga_status"
    ON "public".user_outbox
    (type, outbox_status, saga_status);

CREATE UNIQUE INDEX "user_outbox_saga_id"
    ON "public".user_outbox
    (type, saga_id, saga_status, service_name);

CREATE UNIQUE INDEX "user_outbox_saga_id_copy_state_type"
    ON "public".user_outbox
    (type, saga_id, copy_state, service_name);

DROP TABLE IF EXISTS "public".organization_outbox CASCADE;

CREATE TABLE "public".organization_outbox
(
    id uuid NOT NULL,
    saga_id uuid NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    processed_at TIMESTAMP WITH TIME ZONE,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    payload jsonb NOT NULL,
    outbox_status outbox_status NOT NULL,
    saga_status saga_status NOT NULL,
    service_name service_name NOT NULL,
    copy_state CopyState NOT NULL,
    version integer NOT NULL,
    CONSTRAINT organization_outbox_pkey PRIMARY KEY (id)
);

CREATE INDEX "organization_outbox_saga_status"
    ON "public".organization_outbox
    (type, outbox_status, saga_status);

CREATE UNIQUE INDEX "organization_outbox_saga_id"
    ON "public".organization_outbox
    (type, saga_id, copy_state, outbox_status, service_name);