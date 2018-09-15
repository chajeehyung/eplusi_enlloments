CREATE TABLE eplusi.senior_duty
(
    christian_charge_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    org_code int(11) NOT NULL,
    charge_id int(11) NOT NULL,
    role_code int(11) NOT NULL,
    start_date date,
    end_date date,
    update_time datetime(6),
    create_time datetime(6) NOT NULL
);