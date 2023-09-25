package com.welcome.collections.set;

import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> al= new LinkedHashSet<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi"); // can not accept duplicates
        al.add("Ajay");
        //Traversing elements
        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
