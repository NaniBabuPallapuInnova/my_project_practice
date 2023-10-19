package mypractice.com.programs_practice.arrays_programs;

import java.util.Arrays;

/**
 * Printing whose elements have duplicates.
 * Remove duplicate elements in array and print the array.
 */
public class DuplicateElements {
    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 6, 8, 7, 4, 2, 2, 2, 4, 4, 6, 7, 3};
        int[] array = {10, 70, 30, 90, 20, 20, 30, 40, 70, 50};//unsorted array


        int[] duplicateCount = new int[array.length];

        int visited = -1;
        System.out.println("==== Printing whose elements have duplicates ====");
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    array[j] = visited;
                }
            }

            //Printing whose elements have duplicates
            if (array[i] != visited) {
                if (count > 1) {
                    System.out.print(array[i] + "  ");
                }
            }
/*

             //Removing duplicate Elements and print an array
            if (array[i] != visited) {
                System.out.print(array[i] + "  ");
            }
*/
        }
    }
}
