select * from residents;

-- DML (data manipulation language
-- update
--if no where clause, updates every row.
update residents -- update table
	set last_name = 'Sillyson' --new values for columns
	where last_name = 'Bobson'; --given set of columns that match condition

--insert	
INSERT INTO apartments VALUES
  (1, 'A', 1, 1250),
  (2, 'B', 1, 1300),
  (3, 'C', 1, 1500),
  (4, 'C', 2, 1400);
	
	
-- delete
-- if no where clause will delete everything
delete from residents --delete rows from a table
	where id = 4; -- I could delete given some condition

--truncate
--truncate better than delete since does not need to operate
--on each row, faster than delete
--can save from recreating  the table
truncate residents; -- delete all of rows, but not the table
	
--DDL (data definition language)
--create
create table my_table(
	some_column numeric --Columns: column_name data_type and comma-delimited
	--do not need to give data limits, but should set limits.
	--Gives table security
);
insert into my table values (1.111111);

-- drop
drop residents; --Outright delets the table and all of its data
drop table foreign_key_table;
-- alter
alter table residents drop column last_name;
alter table residents add column last_name varchar(60);
alter table residents alter column first_name set not null; -- use set to add restrictions
alter table residents alter column first_name drop not null; --use drop to get rid of restrictions
alter table cars drop constraint cars_owner_id_fkey; -- to drop a foreign key, find its name and use drop constraint
--other restrictions include unique
--changes to table should not be taken lightly


