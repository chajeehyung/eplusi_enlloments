CREATE TABLE eplusi.youth_family
(
    youth_fam_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    youth_id int(11) NOT NULL,
    person_name varchar(16) NOT NULL,
    rel_type varchar(20) NOT NULL,
    create_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
);
INSERT INTO eplusi.youth_family (youth_fam_id, youth_id, person_name, rel_type, create_time) VALUES (1, 1, '조XX', 'F', '2017-10-10 12:15:28');
INSERT INTO eplusi.youth_family (youth_fam_id, youth_id, person_name, rel_type, create_time) VALUES (2, 1, '조XX', 'M', '2017-10-10 12:15:28');