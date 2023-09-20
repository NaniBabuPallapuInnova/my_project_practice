package com.welcome.programs_practice.arrays_programs;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array1 = new int[]{3,4,5,6,7,8,9};

        for(int i=array1.length-1;i>=0;i--){
            System.out.print(array1[i]);
        }
    }


}
