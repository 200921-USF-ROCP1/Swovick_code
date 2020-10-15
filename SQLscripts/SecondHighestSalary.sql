select id, salary from packages where
salary in (select max(salary) from packages where 
salary< (select max(salary) from packages));