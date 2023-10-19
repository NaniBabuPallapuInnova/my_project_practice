package mypractice.com.collections.list;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        // checking stack is empty or not
        boolean result = stack.empty();
        System.out.println("Is the stack empty? " + result);
        // pushing elements into stack
        stack.push(78);
        stack.push(113);
        stack.push(90);
        stack.push(120);
        stack.pop(); // remove the last pushed element
        //prints elements of the stack
        System.out.println("Elements in Stack: " + stack);
    }
}
