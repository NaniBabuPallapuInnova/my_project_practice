package mypractice.com.programs_practice.arrays_programs;

import java.util.HashMap;
import java.util.Map;

/**
 * Writing a program to find how many times each element in the array is repeated.
 */
public class FrequencyOfEachElements {
    public static void main(String[] args) {
//        int[] array = new int[]{1,2,3,4,2,2,2,4,4,1,3};
        String s = "india";
        char[] array = s.toCharArray();
        int[] frequency = new int[array.length];
        int visited = -1;
        for(int i=0;i<array.length;i++){
            int count =1;
            for(int j=i+1;j<array.length;j++) {
                if(array[i] == array[j]){
                    count++;
                    frequency[j] = visited; // it keeps the -1 value in index j position

                }
            }
            if(frequency[i]!=visited){
                frequency[i] = count;
            }
        }

        for(int i=0;i<frequency.length;i++){
            if(frequency[i]!=visited){
                System.out.println(array[i]+" "+frequency[i]);
            }
        }


        /**
         * Code Optimization
         */
//        int[] array = new int[]{1,2,3,4,2,2,2,4,4,1,3};
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : array){
//            map.put(num, map.getOrDefault(num, 0)+1);
//        }
//
//        map.forEach((key, value) -> {
//            if(value > 1){
//                System.out.println(key+" repeated "+value);
//            }
//        });

    }
}
