package mypractice.com.basics;

public class Operators {
    public static void unaryOperators(){
        int a= 10;
        int b = -10;
        System.out.println(a++);//10
        System.out.println(++a);//12
        System.out.println(a++ + ++a);//12+14 = 26
        System.out.println(~a);//-11 (minus of total positive value which starts from 0)
        System.out.println(~b);//9 (positive of total minus, positive starts from 0)
    }

    public static void shiftOperators(){


        System.out.println("Left Shift Operators");
        System.out.println(10<<2); // 10 * 2^2 = 10 * 4 = 40
        System.out.println(10<<3); // 10 * 2^3 = 10 * 8 = 80
        // System.out.println(10<<<3); // <<< not a valid operator
        System.out.println("Right Shift Operators");
        System.out.println(10>>2); // 10 / 2^2 = 10 / 4 = 2
        System.out.println(10>>3); // 10 / 2^3 = 10 / 8 = 1
        System.out.println(-8 >> 2); // Output: -2 --> Explanation: The binary representation of -8 is 11111111 11111111 11111111 11111000. When you shift it to the right by 2 positions using >>, it becomes 11111111 11111111 11111111 11111110, which is equivalent to -2.
        System.out.println(-8 >>> 2); // Output: 1073741822 --> Explanation: The binary representation of -8 is 11111111 11111111 11111111 11111000. When you shift it to the right by 2 positions using >>>, it becomes 00111111 11111111 11111111 11111110, which is equivalent to 1073741822.





    }

    public static void main(String[] args) {
        unaryOperators();
        System.out.println("\n");
        shiftOperators();
        System.out.println("\n");

    }
}
