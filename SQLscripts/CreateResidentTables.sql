
create table Apartments(
	id serial primary key,
	building_letter varchar(2),
	room_number numeric(4),
	monthly_rent numeric (7, 2)
);

create table Residents(
	id serial primary key,
	first_name varchar(60),
	last_name varchar(60),
	apartment_id integer references Apartments(id)
);
create table Cars(
	id serial primary key,
	make varchar(60),
	model varchar(60),
	year numeric(4),
	license_plate varchar(10),
	owner_id integer references Residents(id)
);
create table Pets(
	id serial primary key,
	breed varchar(60),
	name varchar(60),
	apartment_id integer references Apartments(id),
	is_service_animal boolean
);
drop table if exists Pets;
drop table if exists cars;
drop table if exists residents;
drop table if exists Apartments;