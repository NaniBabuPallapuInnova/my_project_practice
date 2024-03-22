package mypractice.com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class TestingApp {
    public static void program(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : array){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        map.forEach((key, value) -> System.out.println(key+" repeated "+value));

    }

    public static void main(String[] args) {

        int[] array = {3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 2, 2, 2};
        program(array);
    }
}
