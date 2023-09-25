package com.welcome.collections.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> names=new LinkedList<>();
        System.out.println("Initial list of elements: ");
        names.add("Ravi");
        names.add("Vijay");
        names.add("Ajay");
        for(String name : names){
            System.out.print(name+" ");
        }

        System.out.println("\n");

        // converting Array to LinkedList array;
        String[] array={"Java","Python","PHP","C++"};
        List<String> list = new LinkedList<>();
        for(String course : array){
            list.add(course);
        }
        list.forEach(language -> {
            System.out.print(language+" ");
        });
        System.out.println("\n");

        // converting LinkedList to Array;

        String[] courses = list.toArray(new String[list.size()]);
        for (String course : courses){
            System.out.print(course+" ");

        }



    }
}
