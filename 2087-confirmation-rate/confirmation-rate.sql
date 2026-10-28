select 
    user_id
    , round(coalesce(AVG(action = 'confirmed'),0),2) confirmation_rate
from Confirmations
right join signups
using(user_id)
group by user_id