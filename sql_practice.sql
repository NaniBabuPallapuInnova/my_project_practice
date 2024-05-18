SQL-TUTORIAL
================

**Database (DB)**:

A database is a structured collection of data that is organized and stored in a way that allows for efficient data retrieval, management, and manipulation. Databases are used to store and manage various types of information, ranging from simple lists to complex business data. They serve as a central repository for data, enabling multiple users or applications to access and interact with the stored information. Databases are commonly used in software applications, business operations, and various other domains.

Key characteristics of databases:

- **Structured Data**: Databases store data in a structured format, often using tables or collections to organize related information.

- **Data Integrity**: Databases enforce data integrity constraints to maintain the accuracy and consistency of data.

- **Data Security**: Access to databases can be controlled through user authentication and authorization mechanisms.

- **Concurrent Access**: Databases support concurrent access by multiple users or applications, ensuring that data remains consistent.

- **Scalability**: Databases can scale to handle large volumes of data and high numbers of transactions.

- **Data Retrieval**: Users and applications can retrieve, query, and manipulate data from databases.

**Database Management System (DBMS)**:

A Database Management System (DBMS) is software that provides tools and services for creating, managing, and interacting with databases. The primary purpose of a DBMS is to enable efficient and secure data storage, retrieval, and manipulation. It acts as an intermediary between users or applications and the physical database, handling tasks like data storage, indexing, transaction management, and security.




Common DBMS features:

- **Data Storage**: DBMS systems store data on disk or in memory, managing how data is organized and accessed.

- **Data Retrieval**: DBMS systems provide SQL-based interfaces for retrieving and querying data.

- **Data Security**: DBMS systems offer authentication, authorization, and encryption to protect data.

- **Data Integrity**: DBMS systems enforce constraints and rules to maintain data accuracy and consistency.

- **Concurrency Control**: DBMS systems manage concurrent access to the database to prevent data corruption.

- **Backup and Recovery**: DBMS systems offer backup and restore mechanisms to protect data in case of failure.

- **Indexing**: DBMS systems create and manage indexes to improve data retrieval performance.

- **Transactions**: DBMS systems support transactions, allowing a series of operations to be executed atomically.




Types of DBMS:

1. **Relational DBMS (RDBMS)**: Data is organized in tables with rows and columns, and relationships between data are established. Examples include MySQL, Oracle Database, and Microsoft SQL Server.

2. **NoSQL DBMS**: Designed for handling unstructured or semi-structured data. Types include document-oriented (e.g., MongoDB), key-value stores (e.g., Redis), and column-family stores (e.g., Apache Cassandra).

3. **Object-Oriented DBMS (OODBMS)**: Designed to work with object-oriented programming languages and data models.

4. **Graph DBMS**: Specialized for managing graph-like data structures.




**Types of SQL Commands**:

Structured Query Language (SQL) is a domain-specific language for managing and querying relational databases. SQL commands are used to interact with a database, including retrieving, inserting, updating, and deleting data. Common types of SQL commands include:

1. **Data Query Language (DQL)**:
   - `SELECT`: Retrieves data from one or more tables.
   - `FROM`: Specifies the table(s) to query.
   - `WHERE`: Filters rows based on specified conditions.
   - `GROUP BY`: Groups rows by one or more columns.
   - `HAVING`: Filters groups based on specified conditions.
   - `ORDER BY`: Sorts rows based on specified columns.

2. **Data Manipulation Language (DML)**:
   - `INSERT INTO`: Adds new rows to a table.
   - `UPDATE`: Modifies existing data in a table.
   - `DELETE`: Removes rows from a table.

3. **Data Definition Language (DDL)**:
   - `CREATE TABLE`: Defines a new table and its structure.
   - `ALTER TABLE`: Modifies an existing tables structure.
   - `DROP TABLE`: Deletes a table and its data.
   - `CREATE INDEX`: Creates an index for improving data retrieval.
   - `DROP INDEX`: Removes an index.

4. **Data Control Language (DCL)**:
   - `GRANT`: Grants privileges or permissions to users or roles.
   - `REVOKE`: Revokes previously granted privileges.

5. **Transaction Control Language (TCL)**:
   - `COMMIT`: Confirms and persists changes made within a transaction.
   - `ROLLBACK`: Reverts changes made within a transaction.
   - `SAVEPOINT`: Sets a savepoint within a transaction for later rollback.

SQL commands allow users and applications to interact with relational databases, making it possible to store, retrieve, and manage data effectively.






				

MYSQL QUERIES
=====================================================




/* employee table and user table */
emp_id, emp_company_name, 		emp_name, emp_salary
1, 		'Innova Solutions', 	'Nani'	, '55000.2'
2, 		'ACS Solutions',		'Pinky', '45000.2'
3, 		'HCL', 					'Srinivas', '56000.2'
4, 		'TECHERA Solutions', 	'Ramu', '51000.2'
5, 		'IBM', 					'Raju', '58000.2'
6, 		'TCS', 					'Pavan', '65000.2'


CREATING TABLE 
================
CREATE TABLE user (
id int NOT NULL AUTO_INCREMENT,
name varchar(60) not null,
age int not null,
occupation varchar(60),
PRIMARY KEY(id)
)

/** ALTER TABLE **/ 

/* add a column */
alter table user add dob varchar(60) not null after name;

/* add multiple columns */
alter table user add dob varchar(60) not null after name , add salary VARCHAR(60) not null after occupation;

/* modify column is used to modify the definition of the COLUMN */
alter table user modify dob VARCHAR(40) ;

/* drop a column */
alter table user drop column dob;

/* change column name */
Syntax : ALTER TABLE table_name  CHANGE COLUMN old_name new_name   column_definition  [ FIRST | AFTER column_name ]  
alter table user change name user_name after age

/* Rename table */
alter table rename to users

/* delete the row data from a table */
delete user where id in (4,6)

/* delete entire table data or TRUNCATE table data without deleting columns */
TRUNCATE table user;

/* drop table or delete table with columns */
drop table user;

/* drop table or delete table with columns */
drop table IF EXISTS user, employee, customer ;

/* show table STRUCTURE */
desc user;

/* show columns from table from any database */

syntax : SHOW COLUMNS FROM database_name.table_name;  




MySQL CONSTRAINTS 
==================
The constraint in MySQL is used to specify the rule that allows or restricts what values/data will be stored in the table. 
They provide a suitable method to ensure data accuracy and integrity inside the table. 
It also helps to limit the type of data that will be inserted inside the table. 4

If any interruption occurs between the constraint and data action, the action is failed.

	Types of MySQL Constraints
	Constraints in MySQL is classified into two types:
	i) Column Level Constraints: These constraints are applied only to the single column that limits the type of particular column data.
	ii) Table Level Constraints: These constraints are applied to the entire table that limits the type of data for the whole table.


1) NOT NULL Constraint
	This constraint specifies that the column cannot have NULL or empty values. The below statement creates a table with NOT NULL constraint.
	mysql> CREATE TABLE Student(Id INTEGER, LastName TEXT NOT NULL, FirstName TEXT NOT NULL, City VARCHAR(35));  
	
2) UNIQUE Constraint
	mysql> CREATE TABLE ShirtBrands(Id INTEGER, BrandName VARCHAR(40) UNIQUE, Size VARCHAR(30));  
	
	mysql> INSERT INTO ShirtBrands(Id, BrandName, Size) VALUES(1, 'Pantaloons', 38), (2, 'Cantabil', 40);  
  
	mysql> INSERT INTO ShirtBrands(Id, BrandName, Size) VALUES(1, 'Raymond', 38), (2, 'Cantabil', 40);   // gives an error in 'Cantabil' value(duplicate entry for key)

3) CHECK Constraint
	
	It controls the value in a particular column. It ensures that the inserted value in a column must be satisfied with the given condition. 
	In other words, it determines whether the value associated with the column is valid or not with the given condition.
	The CHECK constraint ensures that the inserted value in a column must be satisfied with the given condition means the Age of a person should be greater than or equal to 18.
	

	
	mysql> CREATE TABLE Persons (  
    ID int NOT NULL,  
    Name varchar(45) NOT NULL,  
    Age int CHECK (Age>=18)  
	);  
	
	mysql> INSERT INTO Persons(Id, Name, Age) VALUES (1,'Robert', 28), (2, 'Joseph', 35), (3, 'Peter', 40);  
	  
	mysql> INSERT INTO Persons(Id, Name, Age) VALUES (1,'Robert', 15);  // gives an error check_constraint 'persons_chk_1' is violated (because of value '15')

