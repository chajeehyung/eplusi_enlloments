CREATE TABLE eplusi.enroll_status
(
    enroll_status_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enroll_status varchar(20) NOT NULL,
    enroll_desc varchar(200),
    updated_date datetime(6),
    created_date datetime(6) NOT NULL
);
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (1, '재적', 'enrolled, 출석중인 상태', null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (2, '제적', 'expelled, 제명당한 상태', null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (3, '워킹홀리데이', 'Working Holiday', null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (4, '군대', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (5, '유학', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (6, '결혼', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (7, '어학연수', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (8, '장기 출장', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (9, '지방 이전', null, null, '2018-05-28 12:20:38.000000');
INSERT INTO eplusi.enroll_status (enroll_status_code, enroll_status, enroll_desc, updated_date, created_date) VALUES (10, '기타', null, null, '2018-05-28 12:20:38.000000');