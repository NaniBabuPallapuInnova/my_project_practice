package com.welcome.collections.list;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vec = new Vector<String>();
        //Adding elements using add() method of List
        vec.add("Tiger");
        vec.add("Lion");
        vec.add("Dog");
        vec.add("Elephant");
        vec.add("Lion");
        System.out.println(vec);
    }
}
