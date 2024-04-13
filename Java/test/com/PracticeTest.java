package test.com;


import mypractice.com.collections.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PracticeTest {

    public static void main(String[] args) {

        // 1. Supplier
        Supplier<Double> value = () -> Math.random();
        System.out.println(value.get());

        // 2. Function

        Function<String, Integer> function = string -> string.length(); //it gives 5

        function = function.andThen(data -> 3 * data); // (5 * 3) = 15

        function = function.compose(element -> 3 + element);

        System.out.println(function.apply("Hello"));

        // 3. Predicate interface

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(10));

        // 4. Consumer Interface

        Consumer<Integer> consumer = element -> System.out.println(element);

        consumer.accept(10);

        Consumer<List<Student>> listConsumer = student -> System.out.println(student);

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nani", 25));
        students.add(new Student(2, "Babu", 30));
        students.add(new Student(3, "Priya", 40));
        students.add(new Student(4, "Praneetha", 50));

        listConsumer.accept(students);

    }

}
