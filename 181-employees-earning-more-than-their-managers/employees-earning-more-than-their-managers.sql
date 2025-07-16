# Write your MySQL query statement below
select a.name as Employee
from employee a
join employee b
on a.managerId = b.id
where b.salary<a.salary