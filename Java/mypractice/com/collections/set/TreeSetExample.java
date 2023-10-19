package mypractice.com.collections.set;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
//        Set<String> set= new TreeSet<>(); // it won't work for    Iterator iterator=set.descendingIterator();

        TreeSet<String> set= new TreeSet<>();
        set.add("Ravi");
        set.add("Ajay");
        set.add("Vijay");
        set.add("Ravi"); // can not accept duplicates
        //Traversing elements
        Iterator<String> itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("\n");

        System.out.println("==== DESCENDING ORDER ====");
        Iterator iterator=set.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
