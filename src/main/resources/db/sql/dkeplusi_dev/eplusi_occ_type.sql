CREATE TABLE eplusi.occ_type
(
    occ_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    occ_type varchar(20) NOT NULL,
    update_time datetime(6),
    create_time datetime(6) NOT NULL
);
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (1, '직장인', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (2, '대학생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (3, '대학원생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (4, '자영업자', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (5, '수험생', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (6, '기타', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (7, '프리랜서', null, '2018-05-28 12:21:53.000000');
INSERT INTO eplusi.occ_type (occ_type_code, occ_type, update_time, create_time) VALUES (8, '취업준비생', null, '2018-05-28 12:21:53.000000');