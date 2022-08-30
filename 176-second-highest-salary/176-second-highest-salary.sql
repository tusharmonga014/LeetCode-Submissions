# Write your MySQL query statement below
Select max(Salary) as SecondHighestSalary from Employee where salary < (Select max(Salary) from Employee);