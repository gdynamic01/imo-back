-- create schema
CREATE SCHEMA IF NOT EXISTS public;

-- create table users
create table IF NOT EXISTS public.imo_users(
    id BIGSERIAL NOT NULL,
    create_at date,
    update_at date,
    modificationcounter integer,
    email varchar(500) not null CONSTRAINT email_unique UNIQUE,
    password varchar(500) not null,
    code_postal int,
    ville text,
    pays text,
    complement_adresse text,
    libelle_rue varchar(70),
    numero_rue varchar(5),
    poste_occupe varchar(100),
    prenom varchar(50) not null,
    nom varchar(50) not null,
    sexe varchar(2) not null,
    telephone varchar(15),
    enabled boolean,
    type_user varchar(13) not null,
    PRIMARY KEY(id)
);

-- create table role
create table IF NOT EXISTS public.imo_role(
    id BIGSERIAL NOT NULL,
    create_at date,
    update_at date,
    modificationcounter integer,
    role varchar(60) not null CONSTRAINT role_unique UNIQUE,
    PRIMARY KEY(id)
);

-- create table user_roles
create table IF NOT EXISTS public.imo_user_roles(
    user_id BIGSERIAL NOT NULL,
    role_id BIGSERIAL NOT NULL,
    PRIMARY KEY(user_id,role_id)
);

-- create user_moral
create table IF NOT EXISTS public.imo_user_moral(
    id BIGSERIAL NOT NULL,
    kbis text,
    raison_social text,
    siret varchar(20),
     PRIMARY KEY(id)
);

-- create table user_physique
create table IF NOT EXISTS public.imo_user_physique(
    id BIGSERIAL NOT NULL,
     PRIMARY KEY(id)
);

-- create table offre
CREATE TABLE IF NOT EXISTS public.imo_offre (
    id BIGSERIAL NOT NULL,
    modificationcounter integer,
    create_at date not null,
    update_at date,
    code_postal int,
    complement_adresse character varying(255),
    libelle_rue character varying(255),
    numero_rue character varying(255),
    pays character varying(255),
    ville character varying(255),
    description character varying(255) NOT NULL,
    prix double precision NOT NULL,
    titre character varying(255) NOT NULL,
    users_id BIGSERIAL NOT NULL,
    type_offre character varying(250) NOT NULL,
    type_service_offre character varying(250) NOT NULL,
    PRIMARY KEY(id)
);

-- create table immobilier
CREATE TABLE IF NOT EXISTS public.imo_immobilier (
	id BIGSERIAL NOT NULL,
    surface double precision NOT NULL,
    nombre_pieces integer NOT NULL,
    piscine boolean,
    type_de_Bien character varying(255),
    type_location character varying(255) NOT NULL,
    sanitaire character varying(255),
    autre_service character varying(255),
    zone_geographique character varying(255) NOT NULL,
    parking boolean,
    electricite boolean,
    eau boolean,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    PRIMARY KEY(id)
);

-- create table mobile
CREATE TABLE IF NOT EXISTS public.imo_mobile (
	id BIGSERIAL NOT NULL,
    motoriser boolean,
    batterie character varying(255),
    duree_batterie time without time zone,
    date_mise_en_circulation date NOT NULL,
    kilometrage integer,
    model character varying(255) NOT NULL,
    nombre_porte integer,
    nombre_roue integer,
    type_moteur character varying(255) NOT NULL,
    PRIMARY KEY(id)
);

-- create table photos
CREATE TABLE IF NOT EXISTS public.imo_photos (
	id BIGSERIAL NOT NULL,
	modificationcounter integer,
	create_at date,
    update_at date,
	path_photos text NOT NULL,
	offre_id BIGSERIAL NOT NULL,
	CONSTRAINT imo_photos_pkey PRIMARY KEY(id)
);

-- Add contraintes
ALTER TABLE ONLY public.imo_mobile
    ADD CONSTRAINT fk215868tr3u27jcxsj6i1sctax FOREIGN KEY (id) REFERENCES public.imo_offre(id);
    
ALTER TABLE ONLY public.imo_immobilier
    ADD CONSTRAINT fk2rx01vuus4k1esue2a7ac9l21 FOREIGN KEY (id) REFERENCES public.imo_offre(id);
    
ALTER TABLE ONLY public.imo_offre
    ADD CONSTRAINT fk41bjdvev9kcc9d887ks4wse8c FOREIGN KEY (users_id) REFERENCES public.imo_users(id);

ALTER TABLE public.imo_photos ADD CONSTRAINT fkm7w044thf5518nhnw1amen6ti FOREIGN KEY (offre_id) REFERENCES imo_offre(id);

ALTER TABLE ONLY imo_user_roles ADD CONSTRAINT fk_user_roles FOREIGN KEY(user_id) REFERENCES imo_users(id);

ALTER TABLE ONLY imo_user_roles ADD CONSTRAINT fk_role_user FOREIGN KEY(role_id) REFERENCES imo_role(id);

ALTER TABLE ONLY imo_user_moral ADD CONSTRAINT fk_user_morale_user FOREIGN KEY (id) REFERENCES imo_users(id);

ALTER TABLE ONLY imo_user_physique ADD CONSTRAINT fk_user_physique_user FOREIGN KEY (id) REFERENCES imo_users(id);

insert into imo_role (id,modificationcounter, role) values (1, 0, 'ADMIN'),(2, 0, 'USER_MORAL'),(3, 0, 'USER_PHYSIQUE');

