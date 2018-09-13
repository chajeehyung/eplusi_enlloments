create table biz_type
(
	biz_type_code varchar(4) not null
		primary key,
	biz_type varchar(40) null,
	parent_code varchar(3) null,
	update_time datetime null,
	create_time timestamp default CURRENT_TIMESTAMP not null
)
comment '사람인 기준 산업/업종 코드'
;

create table biz_type_keyword
(
	biz_kw_code varchar(6) not null
		primary key,
	biz_kw_name varchar(40) not null,
	biz_type_code varchar(4) not null,
	update_time datetime null,
	create_time timestamp default CURRENT_TIMESTAMP not null,
	constraint biz_type_keyword_biz_type_biz_type_code_fk
		foreign key (biz_type_code) references biz_type (biz_type_code)
			on update cascade on delete cascade
)
comment '사람인 기준 산업/업종 코드 별 키워드'
;

create table enroll_status
(
	enroll_status_code int auto_increment
		primary key,
	enroll_status varchar(20) not null,
	enroll_desc varchar(200) null
)
comment '재적 상태 정보'
;

create table occ
(
	occ_code varchar(4) not null
		primary key,
	occ_name varchar(40) null,
	parent_code varchar(4) null,
	update_time datetime null on update CURRENT_TIMESTAMP,
	create_time timestamp default CURRENT_TIMESTAMP null
)
comment '사람인 기준 직업/직종 코드'
;

create table occ_type
(
	occ_type_code int auto_increment
		primary key,
	occ_type varchar(20) null
)
comment '직업 상태' collate=utf8_unicode_ci
;

create table common.organization
(
	org_code int auto_increment
		primary key,
	parent_code int null,
	org_name varchar(50) not null,
	applied_year year null
)
comment '청년부 조직 체계 정보'
;

create table religion_type
(
	religion_type_code int auto_increment
		primary key,
	religion_type varchar(8) null
)
comment '신급 유형' collate=utf8_unicode_ci
;

create table role_type
(
	role_code int auto_increment
		primary key,
	role_name varchar(20) not null,
	constraint role_type_role_name_uindex
		unique (role_name)
)
comment '직분 유형'
;

create table common.senior
(
	christian_id int auto_increment
		primary key
)
comment '교인 정보'
;

create table common.senior_duty
(
	christian_charge_id int auto_increment
		primary key,
	org_code int not null,
	charge_id int not null,
	role_code int not null,
	start_date date null,
	end_date date null
)
comment '성도들의 담당 부서 정보 (부장, 부감 등)'
;

create table common.worker_duty
(
	worker_charge_id int auto_increment
		primary key,
	worker_id int not null,
	org_code int not null,
	start_date date null,
	end_date date null
)
comment '교역자 담당 부서 정보'
;

create table common.workers
(
	worker_id int auto_increment
		primary key
)
comment '교역자'
;

create table eplusi.youth
(
	youth_id int auto_increment
		primary key,
	youth_name varchar(20) not null,
	youth_peer char(2) null comment '또래',
	gender char null,
	birth_date date null,
	cell_phone varchar(11) null,
	home_address varchar(100) null,
	is_born_chr tinyint(1) default '1' null comment '모태신앙여부',
	is_self_in tinyint(1) default '0' null comment '자진등록여부',
	guide_name varchar(20) null comment '인도자->view_(youth,christian,worker)_id->청년, 집사님, 전도사님 중 인도자가 있을 수 있으므로',
	occ_type_code int null comment '직업 상태 - 대학생/직장인/기타',
	occ_code varchar(4) null comment '사람인 기준 직업 코드',
	biz_type_code varchar(4) null,
	religion_type_code int null comment '신급',
	church_reg_date date null comment '교회 등록 날짜',
	is_attending tinyint(1) default '1' not null comment '출석 상태 - 유학/지방이전 상태라 할지라도 리더의 판단에 따라 교회에 나오지 않는다 판단되면 False',
	is_registered tinyint(1) default '1' null,
	update_time datetime null on update CURRENT_TIMESTAMP,
	create_time timestamp default CURRENT_TIMESTAMP not null,
	constraint youth_biz_type_biz_type_code_fk
		foreign key (biz_type_code) references code.biz_type (biz_type_code)
			on update cascade on delete cascade,
	constraint youth_occ_occ_code_fk
		foreign key (occ_code) references code.occ (occ_code)
			on update cascade on delete cascade,
	constraint youth_occ_type_occ_type_code_fk
		foreign key (occ_type_code) references code.occ_type (occ_type_code)
			on update cascade on delete cascade,
	constraint youth_religion_type_religion_type_code_fk
		foreign key (religion_type_code) references code.religion_type (religion_type_code)
			on update cascade on delete cascade
)
comment '청년 기본 정보'
;