4) DEFAULT Constraint
	This constraint is used to set the default value for the particular column where we have not specified any value. 
	It means the column must contain a value, including NULL.

	For example, the following statement creates a table "Persons" that contains DEFAULT constraint on the "City" column. 
	If we have not specified any value to the City column, it inserts the default value:
	
	mysql> CREATE TABLE Persons (  
    ID int NOT NULL,  
    Name varchar(45) NOT NULL,  
    Age int,  
    City varchar(25) DEFAULT 'New York'  
	);  
	
	mysql> INSERT INTO Persons(Id, Name, Age, City) VALUES (1,'Robert', 15, 'Florida'), (2, 'Joseph', 35, 'California'),(3, 'Peter', 40, 'Alaska');  
	mysql> INSERT INTO Persons(Id, Name, Age) VALUES (1,'Brayan', 15);  // after 15  city was not given, it will take 'New_York' as DEFAULT value.

5) AUTO_INCREMENT Constraint
	This constraint automatically generates a unique number whenever we insert a new record into the table. 
	Generally, we use this constraint for the primary key field in a table.
	
	mysql> CREATE TABLE Animals(  
	id int NOT NULL AUTO_INCREMENT,   
	name CHAR(30) NOT NULL,   
	PRIMARY KEY (id)
	);  

6) ENUM Constraint
	
	The ENUM data type in MySQL is a string object. It allows us to limit the value chosen from a list of permitted values in the column specification at the time of table creation. 
	It is short for enumeration, which means that each column may have one of the specified possible values. 
	It uses numeric indexes (1, 2, 3…) to represent string values.
	
	mysql> CREATE TABLE Shirts (    
    id INT PRIMARY KEY AUTO_INCREMENT,     
    name VARCHAR(35),     
    size ENUM('small', 'medium', 'large', 'x-large')    
	);  
	
	mysql> INSERT INTO Shirts(id, name, size) VALUES (1,'t-shirt', 'medium'),(2, 'casual-shirt', 'small'),(3, 'formal-shirt', 'large');  


7) INDEX Constraint
	This constraint allows us to create and retrieve values from the table very quickly and easily. 
	An index can be created using one or more than one column. It assigns a ROWID for each row in that way they were inserted into the table.
	
	mysql> CREATE TABLE Shirts (    
    id INT PRIMARY KEY AUTO_INCREMENT,     
    name VARCHAR(35),     
    size ENUM('small', 'medium', 'large', 'x-large')    
	);  
	
	
	mysql> INSERT INTO Shirts(id, name, size) VALUES (1,'t-shirt', 'medium'), (2, 'casual-shirt', 'small'), (3, 'formal-shirt', 'large');  
	
	mysql> CREATE INDEX idx_name ON Shirts(name);  // creating index query 
	mysql> SELECT * FROM Shirts USE INDEX(idx_name); 

8) Foreign Key Constraint
	This constraint is used to link two tables together. It is also known as the referencing key.
	A foreign key column matches the primary key field of another table. It means a foreign key field in one table refers to the primary key field of another table.
	
	Let us consider the structure of these tables: Persons and Orders.
	
	persons table :
	
	CREATE TABLE Persons (  
    Person_ID int NOT NULL PRIMARY KEY,   
    Name varchar(45) NOT NULL,   
    Age int,   
    City varchar(25)  
	);  
	
	Orders table : 
	CREATE TABLE Orders (  
    Order_ID int NOT NULL PRIMARY KEY,  
    Order_Num int NOT NULL,  
    Person_ID int,  
    FOREIGN KEY (Person_ID) REFERENCES Persons(Person_ID)  
	);  
	
	In the above table structures, we can see that the "Person_ID" field in the "Orders" table points to the "Person_ID" field in the "Persons" table. 
	The "Person_ID" is the PRIMARY KEY in the "Persons" table, while the "Person_ID" column of the "Orders" table is a FOREIGN KEY.

9)	A composite key is made by the combination of two or more columns in a table that can be used to uniquely identify each row in the table when the columns are combined uniqueness of a row is guaranteed, but when it is taken individually it does not guarantee uniqueness, or it can also be understood as a primary key made by the combination of two or more attributes to uniquely identify every row in a table. 

		example : 
		CREATE TABLE Students (
			first_name VARCHAR(50),
			last_name VARCHAR(50),
			age INT,
			-- Other columns...
			PRIMARY KEY (first_name, last_name)
		);


/* Copy data from one table to another table (coping from product row 1 data to product_info table row1 */
insert into product_info(id, expiry_date, product_name, product_price )  select id, expiry_date, product_name, product_price from product where id =1


MySQL CLAUSES 
=================

1. WHERE - is used to filter the results. It specifies a specific position where you have to do the operation.
	Ex: select * from student where name = "Nani";

2. DISTINCT - is used to remove duplicate records from table and fetch only the unique records. The DISTINCT clause is used only with SELECT statement.
	Ex: select  distinct  product_price from product 

3. ORDER BY - is used to sort the records in ascending or descending order.

	Ex: SELECT * FROM product  ORDER BY product_name ASC; // ascending order 

		SELECT * FROM product  ORDER BY product_name DESC; // descnding order.
		
		SELECT * FROM product  ORDER BY product_name; // by default ascending order.
		
4. GROUP BY - The MYSQL GROUP BY Clause is used to collect data from multiple records and group the result by one or more column. It is generally used in a SELECT statement.

			  You can also use some aggregate functions like COUNT, SUM, MIN, MAX, AVG etc. on the grouped column.
			  
		Ex: select product_name , count(*) from product group by product_name // group by with COUNT function.
		
			select emp_name , sum(work_hours) as total_work_hours from emp_work_hours group by emp_name //group by with SUM() function.
			
			select emp_name ,MIN(work_hours) as minimum_work_hours from emp_work_hours group by emp_name // group by with MIN() function.
			
			select emp_name ,MAX(work_hours) as maximum_work_hours from emp_work_hours group by emp_name // group by with MAX() function.
			
			select emp_name ,AVG(work_hours) as avg_work_hours from emp_work_hours group by emp_name // group by with AVG() function.

5. HAVING - MySQL HAVING Clause is used with GROUP BY clause. It always returns the rows where condition is TRUE.

			select emp_name , sum(work_hours) as total_work_hours from emp_work_hours group by emp_name having sum(work_hours) > 13 // returns records whose sum of work_hours is above  13 work_hours.


MYSQL CONTROL FLOW :
=====================

