package mypractice.com.programs_practice;

import java.util.Calendar;

/**
 * Q. You have a table named Orders with the following columns
 * <p>
 * order_id (unique identifier for each order)
 * order_date (date when the order was placed)
 * customer_id (identifier for the customer who placed the order)
 * total_amount (total amount of the order)
 * Write a SQL query to find the total revenue generated per month for the year 2023.
 */


public class AlmostCompleteBinaryTree {

    public static int  sum(int num){
       return num * (num +1)/2;
    }

    public static void main(String[] args) {

        int sum = 0;
        for(int i=1;i<=10;i++){
            sum = sum+i;
        }
        System.out.println(sum);
        System.out.println(sum(10));


    }
}

