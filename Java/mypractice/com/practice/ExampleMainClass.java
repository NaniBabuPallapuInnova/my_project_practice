package mypractice.com.practice;

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class ElectricEngine extends Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started");
    }
}

class Car {
    private Engine engine; // Car accepts an Engine from the outside.

    public Car() {
        // With Dependency Injection: Car accepts an Engine from the outside.
        this.engine = new Engine(); // Each Car uses the provided Engine.
    }

    public void start() {
        engine.start(); // Use the provided engine to start the Car.
        System.out.println("Car started");
    }
}

class Bike {
    private Engine engine; // Bike accepts an Engine from the outside.

    public Bike() {
        // With Dependency Injection: Bike accepts an Engine from the outside.
        this.engine = new Engine(); // Each Bike uses the provided Engine.
    }

    public void start() {
        engine.start(); // Use the provided engine to start the Bike.
        System.out.println("Bike started");
    }
}

public class ExampleMainClass {
    public static void main(String[] args) {
//        Engine electricEngine = new ElectricEngine(); // Create an ElectricEngine externally.

        Car car = new Car(); // Car receives an ElectricEngine through injection.
        Bike bike = new Bike(); // Bike receives the same ElectricEngine.

        car.start(); // Start the Car.
        bike.start(); // Start the Bike.
    }
}
