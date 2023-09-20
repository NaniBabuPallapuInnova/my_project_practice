package com.welcome.programs_practice.strings_programs;

public class CountCharactersInString {
    public static void main(String[] args) {
        String text = "Java t point";
        int count =0;

        for(int i=0;i<text.length();i++){
            if(text.charAt(i)!=' '){
                count++;
            }
        }
        System.out.println(text+" has "+count+" characters");
    }
}