create table eplusi.cell_report
(
	id int auto_increment comment '고유 ID'
		primary key,
	cell_leader_id int not null comment '순장 ID',
	cell_summary text null comment '순모임 내용, 분위기 등',
	cell_special text null comment '순특이사항',
	to_minister text null comment '목사님께',
	to_leader text null comment '대표순장님께',
	updated_date datetime null on update CURRENT_TIMESTAMP,
	created_date timestamp default CURRENT_TIMESTAMP not null,
	constraint cell_leader_id
		foreign key (cell_leader_id) references eplusi.youth (youth_id)
			on update cascade on delete cascade
)
comment '순모임 보고서'
;

create table eplusi.enrollments
(
	enroll_id int auto_increment
		primary key,
	youth_id int not null,
	enroll_status_code int not null,
	start_date date null,
	end_date date null,
	enroll_desc text null,
	constraint enrollments_enroll_status_enroll_status_code_fk
		foreign key (enroll_status_code) references code.enroll_status (enroll_status_code)
			on update cascade on delete cascade,
	constraint enrollments_youth_youth_id_fk
		foreign key (youth_id) references eplusi.youth (youth_id)
			on update cascade on delete cascade
)
comment '재적부'
;

create table eplusi.prayer_note
(
	id int auto_increment comment '고유 ID'
		primary key,
	youth_id int null comment '순원 ID',
	prayer_date date not null comment '기도제목 해당 일자',
	prayer_note text null comment '기도제목 내용',
	updated_date datetime null on update CURRENT_TIMESTAMP comment '갱신일자',
	created_date timestamp default CURRENT_TIMESTAMP not null comment '생성일자',
	constraint prayer_note_youth_youth_id_fk
		foreign key (youth_id) references eplusi.youth (youth_id)
			on update cascade on delete cascade
)
comment '기도제목'
;

create table eplusi.roll_book
(
	id int auto_increment comment '고유 ID'
		primary key,
	youth_id int not null comment '순원 ID',
	att_date date not null comment '출석일자',
	worship_att tinyint(1) default '0' not null comment '예배 출석 여부',
	cell_att tinyint(1) default '0' not null comment '순모임 출석 여부',
	att_desc varchar(100) null comment '결석 사유',
	updated_date datetime null on update CURRENT_TIMESTAMP comment '갱신일자',
	created_date timestamp default CURRENT_TIMESTAMP not null comment '생성일자',
	constraint youth_id
		foreign key (youth_id) references eplusi.youth (youth_id)
)
comment '출석부'
;

create index youth_id_idx
	on eplusi.roll_book (youth_id)
;

create table eplusi.youth_family
(
	youth_fam_id int auto_increment
		primary key,
	youth_id int not null,
	person_name varchar(16) not null,
	rel_type varchar(20) not null,
	create_time timestamp default CURRENT_TIMESTAMP not null
)
comment '교회 내 가족'
;

create table eplusi.youth_org
(
	youth_org_id int auto_increment comment '이력 ID'
		primary key,
	youth_id int not null comment '청년 ID',
	org_code int not null comment '조직 CODE',
	role_code int not null comment '직분 CODE',
	start_date date null,
	end_date date null,
	constraint youth_belongings_organization_org_code_fk
		foreign key (org_code) references common.organization (org_code)
			on update cascade on delete cascade,
	constraint youth_belongings_role_type_role_code_fk
		foreign key (role_code) references code.role_type (role_code)
			on update cascade on delete cascade,
	constraint youth_belongings_youth_youth_id_fk
		foreign key (youth_id) references eplusi.youth (youth_id)
			on update cascade on delete cascade
)
comment '청년들의 양육부, 행정사역부 소속 이력'
;

