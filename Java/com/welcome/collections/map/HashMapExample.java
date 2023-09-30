package com.welcome.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Mango");  //Put elements in Map
        map.put(2,"Apple");
        map.put(3,"Banana");
        map.put(4,"Grapes");
        map.put(2,"Orange"); // Apple will be replaced as Orange because of duplicate

        for(Map.Entry mapEntry : map.entrySet()){
            System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
        }
    }
}
