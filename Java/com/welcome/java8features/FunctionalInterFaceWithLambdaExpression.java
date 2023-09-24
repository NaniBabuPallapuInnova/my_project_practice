package com.welcome.java8features;

import java.util.ArrayList;
import java.util.List;

/**
 * To make the interface as functional interface, we should annotate the interface with @FunctionalInterface
 * Java Lambda Expression Example: Multiple Statements
 */
@FunctionalInterface
interface Customer{
    String sendingMessage(String message);

}

public class FunctionalInterFaceWithLambdaExpression {
    public static void main(String[] args) {


        Customer customer = (message) -> {
            String messageData = "Welcome to ";
            String fullMessage = messageData+message;
            return fullMessage;
        };
        System.out.println(customer.sendingMessage("My World"));

    }
}
