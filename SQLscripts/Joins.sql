-- the "left" table is the "from" table, and the "right" table is the "join" table
-- this will be the default order if you do select *

-- left join: get all data in left table, 
-- plus data matching join condition in right table.
-- Rows that don't match in the left table get nulls for new columns
-- left outer join

select apartments.*, residents.* from apartments
	left join residents on apartments.id = residents.apartment_id;
	
--insert into apartments values (5, 'A', 2, 3000)

-- right join: get all data from the right table,
-- with only matching rows from the left. null values
-- for any rows in the right table with no matches.
-- right outer join, outer is implied

select apartments.*, residents.* from apartments
	right join residents on apartments.id = residents.apartment_id;
	
--insert into residents values (6, 'Lauren', null, 'Smith')

-- inner join: only gives rows with a match for the join condition.
select apartments.*, residents.* from apartments
	inner join residents on apartments.id = residents.apartment_id;
	
select apartments.*, residents.* from apartments
	join residents on apartments.id = residents.apartment_id;

--full outer join or full join gives all rows from both tables,
--connecting matches if they exist

select apartments.*, residents.* from apartments
	full join residents on apartments.id = residents.apartment_id;

-- gives permutations of every possible combination on the table
-- most times not use cross join, geometricly increases
-- every a.1 <-> b1., a.2 <-> b.1, a.2 <-> b.2, etc...

select apartments.*, residents.* from apartments
	cross join residents;
-- seems to be same as inner join
select apartments.*, residents.* from apartments, residents
	where apartments.id = residents.apartment_id; 
-- natural join: joins on fields of the same name
-- left, right, full, and inner joins
select apartments.*, residents.* from apartments
	natural left join residents;