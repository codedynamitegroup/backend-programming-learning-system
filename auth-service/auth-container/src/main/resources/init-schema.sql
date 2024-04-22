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

DROP TABLE IF EXISTS "public".main_user CASCADE;

CREATE TABLE "public".main_user (
	id uuid NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    dob TIMESTAMP WITH TIME ZONE,
	first_name character varying,
	last_name character varying,
	phone character varying,
	address character varying,
	avatar_url text,
	refresh_token character varying,
	last_ip character varying,
	last_login TIMESTAMP WITH TIME ZONE,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	copy_state CopyState,
	is_deleted boolean NOT NULL DEFAULT false,
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
	organization_id uuid NOT NULL,
	description text,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
	PRIMARY KEY ("id"),
    CONSTRAINT role_fk1 FOREIGN KEY (organization_id)
        REFERENCES "public".main_organization (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS "public".user_role CASCADE;

CREATE TABLE "public".user_role (
	id uuid NOT NULL,
	user_id uuid NOT NULL,
	role_id uuid NOT NULL,
	is_active boolean NOT NULL DEFAULT true,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
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