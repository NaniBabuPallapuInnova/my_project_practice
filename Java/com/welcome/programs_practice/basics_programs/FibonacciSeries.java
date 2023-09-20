package com.welcome.programs_practice.basics_programs;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 1, sum = 0;
        System.out.println("=== Enter limit ====");
        int limit = scanner.nextInt();
        System.out.print(num1 + " " + num2+" ");
        do {
            sum = num1 + num2;
            System.out.print( sum+" ");
            num1 = num2;
            num2 = sum;
        } while (sum < limit);
    }
}
