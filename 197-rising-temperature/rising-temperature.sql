# Write your MySQL query statement below
select t1.id
from Weather t1
join Weather t2
on DATEDiff(t1.recordDate,t2.recordDate)=1
where t1.temperature > t2.temperature