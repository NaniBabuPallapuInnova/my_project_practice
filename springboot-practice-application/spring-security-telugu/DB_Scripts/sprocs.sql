--STORED PROCEDURE - 1
--writing a stored procedure to get employees based on email and
--below stored procedure is called when i execute call this "call security_telugu.usp_search_employee('nanipallapu369@gmail.com')" from db

DELIMITER //
CREATE PROCEDURE usp_search_employee(
    IN emp_email VARCHAR(255)
)
BEGIN
    IF emp_email IS NULL THEN
        SELECT * FROM employee;
    ELSE
        SELECT * FROM employee WHERE email = emp_email;
    END IF;
END //
DELIMITER ;

CALL usp_search_employee('employee@example.com');




