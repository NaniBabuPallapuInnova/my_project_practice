package mypractice.com.collections.programs_on_collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamExample {

    /**
     * Using Intermediate Operations(map, filter, sorted)
     *
     * Note : forEach does not come under Intermediate Operations.
     */
    public static void squareAndPrintEventNumberAndSortUsingIntermediateOperation(int[] array) {


        Arrays.stream(array)
                .map(element -> element * element)
                .filter(element -> element % 2 == 0)
                .sorted()
                .forEach(element -> System.out.print(element + " "));


    }


    public static void convertArrayInToListAndIterateElements(int[] array){

        List<Integer> list = Arrays.stream(array).boxed().toList();
        int sum = list.stream()
                .map(element -> element * element)
                .sorted()
                .reduce(0, (element1 , element2) -> element1+element2);
        System.out.println("Sum = "+sum);
    }

    public static void main(String[] args) {

        int[] array = {5,7, 6, 7,10,9, 8, 2, 3, 4 };


        /**
         *
         * Given An array square and take only even number and sort them using IntermediateOperation Streams
         */
        squareAndPrintEventNumberAndSortUsingIntermediateOperation(array);

        /**
         *
         */

        System.out.println("\n");

        /**
         * convert array into list and iterate elements and print them.
         */
        convertArrayInToListAndIterateElements(array);

    }


}
