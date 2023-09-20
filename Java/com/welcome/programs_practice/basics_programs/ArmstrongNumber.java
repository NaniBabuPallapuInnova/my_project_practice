package com.welcome.programs_practice.basics_programs;

public class ArmstrongNumber {
    public static void checkArmstrongNumber(int number) {
        int sum = 0;
        int remainder = 0;
        int digits = 0;
        int temp = number;


        while (temp > 0) {
            temp = temp / 10;
            digits++;
        }
        temp = number;

        while (number > 0) {
            remainder = number % 10;
            sum = (int) (sum + Math.pow(remainder, digits));
            number = number / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is a Armstrong number");
        } else {
            System.out.println(temp + " is a not armstrong number");
        }
    }

    public static void main(String[] args) {
        checkArmstrongNumber(1634);
    }
}
