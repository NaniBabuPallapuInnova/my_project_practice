package mypractice.com.programs_practice.arrays_programs;

import java.util.Arrays;

public class CopyingArray {
    public static void main(String[] args) {
        int[] array1 = new int[]{3,4,5,6,7,8,9};
        int[] array2 = new int[array1.length];

        for(int i=0;i<array1.length;i++){
            array2[i] = array1[i];
        }

//        array2 = Arrays.copyOf(array1, array1.length);  // Copying Arrays using Array.copy() method.

        System.out.println("===PRINTING 2nd ARRAY ===");
        for(int i : array2){
            System.out.print(i+" ");
        }
    }
}
