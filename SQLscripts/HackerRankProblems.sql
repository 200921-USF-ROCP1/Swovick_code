create table students (
	id serial primary key,
	name varchar(20)
);
create table friends(
	id serial primary key,
	friend_id integer
);
create table packages(
	id serial primary key,
	salary numeric (7, 2) 
);
insert into students (name) values
	('Ashley'),
	('Samantha'),
	('Julia'),
	('Scarlet');
insert into friends (friend_id) values
	(2),
	(3),
	(4),
	(1);
insert into packages (salary) values
	(15.20),
	(10.06),
	(11.55),
	(12.12);
--This does  not quite work
select s1.name from students AS s1
join packages as p1 on s1.id=p1.id
where exists
(select * from packages as p2, friends 
--join friends on friends.friend_id = p2.id
where p2.id = friends.friend_id and p2.salary>p1.salary)
order by p2.salary;

--This works
select s1.name from students AS s1
join packages as p1 on s1.id=p1.id
join friends as f1 on s1.id = f1.id
join packages as p2 on p2.id = f1.friend_id
where p2.salary>p1.salary;

select * from students AS s1
join packages as p1 on s1.id=p1.id
join friends as f1 on s1.id = f1.id
join packages as p2 on p2.id = f1.friend_id

select * from packages as p2
join friends on friends.friend_id = p2.id;

select * from packages as p2, friends
where friends.friend_id = p2.id;

select * from students AS s1
join packages as p1 on s1.id=p1.id;

