# Write your MySQL query statement below
with managers as (
    select managerId from employee
group by managerId
having count(managerId)>=5
)
select name from employee
join managers on
managers.managerId = employee.Id