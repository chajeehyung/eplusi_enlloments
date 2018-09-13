CREATE TABLE eplusi.cell_report
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cell_summary longtext,
    cell_special longtext,
    to_minister longtext,
    to_leader longtext,
    updated_date datetime(6),
    created_date datetime(6) NOT NULL,
    cell_leader_id int(11) NOT NULL,
    CONSTRAINT cell_report_cell_leader_id_6fda9a46_fk_youth_youth_id FOREIGN KEY (cell_leader_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX cell_report_cell_leader_id_6fda9a46_fk_youth_youth_id ON eplusi.cell_report (cell_leader_id);