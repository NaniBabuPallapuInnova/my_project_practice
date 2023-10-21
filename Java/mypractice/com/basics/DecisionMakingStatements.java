package mypractice.com.basics;

public class DecisionMakingStatements {
    /** Check person is eligible for vote or not using if-else **/
    public static void ifExample(int age){
        if(age>=18){
            System.out.println("Congrats! you are eligible for vote");
        } else{
            System.out.println("Sorry! you are not eligible for vote");
        }
    }

    /** Print today is what-day **/
    public static void ElseIfExample(int marks){
        if(marks>=90){
            System.out.println("GREAT! You got 'A++' grade");
        } else if(marks>=75){
            System.out.println("CONGRATS! You got 'A' grade");
        } else if(marks>=60){
            System.out.println("GOOD! You got 'B' grade");
        } else if(marks>=50){
            System.out.println("OK! You got 'C' grade");
        } else if(marks>=35){
            System.out.println(" You just got 'D' grade");
        } else if(marks<=34){
            System.out.println(" SORRY! You have failed");
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    /** Check given character is VOWEL or CONSONANT switch() Case Statement **/
    private static final String VOWEL = "VOWEL";
    public static void switchCaseExample(char ch){
        switch (ch){
            case 'A'|'a':
                System.out.println(ch+" : "+VOWEL);
                break;
            case 'E'|'e':
                System.out.println(ch+" : "+VOWEL);
                break;
            case 'I'|'i':
                System.out.println(ch+" : "+VOWEL);
                break;
            case 'O'|'o':
                System.out.println(ch+" : "+VOWEL);
                break;
            case 'U'|'u':
                System.out.println(ch+" : "+VOWEL);
                break;
            default:
                System.out.println(ch+" : "+VOWEL);
        }
    }
    /** Check given character is VOWEL or CONSONANT with efficient code using switch() Case Statement **/
    public static void switchCaseExampleEfficient(char ch){
        switch (ch){
            case 'A'|'a':
            case 'E'|'e':
            case 'I'|'i':
            case 'O'|'o':
            case 'U'|'u':
                System.out.println(ch+" : "+VOWEL);
                break;
            default:
                System.out.println(ch+" : "+"CONSONANT");
        }
    }
    public static void main(String[] args) {
        ifExample(20);
        ElseIfExample(55);
        switchCaseExample('D');
        switchCaseExampleEfficient('E');
    }
}
