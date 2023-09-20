package com.welcome.programs_practice.basics_programs;

public class PalindromeProgram {

    public static void checkPalindromeOrNot(int number) {
        int sum = 0;
        int reminder = 0;
        int temp = number;

        while (number > 0) {
            reminder = number % 10;// getting remainder
            sum = (sum * 10) + reminder;
            number = number / 10;
        }
        if (temp == sum) {
            System.out.println(temp + " is a Palindrome Number");
        } else {
            System.out.println(temp + " is not a Palindrome Number");
        }
    }

    public static void checkPalindromeOrNot(String value) {
        String reverse = "";
       /*  Method 1 - using StringBuilder
        StringBuilder stringBuilder = new StringBuilder(value);
        reverse = String.valueOf(stringBuilder.reverse());

        */

        for (int i = 0; i < value.length(); i++) {
            reverse = reverse + value.charAt(i);
        }
        if (value.equals(reverse)) {
            System.out.println(reverse + " is a Palindrome");
        } else {
            System.out.println(reverse + " is not a Palindrome");

        }

    }

    public static void main(String[] args) {
        checkPalindromeOrNot(141);
        checkPalindromeOrNot("madam");
    }
}
