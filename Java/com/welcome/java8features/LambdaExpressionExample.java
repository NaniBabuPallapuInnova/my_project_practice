package com.welcome.java8features;

/**
 * Lambda expression is a new and important feature of Java which was included in Java SE 8.
 * It provides a clear and concise way to represent one method interface using an expression.
 * It is very useful in collection library. It helps to iterate, filter and extract data from collection.
 *
 * The Lambda expression is used to provide the implementation of an interface which has functional interface.
 * It saves a lot of code. In case of lambda expression, we don't need to define the method again for providing the implementation.
 * Here, we just write the implementation code.
 *
 * Java lambda expression is treated as a function, so compiler does not create .class file.
 * Syntax: (argument-list) -> {body} :  parameter -> expression
 * Syntax 2 : (parameter1, parameter2) -> expression
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Functional Interface :
 * Lambda expression provides implementation of functional interface. An interface which has only one abstract method is called functional interface.
 * Java provides an annotation @FunctionalInterface, which is used to declare an interface as functional interface.
 */
public class LambdaExpressionExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Nani");
        names.add("Pinky");
        names.add("Hema");
        names.add("Suresh");
        names.add("Ramesh");

        // For loop
        System.out.println("===== USING FOR LOOP =======");

        for(String name : names){
            System.out.print(name+ " ");
        }

        // forEach loop with Lambda expression.
        System.out.println("===== USING FOREACH LOOP with Lambda Expression =======");
        names.forEach(
                name -> { System.out.print(name+" ");}
        );


    }
}
