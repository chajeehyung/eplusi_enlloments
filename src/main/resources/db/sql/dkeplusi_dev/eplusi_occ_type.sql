CREATE TABLE eplusi.occ_type
(
    occ_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    occ_type varchar(20) NOT NULL,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL
);
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (1, '직장인', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (2, '대학생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (3, '대학원생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (4, '자영업자', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (5, '수험생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (6, '기타', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (7, '프리랜서', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, updated_date, created_date) VALUES (8, '취업준비생', null, '2018-05-28 12:21:53.000000');