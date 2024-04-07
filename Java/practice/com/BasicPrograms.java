package practice.com;


public class BasicPrograms {

    public static void findPrime(int n) {

        int count = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
                break;
            }
        }
        if (count == 1) {
            System.out.println(n + " is prime.");
        }
    }

    public static void printPrimeUpToN(int n) {

        for (int i = 1; i <= n; i++) {
            int count = 1;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void fibonacciSeries(int value1, int value2, int n) {

        System.out.print(value1 + " " + value2 + " ");
        int sum = 0;
        while (sum < n) {
            sum = value1 + value2;
            value1 = value2;
            value2 = sum;
            System.out.print(sum + " ");
        }
    }

    public static void palindromeOrNot(int n) {

        int sum = 0, rem = 0, temp = n;
        while (n > 0) {

            rem = n % 10;
            sum = rem + sum * 10;
            n = n / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is palindrome");
        }
    }


    public static void armStrongOrNot(int n) {

        int sum = 0, rem = 0, temp = n;
        int parts = 0;
        while (n > 0) {
            n = n / 10;
            parts++;
        }

        n = temp;


        while (n > 0) {
            rem = n % 10;
            sum = sum + (int) Math.pow(rem, parts);
            n = n / 10;
        }

        if (sum == temp) {
            System.out.println(sum + " is a armstrong number");
        }

    }

    public static void findFactorialOfGivenNumber(int value) {
        int sum = 1;
        for (int i = value; i >= 1; i--) {
            sum = sum * i;
        }
        System.out.println(sum);

    }

    public static void sumOfDigits(int n) {

        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {

        findPrime(11);
        System.out.println("\n");

        printPrimeUpToN(100);
        System.out.println("\n");

        fibonacciSeries(0, 1, 100);

        System.out.println("\n");

        palindromeOrNot(121);
        System.out.println("\n");

        armStrongOrNot(153);
        System.out.println("\n");

        findFactorialOfGivenNumber(5);
        System.out.println("\n");

        sumOfDigits(123456);
        System.out.println("\n");

    }
}
