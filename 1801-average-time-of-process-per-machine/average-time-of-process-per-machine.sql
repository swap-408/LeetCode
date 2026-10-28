# Write your MySQL query statement below
with process_time as (
    select m1.machine_id, (m1.timestamp-m2.timestamp) time
    from activity m1
    join activity m2
    on m1.machine_id=m2.machine_id and m1.process_id=m2.process_id and m1.activity_type = 'end' and m2.activity_type='start'
)
select machine_id,Round(AVG(time),3) processing_time
from process_time
group by machine_id