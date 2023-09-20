use practice;
show tables;
select * from customer;
select * from employee;
SELECT * FROM product;


select * from employee;
select * from emp_work_hours;

select emp_name, emp_id from employee as e1 , employee as e2  WHERE  e1.emp_id = e2.emp_id; 

select * from employee CROSS JOIN emp_work_hours

select  emp_name,c.id, customer_name,state from customer c 
RIGHT JOIN employee e ON  c.id = e.emp_id
RIGHT JOIN product p ON c.id = p.id
 