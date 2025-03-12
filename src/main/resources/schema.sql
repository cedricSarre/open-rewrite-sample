CREATE SCHEMA IF NOT EXISTS classrooms;
CREATE SCHEMA IF NOT EXISTS establishments;
CREATE SCHEMA IF NOT EXISTS students;

SET search_path TO classrooms;
CREATE TABLE classroom
(
    id                      UUID    NOT NULL,
    establishment_id        UUID    NOT NULL,
    name                    varchar NOT NULL,
    "level"                 varchar NOT NULL,
    max_students_capacity   int     NOT NULL,
    CONSTRAINT classroom_pk PRIMARY KEY (id)
);

CREATE TABLE planning
(
    id                      UUID    NOT NULL,
    classroom_id            UUID    NOT NULL,
    "day"                   varchar NOT NULL,
    begin_hour              varchar NOT NULL,
    end_hour                varchar NOT NULL,
    subject                 varchar NOT NULL,
    teacher_id              UUID    NOT NULL,
    location                varchar NOT NULL,
    CONSTRAINT planning_pk PRIMARY KEY (id)
);


ALTER TABLE planning
    ADD CONSTRAINT planning_id FOREIGN KEY (classroom_id) REFERENCES classroom (id) ON DELETE CASCADE;

SET search_path TO establishments;
CREATE TABLE establishment
(
    id                      UUID    NOT NULL,
    "name"                  varchar NOT NULL,
    address                 varchar NULL,
    phone_number            varchar NULL,
    email                   varchar NULL,
    nb_max_classroom        int NOT NULL,
    CONSTRAINT establishment_pk PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id                  UUID    NOT NULL,
    establishment_id    UUID    NOT NULL,
    firstname           varchar NOT NULL,
    lastname            varchar NOT NULL,
    role                varchar NOT NULL,
    email               varchar NULL,
    CONSTRAINT employee_pk PRIMARY KEY (id)
);

CREATE TABLE activity
(
    id                  UUID    NOT NULL,
    establishment_id    UUID    NOT NULL,
    title               varchar NOT NULL,
    description         varchar NOT NULL,
    "date"              date    NULL,
    CONSTRAINT activity_pk PRIMARY KEY (id)
);

ALTER TABLE employee
    ADD CONSTRAINT employee_id FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON DELETE CASCADE;
ALTER TABLE activity
    ADD CONSTRAINT activity_id FOREIGN KEY (establishment_id) REFERENCES establishment (id) ON DELETE CASCADE;

SET search_path TO students;
CREATE TABLE student
(
    id                      UUID,
    classroom_id            UUID,
    establishment_id        UUID,
    firstname               varchar NOT NULL,
    lastname                varchar NOT NULL,
    birthdate               date    NOT NULL,
    CONSTRAINT classroom_pk PRIMARY KEY (id)
);

CREATE TABLE absence
(
    id                      UUID    NOT NULL,
    student_id              UUID    NOT NULL,
    "date"                  date    NOT NULL,
    CONSTRAINT absence_pk PRIMARY KEY (id)
);

CREATE TABLE rate --notes
(
    id                      UUID    NOT NULL,
    student_id              UUID    NOT NULL,
    subject                 varchar NOT NULL, -- matière
    "date"                  date    NOT NULL,
    "value"                 float   NOT NULL, -- note
    CONSTRAINT rate_pk PRIMARY KEY (id)
);

ALTER TABLE absence
    ADD CONSTRAINT absence_id FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE;
ALTER TABLE rate
    ADD CONSTRAINT rate_id FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE;
