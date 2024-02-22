package mypractice.com.dsa.searching.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Open below link and refer for converting array into collections list and list into array conversion.
 * https://www.geeksforgeeks.org/convert-an-array-into-collection-in-java/
 */
public class BinarySearchInCollection {
    public static void main(String[] args) {
        int[] array = {2,5,8,12,16,23,38,56,72,91};


        //converting array into Integer List and adding them into list
        List<Integer> list = new ArrayList<>(Arrays.stream(array).boxed().toList());

        // converting list into array =====>>>> array = list.stream().mapToInt(Integer :: intValue).toArray();
        System.out.println("List : "+list);

        Collections.sort(list);

        int index = Collections.binarySearch(list, 23);
        System.out.println("Element Found at Index : "+index);

    }
}
