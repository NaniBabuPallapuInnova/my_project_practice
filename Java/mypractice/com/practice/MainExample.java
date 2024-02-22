package mypractice.com.practice;

import java.util.HashSet;
import java.util.Set;

/**
 [4:26 PM] Puspendu Patel
 [ 5,8,2,4,3,9,8,3,4,8]
 */

public class MainExample {

    public static void  calculate(int[] array, int key){

        Set<Integer> integerSet = new HashSet<>();

        for(int i : array){
            int complement= key - i;
            if(integerSet.contains(complement)){
                System.out.println("value1 = "+complement+" , "+" Value2 = "+i);
                return;
            }
            integerSet.add(i);
        }
        System.out.println("No Pair Found for the given key");

        /*
        for(int i=0; i<array.length;i++){
            int sum = 0;
            for(int j=i+1;j<array.length;j++){
                sum =  array[i]+array[j];
                if(sum == key){
                    System.out.println("value 1 "+array[i]+" , "+" Value 2 "+array[j]);
                }
            }
        }*/

    }

    public static void main(String[] args) {

        int[] array = { 5,8,2,4,3,9,8,3,4,8};
        int key = 17;
        calculate(array, key);
    }
}
