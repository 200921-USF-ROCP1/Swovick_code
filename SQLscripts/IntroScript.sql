drop table if exists test_table;

create table test_table (
	--id numeric(10) primary key,
	name varchar(60) primary key,
	number_of_pets numeric(5), /*5 digits*/
	yearly_income numeric(10, 2), /*10 digits, 2 decimals, 
	8 digits before and 2 digits after decmial*/
	depratment varchar(60)
	--date_of_birth date,
	--last_logged_in timestamp,/*Does not have datetime, has timestamp instead*/
	--primary key (name, number_of_pets, yearly_income)*/ /*makes multiple primary keys*/
);
-- Use references of othertable(columnname) for foreign name
create table foreign_key_table (
	id numeric primary key,
	other_id varchar(60) references test_table(name)
);

--I need to put data into my table!
--Strings are in single quotes in SQL
insert into test_table values
	('Peter', 2, 0, 'Engineering'),
	('Jackson', 1, 20000, 'Accounting'),
	('Phillie', 1, 30000, 'Engineering');

insert into test_table(number_of_pets, yearly_income, name, depratment) values
	(4, 60000, 'Jake', 'Accounting');
	
--if I wanted to change the order, I could order by which defaults to ascending
select * from test_table
order by number_of_pets;

-- We can use the where clause to filter out rows
-- same symbols as Java <, >, <=, >=
select * from test_table 
where yearly_income <40000;

-- We can do operations on entire tables using aggregate functions
-- Here we take the average income of everyone in the table!
select AVG(yearly_income) from test_table;

select AVG(number_of_pets) from test_table
where name like 'J%'; --% means any number of character, any kind of characters

-- We can use Group By to further split up aggregate data
-- such as below, where we find average income per department
select depratment, AVG(yearly_income) as average_income
from test_table
group by depratment;

-- We can use having to filter results of aggregate functions
-- Note that you can't use aliases in the having clause in PostgreSQL
select depratment, AVG(yearly_income) as average_income
from test_table
group by depratment
having AVG(yearly_income)>20000; --having occurs after group by, will order things after aggregating

--using a having like clause with an alias.
select depratment, average_income from(
select test.depratment, AVG(test.yearly_income) as average_income
from test_table as test group by test.depratment) as average
where average_income>20000;