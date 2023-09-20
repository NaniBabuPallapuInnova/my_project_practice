package com.welcome.programs_practice.arrays_programs;

/**
 * Write a program to print even and odd positions of the array.
 * Print Even numbers in array and Odd numbers in Array.
 */

public class PrintEvenPositionAndOddPositions {

    public static void printEvenPositionAndOddPosition(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                System.out.println("Even Position : " + array[i] + " ");
            } else {
                System.out.println("Odd Position : " + array[i] + " ");
            }
        }
    }

    public static void printEvenAndOddElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println("Even Element : " + array[i] + " ");
            } else {
                System.out.println("Odd Element : " + array[i] + " ");

            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 4, 5, 6, 7, 8, 9};

        System.out.println("===== PRINT EVEN AND ODD POSITIONS OF AN ARRAY ======");
        printEvenPositionAndOddPosition(array1);

        System.out.println("\n\n");

        System.out.println("===== PRINT EVEN AND ODD ELEMENTS OF AN ARRAY ======");

        printEvenAndOddElements(array1);
    }
}
