package junit_practice;

public class Calculate {

    public static int findMaxElementInArray(int[] array){

        int max = array[0];
        for(int value : array){
            if(value > max){
                max = value;
            }
        }

        return max;
    }

}
