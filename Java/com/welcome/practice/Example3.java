package com.welcome.practice;

public class Example3 {

        public static double calculateFinalResult(double[] input1, int input2) {
            double[] step1Array = new double[input1.length];

            for (int i = 0; i < input1.length; i++) {
                int position = input2 < i ? input2 : (int) Math.log10(input1[i]);
                double digit = (int) (input1[i] / Math.pow(10, position)) % 10;
                step1Array[i] = digit;
            }

            double[] step2Array = new double[input1.length];
            for (int i = 0; i < input1.length; i++) {
                step2Array[i] = Math.pow(step1Array[i], 2);
            }

            double sum = 0;
            for (double value : step2Array) {
                sum += value;
            }

            return sum;
        }
        public static void main(String[] args) {
            double[] input1 = { 1,5, 423, 310, 61540 };
            int input2 = 5;
            double result = calculateFinalResult(input1, input2);
            System.out.println("Final Result: " + result);
        }
    }
