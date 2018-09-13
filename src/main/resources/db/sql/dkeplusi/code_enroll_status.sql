CREATE TABLE code.enroll_status
(
    enroll_status_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enroll_status varchar(20) NOT NULL,
    enroll_desc varchar(200)
);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (1, '재적', 'enrolled, 출석중인 상태');
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (2, '제적', 'expelled, 제명당한 상태');
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (3, '워킹홀리데이', 'Working Holiday');
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (4, '군대', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (5, '유학', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (6, '결혼', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (7, '어학연수', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (8, '장기 출장', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (9, '지방 이전', null);
INSERT INTO code.enroll_status (enroll_status_code, enroll_status, enroll_desc) VALUES (10, '기타', null);