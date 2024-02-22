package mypractice.com.collections.programs_on_collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateHashMapUsingEntrySet {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(101, "Andhra Pradesh");
        hashMap.put(105,"Bangladesh");
        hashMap.put(104, "Chennai");
        hashMap.put(102, "TamilNadu");
        hashMap.put(103, "Kerala");
        hashMap.put(107,"Karnataka");
        hashMap.put(107,"Odisha"); // the key value will be replaced if add duplicate entry with key.(Karnataka --> Odisha)
        System.out.println("\n");

        System.out.println(hashMap);

        System.out.println(hashMap.entrySet()); // Using entrySet() to get the set view like ==> []

        System.out.println(hashMap.keySet()); // will give keys
        System.out.println(hashMap.get(103)); // will give keys




        System.out.println("\n");

        // Method 1: Iterating HashMap through for loop
        for(Map.Entry<Integer, String> map : hashMap.entrySet()){
            System.out.println(map.getKey()+" "+map.getValue());
        }

        System.out.println("\n");

        // Method 2: Using a forEach to iterate through a HashMap
        hashMap.forEach((key, value) -> System.out.println(key+" "+value));

        //Method 3: Using an iterator to iterate through a HashMap.
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();

        // Iterating over entries
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Method 5: Loop through a HashMap using Stream API
        hashMap.entrySet().stream()
                .forEach(input -> System.out.println(input.getKey()+" : "+input.getValue()));





    }
}
