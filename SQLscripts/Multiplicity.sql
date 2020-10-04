-- one to many: one account to many users
create table users(
	id serial primary key,
	username varchar(60),
	password varchar(60)
	account_id numeric(2) references accounts(id)
);
create table accounts(
	id serial primary key,
	account_balance numeric(10, 2)
	--account_owner references users(id)
);
-- one to many: one user to many accounts
create table users(
	id serial primary key,
	username varchar(60),
	password varchar(60)
	account_id numeric(2) references accounts(id)
);
create table accounts(
	id serial primary key,
	account_balance numeric(10, 2)
	account_owner numeric(2) references users(id)
);
-- many-to-many: many users to many accounts
drop table if exists users;
create table users(
	id serial primary key,
	username varchar(60),
	passwrd varchar(60)
);
drop table if exists users_accounts;
create table users_accounts(
	user_id serial references users(id),
	account_id serial references accounts(id)
);
drop table if exists accounts;
drop table if exists users_accounts;
create table accounts(
	id serial primary key,
	account_balance numeric(10, 2)
	--account_owner references users(id)
);

insert into users (username, passwrd) values
	('petersw', 'password'),
	('otherguy', 'password');
insert into accounts (account_balance) values
	(1500),
	(1200),
	(30000);

insert into users_accounts values
	(1, 1),
	(2, 2),
	(1, 3);
insert into users_accounts values
	(2, 3);
select * from users;
select * from accounts;
select * from users_accounts;
select users.*, accounts.* from users
	left join users_accounts on users.id = users_accounts.user_id 
	left join accounts on users_accounts.account_id = account_id;


