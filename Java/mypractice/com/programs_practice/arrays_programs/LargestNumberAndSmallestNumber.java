package mypractice.com.programs_practice.arrays_programs;

/**
 * Find The Largest Number and Smallest Number in Array.
 * Find The Sum of Elements in Given Array.
 */
public class LargestNumberAndSmallestNumber {
    public static void main(String[] args) {
        int[] array1 = new int[]{3, 4, 2, 8, 10, 22, 5, 6, 7, 8, 9};

        int largest = array1[0];
        int smallest = array1[0];


        for(int i=0;i<array1.length;i++){
            if(largest<=array1[i]){
                largest = array1[i];
            }
            if(smallest>=array1[i]){
                smallest = array1[i];
            }
        }
        System.out.println("Largest Number : "+largest);
        System.out.println("Smallest Number : "+smallest);

        int sum =0;
        for(int i=0;i<array1.length;i++){
            sum = sum + array1[i];
        }
        System.out.println("Sum Of All Elements In Array : "+sum);

    }
}