Syntax: SELECT IF(expression1(check condition) , expression 2(true), expression 3(false);

IF EXPRESSION: 
----------------

 SELECT IF(30<20, 'Yes', 'No');
 SELECT IF(200=30, 'CORRECT' , 'WRONG');
 SELECT IF(STRCMP('WELCOME', 'UNWELCOME')=0, 'SAME',  'DIFFERENT'); // comparing the strings
 
 SELECT emp_name,emp_salary, IF(emp_salary >55000, 'ELIGIBLE FOR LOAN', 'NOT ELIGIBLE FOR LOAN') AS result from employee;
 
 SELECT IFNULL('Welcome', 'Unwelcome'); /* it returns Welcome because , first expression is not null.*/
 SELECT IFNULL(NULL, 'Unwelcome'); /* it returns Unwelcome because , first expression is null.*/

 
CASE EXPRESSION:
----------------
 Syntax:
	CASE value   
		WHEN [compare_value] THEN result   
		[WHEN [compare_value] THEN result ...]   
		[ELSE result]   
	END  
	
EX: 1
	
SELECT CASE 'getout'
	WHEN 'welcome' THEN 'THANK YOU'
    WHEN 'Unwelcome' THEN 'NO PROBLEM'
    WHEN 'getout' THEN 'SAD'   /* This will be returned */
    ELSE 'INVALID'
END


EX: 2

SELECT emp_id, emp_name ,
CASE 
	WHEN emp_salary > 50000 THEN 'Eligible for loan'
    WHEN emp_salary  < 50000 THEN 'Not eligible for loan'
    WHEN emp_salary = 60000 THEN 'Interest will be less'
    ELSE 'INVALID'
END AS result from employee 





MySQL CONDITIONS:
=================

1. AND :  select * from employee where emp_name ='Nani' AND emp_salary = 55000.2;

2. OR  : select * from employee where emp_name = 'nani' OR emp_name = 'ramu';

3. AND OR : select * from employee where (emp_name = 'nani' AND emp_name = 'ramu') OR emp_salary>=55000

4. Boolean : SELECT studentid, name, pass FROM student1 WHERE pass = TRUE;  

5. LIKE	: LIKE condition is used to perform pattern matching to find the correct result. It is used in SELECT, INSERT, UPDATE and DELETE statement with the combination of WHERE clause.
			select * from employee where emp_name LIKE '%van'; /* search for name based on given ending characters('van' - 'Pavan') */
			select * from employee where emp_name LIKE '%an%'; /* search for name based on given middle characters('%an%' - 'Pavan') */
			select * from employee where emp_name LIKE 'Pav%'; /* search for name based on given first characters('Pav%' - 'Pavan') */
			
			select * from employee where emp_name LIKE 'P_v_n%'; // search for name based on given index characters('Pav%' - 'Pavan') - using underscore
			
			
6. IN   : The MySQL IN condition is used to reduce the use of multiple OR conditions in a SELECT, INSERT, UPDATE and DELETE statement.
			
			select * from employee where id IN (3,7,8); /* it will fetch the records whose id's are 3,7,8 */
		
			select * from employee where emp_name IN ('nani', 'pavan',  'raju');
			
			
7.  ANY : The ANY keyword is a MySQL operator that returns the Boolean value TRUE if the comparison is TRUE for ANY of the subquery condition. In other words, this keyword returns true if any of the subquery condition is fulfilled when the SQL query is executed. The ANY keyword must follow the comparison operator. 
		  It is noted that ALL SQL operator works related to ANY operator, but it returns true when all the subquery values are satisfied by the condition in MySQL.
		  The ANY operator works like comparing the value of a table to each value in the result set provided by the subquery condition. And then, if it finds any value that matches at least one value/row of the subquery, it returns the TRUE result.

			select emp_salary from employee where emp_salary > ANY (select product_price from product) /** it returns true that mean employee salaries will be printed because salaries are greater than product_prices */
			
			select product_price from product where product_price > ANY(select emp_salary from employee ) /** it returns false(empty table) because product_prices are not greater than employee salaries */
			
8. 	NOT : select * from employee where emp_name NOT IN ('nani', 'pavan',  'raju');
		  select * from employee where id IN (3, 7); 
		  
		  
9.  NOT EQUAL : select * from  employee where emp_id <> 6; /* NOT EQUAL */
				select * from  employee where emp_id != 6; /* NOT EQUAL : Above and this query will give same results */
				
			
10. NULL/NOT NULL    : 	select * from employee where emp_name IS NULL; /* returns records whose names are having null value */
					 :  select * from employee where emp_name IS NOT NULL; /* returns records whose names are not having null value */

			

	
	
	
MySQL JOINS :
====================

MySQL JOINS are used with SELECT statement. It is used to retrieve data from multiple tables. It is performed whenever you need to fetch records from two or more tables.

1. INNER JOIN :
========================
The MySQL Inner Join is used to returns only those results from the tables that match the specified condition and hides other rows and columns. 
MySQL assumes it as a default Join, so it is optional to use the Inner Join keyword with the query.

	Syntax :SELECT columns  
			FROM table1  
			INNER JOIN table2 ON condition1  
			INNER JOIN table3 ON condition2  
			...;
	
	ex: select e.emp_id, ew.working_date,e.emp_name, work_hours, emp_salary from employee e INNER JOIN emp_work_hours ew  ON e.emp_id = ew.emp_id;
	
	
	MySQL Inner Join with GROUP BY CLAUSE 
	------------------------------------
	
	select   ew.day_id , e.emp_name, e.emp_id, e.emp_salary , ew.working_date from emp_work_hours  ew LEFT JOIN   employee e  ON  e.emp_id = ew.emp_id;

	
	MySQL Inner Join with USING clause:
	----------------------------------
	
	Sometimes, the name of the columns is the same in both the tables. In that case, we can use a USING keyword to access the records. The following query explains it more clearly:

	
	select   employee.emp_id, emp_work_hours.working_date,employee.emp_name, work_hours, emp_salary from employee  INNER JOIN emp_work_hours   USING(emp_id);


2. LEFT JOIN 
=======================

The Left Join in MySQL is used to query records from multiple tables. 
This clause is similar to the Inner Join clause that can be used with a SELECT statement immediately after the FROM keyword. 
When we use the Left Join clause, it will return all the records from the first (left-side) table, even no matching records found from the second (right side) table. 
If it will not find any matches record from the right side table, then returns null.
	
	
	Syntax : 	SELECT columns    
				FROM table1    
				LEFT JOIN table2    
				ON Join_Condition; 
example : 
select   ew.day_id , e.emp_name, e.emp_id, e.emp_salary , ew.working_date from emp_work_hours  ew LEFT JOIN   employee e  ON  e.emp_id = ew.emp_id;
				
	
	MySQL LEFT JOIN with GROUP BY CLAUSE 
	----------------------------------------
select   ew.day_id , e.emp_name, e.emp_id, e.emp_salary , ew.working_date from emp_work_hours  ew LEFT JOIN   employee e  ON  e.emp_id = ew.emp_id GROUP BY e.emp_company_name



3. RIGHT-JOIN
===========================
The Right Join is used to joins two or more tables and returns all rows from the right-hand table, and only those results from the other table that fulfilled the join condition. 
If it finds unmatched records from the left side table, it returns Null value. 
It is similar to the Left Join, except it gives the reverse result of the join tables. 
It is also known as Right Outer Join. So, Outer is the optional clause used with the Right Join.
	
	
	
	
	
Syntax: SELECT column_list  
		FROM Table1  
		RIGHT JOIN Table2   
		ON join_condition;  
	
	
Example : 	SELECT  emp_name,c.id, customer_name,state from customer c 
			RIGHT JOIN employee e ON  c.id = e.emp_id
			RIGHT JOIN product p ON c.id = p.id



4. CROSS-JOIN
=========================
MySQL CROSS JOIN is used to combine all possibilities of the two or more tables and returns the result that contains every row from all contributing tables. 
The CROSS JOIN is also known as CARTESIAN JOIN, which provides the Cartesian product of all associated tables. 
The Cartesian product can be explained as all rows present in the first table multiplied by all rows present in the second table. 
It is similar to the Inner Join, where the join condition is not available with this clause.


Syntax : 	SELECT *  
			FROM customers  
			CROSS JOIN contacts;  
			
			
Example : SELECT * FROM employee CROSS JOIN emp_work_hours




5. SELF-JOIN
=========================
A SELF JOIN is a join that is used to join a table with itself. 
In the previous sections, we have learned about the joining of the table with the other tables using different JOINS, such as INNER, LEFT, RIGHT, and CROSS JOIN. 
However, there is a need to combine data with other data in the same table itself. In that case, we use Self Join.

We can perform Self Join using table aliases. The table aliases allow us not to use the same table name twice with a single statement. 
If we use the same table name more than one time in a single query without table aliases, it will throw an error.

The table aliases enable us to use the temporary name of the table that we are going to use in the query. 
Let us understand the table aliases with the following explanation.

Suppose we have a table named "student" that is going to use twice in the single query. To aliases the student table, we can write it as:

Select … FROM student AS S1   
INNER JOIN student AS S2;  



Syntax : 	SELECT s1.col_name, s2.col_name...  
			FROM table1 s1, table1 s2  
			WHERE s1.common_col_name = s2.common_col_name;  
			
			
			
example : 	SELECT  s1.student_id, s1.name  
			FROM student AS s1, student s2  
			WHERE s1.student_id=s2.student_id  
			AND s1.course_id<>s2.course_id;  
			

	i. SELF JOIN using INNER JOIN clause
	-----------------------------------------------
				SELECT  s1.student_id, s1.name  
				FROM student s1  
				INNER JOIN student s2  
				ON s1.student_id=s2.student_id  
				AND s1.course_id<>s2.course_id  
				GROUP BY student_id;  
				
	ii. SELF-JOIN using LEFT JOIN clause
	----------------------------------------------

				SELECT (CONCAT(s1.stud_lname, ' ', s2.stud_fname)) AS 'Monitor', s1.city  
				FROM students s1  
				LEFT JOIN students s2 ON s1.student_id=s2.student_id  
				ORDER BY s1.city DESC;  
				
				
				
				
				
				
MySQL STORED PROCEDURES
=========================

Certainly! Here's a tutorial on MySQL stored procedures with explanations for each step:

**MySQL Stored Procedures Tutorial**

A stored procedure is a collection of SQL statements that can be executed as a single unit. It allows for code reusability, improved performance, and enhanced security. This tutorial will guide you through creating a MySQL stored procedure, using input and output parameters, executing the procedure, and implementing error handling.


MySQL stored procedures offer several features that make them valuable for database development and management:

1. **Code Reusability**: Stored procedures allow you to encapsulate a sequence of SQL statements into a single, reusable unit. This promotes code reusability, reducing the need to duplicate code in multiple parts of your application.

2. **Performance Optimization**: Stored Procedure increases the performance of the applications. Once stored procedures are created, they are compiled and stored in the database.

3. **Reduced Network Traffic**: Stored procedure reduces the traffic between application and database server. Because the application has to send only the stored procedure's name and parameters instead of sending multiple SQL statements.

4. **Improved Security**: A procedure is always secure. The database administrator can grant permissions to applications that access stored procedures in the database without giving any permissions on the database tables.

5. **Error Handling**: Stored procedures enable you to implement robust error handling with DECLARE...HANDLER statements, so you can gracefully handle exceptions and errors that might occur during execution.


Overall, MySQL stored procedures are a powerful tool for enhancing database development, ensuring data integrity, improving performance, and centralizing business logic within the database server. They can be particularly valuable in enterprise applications with complex data manipulation and security requirements.


1 Creating a MySQL stored procedure.
2. Using input and output parameters.
3. Executing the stored procedure.
4. Error handling.




**Step 1: Creating a MySQL Stored Procedure**

1. **Definition**: To create a MySQL stored procedure, use the `CREATE PROCEDURE` statement, followed by the procedure name, input parameters (if any), and the SQL statements enclosed within a `BEGIN...END` block.

2. **Example**:
   ```sql
   DELIMITER //
   CREATE PROCEDURE InsertProduct(IN product_name VARCHAR(255), IN price DECIMAL(10, 2))
   BEGIN
       INSERT INTO products (product_name, price) VALUES (product_name, price);
   END //
   DELIMITER ;
   ```

   - Explanation: In this example, we create a stored procedure named `InsertProduct`. It takes two input parameters, `product_name` and `price`, and inserts a new product record into the "products" table.

**Step 2: Using Input and Output Parameters**

1. **Definition**: Stored procedures can have input and output parameters. Input parameters are values passed into the procedure, while output parameters return results.

2. **Example**:
   ```sql
   DELIMITER //
   CREATE PROCEDURE AddTwoNumbers(IN num1 INT, IN num2 INT, OUT result INT)
   BEGIN
       SET result = num1 + num2;
   END //
   DELIMITER ;
   ```

   - Explanation: In this example, `num1` and `num2` are input parameters, and `result` is an output parameter. The procedure calculates the sum of the input parameters and stores it in the output parameter.

**Step 3: Executing the Stored Procedure**

1. **Definition**: To execute a stored procedure, use the `CALL` statement. Provide the procedure name and input parameter values.

2. **Example**:
   ```sql
   CALL InsertProduct('Sample Product', 29.99);
   ```

   - Explanation: This `CALL` statement executes the `InsertProduct` procedure with specific values for the `product_name` and `price` input parameters. It inserts a new product into the "products" table.

3. **Example (with output parameter)**:
   ```sql
   CALL AddTwoNumbers(5, 7, @sum);
   SELECT @sum;
   ```

   - Explanation: This example calls the `AddTwoNumbers` procedure with input parameters 5 and 7. It also stores the result in an output parameter `@sum` and then selects and displays the sum.

**Step 4: Error Handling**

1. **Definition**: MySQL stored procedures allow you to handle errors using `DECLARE...HANDLER` statements. These handlers specify how to react to specific errors that might occur during procedure execution.

2. **Example**:
   ```sql
   DELIMITER //
   CREATE PROCEDURE DivideNumbers(IN dividend INT, IN divisor INT, OUT quotient DECIMAL(10, 2))
   BEGIN
       DECLARE CONTINUE HANDLER FOR 1365
       SET quotient = NULL;  -- Handle division by zero error (error code 1365)
       
       SET quotient = dividend / divisor;
   END //
   DELIMITER ;
   ```

   - Explanation: In this example, a handler is declared to catch the division by zero error (error code 1365). If the error occurs, the output parameter `quotient` is set to NULL.

This tutorial provides a comprehensive introduction to MySQL stored procedures. As you become more proficient, you can explore advanced scenarios involving conditionals, loops, and transactions within your stored procedures.


========================================
Triggers & Functions & Stored Procedures
========================================
-----------------------
### Triggers in MySQL:
----------------------

Triggers are database objects that are automatically executed or fired when certain events occur in the database. These events can be INSERT, UPDATE, DELETE, or even events like BEFORE INSERT, AFTER UPDATE, etc. Triggers are useful for enforcing complex business rules, maintaining referential integrity, auditing changes, and more.

#### Types of Triggers:

1. **BEFORE Triggers:** These triggers are executed before the operation (INSERT, UPDATE, DELETE) occurs.
2. **AFTER Triggers:** These triggers are executed after the operation (INSERT, UPDATE, DELETE) occurs.

#### Scenario:
- Use a BEFORE INSERT trigger to automatically set a default value for a column.
- Use an AFTER UPDATE trigger to log changes made to a specific table.

#### Example:
```sql
-- BEFORE INSERT trigger to set a default value
CREATE TRIGGER set_default_value BEFORE INSERT ON my_table
FOR EACH ROW
SET NEW.column_name = IFNULL(NEW.column_name, 'default_value');

-- AFTER UPDATE trigger to log changes
CREATE TRIGGER log_changes AFTER UPDATE ON my_table
FOR EACH ROW
INSERT INTO change_log (table_name, column_name, old_value, new_value)
VALUES ('my_table', 'column_name', OLD.column_name, NEW.column_name);
```

-----------------------
### Functions in MySQL:
-----------------------

Functions in MySQL are stored routines that accept parameters, perform an operation, and return a single value. They can be used to encapsulate common logic, perform calculations, or manipulate data before returning a result.

#### Types of Functions:

1. **Scalar Functions:** These functions return a single value.
2. **Table-Valued Functions:** These functions return a result set.

#### Scenario:
- Use a scalar function to concatenate first name and last name fields.
- Use a table-valued function to split a comma-separated string into individual values.

#### Example:
```sql
-- Scalar function to concatenate names
CREATE FUNCTION full_name(first_name VARCHAR(50), last_name VARCHAR(50))
RETURNS VARCHAR(100)
BEGIN
    RETURN CONCAT(first_name, ' ', last_name);
END;

-- Table-valued function to split a comma-separated string
CREATE FUNCTION split_string(input_string VARCHAR(255))
RETURNS TABLE (output_value VARCHAR(100))
BEGIN
    DECLARE temp_value VARCHAR(100);
    WHILE LENGTH(input_string) > 0 DO
        SET temp_value = SUBSTRING_INDEX(input_string, ',', 1);
        SET input_string = TRIM(BOTH ',' FROM SUBSTRING(input_string, LENGTH(temp_value) + 2));
        INSERT INTO output_value VALUES (temp_value);
    END WHILE;
    RETURN;
END;
```
-------------------------------
### Stored Procedures in MySQL:
-------------------------------

Stored Procedures are precompiled SQL statements that are stored in the database. They can accept input parameters, perform operations, and return multiple result sets. Stored Procedures are used for encapsulating complex business logic, improving performance, and ensuring consistency in data manipulation.

#### Scenario:
- Use a stored procedure to insert a new employee record and update related tables.
- Use a stored procedure to calculate monthly sales totals for a specific product.

#### Example:
```sql
-- Stored procedure to insert a new employee
CREATE PROCEDURE add_employee(IN first_name VARCHAR(50), IN last_name VARCHAR(50), IN department_id INT)
BEGIN
    DECLARE new_employee_id INT;
    START TRANSACTION;
    INSERT INTO employees (first_name, last_name, department_id) VALUES (first_name, last_name, department_id);
    SET new_employee_id = LAST_INSERT_ID();
    INSERT INTO employee_history (employee_id, action) VALUES (new_employee_id, 'New employee added');
    COMMIT;
END;

-- Stored procedure to calculate monthly sales
CREATE PROCEDURE calculate_monthly_sales(IN product_id INT, IN month INT, IN year INT)
BEGIN
    SELECT SUM(sales_amount) AS total_sales
    FROM sales
    WHERE product_id = product_id
    AND MONTH(sale_date) = month
    AND YEAR(sale_date) = year;
END;
```

### Conclusion:

- **Triggers** are used to automatically execute actions based on predefined events in the database.
- **Functions** are used to encapsulate logic and calculations to return a single value or a table of values.
- **Stored Procedures** are used to encapsulate complex business logic and perform multiple database operations in a transactional manner.

These are powerful features of MySQL that can greatly enhance the functionality and maintainability of your database applications.


SQL Practice 
=============
create database practice_sql;


--CREATING TABLES FOR PRACTICE
--============================

-- Create a table for storing customers
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);

