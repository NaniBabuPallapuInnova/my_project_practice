package mypractice.com.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListExample1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(6);

        System.out.println("======= 1. BY ITERATOR INTERFACE =======");
        Iterator iterator = arrayList.iterator(); //getting the Iterator
        while (iterator.hasNext()){ //check if iterator has the elements
            System.out.print(iterator.next()+" "); //printing the element and move to next
        }
        System.out.println("\n");

        System.out.println("======= 2. BY FOR-EACH LOOP =======");
        for(Integer i : arrayList){
            System.out.print(i+" ");
        }
        System.out.println("\n");

        System.out.println("======= 3. BY TRAVERSING THROUGH LIST-ITERATOR =======");
        //Here, element iterates in reverse order
        ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());
        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+" ");
        }
        System.out.println("\n");

        System.out.println("======= 4. BY FOR LOOP =======");
        for(int i=0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i));
        }
        System.out.println("\n");

        System.out.println("======= 5. BY FOR-EACH() METHOD =======");
        arrayList.forEach(element -> {
            System.out.print(element+" ");
        });
        System.out.println("\n");

        System.out.println("======= 6. BY FOR-EACH-REMAINING() METHOD =======");
        Iterator<Integer> integerIterator  = arrayList.iterator();
        integerIterator.forEachRemaining(element ->{
            System.out.print(element+" ");
        });





    }
}
