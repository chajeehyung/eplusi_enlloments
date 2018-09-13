CREATE TABLE eplusi.youth_family
(
    youth_fam_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    youth_id int(11) NOT NULL,
    person_name varchar(16) NOT NULL,
    rel_type varchar(20) NOT NULL,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL
);