//package mypractice.com.practice;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//class Employee implements Comparable<Employees>{
//    private int id;
//    private String name;
//    private int age;
//
//    public Employee() {
//    }
//
//    public Employee(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Employees employee) {
//        int value =Integer.compare(this.age, employee.age);
//        System.out.println("value = "+value);
//        return value;
//
//    }
//}
//public class SortingProblem {
//
//    public static void main(String[] args) {
//        List<Employees> employeeList = new ArrayList<>();
//        employeeList.add(new Employees(1, "Harish", 25));
//        employeeList.add(new Employees(2, "Nani", 22));
//        employeeList.add(new Employees(3, "Amal", 21));
//        employeeList.add(new Employees(4, "Ramesh", 26));
//
//        Collections.sort(employeeList);
//        employeeList.forEach(employee -> System.out.println(employee.toString()));
//
//        System.out.println("\n\n\n");
//        Comparator<Employees> nameSort = Comparator.comparing(employee -> employee.getName());
//
//        employeeList.sort(nameSort);
//        employeeList.forEach(employee -> System.out.println(employee.toString()));
//
//        System.out.println("\n\n\n");
//
//        List<Employees> sorting = employeeList.stream().sorted(Comparator.comparingInt(Employees::getId)).toList();
//        sorting.forEach(employee -> System.out.println(employee.toString()));
//
//    }
//}
