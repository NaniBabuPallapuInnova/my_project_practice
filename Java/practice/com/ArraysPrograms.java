package practice.com;

import javax.naming.PartialResultException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysPrograms {

    public static void sumOfElementsInArray(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println(sum);
    }

    public static void largestAndSmallest(int[] array) {
        int max = array[0];
        int min = array[0];
/*
        max = Arrays.stream(array).max().getAsInt();
        min = Arrays.stream(array).min().getAsInt();
*/

        for (int value : array) {
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }
        System.out.println("Max = " + max + "    " + " Min = " + min);
    }

    private static void NthLargestElementInArray(int[] array,int n) {

        Arrays.sort(array);
        System.out.println(array[array.length - n]);

    }

    private static void sortArrayASCAndDESCOrder(int[] array) {

        int[] asc = array;
        int[] desc = array;

        System.out.println("ASCENDING ORDER");

        for(int i=0;i<asc.length;i++){
            for(int j=i+1;j<asc.length;j++){
                if(asc[i] > asc[j]){
                    int temp = asc[j];
                    asc[j] = asc[i];
                    asc[i] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(asc));

        

        System.out.println("DESCENDING ORDER");
        for(int i=0;i<desc.length;i++){
            for(int j=i+1;j<desc.length;j++){
                if(desc[i] < desc[j]){
                    int temp = desc[j];
                    desc[j] = desc[i];
                    desc[i] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(desc));

    }


    public static void main(String[] args) {

        int[] array = {5, 4, 1, 2, 6, 8, 7, 3, 9, 1, 2, 3, 4};

        sumOfElementsInArray(array);
        System.out.println("\n");

        largestAndSmallest(array);
        System.out.println("\n");

        NthLargestElementInArray(array,2);
        System.out.println("\n");

        sortArrayASCAndDESCOrder(array);


    }




}
