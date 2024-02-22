package mypractice.com.collections.queue;

import java.util.PriorityQueue;

class Student implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> queue=new PriorityQueue<String>();
        queue.add("Rajesh");
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        queue.poll(); // it will remove the head element
        System.out.println("head:"+queue.element());
        System.out.println("head:"+queue.peek());
        System.out.println("head:"+queue);
    }
}
