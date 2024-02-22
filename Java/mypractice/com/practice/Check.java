package mypractice.com.practice;



public class Check {

    public void factorial(int value){
        int sum = 1;

        for(int i=1;i<=value;i++){
            sum = sum * i;
        }
        System.out.println(sum);
    }

    public void primeNunber(int value){

        int original = value;
        int temp=0;

        for(int i=2;i<=value/2;i++){
            if(value % i == 0){
                temp++;
                break;
            }
        }

        if(temp == 0){
            System.out.println("PrimeNunber");
        } else {
            System.out.println("Not a PrimeNunber");
        }
    }

    public void primeNumberUpToN(int value){

        for(int i=1;i<value;i++){
            int temp = 0;
            for(int j=2; j<=i/2;j++){
                if(i % j == 0){
                    temp++;
                }
            }

            if(temp == 0){
                System.out.print(i+"  ");
            }
        }
    }

    public void armStrongNumber(int value){

        int duplicate = value;

        int rem = 0;
        while(duplicate > 0){
            duplicate = duplicate / 10;
            rem++;
        }

        System.out.println("times = " +rem);

        int sum = 0;
        int reminder = 0;
        int temp = value;
        while(value > 0 ){
            reminder = value % 10;
            sum = sum + (int) Math.pow(reminder,rem);
            value = value / 10;
        }
        System.out.println("sum = "+sum);
        if(sum == temp){
            System.out.println("ARMSTRONG");
        } else {
            System.out.println("NOT A ARMSTRONG");
        }
    }

    private void fibonacciSeries(int value) {

        int value1 =0;
        int value2 = 1;
        int sum = 0;
        int reminder = 0;
        System.out.print(value1+ " "+value2+" ");
        while (sum < value){
            sum = value1+value2;
            value1 = value2;
            value2 = sum;
            System.out.print(sum+ " ");

        }

    }

    public void palindromeNumber(int value){

        int sum = 0;
        int temp = value;
        int reminder = 0;

        while(value > 0){
            reminder = value % 10;
            sum = (sum * 10)+  reminder;
            value = value/10;
        }
        System.out.println("sum for palindrome = "+sum);
        if(sum == temp){
            System.out.println("PALINDROME ");
        } else {
            System.out.println("NOT A PALINDROME");
        }
    }
    public static void main(String[] args) {

        Check check = new Check();
        check.factorial(5);
        System.out.println("\n");
        check.primeNunber(9);
        System.out.println("\n");
        check.primeNumberUpToN(100);
        System.out.println("\n");
        check.armStrongNumber(1064);
        System.out.println("\n");
        check.fibonacciSeries(100);
        System.out.println("\n");
        check.palindromeNumber(121);
    }


}
