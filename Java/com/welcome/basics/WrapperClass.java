package com.welcome.basics;

/**
 * The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.
 *
 * Autoboxing : Converting the Primitives into Objects is known as Autoboxing.
 * Unboxing : Converting the Objects into Primitives is known as Unboxing.
 */
public class WrapperClass {

    public static void main(String[] args) {

        // Autoboxing

        int a = 6;
        Integer value1 = Integer.valueOf(a); //converting int into Integer explicitly
        Integer value2 = a; //autoboxing, now compiler will write Integer.valueOf(a) internally
        System.out.println(value1+"   "+value2);

        //Unboxing
        Integer value3 = new Integer(5);
        int value4 = value3.intValue(); //converting Integer to int explicitly
        int value5 = value3; //unboxing, now compiler will write a.intValue() internally
        System.out.println(value4+"   "+value5);

    }
}
