CREATE TABLE eplusi.role_type
(
    role_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_name varchar(20) NOT NULL,
    update_time datetime(6),
    create_time datetime(6) NOT NULL
);
CREATE UNIQUE INDEX role_name ON eplusi.role_type (role_name);
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (1, '간사', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (2, '마을대표순장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (3, '순장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (4, '순원', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (5, '국장', null, '2018-05-28 12:23:22.000000');
INSERT INTO eplusi.role_type (role_code, role_name, update_time, create_time) VALUES (6, '팀장', null, '2018-05-28 12:23:22.000000');