package com.welcome.oops;

/**
 * Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.
 * The idea behind inheritance in Java is that you can create new classes that are built upon existing classes.
 * When you inherit from an existing class, you can reuse methods and fields of the parent class.
 * Moreover, you can add new methods and fields in your current class also.
 * Uses: Runtime Polymorphism(Method Overloading) can be achieved and code re-usability.
 */

/**
 * Single Inheritance : When a class inherits another class, it is known as a single inheritance.
 */
class Animal {
    public void eat(){
        System.out.println("---- Animal is Eating -----");
    }
}
class Dog extends Animal {
    public void bark(){
        System.out.println("--- This dog is barking ----");
    }
}

/**
 * Multi-level Inheritance : When there is a chain of inheritance, it is known as multilevel inheritance.
 */
class Father{
    int fatherPropertyCost = 10000;
    int total = 0;
    public void fatherPropertyCalculate(){
        total = fatherPropertyCost;
        System.out.println("--- Father has "+total+" property ----");
    }
}
class Son extends Father{
    int sonPropertyCost = 200000;
    public void sonPropertyCalculation(){
         total = total+sonPropertyCost;
         System.out.println("---- Son has "+total+" Property ----");
    }
}
class GrandSon extends Son{
    int grandSonPropertyCost = 500000;

    public void grandSonPropertyCalculation(){
        total = total+grandSonPropertyCost;
        System.out.println("---- GrandSon has "+total+" property ----");
    }
}


/**
 * Hierarchical Inheritance : When two or more classes inherits a single class, it is known as hierarchical inheritance.
 */
class Vehicle{
    public void run(){
        System.out.println("Vehicle is running");
    }
}
class Car extends Vehicle{
    public void run(){
        System.out.println("Car is running");
    }
    public void carDrive(){
        System.out.println("Driving the car");
    }
}
class Bike extends Vehicle{
    public void run(){
        System.out.println("Bike is running");
    }
    public void bikeDrive(){
        System.out.println("Driving the bike");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        // Single Inheritance
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        System.out.println("\n"+"\n"); // print 2 empty lines

        // Multi-Level Inheritance
        GrandSon grandSon = new GrandSon();
        grandSon.fatherPropertyCalculate();
        grandSon.sonPropertyCalculation();
        grandSon.grandSonPropertyCalculation();

        // Hierarchical Inheritance
        Bike bike = new Bike();
        bike.run();
        bike.bikeDrive();
    }
}
