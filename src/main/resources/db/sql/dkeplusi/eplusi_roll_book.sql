CREATE TABLE eplusi.roll_book
(
    id int(11) PRIMARY KEY NOT NULL COMMENT '고유 ID' AUTO_INCREMENT,
    youth_id int(11) NOT NULL COMMENT '순원 ID',
    att_date date NOT NULL COMMENT '출석일자',
    worship_att tinyint(1) DEFAULT '0' NOT NULL COMMENT '예배 출석 여부',
    cell_att tinyint(1) DEFAULT '0' NOT NULL COMMENT '순모임 출석 여부',
    att_desc varchar(100) COMMENT '결석 사유',
    update_time datetime COMMENT '갱신일자',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '생성일자',
    CONSTRAINT youth_id FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX youth_id_idx ON eplusi.roll_book (youth_id);