# Write your MySQL query statement below
with exam as (
    select *, count(subject_name) attended_exams
    from examinations
    group by student_id,subject_name
),
student_subject as(
    select * from students,subjects 
)
select student_subject.student_id ,student_name , student_subject.subject_name , coalesce(attended_exams ,0) attended_exams
from student_subject
left join
exam
on student_subject.student_id = exam.student_id and student_subject.subject_name=exam.subject_name
order by student_subject.student_id, student_subject.subject_name