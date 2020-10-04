-- can use on delete cascade, delete row that was referring to that row
-- when delete row, other rows would be deleted
-- sometimes make sense, sometimes does not. Deleting an apartment with an id 
-- deletes the resident.
drop table if exists Pets;
drop table if exists cars;
drop table if exists residents;
drop table if exists Apartments;

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
	apartment_id integer references Apartments(id) on delete cascade
);
create table Cars(
	id serial primary key,
	make varchar(60),
	model varchar(60),
	year numeric(4),
	license_plate varchar(10),
	owner_id integer references Residents(id) on delete cascade
);

create table Pets(
	id serial primary key,
	breed varchar(60),
	name varchar(60),
	apartment_id integer references Apartments(id) on delete cascade,
	is_service_animal numeric(1)
);