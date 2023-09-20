package com.welcome.practice;

public class Example2 {
        public static int calculatePositionBasedSum(int[] input1, int input2) {
            int[] step1Array = new int[input1.length];

            for (int i = 0; i < input1.length; i++) {
                int position = input2 < i ? input2 : (int) Math.log10(input1[i]);
                int digit = (int) (input1[i] / Math.pow(10, position)) % 10;
                step1Array[i] = digit;
            }

            int[] step2Array = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                step2Array[i] = (int) Math.pow(step1Array[i], 2);
            }

            int sum = 0;
            for (int value : step2Array) {
                sum += value;
            }

            return sum;
        }

    public static void main(String[] args) {
       // int[] input11 = { 1,51, 436, 7860, 41236 };
        int[] input11 = { 1,5, 423, 310, 61540 };

        int result = calculatePositionBasedSum(input11,5);
        System.out.println("Final Result: " + result);
    }
}
