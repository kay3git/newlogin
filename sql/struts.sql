drop database if exists openconnect;
create database openconnect;
use openconnect;

create table user(
	id int,
	user_name varchar(255),
	password varchar(255)
);

insert into user values
	(1,"taro","123"),
	(2,"jiro","123"),
	(3,"hanako","123"),
	(4,"saburo","123");