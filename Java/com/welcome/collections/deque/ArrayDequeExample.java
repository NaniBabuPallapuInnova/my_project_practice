package com.welcome.collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");
        deque.add("Nani");
        deque.add("Ganesh");

        //Traversing elements
        for (String str : deque) {
            System.out.println(str);
        }
    }
}
