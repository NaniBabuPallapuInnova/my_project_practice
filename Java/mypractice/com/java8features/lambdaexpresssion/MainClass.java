package mypractice.com.java8features.lambdaexpresssion;

/**
 * Why we use Lambda Expression?
 * 1. To provide the implementation of Functional interface.
 * 2. Less coding.
 */

@FunctionalInterface
interface Drive {
     void driving(String name, String carName);
}

public class MainClass {
    public static void main(String[] args) {
        int kmph = 80;

//        // Providing implementation using Anonymous class for Drive(interface)
//
//        Drive drive = new Drive() {
//
//            @Override
//            public void driving(){
//                System.out.println("=========== Driving the car "+kmph+ " Kilo Meter Per Hour ===========");
//            }
//        };

        // Providing implementation using Lambda Expression instead of  Anonymous class for Drive(interface)
        // body with two arguments list
        Drive drive = (name, car) -> {
                System.out.println("=========== "+name+" is driving the "+car + kmph+ " Kilo Meter Per Hour ===========");
        };

        drive.driving("Nani", "Sports Car"); // passing two arguments to Lambda expression.
    }
}
