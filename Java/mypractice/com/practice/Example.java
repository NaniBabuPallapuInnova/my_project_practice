package mypractice.com.practice;

public class Example {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfPrimeIndexValues(int[] input1, int input2) {
        int sum =0;
        for (int i = input2; i < input1.length; i++) { // Start from index 2 (3rd element)
            if (isPrime(i)) {
                sum += input1[i];
            }
        }
        return sum;
    }


public static void main(String[] args) {

        int[] array = {10,20,30,40,50,60,70,80,90,100};

       int sum =  sumOfPrimeIndexValues(array,2);
       System.out.println(sum);
    }
}
