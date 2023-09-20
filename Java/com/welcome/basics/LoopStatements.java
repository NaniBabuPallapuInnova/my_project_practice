package com.welcome.basics;

public class LoopStatements {

    /** Print Even and Odd numbers upto Given Number **/
    public static void forLoopExample(int value){
        for(int i=1;i<=value;i++){
            if(i%2==0){
                System.out.print("Even Numbers : "+i);
            } else{
                System.out.print("Odd Numbers : "+i);
            }
            System.out.println();
        }
    }

    public static void forEachLoopExample(String value){
        char[] chars = value.toCharArray();
        for(char ch : chars){
            if(ch=='a'|| ch == 'A' || ch == 'e'|| ch == 'E' || ch == 'i'|| ch== 'I' || ch == 'o'|| ch == 'O' || ch == 'u'|| ch == 'U'){
                System.out.print(ch+" : is a vowel");
            } else if(ch==' '){
                System.out.print(ch+" : is a space ");
            } else {
                System.out.print(ch+" : is a consonant ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        forLoopExample(1000);
        forEachLoopExample("Welcome To My World");
    }
}
