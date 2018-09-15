CREATE TABLE eplusi.enrollments
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    start_date date,
    end_date date,
    enroll_desc longtext,
    update_time datetime(6),
    create_time datetime(6) NOT NULL,
    enroll_status_code int(11) NOT NULL,
    youth_id int(11) NOT NULL,
    CONSTRAINT enrollments_enroll_status_code_6f042b84_fk_enroll_st FOREIGN KEY (enroll_status_code) REFERENCES eplusi.enroll_status (enroll_status_code),
    CONSTRAINT enrollments_youth_id_568370e5_fk_youth_youth_id FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX enrollments_enroll_status_code_6f042b84_fk_enroll_st ON eplusi.enrollments (enroll_status_code);
CREATE INDEX enrollments_youth_id_568370e5_fk_youth_youth_id ON eplusi.enrollments (youth_id);