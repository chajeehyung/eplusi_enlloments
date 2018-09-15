CREATE TABLE eplusi.religion_type
(
    religion_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    religion_type varchar(8) NOT NULL,
    update_time datetime(6),
    create_time datetime(6) NOT NULL
);
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, update_time, create_time) VALUES (1, '입교', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, update_time, create_time) VALUES (2, '세례', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, update_time, create_time) VALUES (3, '학습', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, update_time, create_time) VALUES (4, '유아세례', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, update_time, create_time) VALUES (5, '해당없음', null, '2018-05-28 12:22:51.000000');