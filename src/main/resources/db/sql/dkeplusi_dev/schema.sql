create table code.biz_type
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

create table eplusi.biz_type
(
	biz_type_code varchar(4) not null
		primary key,
	biz_type varchar(40) not null,
	parent_code varchar(3) null,
	updated_date datetime default CURRENT_TIMESTAMP null,
	created_date datetime default CURRENT_TIMESTAMP not null
)
;

create table eplusi.biz_type_keyword
(
	biz_kw_code varchar(6) not null
		primary key,
	biz_kw_name varchar(40) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	biz_type_code varchar(4) not null,
	constraint biz_type_keyword_biz_type_code_2551a01d_fk_biz_type_
		foreign key (biz_type_code) references eplusi.biz_type (biz_type_code)
)
;

create table code.biz_type_keyword
(
	biz_kw_code varchar(6) not null
		primary key,
	biz_kw_name varchar(40) not null,
	biz_type_code varchar(4) not null,
	update_time datetime null,
	create_time timestamp default CURRENT_TIMESTAMP not null,
	constraint biz_type_keyword_biz_type_biz_type_code_fk
		foreign key (biz_type_code) references code.biz_type (biz_type_code)
			on update cascade on delete cascade
)
comment '사람인 기준 산업/업종 코드 별 키워드'
;

create table eplusi.enroll_status
(
	enroll_status_code int auto_increment
		primary key,
	enroll_status varchar(20) not null,
	enroll_desc varchar(200) null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table code.enroll_status
(
	enroll_status_code int auto_increment
		primary key,
	enroll_status varchar(20) not null,
	enroll_desc varchar(200) null
)
comment '재적 상태 정보'
;

create table eplusi.occ
(
	occ_code varchar(4) not null
		primary key,
	occ_name varchar(40) not null,
	parent_code varchar(4) null,
	updated_date datetime default CURRENT_TIMESTAMP null,
	created_date datetime default CURRENT_TIMESTAMP not null
)
;

create table code.occ
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

create table code.occ_type
(
	occ_type_code int auto_increment
		primary key,
	occ_type varchar(20) null
)
comment '직업 상태' collate=utf8_unicode_ci
;

create table eplusi.occ_type
(
	occ_type_code int auto_increment
		primary key,
	occ_type varchar(20) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
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

create table eplusi.organization
(
	org_code int auto_increment
		primary key,
	parent_code int null,
	org_name varchar(50) not null,
	applied_year varchar(4) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table eplusi.religion_type
(
	religion_type_code int auto_increment
		primary key,
	religion_type varchar(8) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table code.religion_type
(
	religion_type_code int auto_increment
		primary key,
	religion_type varchar(8) null
)
comment '신급 유형' collate=utf8_unicode_ci
;

create table code.role_type
(
	role_code int auto_increment
		primary key,
	role_name varchar(20) not null,
	constraint role_type_role_name_uindex
		unique (role_name)
)
comment '직분 유형'
;

create table eplusi.role_type
(
	role_code int auto_increment
		primary key,
	role_name varchar(20) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	constraint role_name
		unique (role_name)
)
;

create table eplusi.senior
(
	christian_id int auto_increment
		primary key,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
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

create table eplusi.senior_duty
(
	christian_charge_id int auto_increment
		primary key,
	org_code int not null,
	charge_id int not null,
	role_code int not null,
	start_date date null,
	end_date date null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
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

create table eplusi.worker_duty
(
	worker_charge_id int auto_increment
		primary key,
	worker_id int not null,
	org_code int not null,
	start_date date null,
	end_date date null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table common.workers
(
	worker_id int auto_increment
		primary key
)
comment '교역자'
;

create table eplusi.workers
(
	worker_id int auto_increment
		primary key,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table eplusi.youth
(
	youth_id int auto_increment
		primary key,
	youth_name varchar(20) not null,
	youth_peer varchar(2) null,
	gender varchar(1) null,
	birth_date date null,
	cell_phone varchar(11) null,
	home_address varchar(100) null,
	is_born_chr int null,
	is_self_in int null,
	guide_name varchar(20) null,
	church_reg_date date null,
	is_attending int not null,
	is_registered int null,
	updated_date datetime default CURRENT_TIMESTAMP null,
	created_date datetime default CURRENT_TIMESTAMP not null,
	biz_type_code varchar(4) null,
	occ_code varchar(4) null,
	occ_type_code int null,
	religion_type_code int null,
	constraint youth_biz_type_code_6d42d152_fk_biz_type_biz_type_code
		foreign key (biz_type_code) references eplusi.biz_type (biz_type_code),
	constraint youth_occ_code_842be4d3_fk_occ_occ_code
		foreign key (occ_code) references eplusi.occ (occ_code),
	constraint youth_occ_type_code_be1d0c97_fk_occ_type_occ_type_code
		foreign key (occ_type_code) references eplusi.occ_type (occ_type_code),
	constraint youth_religion_type_code_71f9b5aa_fk_religion_
		foreign key (religion_type_code) references eplusi.religion_type (religion_type_code)
)
;

create table eplusi.cell_report
(
	id int auto_increment
		primary key,
	cell_summary longtext null,
	cell_special longtext null,
	to_minister longtext null,
	to_leader longtext null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	cell_leader_id int not null,
	constraint cell_report_cell_leader_id_6fda9a46_fk_youth_youth_id
		foreign key (cell_leader_id) references eplusi.youth (youth_id)
)
;

create table eplusi.enrollments
(
	enroll_id int auto_increment
		primary key,
	start_date date null,
	end_date date null,
	enroll_desc longtext null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	enroll_status_code int not null,
	youth_id int not null,
	constraint enrollments_enroll_status_code_6f042b84_fk_enroll_st
		foreign key (enroll_status_code) references eplusi.enroll_status (enroll_status_code),
	constraint enrollments_youth_id_568370e5_fk_youth_youth_id
		foreign key (youth_id) references eplusi.youth (youth_id)
)
;

create table eplusi.prayer_note
(
	id int auto_increment
		primary key,
	prayer_date date not null,
	prayer_note longtext null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	youth_id int null,
	constraint prayer_note_youth_id_dc8748b6_fk_youth_youth_id
		foreign key (youth_id) references eplusi.youth (youth_id)
)
;

create table eplusi.roll_book
(
	id int auto_increment
		primary key,
	att_date date not null,
	worship_att int not null,
	cell_att int not null,
	att_desc varchar(100) null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	youth_id int not null,
	constraint roll_book_youth_id_6dd1e521_fk_youth_youth_id
		foreign key (youth_id) references eplusi.youth (youth_id)
)
;

create table eplusi.youth_family
(
	youth_fam_id int auto_increment
		primary key,
	youth_id int not null,
	person_name varchar(16) not null,
	rel_type varchar(20) not null,
	updated_date datetime(6) null,
	created_date datetime(6) not null
)
;

create table eplusi.youth_org
(
	youth_org_id int auto_increment
		primary key,
	start_date date null,
	end_date date null,
	updated_date datetime(6) null,
	created_date datetime(6) not null,
	org_code int not null,
	role_code int not null,
	youth_id int not null,
	constraint youth_org_org_code_abf55818_fk_organization_org_code
		foreign key (org_code) references eplusi.organization (org_code),
	constraint youth_org_role_code_9365626f_fk_role_type_role_code
		foreign key (role_code) references eplusi.role_type (role_code),
	constraint youth_org_youth_id_642c66a4_fk_youth_youth_id
		foreign key (youth_id) references eplusi.youth (youth_id)
)
;

