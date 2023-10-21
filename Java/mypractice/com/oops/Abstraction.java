package mypractice.com.oops;


/**
 * Abstract class : A class which is declared as abstract is known as an abstract class. It can have abstract and non-abstract methods.
 * It needs to be extended and its method implemented. It cannot be instantiated.
 */
abstract class Bank {
    private int value = 10;

    abstract void balance(); // abstract method should not have method body.

    Bank() {
        System.out.println("====== Bank constructor is calling first ======" + value);
    }

    void interest() {
        System.out.println("====== Usually banks give 10% interest ======"); // it should be overridden.
    }
}

class Sbi extends Bank {

    @Override
    void balance() {
        System.out.println("====== SBI bank give 11% interest ======");
    }
}

class Hdfc extends Bank {

    @Override
    void balance() {
        System.out.println("====== Hdfc bank give 13% interest ======");

    }
}

/**
 * An interface in Java is a blueprint of a class. It has static constants and abstract methods.
 * The interface in Java is a mechanism to achieve abstraction. There can be only abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in Java.
 * In other words, you can say that interfaces can have abstract methods and variables. It cannot have a method body.
 *
 *
 * An interface is declared by using the interface keyword.
 * It provides total abstraction; means all the methods in an interface are declared with the empty body, and all the fields are public, static and final by default. A class that implements an interface must implement all the methods declared in the interface.
 */

interface Games{
    void play();
}
interface Education{
    void study();
}
class Student implements Education, Games{ // this is multiple interface.

    @Override
    public void study() {
        System.out.println("======= Student is studying =======");
    }
    @Override
    public void play() {
        System.out.println("======= Student is playing =======");
    }
}
/**
 * Abstraction is a process of hiding the implementation details and showing only functionality to the user.
 * Another way, it shows only essential things to the user and hides the internal details, for example, sending SMS where you type the text and send the message. You don't know the internal processing about the message delivery.
 * Abstraction lets you focus on what the object does instead of how it does it.
 * There are two ways to achieve abstraction in java : 1. Abstract class(0-100%) 2. Interface(100%)
 */

public class Abstraction {

    public static void main(String[] args) {
        // Abstract class Example
        Bank bank;
        bank = new Sbi();
        bank.balance();
        bank.interest();

        bank = new Hdfc();
        bank.balance();
        bank.interest();

        System.out.println("\n");

        // Interface example  - multiple inheritance has been achieved.
        Games games = new Student();
        games.play(); // access only play() method

        Education education = new Student();
        education.study();  // access only study() method

        Student student = new Student();
        student.study(); //   access only play() and study() methods
        student.play();
    }
}
