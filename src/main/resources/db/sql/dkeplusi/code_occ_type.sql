CREATE TABLE code.occ_type
(
    occ_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    occ_type varchar(20)
);
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (1, '직장인');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (2, '대학생');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (3, '대학원생');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (5, '자영업자');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (6, '수험생');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (7, '기타');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (8, '프리랜서');
INSERT INTO code.occ_type (occ_type_code, occ_type) VALUES (9, '취업준비생');