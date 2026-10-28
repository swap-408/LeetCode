# Write your MySQL query statement below
select e.name, eu.unique_id
from Employees e
Left Join EmployeeUNI eu
ON e.id=eu.id
