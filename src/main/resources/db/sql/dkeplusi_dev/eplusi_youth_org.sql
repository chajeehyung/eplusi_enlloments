CREATE TABLE eplusi.youth_org
(
    youth_org_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    start_date date,
    end_date date,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL,
    org_code int(11) NOT NULL,
    role_code int(11) NOT NULL,
    youth_id int(11) NOT NULL,
    CONSTRAINT youth_org_org_code_abf55818_fk_organization_org_code FOREIGN KEY (org_code) REFERENCES eplusi.organization (org_code),
    CONSTRAINT youth_org_role_code_9365626f_fk_role_type_role_code FOREIGN KEY (role_code) REFERENCES eplusi.role_type (role_code),
    CONSTRAINT youth_org_youth_id_642c66a4_fk_youth_youth_id FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX youth_org_org_code_abf55818_fk_organization_org_code ON eplusi.youth_org (org_code);
CREATE INDEX youth_org_role_code_9365626f_fk_role_type_role_code ON eplusi.youth_org (role_code);
CREATE INDEX youth_org_youth_id_642c66a4_fk_youth_youth_id ON eplusi.youth_org (youth_id);