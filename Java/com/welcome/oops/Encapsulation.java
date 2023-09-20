package com.welcome.oops;

/**
 * Encapsulation in Java
 * Encapsulation in Java is a process of wrapping code and data together into a single unit, for example, a capsule which is mixed of several medicines.
 * <p>
 * We can create a fully encapsulated class in Java by making all the data members of the class private. Now we can use setter and getter methods to set and get the data in it.
 * <p>
 * The Java Bean class is the example of a fully encapsulated class.
 * <p>
 * Advantage of Encapsulation in Java
 * By providing only a setter or getter method, you can make the class read-only or write-only. In other words, you can skip the getter or setter methods.
 */

class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee() {

    }

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Encapsulation {
    public static void main(String[] args) {

        /* Assigning values using setters and getters */
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Nani Babu");
        employee.setSalary(10000.50);

        System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
        System.out.println(employee); // by default calling toString method.

        /* Assigning values using parameterized constructor */
        Employee employee1 = new Employee(2,"Priya",20000.5);
        System.out.println(employee1);

    }
}
