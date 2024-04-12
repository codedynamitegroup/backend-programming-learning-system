DROP SCHEMA IF EXISTS "public" CASCADE;

CREATE SCHEMA "public";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

<<<<<<< HEAD:auth-service/auth-container/src/main/resources/init-schema.sql
CREATE TABLE public.main_user (
=======
DROP TABLE IF EXISTS "public".main_user CASCADE;

CREATE TABLE "public".main_user (
>>>>>>> origin/main:auth-service/auth-container/src/main/resources/init_schema.sql
	id uuid NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    dob TIMESTAMP WITH TIME ZONE,
	firstname character varying,
	lastname character varying,
	phone character varying,
	address character varying,
	avatar_url text,
	refresh_token character varying,
	last_ip character varying,
	last_login TIMESTAMP WITH TIME ZONE,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	is_deleted boolean NOT NULL DEFAULT false,
	PRIMARY KEY ("id")
);

<<<<<<< HEAD:auth-service/auth-container/src/main/resources/init-schema.sql
CREATE TABLE public.main_organization (
=======
DROP TABLE IF EXISTS "public".main_organization CASCADE;

CREATE TABLE "public".main_organization (
>>>>>>> origin/main:auth-service/auth-container/src/main/resources/init_schema.sql
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

<<<<<<< HEAD:auth-service/auth-container/src/main/resources/init-schema.sql
CREATE TABLE public.role (
=======
DROP TABLE IF EXISTS "public".role CASCADE;

CREATE TABLE "public".role (
>>>>>>> origin/main:auth-service/auth-container/src/main/resources/init_schema.sql
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

<<<<<<< HEAD:auth-service/auth-container/src/main/resources/init-schema.sql
CREATE TABLE public.user_role (
=======
DROP TABLE IF EXISTS "public".user_role CASCADE;

CREATE TABLE "public".user_role (
>>>>>>> origin/main:auth-service/auth-container/src/main/resources/init_schema.sql
	id uuid NOT NULL,
	user_id uuid NOT NULL,
	role_id uuid NOT NULL,
	is_active boolean NOT NULL DEFAULT true,
	name character varying COLLATE pg_catalog."default" NOT NULL,
	created_at TIMESTAMP WITH TIME ZONE,
	updated_at TIMESTAMP WITH TIME ZONE,
	updated_by uuid,
	created_by uuid,
<<<<<<< HEAD:auth-service/auth-container/src/main/resources/init-schema.sql
	PRIMARY KEY ("id")
);

ALTER TABLE public.role
    ADD CONSTRAINT "role_fk1" FOREIGN KEY (organization_id)
    REFERENCES "public".main_organization (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE public.user_role
    ADD CONSTRAINT "user_role_fk1" FOREIGN KEY (user_id)
    REFERENCES public.main_user (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE public.user_role
    ADD CONSTRAINT "user_role_fk2" FOREIGN KEY (role_id)
    REFERENCES public.role (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;
=======
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
>>>>>>> origin/main:auth-service/auth-container/src/main/resources/init_schema.sql
