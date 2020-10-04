-- transaction keywords

-- to start a transaction
begin transaction;
--or 
begin;

-- to commit the transaction
commit;
-- or
commit transaction;

--if we need to rollback changes before transaction is committed
rollback;

-- if we want to save our progress and make
-- checkpoint, we use savepoint
savepoint my_point;

-- if we want to rollback to a savepoint:
rollback to my_point;

-- here is how a transaction looks in use
begin;

update residents set first_name = 'Jacob'
where first_name = 'Jacobo';

savepoint my_savepoint;

update residents set last_name = 'Daviss'
 where last_name = 'Davis';

commit;
--useful for when operations could be compromised
--most times will use single sql statements
select * from residents;

