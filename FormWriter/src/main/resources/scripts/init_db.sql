-- Init tables SCRIPT
--select 'drop table if exists"' || tablename || '" cascade;' from pg where tableowner = 'postgres';
--select 'drop sequence if exists "' || relname || '"cascade;' from pg_class where relkind - 'S';
DROP SCHEMA IF EXISTS validated_forms cascade;

CREATE SCHEMA validated_forms;

GRANT ALL ON SCHEMA validated_forms TO postgres;

-- ADDRESS
CREATE TABLE validated_forms.address (
  id         serial primary key,
  number     integer     not null,
  street     varchar(50) not null,
  city       varchar(50) not null,
  county     varchar(50) not null,
  country    varchar(50) not null,
  postalCode varchar(50) not null
);

-- COORDINATES
CREATE TABLE validated_forms.coordinates (
  id        serial primary key,
  latitude  double precision not null,
  longitude double precision not null,
  altitude  double precision not null
);

-- LOCATION
CREATE TABLE validated_forms.location (
  id             serial primary key,
  description    varchar(50) not null,
  coordinates_id integer references validated_forms.coordinates (id),
  address_id     integer references validated_forms.address (id)
);

-- LEGAL PERSON
CREATE TABLE validated_forms.legalperson (
  id   serial primary key,
  name varchar(50) not null,
  cif  varchar(50) not null
);

-- INDIVIDUAL PERSON
CREATE TABLE validated_forms.individualperson (
  id          serial primary key,
  cnp         char(13) unique,
  lastname    varchar(50) not null,
  firstname   varchar(50) not null,
  citizenship varchar(50) not null
);

-- PERSON
CREATE TABLE validated_forms.person (
  id                   serial primary key,
  individual_person_id integer references validated_forms.individualperson (id),
  legal_person_id      integer references validated_forms.legalperson (id),
  telephone            char(10),
  address_id           int references validated_forms.address (id)
);

-- APPLICANT
CREATE TABLE validated_forms.applicant (
  id                  serial primary key,
  individualperson_id int references validated_forms.individualperson (id),
  legalperson_id      int references validated_forms.legalperson (id)
);

-- PACIENT
CREATE TABLE validated_forms.pacient (
  id                  serial primary key,
  individualperson_id int references validated_forms.individualperson (id)
);

-- INJURED PERSON
CREATE TABLE validated_forms.injuredperson (
  id        serial primary key,
  person_id int references validated_forms.person (id)
);

-- AGENT
CREATE TABLE validated_forms.agent (
  id                  serial primary key,
  individualperson_id int references validated_forms.individualperson (id)
);

-- HOSPITAL FORM
CREATE TABLE validated_forms.hospitalform (
  id              serial primary key,
  applicant_id    integer references validated_forms.applicant (id),
  details         varchar(50) not null,
  authorizationNr varchar(50) not null,
  location_id     integer references validated_forms.location (id),
  pacient_id      integer references validated_forms.pacient (id),
  equipment       varchar(50),
  data            timestamp
);

-- POLICE FORM
CREATE TABLE validated_forms.policeform (
  id               serial primary key,
  applicant_id     integer references validated_forms.applicant (id),
  details          varchar(50) not null,
  authorizationNr  varchar(50) not null,
  location_id      integer references validated_forms.location (id),
  injuredperson_id integer references validated_forms.injuredperson (id),
  agent_id         integer references validated_forms.agent (id),
  data             timestamp
);

-- COMPANY FORM
CREATE TABLE validated_forms.companyform (
  id           serial primary key,
  applicant_id integer references validated_forms.applicant (id),
  details      varchar(50) not null,
  location_id  integer references validated_forms.location (id),
  contractNr   varchar(50) not null,
  data         timestamp
);
