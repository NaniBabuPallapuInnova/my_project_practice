package mypractice.com.programs_practice.basics_programs;

import java.util.Scanner;

public class PrimeNumbersProgram {

    public static void findPrimeOrNot(int number) {
        int count = 0;
        if (number > 1) {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    count++;
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }

    public static void printPrimeNumbersUpToN(int limit){
        int alternative=0;

        for(int i=2;i<=limit;i++){
            int count =0;
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.print(i+" ");
                alternative++;
            }
            /* PRINTING ALTERNATIVE PRIME NUMBERS
            if(count==0){
                if(alternative%2!=0){
                    System.out.print(i+" ");
                }
            }
            */
        }
    }

    public static void main(String[] args) {

        findPrimeOrNot(4);
        System.out.print("Prime Numbers: ");
        printPrimeNumbersUpToN(1000);
    }
}
