package junit_practice.on_collections;

import java.util.*;

class Employee{
    private int id;
    private String name;
    private double salary;
    private int age;


    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age='" + age + '\'' +
                '}';
    }
}
public class SampleOnCollections {
    public static List<Integer> removeDuplicates(int[] array){

        List<Integer> list = new ArrayList<>();

        for(int value : array){
            if(!list.contains(value)){
                list.add(value);
            }
        }
        return list;
    }

    public static int sumOfElementInArray(int[] array){

        return Arrays.stream(array).sum();
    }

    public static Employee highestSalaryEmployeeDetails(List<Employee> employees){

        Optional<Employee> employee = employees.stream()
                .max(Comparator.comparingDouble(Employee :: getSalary));
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }

}
