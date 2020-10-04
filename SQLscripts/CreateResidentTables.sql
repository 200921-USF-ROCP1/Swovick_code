drop table if exists Apartments;
create table Apartments(
	id numeric(4) primary key,
	building_letter varchar(2),
	room_number numeric(4),
	monthly_rent numeric (7, 2)
);
drop table if exists residents;
create table Residents(
	id numeric(4) primary key,
	first_name varchar(60),
	last_name varchar(60),
	apartment_id numeric(4) references Apartments(id)
);
drop table if exists cars;
create table Cars(
	id numeric(4) primary key,
	make varchar(60),
	model varchar(60),
	year numeric(4),
	license_plate varchar(10),
	owner_id numeric(4) references Residents(id)
);
drop table if exists Pets;
create table Pets(
	id numeric(4) primary key,
	breed varchar(60),
	name varchar(60),
	apartment_id numeric(4) references Apartments(id),
	is_service_animal numeric(1)
);
