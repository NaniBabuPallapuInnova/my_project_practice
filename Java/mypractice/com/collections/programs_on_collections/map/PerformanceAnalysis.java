package mypractice.com.collections.programs_on_collections.map;

import java.util.*;

public class PerformanceAnalysis {

    public static void performanceUsingForLoop(List<Integer> list) {

        long start = Calendar.getInstance().getTimeInMillis();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n");
        System.out.println("Printing performanceUsingNormalForLoop : " + (end - start) + " ms");


    }

    public static void performanceUsingForEachLoop(List<Integer> list) {

        long start = Calendar.getInstance().getTimeInMillis();

        for (int i : list) {
            System.out.print(i + " ");
        }

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n");
        System.out.println("Printing performanceUsingForEachLoop : " + (end - start) + " ms");
    }

    public static void performanceUsingCollectionSize(List<Integer> list) {

        long start = Calendar.getInstance().getTimeInMillis();

        for (int i = 0; i < list.size(); i++) {

            int temp = list.get(i);
            System.out.print(temp + " ");
        }

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n");
        System.out.println("Printing performanceUsingCollectionSize : " + (end - start) + " ms");
    }

    public static void performanceUsingCollectionUsingLambdaExpression(List<Integer> list){

        long start = Calendar.getInstance().getTimeInMillis();

        list.forEach(element -> System.out.print(element+" "));

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n");
        System.out.println("Printing performanceUsingCollectionUsingLambdaExpression : " + (end - start) + " ms");
    }

    public static void performanceUsingCollectionUsingMethodMapping(List<Integer> list){

        long start = Calendar.getInstance().getTimeInMillis();

        list.forEach(System.out::print);

        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("\n");
        System.out.println("Printing performanceUsingCollectionUsingLambdaExpression : " + (end - start) + " ms");
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        performanceUsingForLoop(list);
        performanceUsingForEachLoop(list);
        performanceUsingCollectionSize(list);
        performanceUsingCollectionUsingLambdaExpression(list);
        performanceUsingCollectionUsingMethodMapping(list);

    }
}
