CREATE TABLE code.religion_type
(
    religion_type_code int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    religion_type varchar(8)
);
INSERT INTO code.religion_type (religion_type_code, religion_type) VALUES (1, '입교');
INSERT INTO code.religion_type (religion_type_code, religion_type) VALUES (2, '세례');
INSERT INTO code.religion_type (religion_type_code, religion_type) VALUES (3, '학습');
INSERT INTO code.religion_type (religion_type_code, religion_type) VALUES (4, '유아세례');