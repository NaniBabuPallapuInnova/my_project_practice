package mypractice.com.collections.list;

import mypractice.com.collections.Student;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample2 {
    public static void main(String[] args) {

        List<Student> studentsList = new ArrayList<>();

/*
        //Creating user-defined class objects - method 1
        Student s1 = new Student(1, "Nani",25);
        Student s2 = new Student(2, "Priya",21);
        Student s3 = new Student(3, "Madhu",20);

        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        */

        //creating user-defined class objects - method 2
        studentsList.add(new Student(1, "Nani",25));
        studentsList.add(new Student(2, "Priya",21));
        studentsList.add(new Student(3, "Madhu",20));
        studentsList.add(new Student(4, "Stalin",30));

        for(Student student : studentsList){
            System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
        }



    }
}
