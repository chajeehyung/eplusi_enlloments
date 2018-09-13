CREATE TABLE common.senior_duty
(
    christian_charge_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    org_code int(11) NOT NULL,
    charge_id int(11) NOT NULL,
    role_code int(11) NOT NULL,
    start_date date,
    end_date date
);