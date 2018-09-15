CREATE TABLE eplusi.roll_book
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    att_date date NOT NULL,
    worship_att int(11) NOT NULL,
    cell_att int(11) NOT NULL,
    att_desc varchar(100),
    update_time datetime(6),
    create_time datetime(6) NOT NULL,
    youth_id int(11) NOT NULL,
    CONSTRAINT roll_book_youth_id_6dd1e521_fk_youth_youth_id FOREIGN KEY (youth_id) REFERENCES eplusi.youth (youth_id)
);
CREATE INDEX roll_book_youth_id_6dd1e521_fk_youth_youth_id ON eplusi.roll_book (youth_id);