-- Create a table for storing addresses
CREATE TABLE addresses (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    postal_code VARCHAR(20),
    country VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


-- Create a table for storing orders
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Create a table for storing order items
CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);





--INSERTING DATA INTO TABLES TO PRACTICE
--=======================================

-- Insert data into the customers table
INSERT INTO customers (first_name, last_name, email, phone_number)
VALUES
    ('Ramesh', 'Kumar', 'ramesh@example.com', '9876543210'),
    ('Suresh', 'Sharma', 'suresh@example.com', '8765432109'),
    ('Preeti', 'Patel', 'preeti@example.com', '7654321098'),
    ('Vikram', 'Singh', 'vikram@example.com', '6543210987'),
    ('Priya', 'Mishra', 'priya@example.com', '5432109876'),
    ('Amit', 'Verma', 'amit@example.com', '4321098765'),
    ('Anita', 'Reddy', 'anita@example.com', '3210987654'),
    ('Rajesh', 'Gupta', 'rajesh@example.com', '2109876543'),
    ('Deepak', 'Shah', 'deepak@example.com', '1098765432'),
    ('Neha', 'Jain', 'neha@example.com', '0987654321');


-- Insert data into the addresses table
INSERT INTO addresses (customer_id, street, city, state, postal_code, country)
VALUES
    (1, '123 ABC Street', 'Mumbai', 'Maharashtra', '400001', 'India'),
    (2, '456 XYZ Street', 'Delhi', 'Delhi', '110001', 'India'),
    (3, '789 PQR Street', 'Bangalore', 'Karnataka', '560001', 'India'),
    (4, '101 QWE Street', 'Kolkata', 'West Bengal', '700001', 'India'),
    (5, '888 JKL Street', 'Chennai', 'Tamil Nadu', '600001', 'India'),
    (6, '222 MNO Street', 'Hyderabad', 'Telangana', '500001', 'India'),
    (7, '555 UVW Street', 'Pune', 'Maharashtra', '411001', 'India'),
    (8, '999 XYZ Street', 'Ahmedabad', 'Gujarat', '380001', 'India'),
    (9, '777 FGH Street', 'Jaipur', 'Rajasthan', '302001', 'India'),
    (10, '333 IJK Street', 'Lucknow', 'Uttar Pradesh', '226001', 'India');

