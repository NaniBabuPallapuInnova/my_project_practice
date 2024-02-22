package mypractice.com.programs_practice.strings_programs;

import java.util.ArrayList;
import java.util.List;

public class CheckVowelsAndConsonantsInString {
    public static void main(String[] args) {
        String text = "java t point";
        int countVowels = 0;
        int countConsonants = 0;


        char[] vowelChars = new char[text.length()];
        char[] consonantChars = new char[text.length()];

        text = text.toLowerCase();

        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'u'){
                vowelChars[i] = text.charAt(i);
                countVowels++;
            } else{
                if (text.charAt(i)!=' ') {
                    consonantChars[i] = text.charAt(i);
                    countConsonants++;
                }
            }
        }
        System.out.print("\n");
        System.out.println("VOWELS FROM "+text+" and Vowels Count : "+countVowels);
        for(char ch : vowelChars){
            if (ch != 0) { // check if character is null or not implicitly.
                System.out.print(ch);
            }
        }

        System.out.print("\n");
        System.out.println("CONSONANTS FROM "+text+" and Consonants Count : "+countConsonants);
        for(char ch : consonantChars){
            if (ch != 0) {
                System.out.print(ch);
            }
        }

        System.out.print("\n");

    }
}
