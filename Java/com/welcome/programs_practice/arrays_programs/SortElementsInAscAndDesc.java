package com.welcome.programs_practice.arrays_programs;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Sort An Array in Ascending and Descending Order.
 *  If We need to print the third or second or Nth largest element in the array, We need to sort the array first.
 */
public class SortElementsInAscAndDesc {

    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("======= ENTER SIZE =======");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("======= ENTER "+size+" ELEMENTS =======");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i : array) {
            System.out.print(i +"  ");
        }
*/

        int[] array1 = new int[]{3, 4, 2, 8, 10, 22, 5, 6, 7, 8, 9};

        int temp1 = 0;

        System.out.println("==== SORTING IN ASCENDING ORDER ========");
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                if (array1[i] > array1[j]) {
                    temp1 = array1[i];
                    array1[i] = array1[j];
                    array1[j] = temp1;
                }
            }
        }
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(" 3rd LARGEST NUMBER IN ARRAY : "+array1[array1.length-3]);
        System.out.println(" 2nd LARGEST NUMBER IN ARRAY : "+array1[array1.length-2]);


        System.out.println("\n");
        int[] array2 = new int[]{3, 4, 2, 8, 10, 22, 5, 6, 7, 8, 9};

        System.out.println("==== SORTING IN DESCENDING ORDER ========");
        int temp2 = 0;
        for (int i = 0; i < array2.length; i++) {
            for (int j = i + 1; j < array2.length; j++) {
                if (array2[i] < array2[j]) {
                    temp2 = array2[i];
                    array2[i] = array2[j];
                    array2[j] = temp2;
                }
            }
        }

        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

    }
}
