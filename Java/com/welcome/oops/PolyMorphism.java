package com.welcome.oops;

/**
 * Compile time polymorphism : If you overload a static method in java , it is called compile time polymorphism.
 */

class MethodOverloading {

    public static void add(int a, int b) {
        System.out.println("A+B(int) = " + (a + b));
    }

    public static void add(double a, double b) {
        System.out.println("A+B(double) = " + (a + b));
    }

    public static void add(int a, int b, int c) {
        System.out.println("A+B+C(int) = " + (a + b + c));
    }

    public static void add(double a, double b, double c) {
        System.out.println("A+B+C(double) = " + (a + b + c));
    }

}

/**
 * Method overriding is an example of runtime polymorphism. In method overriding, a subclass overrides a method with the same signature as that of in its superclass. During compile time, the check is made on the reference type.
 * However, in the runtime, JVM figures out the object type and would run the method that belongs to that particular object.
 * In this process, an overridden method is called through the reference variable of a superclass.
 * The determination of the method to be called is based on the object being referred to by the reference variable.
 */
class Calculate {
    public void calculating(int a, int b) {
        System.out.println("Multiplication : A*B(int) = " + (a * b));
    }

    public void calculating(int a, int b, int c) {
        System.out.println("Multiplication :  A*B*C(int) = " + (a * b * c));
    }
}

class RuntimePolymorphism extends Calculate {

    public void calculating(int a, int b) {
        System.out.println("Addition : A+B(int) = " + (a + b));
    }

    public void calculating(int a, int b, int c) {
        System.out.println(" Addition : A+B+C(int) = " + (a + b + c));
    }

    public void downCastingMethod(Calculate calculate) {
        RuntimePolymorphism calculate1 = (RuntimePolymorphism) calculate;
        System.out.println("======= DownCasting ====== : ");
        calculate1.calculating(3, 4);
    }

}

public class PolyMorphism {

    public static void main(String[] args) {

        // MethodOverloading(Compile-Time Polymorphism)
        MethodOverloading.add(5, 4);
        MethodOverloading.add(5.5, 5);
        MethodOverloading.add(3, 4, 5);
        MethodOverloading.add(3.5, 4, 5);

        System.out.println("\n");

        /**
         * Runtime Polymorphism
         * Upcasting : If the reference variable of Parent class refers to the object of Child class, it is known as upcasting.
         * Down-Casting : When Subclass type refers to the object of Parent class, it is known as down-casting. If we perform it directly, compiler gives Compilation error. If you perform it by typecasting, ClassCastException is thrown at runtime. But if we use instanceof operator, down-casting is possible.
         */
        Calculate upCasting = new RuntimePolymorphism(); // upcasting
        upCasting.calculating(15, 4);
        upCasting.calculating(13, 4, 5);

        System.out.println("\n");

        RuntimePolymorphism downCasting = new RuntimePolymorphism();
        downCasting.downCastingMethod(upCasting);

    }

}
