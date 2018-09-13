CREATE TABLE eplusi.cell_report
(
    id int(11) PRIMARY KEY NOT NULL COMMENT '고유 ID' AUTO_INCREMENT,
    cell_leader_id int(11) NOT NULL COMMENT '순장 ID',
    cell_summary text COMMENT '순모임 내용, 분위기 등',
    cell_special text COMMENT '순특이사항',
    to_minister text COMMENT '목사님께',
    to_leader text COMMENT '대표순장님께',
    updated_date datetime,
    created_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT cell_leader_id FOREIGN KEY (cell_leader_id) REFERENCES eplusi.youth (youth_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX cell_leader_id ON eplusi.cell_report (cell_leader_id);