-- Insert data into the orders table
INSERT INTO orders (customer_id, order_date, total_amount)
VALUES
    (1, '2024-03-15', 500.00),
    (2, '2024-03-16', 750.00),
    (3, '2024-03-17', 1000.00),
    (4, '2024-03-18', 600.00),
    (5, '2024-03-19', 900.00),
    (6, '2024-03-20', 1200.00),
    (7, '2024-03-21', 850.00),
    (8, '2024-03-22', 950.00),
    (9, '2024-03-23', 1100.00),
    (10, '2024-03-24', 700.00);

-- Insert data into the order_items table
INSERT INTO order_items (order_id, product_name, quantity, unit_price)
VALUES
    (1, 'Product A', 2, 100.00),
    (1, 'Product B', 1, 150.00),
    (2, 'Product C', 3, 200.00),
    (3, 'Product D', 1, 500.00),
    (4, 'Product E', 2, 200.00),
    (4, 'Product F', 1, 400.00),
    (5, 'Product G', 3, 300.00),
    (5, 'Product H', 1, 600.00),
    (6, 'Product I', 2, 250.00),
    (6, 'Product J', 1, 450.00),
    (7, 'Product K', 4, 100.00),
    (8, 'Product L', 2, 475.00),
    (9, 'Product M', 1, 800.00),
    (9, 'Product N', 3, 350.00),
    (10, 'Product O', 2, 150.00),
    (10, 'Product P', 1, 700.00);




