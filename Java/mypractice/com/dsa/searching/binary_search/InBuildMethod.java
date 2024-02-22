package mypractice.com.dsa.searching.binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InBuildMethod {
    public static void main(String[] args) {
        int[] array = {2,5,8,12,16,23,38,56,72,91};
        int target = 23;

        Arrays.sort(array);

        int index = Arrays.binarySearch(array, target);
        System.out.println("Element Found at Index Position "+index);
    }
}
