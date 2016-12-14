create database springmvc_02;

drop table t_emp;
create table t_emp(
	id			VARCHAR(50)			PRIMARY KEY,
	name		VARCHAR(30)			NOT NULL,
	gender		VARCHAR(30)			NOT NULL,
	salary		DOUBLE(16,2)		NOT NULL,
	hiredate	DATE				NOT NULL
);