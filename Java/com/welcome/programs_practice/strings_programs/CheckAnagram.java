package com.welcome.programs_practice.strings_programs;

import java.util.Arrays;

/**
 * Two Strings are called the anagram if they contain the same characters.
 * However, the order or sequence of the characters can be different.
 */
public class CheckAnagram {

    public static void main(String[] args) {
        String text1 = "NaniBabu";
        String text2 = "niuBaNab";

        if (text1.length() != text2.length()) {
            System.out.println("Both String Are Not Anagram");
        } else {

            text1 = text1.toLowerCase();
            text2 = text2.toLowerCase();

            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            if (Arrays.equals(chars1, chars2)) {
                System.out.println("Both String Are Anagram");
            } else {
                System.out.println("Both String Are Not Anagram");
            }
        }

    }
}
