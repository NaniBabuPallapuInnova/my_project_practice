package mypractice.com.dsa.searching.binary_search;

public class RecursiveMethod {
    public static void main(String[] args){
        int[] array = {2,5,8,12,16,23,38,56,72,91};
        int target = 8;
        int start = 0;
        int end = array.length -1;

        search(array, target, start, end);


    }

    public static void search(int[] array, int target, int start, int end){
        if(start <=end){

            int mid = (start+end)/2;

            if(array[mid]==target){
                System.out.println("Element found at position : "+mid);
            } else if(array[mid] >= target){
                end = mid - 1;
                search(array, target, start, end);
            } else{
                start = mid +1;
                search(array, target, start, end);
            }
        }
    }
}
