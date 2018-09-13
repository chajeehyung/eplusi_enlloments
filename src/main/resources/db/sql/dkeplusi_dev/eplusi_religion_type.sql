CREATE TABLE eplusi.religion_type
(
    religion_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    religion_type varchar(8) NOT NULL,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL
);
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, updated_date, created_date) VALUES (1, '입교', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, updated_date, created_date) VALUES (2, '세례', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, updated_date, created_date) VALUES (3, '학습', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, updated_date, created_date) VALUES (4, '유아세례', null, '2018-05-28 12:22:51.000000');
INSERT INTO eplusi.religion_type (religion_type_code, religion_type, updated_date, created_date) VALUES (5, '해당없음', null, '2018-05-28 12:22:51.000000');