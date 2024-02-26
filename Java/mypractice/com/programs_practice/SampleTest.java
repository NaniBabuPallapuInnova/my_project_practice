package mypractice.com.programs_practice;

/**
 * emp(id, name)
 *
 * 1, Vikas
 * 2, Divya
 * 3, Manish
 *
 * emp_sal_dtls (id, emp_id, year, sal)
 *
 * 1, 1, 2018, 5000
 * 2, 1, 2019, 4000
 * 3, 2, 2018, 6000
 * 4, 3, 2019, 3000
 *
 * *Write a SQL query to get details of all employees along with the total salary paid to them*
 *
 * *Expected Output*
 *
 * Emp ID, Name, Total Salary
 * 1, Vikas, 9000
 * 2, Divya, 6000
 * 3, Manish, 3000
 */
public class SampleTest {

// select emp.id, emp.name, SUM(details.salary) as total_salary from employee emp INNER JOIN emp_sal_dtls details ON  emp.id = details.emp_id;

}