---PRACTICE QUESTIONS
--===================
/**
**Customers Table:**

1. Retrieve all customers' first names and last names.
2. Get the email addresses of customers whose first name starts with 'R'.
3. Find the phone numbers of customers whose last name ends with 'a'.
4. Count the total number of customers.
5. Get the details (first name, last name, email, phone number) of the customer with the highest customer_id.
6. Find customers who have email addresses containing 'example'.
7. Retrieve customers who have phone numbers starting with '98'.
8. Get the number of distinct last names among customers.
9. Retrieve customers sorted by last name in ascending order.
10. Find customers who do not have an email address specified.


**Addresses Table:**

11. Get all addresses in Mumbai.
12. Find the postal code of the address with the highest address_id.
13. Retrieve addresses in Karnataka.
14. Count the total number of addresses.
15. Get the country of the address with the lowest address_id.
16. Find addresses in cities starting with 'D'.
17. Retrieve addresses with postal codes ending with '001'.
18. Get distinct states from the addresses table.
19. Find addresses in India.
20. Retrieve addresses sorted by city in descending order.

**Orders Table:**

21. Retrieve all order IDs.
22. Get the total amount of the order with the highest order_id.
23. Find orders placed on '2024-03-15'.
24. Count the total number of orders.
25. Get the order date of the order with the lowest order_id.
26. Find orders with a total amount greater than 1000.00.
27. Retrieve orders placed before '2024-03-20'.
28. Get the average total amount of all orders.
29. Find orders placed by customer_id 3.
30. Retrieve orders sorted by total amount in descending order.

**Order_Items Table:**

31. Retrieve all order item IDs.
32. Get the product names of items with a quantity greater than 2.
33. Find the total price of all items.
34. Count the total number of order items.
35. Get the quantity of the item with the highest order_item_id.
36. Find items with a unit price less than 200.00.
37. Retrieve items with a product name containing 'Product G'.
38. Get the sum of the quantities of all items.
39. Find items with a unit price greater than 500.00.
40. Retrieve items sorted by unit price in ascending order.

41. Retrieve all customers who have placed an order.
42. Get the total number of orders placed by each customer.
43. Find the customer who has placed the most orders.
44. Retrieve the average total amount of orders placed by each customer.
45. Get the customer who has spent the most on orders.
46. Find the number of orders placed in each city.
47. Retrieve the highest total amount of orders placed in a single order.
48. Get the average quantity of items per order.
49. Find the customer who has purchased the most items.
50. Retrieve orders placed by customers with a specific email domain (e.g., '@example.com').

51. Retrieve the first and last names of customers along with their corresponding addresses.
52. Get the total amount of each order along with the corresponding customer's first name.
53. Find the average total amount of orders placed in each city.
54. Retrieve orders along with the customer's phone number and address city.
55. Get the product names along with their corresponding unit prices.
56. Find the total amount of each order along with the customer's last name.
57. Retrieve orders placed by customers with a specific area code in their phone number.
58. Get the order date and total amount of orders placed in each state.
59. Find the customer who has placed the most expensive order.
60. Retrieve orders along with the customer's first name and last name.

61. Retrieve the first name and last name of customers who have placed orders.
62. Get the total amount of orders placed in each country.
63. Find the order date and total amount of orders placed by a specific customer.
64. Retrieve the first name and email address of customers who have placed orders.
65. Get the order date and total amount of orders placed by a customer with a specific email address.
66. Find the customer who has placed the least expensive order.
67. Retrieve the first name and phone number of customers who have placed orders.
68. Get the total number of orders placed in each month.
69. Find the order date and total amount of orders placed by a customer with a specific phone number.
70. Retrieve the first name and address city of customers who have placed orders.

71. Retrieve the first name and last name of customers who have placed orders in Maharashtra.
72. Get the total number of orders placed in each city.
73. Find the order date and total amount of orders placed in Bangalore.
74. Retrieve the first name and email address of customers who have placed orders in Delhi.
75. Get the total number of orders placed in each state.
76. Find the order date and total amount of orders placed in Tamil Nadu.
77. Retrieve the first name and phone number of customers who have placed orders in Mumbai.
78. Get the total number of orders placed in each country.
79. Find the order date and total amount of orders placed in West Bengal.
80. Retrieve the first name and address postal code of customers who have placed orders in Chennai.

81. Retrieve the first name and last name of customers who have placed orders with a total amount greater than 1000.00.
82. Get the total amount of orders placed by customers with a specific last name.
83. Find the order date and total amount of orders placed by customers with a specific first name.
84. Retrieve the first name and email address of customers who have placed orders with a total amount less than 500.00.
85. Get the total amount of orders placed by customers with a specific phone number.
86. Find the order date and total amount of orders placed by customers with a specific email address.
87. Retrieve the first name and phone number of customers who have placed orders with a total amount greater than 750.00.
88. Get the total amount of orders placed by customers with a specific address city.
89. Find the order date and total amount of orders placed by customers with a specific address state.
90. Retrieve the first name and address postal code of customers who have placed orders with a total amount less than 600.00.

91. Retrieve the first name and last name of customers who have placed orders containing a specific product name.
92. Get the total amount of orders placed by customers with a specific address postal code.
93. Find the order date and total amount of orders placed by customers with a specific address country.
94. Retrieve the first name and email address of customers who have placed orders containing a specific product name.
95. Get the total amount of orders placed by customers with a specific email domain.
96. Find the order date and total amount of orders placed by customers with a specific phone number area code.
97. Retrieve the first name and phone number of customers who have placed orders containing a specific product name.
98. Get the total amount of orders placed by customers with a specific last name initial.
99. Find the order date and total amount of orders placed by customers with a specific first name initial.
100. Retrieve the first name and address city of customers who have placed orders containing a specific product name.


101. Retrieve the first name and last name of customers who have not placed any orders.
102. Get the total number of orders placed by customers with a specific email domain.
103. Find the average total amount of orders placed by customers in each city.
104. Retrieve orders placed on weekends (Saturday and Sunday).
105. Get the total amount of orders placed by customers with a specific area code in their phone number.
106. Find the order date and total amount of orders placed in each year.
107. Retrieve the first name and last name of customers who have placed orders with a total amount greater than the average total amount of all orders.
108. Get the total number of orders placed by customers in each month of a specific year.
109. Find the order date and total amount of orders placed by customers with a specific last name.
110. Retrieve the first name and email address of customers who have placed orders with a total amount less than the average total amount of all orders.

111. Retrieve the first name and phone number of customers who have placed orders with a total amount greater than the average total amount of all orders.
112. Get the total amount of orders placed by customers with a specific address city and state.
113. Find the order date and total amount of orders placed by customers with a specific first name.
114. Retrieve the first name and address postal code of customers who have placed orders with a total amount less than the average total amount of all orders.
115. Get the total amount of orders placed by customers with a specific last name initial.
116. Find the order date and total amount of orders placed by customers with a specific email address.
117. Retrieve the first name and phone number of customers who have placed orders with a total amount greater than the average total amount of all orders.
118. Get the total amount of orders placed by customers with a specific address city and country.
119. Find the order date and total amount of orders placed by customers with a specific phone number.
120. Retrieve the first name and address city of customers who have placed orders with a total amount greater than the average total amount of all orders.

121. Retrieve the first name and last name of customers who have placed orders with a total amount less than the average total amount of all orders.
122. Get the total amount of orders placed by customers with a specific address state and country.
123. Find the order date and total amount of orders placed by customers with a specific address postal code.
124. Retrieve the first name and email address of customers who have placed orders with a total amount greater than the average total amount of all orders.
125. Get the total amount of orders placed by customers with a specific email domain.
126. Find the order date and total amount of orders placed by customers with a specific phone number area code.
127. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
128. Get the total amount of orders placed by customers with a specific address city, state, and country.
129. Find the order date and total amount of orders placed by customers with a specific last name initial.
130. Retrieve the first name and address postal code of customers who have placed orders with a total amount greater than the average total amount of all orders.

131. Retrieve the first name and last name of customers who have placed orders with a total amount greater than the average total amount of all orders.
132. Get the total amount of orders placed by customers with a specific address city, state, and country.
133. Find the order date and total amount of orders placed by customers with a specific email domain.
134. Retrieve the first name and email address of customers who have placed orders with a total amount less than the average total amount of all orders.
135. Get the total amount of orders placed by customers with a specific phone number area code.
136. Find the order date and total amount of orders placed by customers with a specific address city and state.
137. Retrieve the first name and phone number of customers who have placed orders with a total amount greater than the average total amount of all orders.
138. Get the total amount of orders placed by customers with a specific address city, state, and postal code.
139. Find the order date and total amount of orders placed by customers with a specific address city and postal code.
140. Retrieve the first name and address country of customers who have placed orders with a total amount less than the average total amount of all orders.

141. Retrieve the first name and last name of customers who have placed orders with a total amount less than the average total amount of all orders.
142. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
143. Find the order date and total amount of orders placed by customers with a specific address state and postal code.
144. Retrieve the first name and email address of customers who have placed orders with a total amount greater than the average total amount of all orders.
145. Get the total amount of orders placed by customers with a specific address city, postal code, and country.
146. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
147. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
148. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
149. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
150. Retrieve the first name and address city of customers who have placed orders with a total amount greater than the average total amount of all orders.

151. Retrieve the first name and last name of customers who have placed orders with a total amount greater than the average total amount of all orders.
152. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
153. Find the order date and total amount of orders placed by customers with a specific address city, state, and country.
154. Retrieve the first name and email address of customers who have placed orders with a total amount less than the average total amount of all orders.
155. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
156. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
157. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
158. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
159. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
160. Retrieve the first name and address country of customers who have placed orders with a total amount greater than the average total amount of all orders.

161. Retrieve the first name and last name of customers who have placed orders with a total amount less than the average total amount of all orders.
162. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
163. Find the order date and total amount of orders placed by customers with a specific address city, state, and country.
164. Retrieve the first name and email address of customers who have placed orders with a total amount greater than the average total amount of all orders.
165. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
166. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
167. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
168. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
169. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
170. Retrieve the first name and address country of customers who have placed orders with a total amount greater than the average total amount of all orders.

171. Retrieve the first name and last name of customers who have placed orders with a total amount greater than the average total amount of all orders.
172. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
173. Find the order date and total amount of orders placed by customers with a specific address city, state, and country.
174. Retrieve the first name and email address of customers who have placed orders with a total amount less than the average total amount of all orders.
175. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
176. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
177. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
178. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
179. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
180. Retrieve the first name and address country of customers who have placed orders with a total amount greater than the average total amount of all orders.

181. Retrieve the first name and last name of customers who have placed orders with a total amount less than the average total amount of all orders.
182. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
183. Find the order date and total amount of orders placed by customers with a specific address city, state, and country.
184. Retrieve the first name and email address of customers who have placed orders with a total amount greater than the average total amount of all orders.
185. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
186. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
187. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
188. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
189. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
190. Retrieve the first name and address country of customers who have placed orders with a total amount greater than the average total amount of all orders.

191. Retrieve the first name and last name of customers who have placed orders with a total amount greater than the average total amount of all orders.
192. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
193. Find the order date and total amount of orders placed by customers with a specific address city, state, and country.
194. Retrieve the first name and email address of customers who have placed orders with a total amount less than the average total amount of all orders.
195. Get the total amount of orders placed by customers with a specific address city, state, postal code, and country.
196. Find the order date and total amount of orders placed by customers with a specific address city, postal code, and country.
197. Retrieve the first name and phone number of customers who have placed orders with a total amount less than the average total amount of all orders.
198. Get the total amount of orders placed by customers with a specific address state, postal code, and country.
199. Find the order date and total amount of orders placed by customers with a specific address city, state, and postal code.
200. Retrieve the first name and address country of customers who have placed orders with a total amount greater than the average total amount of all orders.

*/





/* ANSWERS */


**Customers Table:**

1. Retrieve all customers' first names and last names.
```sql
SELECT first_name, last_name FROM customers;
```

2. Get the email addresses of customers whose first name starts with 'R'.
```sql
SELECT email FROM customers WHERE first_name LIKE 'R%';
```

