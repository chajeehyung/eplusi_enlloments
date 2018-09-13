CREATE TABLE code.role_type
(
    role_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_name varchar(20) NOT NULL
);
CREATE UNIQUE INDEX role_type_role_name_uindex ON code.role_type (role_name);
INSERT INTO code.role_type (role_code, role_name) VALUES (1, '간사');
INSERT INTO code.role_type (role_code, role_name) VALUES (5, '국장');
INSERT INTO code.role_type (role_code, role_name) VALUES (2, '마을대표순장');
INSERT INTO code.role_type (role_code, role_name) VALUES (4, '순원');
INSERT INTO code.role_type (role_code, role_name) VALUES (3, '순장');
INSERT INTO code.role_type (role_code, role_name) VALUES (6, '팀장');