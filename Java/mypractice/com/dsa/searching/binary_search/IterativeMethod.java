package mypractice.com.dsa.searching.binary_search;

public class IterativeMethod {
    public static void main(String[] args){
        int[] array = {2,5,8,12,16,23,38,56,72,91};
        int target = 23;
        int start = 0;
        int end = array.length -1;

        for (int i = 0; i <= end; i++) {
            int mid = (start + end) / 2;
            System.out.println("Mid value : "+mid);

            if (array[mid] == target) {
                System.out.println("Position : "+mid);
                return;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

    }
}
