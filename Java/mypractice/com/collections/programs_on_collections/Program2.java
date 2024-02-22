package mypractice.com.collections.programs_on_collections;

import com.mysql.cj.util.DnsSrv;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Enter sentence A: My Name is Nani
 * Enter sentence B: I love india
 * Output: india Nani Love is I Name My
 * <p>
 * public static void main(String[] args) {
 * <p>
 * String sentenceA = "My Name Is Nani";
 * String sentenceB = "I Work As A Software Developer";
 * <p>
 * String[] wordsA = sentenceA.split("\\s");
 * String[] wordsB = sentenceB.split("\\s");
 * <p>
 * wordsA = reverseElementInArray(wordsA);
 * wordsB =  reverseElementInArray(wordsB);
 * <p>
 * StringBuilder result = new StringBuilder();
 * <p>
 * int length = Math.max(wordsA.length, wordsB.length);
 * <p>
 * for (int i = 0; i < length; i++) {
 * if (i < wordsB.length) {
 * result.append(wordsB[i]).append(" ");
 * }
 * if (i < wordsA.length) {
 * result.append(wordsA[i]).append(" ");
 * }
 * }
 * <p>
 * <p>
 * System.out.println(String.join(" ", result));// + " " + String.join(" ", wordsB));
 * <p>
 * <p>
 * }
 * <p>
 * public static String[] reverseElementInArray(String[] array) {
 * String[] temp = new String[array.length];
 * int position = 0;
 * <p>
 * for (int i = array.length - 1; i >= 0; i--) {
 * temp[position] = array[i];
 * position++;
 * }
 * array = Arrays.copyOf(temp, temp.length);
 * <p>
 * return array;
 * }
 */


public class Program2 {
    public static void main(String[] args){

        int[] array = {21,4,8,2,3,2,40,7,32,56};
//        Vector<Integer> vector = new Vector<>();
//        vector.addAll(Arrays.stream(array).boxed().toList());
        Vector<Integer> vector = new Vector<>(Arrays.stream(array).boxed().toList());
        Collections.sort(vector);
        int index = Collections.binarySearch(vector, 40);
        System.out.println("=== Element 40f found index position at === "+index);



    }
}
