# Write your MySQL query statement below
SELECT s.student_id, s.student_name, u.subject_name, COUNT(e.subject_name) as attended_exams
FROM Students s
JOIN Subjects u
LEFT JOIN Examinations e
ON s.student_id = e.student_id 
AND u.subject_name = e.subject_name
GROUP BY student_id, subject_name
ORDER BY student_id ASC, subject_name ASC;