package com.welcome.arrays;

public class Example1 {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 3;
        intArray[1] = 4;
        intArray[2] = 6;
        intArray[3] = 7;
        intArray[4] = 8;

        int[] intArray2 = {14, 15, 16, 17, 18};
        for (int i : intArray) {
            System.out.println(i);
        }
        System.out.println("\n");

        for (int i = 0; i < intArray2.length; i++) {
            System.out.println(intArray2[i]);
        }
        System.out.println("\n");

        String[] stringArray = new String[5];
        stringArray[0] = "Nani";
        stringArray[1] = "Welcome";
        stringArray[2] = "To";
        stringArray[3] = "My world";
        stringArray[4] = "Thank you!";

        String[] stringArray2 = {"Lemon", "Orange", "Mango", "Grape", "Apple"};

        for (String str : stringArray) {
            System.out.println(str);
        }
        System.out.println("\n");

        for (int i = 0; i < stringArray2.length; i++) {
            System.out.println(stringArray2[i]);
        }
        System.out.println("\n");

        char[] ch = new char[4];
        ch[0] = 'N';
        ch[1] = 'A';
        ch[2] = 'N';
        ch[3] = 'I';

        for (char value : ch) {
            System.out.println(value);
        }

        System.out.println("\n");

        char[] chars = {'P', 'A', 'L', 'L', 'A', 'P', 'U'};
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        /**
         * Multi Dimensional Array
         */
        int[][] arr = new int[3][3];//3 row and 3 column
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;

        System.out.println("====== PRINTING MULTI DIMENSIONAL ARRAY VALUES ======");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        int[][] arr2 = {{1, 2, 3}, {2, 4, 5}, {4, 4, 5}};
        System.out.println("====== PRINTING ANOTHER MULTI DIMENSIONAL ARRAY VALUES ======");
        for (int[] value1 : arr2) {
            for (int value : value1) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
