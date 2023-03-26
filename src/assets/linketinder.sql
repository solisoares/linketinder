-- CREATE DATABASE linketinder

CREATE TABLE "countries"
(
    "id"   SERIAL PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "skills"
(
    "id"   SERIAL PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "applicants"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        varchar,
    "email"       varchar,
    "id_country"  int,
    "cep"         varchar,
    "description" varchar,
    "cpf"         varchar,
    "dob"         date
);

CREATE TABLE "applicant_skills"
(
    "id"           SERIAL PRIMARY KEY,
    "id_applicant" int,
    "id_skill"     int
);

CREATE TABLE "applicant_liked_job_opportunities"
(
    "id"                 SERIAL PRIMARY KEY,
    "id_applicant"       int,
    "id_job_opportunity" int
);

CREATE TABLE "companies"
(
    "id"          SERIAL PRIMARY KEY,
    "name"        varchar,
    "email"       varchar,
    "id_country"  int,
    "cep"         varchar,
    "description" varchar,
    "cnpj"        varchar
);

CREATE TABLE "job_opportunities"
(
    "id"          SERIAL PRIMARY KEY,
    "id_company"  int,
    "name"        varchar,
    "description" varchar,
    "location"    varchar
);

CREATE TABLE "job_opportunity_required_skills"
(
    "id"                 SERIAL PRIMARY KEY,
    "id_job_opportunity" int,
    "id_skill"           int
);
CREATE TABLE "company_liked_applicants"
(
    "id"           SERIAL PRIMARY KEY,
    "id_company"   int,
    "id_applicant" int
);

CREATE TABLE "matches"
(
    "id"                 SERIAL PRIMARY KEY,
    "id_applicant"       int,
    "id_company"         int,
    "id_job_opportunity" int
);

ALTER TABLE "job_opportunities"
    ADD FOREIGN KEY ("id_company") REFERENCES "companies" ("id");

ALTER TABLE "job_opportunity_required_skills"
    ADD FOREIGN KEY ("id_job_opportunity") REFERENCES "job_opportunities" ("id");

ALTER TABLE "job_opportunity_required_skills"
    ADD FOREIGN KEY ("id_skill") REFERENCES "skills" ("id");

ALTER TABLE "applicants"
    ADD FOREIGN KEY ("id_country") REFERENCES "countries" ("id");

ALTER TABLE "applicant_skills"
    ADD FOREIGN KEY ("id_applicant") REFERENCES "applicants" ("id");

ALTER TABLE "applicant_skills"
    ADD FOREIGN KEY ("id_skill") REFERENCES "skills" ("id");

ALTER TABLE "applicant_liked_job_opportunities"
    ADD FOREIGN KEY ("id_applicant") REFERENCES "applicants" ("id");

ALTER TABLE "applicant_liked_job_opportunities"
    ADD FOREIGN KEY ("id_job_opportunity") REFERENCES "job_opportunities" ("id");

ALTER TABLE "companies"
    ADD FOREIGN KEY ("id_country") REFERENCES "countries" ("id");

ALTER TABLE "company_liked_applicants"
    ADD FOREIGN KEY ("id_company") REFERENCES "companies" ("id");

ALTER TABLE "company_liked_applicants"
    ADD FOREIGN KEY ("id_applicant") REFERENCES "applicants" ("id");

ALTER TABLE "matches"
    ADD FOREIGN KEY ("id_applicant") REFERENCES "applicants" ("id");

ALTER TABLE "matches"
    ADD FOREIGN KEY ("id_company") REFERENCES "companies" ("id");

ALTER TABLE "matches"
    ADD FOREIGN KEY ("id_job_opportunity") REFERENCES "job_opportunities" ("id");




-- -- ===============
-- -- Pre-populate DB
-- -- ===============
-- -- Countries
-- INSERT INTO countries(name) VALUES ('Country1');
-- INSERT INTO countries(name) VALUES ('Country2');
-- INSERT INTO countries(name) VALUES ('Country3');
-- INSERT INTO countries(name) VALUES ('Country4');
-- INSERT INTO countries(name) VALUES ('Country5');
--
-- -- Skills
-- INSERT INTO skills(name) VALUES ('Skill1');
-- INSERT INTO skills(name) VALUES ('Skill2');
-- INSERT INTO skills(name) VALUES ('Skill3');
-- INSERT INTO skills(name) VALUES ('Skill4');
-- INSERT INTO skills(name) VALUES ('Skill5');
--
-- -- Applicants
-- INSERT INTO applicants(name, email, id_country, cep, description, cpf, dob) VALUES ('Applicant1', 'applicant1@ap.com', 1, '1111111', 'Applicant Description 1', '11111111111', '1991-01-01');
-- INSERT INTO applicants(name, email, id_country, cep, description, cpf, dob) VALUES ('Applicant2', 'applicant2@ap.com', 2, '2222222', 'Applicant Description 2', '22222222222', '2992-02-02');
-- INSERT INTO applicants(name, email, id_country, cep, description, cpf, dob) VALUES ('Applicant3', 'applicant3@ap.com', 3, '3333333', 'Applicant Description 3', '33333333333', '3993-03-03');
-- INSERT INTO applicants(name, email, id_country, cep, description, cpf, dob) VALUES ('Applicant4', 'applicant4@ap.com', 4, '4444444', 'Applicant Description 4', '44444444444', '4994-04-04');
-- INSERT INTO applicants(name, email, id_country, cep, description, cpf, dob) VALUES ('Applicant5', 'applicant5@ap.com', 5, '5555555', 'Applicant Description 5', '55555555555', '5995-05-05');
--
-- -- Applicants Skills
-- INSERT INTO applicant_skills(id_applicant, id_skill) VALUES (1, 1);
-- INSERT INTO applicant_skills(id_applicant, id_skill) VALUES (2, 2);
-- INSERT INTO applicant_skills(id_applicant, id_skill) VALUES (3, 3);
-- INSERT INTO applicant_skills(id_applicant, id_skill) VALUES (4, 4);
-- INSERT INTO applicant_skills(id_applicant, id_skill) VALUES (5, 5);
--
-- -- Companies
-- INSERT INTO companies(name, email, id_country, cep, description, cnpj) VALUES ('Company1', 'company@co1.com', 1, '1111111', 'Company Description 1', '11111111111');
-- INSERT INTO companies(name, email, id_country, cep, description, cnpj) VALUES ('Company2', 'company@co2.com', 2, '2222222', 'Company Description 2', '22222222222');
-- INSERT INTO companies(name, email, id_country, cep, description, cnpj) VALUES ('Company3', 'company@co3.com', 3, '3333333', 'Company Description 3', '33333333333');
-- INSERT INTO companies(name, email, id_country, cep, description, cnpj) VALUES ('Company4', 'company@co4.com', 4, '4444444', 'Company Description 4', '44444444444');
-- INSERT INTO companies(name, email, id_country, cep, description, cnpj) VALUES ('Company5', 'company@co5.com', 5, '5555555', 'Company Description 5', '55555555555');
--
-- -- Job Opportunities
-- INSERT INTO job_opportunities(id_company, name, description, location) VALUES (1, 'Job Opportunity 1', 'Job Opportunity Description 1', 'Location 1');
-- INSERT INTO job_opportunities(id_company, name, description, location) VALUES (2, 'Job Opportunity 2', 'Job Opportunity Description 2', 'Location 2');
-- INSERT INTO job_opportunities(id_company, name, description, location) VALUES (3, 'Job Opportunity 3', 'Job Opportunity Description 3', 'Location 3');
-- INSERT INTO job_opportunities(id_company, name, description, location) VALUES (4, 'Job Opportunity 4', 'Job Opportunity Description 4', 'Location 4');
-- INSERT INTO job_opportunities(id_company, name, description, location) VALUES (5, 'Job Opportunity 5', 'Job Opportunity Description 5', 'Location 5');
--
-- -- Job Opportunities Required Skills
-- INSERT INTO job_opportunity_required_skills(id_job_opportunity, id_skill) VALUES (1, 1);
-- INSERT INTO job_opportunity_required_skills(id_job_opportunity, id_skill) VALUES (2, 2);
-- INSERT INTO job_opportunity_required_skills(id_job_opportunity, id_skill) VALUES (3, 3);
-- INSERT INTO job_opportunity_required_skills(id_job_opportunity, id_skill) VALUES (4, 4);
-- INSERT INTO job_opportunity_required_skills(id_job_opportunity, id_skill) VALUES (5, 5);
--
-- -- Applicants Liked Job Opportunity
-- INSERT INTO applicant_liked_job_opportunities(id_applicant, id_job_opportunity) VALUES (1, 1);
-- INSERT INTO applicant_liked_job_opportunities(id_applicant, id_job_opportunity) VALUES (2, 2);
-- INSERT INTO applicant_liked_job_opportunities(id_applicant, id_job_opportunity) VALUES (3, 3);
-- INSERT INTO applicant_liked_job_opportunities(id_applicant, id_job_opportunity) VALUES (4, 4);
-- INSERT INTO applicant_liked_job_opportunities(id_applicant, id_job_opportunity) VALUES (5, 5);
--
-- -- Companies Liked Applicants
-- INSERT INTO company_liked_applicants(id_company, id_applicant) VALUES (1, 1);
-- INSERT INTO company_liked_applicants(id_company, id_applicant) VALUES (2, 2);
-- INSERT INTO company_liked_applicants(id_company, id_applicant) VALUES (3, 3);
-- INSERT INTO company_liked_applicants(id_company, id_applicant) VALUES (4, 4);
-- INSERT INTO company_liked_applicants(id_company, id_applicant) VALUES (5, 5);
--
-- -- Matches
-- INSERT INTO matches(id_applicant, id_company, id_job_opportunity) VALUES (1, 1, 1);
-- INSERT INTO matches(id_applicant, id_company, id_job_opportunity) VALUES (2, 2, 2);
-- INSERT INTO matches(id_applicant, id_company, id_job_opportunity) VALUES (3, 3, 3);
-- INSERT INTO matches(id_applicant, id_company, id_job_opportunity) VALUES (4, 4, 4);
-- INSERT INTO matches(id_applicant, id_company, id_job_opportunity) VALUES (5, 5, 5);




-- -- ===============
-- -- Some Selections
-- -- ===============
-- -- Matches
-- select
--     m.id AS "matchId",
--     a.name AS "applicantName",
--     c.name AS "companyName",
--     jo.name AS "jobOpportunyName",
--     jo.description AS "jobOpportunyDescription"
-- from
--     matches AS m,
--     applicants AS a,
--     companies AS c,
--     job_opportunities AS jo
-- where
--     m.id_applicant = a.id
--     AND m.id_company = c.id
--     AND m.id_job_opportunity = jo.id;
--
-- -- Applicants Liked Opportunities
-- select
--     apljo.id AS "id",
--     ap.name,
--     co.name,
--     jo.name
-- from
--     applicant_liked_job_opportunities AS apljo,
--     applicants AS ap,
--     job_opportunities AS jo,
--     companies AS co
-- where
--     apljo.id_applicant = ap.id
--     AND apljo.id_job_opportunity = jo.id
--     AND jo.id_company = co.id;
