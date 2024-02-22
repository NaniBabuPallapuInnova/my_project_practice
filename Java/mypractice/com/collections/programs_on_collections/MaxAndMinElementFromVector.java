package mypractice.com.collections.programs_on_collections;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * Java Program to Get the Maximum Element From a Vector
 *
 * Input: v1={1,2,3,4,5}
 * Output: 5
 *
 * Input: v2={7,50,0,67,98}
 * Output: 98
 */
public class MaxAndMinElementFromVector {

    public static void main(String[] args){


        Vector<Integer> vector = new Vector<>();
        vector.add(7);
        vector.add(50);
        vector.add(1);
        vector.add(67);
        vector.add(98);
        int max = vector.get(0);
        int min = vector.get(0);


        /**
         * Method 1: Using a Predefined Function
         */
//         max = Collections.max(vector);
//         min = Collections.min(vector);

        /**
         * Method 2: Comparing each element present in Vector
         */

        Iterator iterator = vector.iterator();
        while(iterator.hasNext()){
            int element = (Integer)iterator.next();
            if(max < element ){
                max = element;
            }
            if(min > element){
                min = element;
            }
        }

        System.out.println("Max Value : "+max+" "+"Min Value : "+min);

    }
}
