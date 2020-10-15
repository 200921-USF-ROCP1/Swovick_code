--drop table if exists users;
create table roles(
	role_ID serial primary key,
	role varchar(8) not null unique
);
create table Account_Statuses(
	status_ID serial primary key,
	status varchar(7) not null unique
);
create table Account_Types(
	type_id serial primary key,
	type varchar(8) not null unique
);
create table Users(
	user_Id serial primary key,
	username varchar(15) not null unique,
	password varchar(25) not null,
	first_Name varchar(15) not null,
	last_Name varchar(20) not null,
	email varchar(40) not null,
	role_Id int references roles(role_id)
);
create table Accounts(
	account_id serial primary key,
	balance numeric(10, 2) not null,
	status_id references Account_statuses(status_id),
	type_id references Account_types(type_id),
	user_id references Users(user_id)
);


