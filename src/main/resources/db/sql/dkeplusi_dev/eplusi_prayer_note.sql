CREATE TABLE eplusi.prayer_note
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    prayer_date date NOT NULL,
    prayer_note longtext,
    update_time datetime(6),
    create_time datetime(6) NOT NULL,
    youth_id int(11),
    CONSTRAINT prayer_note_youth_id_dc8748b6_fk_youth_youth_id FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX prayer_note_youth_id_dc8748b6_fk_youth_youth_id ON eplusi.prayer_note (youth_id);