3. Find the phone numbers of customers whose last name ends with 'a'.
```sql
SELECT phone_number FROM customers WHERE last_name LIKE '%a';
```

4. Count the total number of customers.
```sql
SELECT COUNT(*) AS total_customers FROM customers;
```

5. Get the details (first name, last name, email, phone number) of the customer with the highest customer_id.
```sql
SELECT first_name, last_name, email, phone_number FROM customers WHERE customer_id = (SELECT MAX(customer_id) FROM customers);
```

6. Find customers who have email addresses containing 'example'.
```sql
SELECT * FROM customers WHERE email LIKE '%example%';
```

7. Retrieve customers who have phone numbers starting with '98'.
```sql
SELECT * FROM customers WHERE phone_number LIKE '98%';
```

8. Get the number of distinct last names among customers.
```sql
SELECT COUNT(DISTINCT last_name) AS distinct_last_names FROM customers;
```

9. Retrieve customers sorted by last name in ascending order.
```sql
SELECT * FROM customers ORDER BY last_name ASC;
```

10. Find customers who do not have an email address specified.
```sql
SELECT * FROM customers WHERE email IS NULL OR email = '';
```



**Addresses Table:**

11. Get all addresses in Mumbai.
```sql
SELECT * FROM addresses WHERE city = 'Mumbai';
```

12. Find the postal code of the address with the highest address_id.
```sql
SELECT postal_code FROM addresses WHERE address_id = (SELECT MAX(address_id) FROM addresses);
```

13. Retrieve addresses in Karnataka.
```sql
SELECT * FROM addresses WHERE state = 'Karnataka';
```

14. Count the total number of addresses.
```sql
SELECT COUNT(*) AS total_addresses FROM addresses;
```

15. Get the country of the address with the lowest address_id.
```sql
SELECT country FROM addresses WHERE address_id = (SELECT MIN(address_id) FROM addresses);
```

16. Find addresses in cities starting with 'D'.
```sql
SELECT * FROM addresses WHERE city LIKE 'D%';
```

17. Retrieve addresses with postal codes ending with '001'.
```sql
SELECT * FROM addresses WHERE postal_code LIKE '%001';
```

18. Get distinct states from the addresses table.
```sql
SELECT DISTINCT state FROM addresses;
```

19. Find addresses in India.
```sql
SELECT * FROM addresses WHERE country = 'India';
```

20. Retrieve addresses sorted by city in descending order.
```sql
SELECT * FROM addresses ORDER BY city DESC;
```



** Order Table **:

21. Retrieve all order IDs.
```sql
SELECT order_id FROM orders;
```

22. Get the total amount of the order with the highest order_id.
```sql
SELECT total_amount FROM orders WHERE order_id = (SELECT MAX(order_id) FROM orders);
```

23. Find orders placed on '2024-03-15'.
```sql
SELECT * FROM orders WHERE order_date = '2024-03-15';
```

24. Count the total number of orders.
```sql
SELECT COUNT(*) AS total_orders FROM orders;
```

25. Get the order date of the order with the lowest order_id.
```sql
SELECT order_date FROM orders WHERE order_id = (SELECT MIN(order_id) FROM orders);
```

26. Find orders with a total amount greater than 1000.00.
```sql
SELECT * FROM orders WHERE total_amount > 1000.00;
```

27. Retrieve orders placed before '2024-03-20'.
```sql
SELECT * FROM orders WHERE order_date < '2024-03-20';
```

28. Get the average total amount of all orders.
```sql
SELECT AVG(total_amount) AS average_total_amount FROM orders;
```

29. Find orders placed by customer_id 3.
```sql
SELECT * FROM orders WHERE customer_id = 3;
```

30. Retrieve orders sorted by total amount in descending order.
```sql
SELECT * FROM orders ORDER BY total_amount DESC;
```


Here are the SQL queries for the remaining questions:

31. Retrieve all order item IDs.
```sql
SELECT order_item_id FROM order_items;
```

32. Get the product names of items with a quantity greater than 2.
```sql
SELECT product_name FROM order_items WHERE quantity > 2;
```

33. Find the total price of all items.
```sql
SELECT SUM(quantity * unit_price) AS total_price FROM order_items;
```

34. Count the total number of order items.
```sql
SELECT COUNT(*) AS total_order_items FROM order_items;
```

35. Get the quantity of the item with the highest order_item_id.
```sql
SELECT quantity FROM order_items WHERE order_item_id = (SELECT MAX(order_item_id) FROM order_items);
```

36. Find items with a unit price less than 200.00.
```sql
SELECT * FROM order_items WHERE unit_price < 200.00;
```

37. Retrieve items with a product name containing 'Product G'.
```sql
SELECT * FROM order_items WHERE product_name LIKE '%Product G%';
```

38. Get the sum of the quantities of all items.
```sql
SELECT SUM(quantity) AS total_quantity FROM order_items;
```

39. Find items with a unit price greater than 500.00.
```sql
SELECT * FROM order_items WHERE unit_price > 500.00;
```

40. Retrieve items sorted by unit price in ascending order.
```sql
SELECT * FROM order_items ORDER BY unit_price ASC;
```

41. Retrieve all customers who have placed an order.
```sql
SELECT DISTINCT c.* FROM customers c INNER JOIN orders o ON c.customer_id = o.customer_id;
```

42. Get the total number of orders placed by each customer.
```sql
SELECT customer_id, COUNT(*) AS total_orders FROM orders GROUP BY customer_id;
```

43. Find the customer who has placed the most orders.
```sql
SELECT customer_id, COUNT(*) AS total_orders FROM orders GROUP BY customer_id ORDER BY total_orders DESC LIMIT 1;
```

44. Retrieve the average total amount of orders placed by each customer.
```sql
SELECT customer_id, AVG(total_amount) AS avg_total_amount FROM orders GROUP BY customer_id;
```

45. Get the customer who has spent the most on orders.
```sql
SELECT customer_id, SUM(total_amount) AS total_spent FROM orders GROUP BY customer_id ORDER BY total_spent DESC LIMIT 1;
```

46. Find the number of orders placed in each city.
```sql
SELECT a.city, COUNT(*) AS total_orders FROM orders o JOIN addresses a ON o.customer_id = a.customer_id GROUP BY a.city;
```

47. Retrieve the highest total amount of orders placed in a single order.
```sql
SELECT MAX(total_amount) AS highest_total_amount FROM orders;
```

48. Get the average quantity of items per order.
```sql
SELECT AVG(quantity) AS average_quantity_per_order FROM order_items;
```

49. Find the customer who has purchased the most items.
```sql
SELECT oi.customer_id, SUM(oi.quantity) AS total_items_purchased FROM order_items oi JOIN orders o ON oi.order_id = o.order_id GROUP BY oi.customer_id ORDER BY total_items_purchased DESC LIMIT 1;
```

50. Retrieve orders placed by customers with a specific email domain (e.g., '@example.com').
```sql
SELECT o.* FROM orders o JOIN customers c ON o.customer_id = c.customer_id WHERE c.email LIKE '%@example.com%';
```





51. **Retrieve the first and last names of customers along with their corresponding addresses.**
```sql
SELECT c.first_name, c.last_name, a.street, a.city, a.state, a.country
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id;
```

52. **Get the total amount of each order along with the corresponding customer''s first name.**
```sql
SELECT o.order_id, c.first_name, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id, c.first_name;
```

53. **Find the average total amount of orders placed in each city.**
```sql
SELECT a.city, AVG(oi.quantity * oi.unit_price) AS avg_total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY a.city;
```

54. **Retrieve orders along with the customer''s phone number and address city.**
```sql
SELECT o.*, c.phone_number, a.city
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id;
```

55. **Get the product names along with their corresponding unit prices.**
```sql
SELECT product_name, unit_price
FROM order_items;
```

56. **Find the total amount of each order along with the customer''s last name.**
```sql
SELECT o.order_id, c.last_name, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id, c.last_name;
```

57. **Retrieve orders placed by customers with a specific area code in their phone number.**
```sql
SELECT o.*
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
WHERE SUBSTRING(c.phone_number, 1, 3) = '123'; -- Replace '123' with the desired area code
```

58. **Get the order date and total amount of orders placed in each state.**
```sql
SELECT a.state, o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY a.state, o.order_date;
```

59. **Find the customer who has placed the most expensive order.**
```sql
SELECT c.first_name, c.last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
ORDER BY SUM(oi.quantity * oi.unit_price) DESC
LIMIT 1;
```

