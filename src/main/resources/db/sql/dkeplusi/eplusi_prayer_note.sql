CREATE TABLE eplusi.prayer_note
(
    id int(11) PRIMARY KEY NOT NULL COMMENT '고유 ID' AUTO_INCREMENT,
    youth_id int(11) COMMENT '순원 ID',
    prayer_date date NOT NULL COMMENT '기도제목 해당 일자',
    prayer_note text COMMENT '기도제목 내용',
    update_time datetime COMMENT '갱신일자',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '생성일자',
    CONSTRAINT prayer_note_youth_youth_id_fk FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX prayer_note_youth_youth_id_fk ON eplusi.prayer_note (youth_id);
INSERT INTO eplusi.prayer_note (id, youth_id, prayer_date, prayer_note, update_time, create_time) VALUES (2, 2, '2018-02-01', 'ddddaaa', '2018-02-21 12:44:29', '2018-02-21 12:44:29');
INSERT INTO eplusi.prayer_note (id, youth_id, prayer_date, prayer_note, update_time, create_time) VALUES (3, 203, '2018-02-08', 'aabbb', '2018-02-21 12:46:58', '2018-02-21 12:46:43');