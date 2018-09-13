CREATE TABLE eplusi.role_type
(
    role_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_name varchar(20) NOT NULL,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL
);
CREATE UNIQUE INDEX role_name ON eplusi.role_type (role_name);
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (1, '간사', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (2, '마을대표순장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (3, '순장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (4, '순원', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (5, '국장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, updated_date, created_date) VALUES (6, '팀장', null, '2018-05-28 12:23:22.000000');