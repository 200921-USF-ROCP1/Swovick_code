-- set allow for combining of results sets, combine things with same number of columns
--set operations

-- union: combine result sets, sets have to have the same number and type of columns
-- so normally they would come from the same table
-- logical or
select * from apartments where id=1
union 
select * from apartments where id=3;

select * from apartments as A where id=1
left join (select * from apartments where id =3) as B on A.id = B.id;

-- intersect: take only the  rows common to both results sets
-- in this case, only  take rows where both conditions are true
-- (room number is 1 and building letter is C
-- logical and
select * from apartments where room_number = 1 
intersect 
select * from apartments where building_letter = 'C'

--except: all values from first table except values from second tables
-- first conditions apply, second conditions do not apply
-- logical not
select * from apartments 
except
select * from apartments where building_letter ='C'