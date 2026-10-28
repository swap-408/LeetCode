# Write your MySQL query statement below
with temp as (
    select user_id, count(*) total_req
    from  confirmations
    group by user_id
),
temp2 as(
    select user_id, count(*)  confirmedReq from confirmations
    group by user_id,action
    having action='confirmed'
),
temp3 as(
    select user_id, round(confirmedReq/total_req,2) confirmation_rate from temp2
    join temp
    using(user_id)
)
select user_id, coalesce(confirmation_rate,0) confirmation_rate
from temp3
right join signups
using(user_id)