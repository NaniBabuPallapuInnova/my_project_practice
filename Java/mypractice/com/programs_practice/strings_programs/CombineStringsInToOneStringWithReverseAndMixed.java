package mypractice.com.programs_practice.strings_programs;

/**
 *         String s1 = "My Name is Nani Babu";
 *         String s2 = "I am software developer";
 *         output : "developer Babu software Nani am is I Name My"
 */
public class CombineStringsInToOneStringWithReverseAndMixed {

    public static void main(String[] args) {

        String s1 = "My Name is Nani Babu";
        String s2 = "I am software developer";

        String[] wordsS1 = s1.split("\\s");
        String[] wordsS2 = s2.split("\\s");

        wordsS1 = reverseWordsInArray(wordsS1);
        wordsS2 = reverseWordsInArray(wordsS2);


        StringBuilder result = new StringBuilder();
        int length = Math.max(wordsS1.length, wordsS2.length);
        for(int i=0;i< length;i++){
            if(i < wordsS2.length){
                result.append(wordsS2[i]).append(" ");
            }
            if(i < wordsS1.length){
                result.append(wordsS1[i]).append(" ");
            }
        }

        System.out.println(result);

    }

    public static String[] reverseWordsInArray(String[] wordsArray){
        String[] temp = new String[wordsArray.length];
        int position=0;
        for(int i=wordsArray.length - 1; i>=0; i--){
            temp[position] = wordsArray[i];
            position++;
        }

        return temp;
    }
}
