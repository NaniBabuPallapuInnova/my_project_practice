use practice;
show tables;
select * from customer;
select * from employee;
select * from product;




DELIMITER //
CREATE PROCEDURE sample( in id bigint,  IN expiry_date  varchar(255),  IN product_name  varchar(255), IN product_price  double)
BEGIN
INSERT INTO product VALUES(id, expiry_date, product_name, product_price);
END //
DELIMITER ;