60. **Retrieve orders along with the customer''s first name and last name.**
```sql
SELECT o.*, c.first_name, c.last_name
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id;
```


61. **Retrieve the first name and last name of customers who have placed orders.**
```sql
SELECT DISTINCT c.first_name, c.last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id;
```

62. **Get the total amount of orders placed in each country.**
```sql
SELECT a.country, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY a.country;
```

63. **Find the order date and total amount of orders placed by a specific customer.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.first_name = 'Ramesh' AND c.last_name = 'Kumar' -- Replace with the desired customer''s name
GROUP BY o.order_date;
```

64. **Retrieve the first name and email address of customers who have placed orders.**
```sql
SELECT DISTINCT c.first_name, c.email
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id;
```

65. **Get the order date and total amount of orders placed by a customer with a specific email address.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.email = 'suresh@example.com' -- Replace with the desired email address
GROUP BY o.order_date;
```

66. **Find the customer who has placed the least expensive order.**
```sql
SELECT c.first_name, c.last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
ORDER BY SUM(oi.quantity * oi.unit_price) ASC
LIMIT 1;
```

67. **Retrieve the first name and phone number of customers who have placed orders.**
```sql
SELECT DISTINCT c.first_name, c.phone_number
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id;
```

68. **Get the total number of orders placed in each month.**
```sql
SELECT MONTH(order_date) AS month, COUNT(*) AS total_orders
FROM orders
GROUP BY MONTH(order_date);
```

69. **Find the order date and total amount of orders placed by a customer with a specific phone number.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.phone_number = '9876543210' -- Replace with the desired phone number
GROUP BY o.order_date;
```

70. **Retrieve the first name and address city of customers who have placed orders.**
```sql
SELECT DISTINCT c.first_name, a.city
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id;
```



71. **Retrieve the first name and last name of customers who have placed orders in Maharashtra.**
```sql
SELECT DISTINCT c.first_name, c.last_name
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE a.state = 'Maharashtra';
```

72. **Get the total number of orders placed in each city.**
```sql
SELECT a.city, COUNT(o.order_id) AS total_orders
FROM addresses a
INNER JOIN orders o ON a.customer_id = o.customer_id
GROUP BY a.city;
```

73. **Find the order date and total amount of orders placed in Bangalore.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.city = 'Bangalore'
GROUP BY o.order_date;
```

74. **Retrieve the first name and email address of customers who have placed orders in Delhi.**
```sql
SELECT DISTINCT c.first_name, c.email
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE a.city = 'Delhi';
```

75. **Get the total number of orders placed in each state.**
```sql
SELECT a.state, COUNT(o.order_id) AS total_orders
FROM addresses a
INNER JOIN orders o ON a.customer_id = o.customer_id
GROUP BY a.state;
```

76. **Find the order date and total amount of orders placed in Tamil Nadu.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.state = 'Tamil Nadu'
GROUP BY o.order_date;
```

77. **Retrieve the first name and phone number of customers who have placed orders in Mumbai.**
```sql
SELECT DISTINCT c.first_name, c.phone_number
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE a.city = 'Mumbai';
```

78. **Get the total number of orders placed in each country.**
```sql
SELECT a.country, COUNT(o.order_id) AS total_orders
FROM addresses a
INNER JOIN orders o ON a.customer_id = o.customer_id
GROUP BY a.country;
```

79. **Find the order date and total amount of orders placed in West Bengal.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.state = 'West Bengal'
GROUP BY o.order_date;
```

80. **Retrieve the first name and address postal code of customers who have placed orders in Chennai.**
```sql
SELECT DISTINCT c.first_name, a.postal_code
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE a.city = 'Chennai';
```


81. **Retrieve the first name and last name of customers who have placed orders with a total amount greater than 1000.00.**
```sql
SELECT DISTINCT c.first_name, c.last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
HAVING SUM(oi.quantity * oi.unit_price) > 1000.00;
```

82. **Get the total amount of orders placed by customers with a specific last name.**
```sql
SELECT c.last_name, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.last_name = 'Kumar' -- Replace with the desired last name
GROUP BY c.last_name;
```

83. **Find the order date and total amount of orders placed by customers with a specific first name.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.first_name = 'Ramesh' -- Replace with the desired first name
GROUP BY o.order_date;
```

84. **Retrieve the first name and email address of customers who have placed orders with a total amount less than 500.00.**
```sql
SELECT DISTINCT c.first_name, c.email
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
HAVING SUM(oi.quantity * oi.unit_price) < 500.00;
```

85. **Get the total amount of orders placed by customers with a specific phone number.**
```sql
SELECT c.phone_number, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.phone_number = '9876543210' -- Replace with the desired phone number
GROUP BY c.phone_number;
```

86. **Find the order date and total amount of orders placed by customers with a specific email address.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE c.email = 'ramesh@example.com' -- Replace with the desired email address
GROUP BY o.order_date;
```

87. **Retrieve the first name and phone number of customers who have placed orders with a total amount greater than 750.00.**
```sql
SELECT DISTINCT c.first_name, c.phone_number
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
HAVING SUM(oi.quantity * oi.unit_price) > 750.00;
```

88. **Get the total amount of orders placed by customers with a specific address city.**
```sql
SELECT a.city, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM addresses a
INNER JOIN orders o ON a.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.city = 'Mumbai' -- Replace with the desired city
GROUP BY a.city;
```

89. **Find the order date and total amount of orders placed by customers with a specific address state.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.state = 'Maharashtra' -- Replace with the desired state
GROUP BY o.order_date;
```

90. **Retrieve the first name and address postal code of customers who have placed orders with a total amount less than 600.00.**
```sql
SELECT DISTINCT c.first_name, a.postal_code
FROM customers c
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY c.customer_id
HAVING SUM(oi.quantity * oi.unit_price) < 600.00;
```


91. **Retrieve the first name and last name of customers who have placed orders containing a specific product name.**
```sql
SELECT DISTINCT c.first_name, c.last_name
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE oi.product_name = 'Product A'; -- Replace with the desired product name
```

92. **Get the total amount of orders placed by customers with a specific address postal code.**
```sql
SELECT a.postal_code, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM addresses a
INNER JOIN orders o ON a.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.postal_code = '400001' -- Replace with the desired postal code
GROUP BY a.postal_code;
```

93. **Find the order date and total amount of orders placed by customers with a specific address country.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE a.country = 'India' -- Replace with the desired country
GROUP BY o.order_date;
```

94. **Retrieve the first name and email address of customers who have placed orders containing a specific product name.**
```sql
SELECT DISTINCT c.first_name, c.email
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE oi.product_name = 'Product B'; -- Replace with the desired product name
```

95. **Get the total amount of orders placed by customers with a specific email domain.**
```sql
SELECT SUBSTRING_INDEX(c.email, '@', -1) AS email_domain, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE SUBSTRING_INDEX(c.email, '@', -1) = 'example.com' -- Replace with the desired email domain
GROUP BY email_domain;
```

96. **Find the order date and total amount of orders placed by customers with a specific phone number area code.**
```sql
SELECT o.order_date, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE SUBSTRING(c.phone_number, 1, 3) = '987' -- Replace with the desired area code
GROUP BY o.order_date;
```

97. **Retrieve the first name and phone number of customers who have placed orders containing a specific product name.**
```sql
SELECT DISTINCT c.first_name, c.phone_number
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE oi.product_name = 'Product C'; -- Replace with the desired product name
```

98. **Get the total amount of orders placed by customers with a specific last name initial.**
```sql
SELECT LEFT(c.last_name, 1) AS last_name_initial, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE LEFT(c.last_name, 1) = 'S' -- Replace with the desired last name initial
GROUP BY last_name_initial;
```

99. **Find the order date and total amount of orders placed by customers with a specific first name initial.**
```sql
SELECT LEFT(c.first_name, 1) AS first_name_initial, SUM(oi.quantity * oi.unit_price) AS total_amount
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE LEFT(c.first_name, 1) = 'R' -- Replace with the desired first name initial
GROUP BY first_name_initial;
```

100. **Retrieve the first name and address city of customers who have placed orders containing a specific product name.**
```sql
SELECT DISTINCT c.first_name, a.city
FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
INNER JOIN addresses a ON c.customer_id = a.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
WHERE oi.product_name = 'Product D'; -- Replace with the desired product name
```

