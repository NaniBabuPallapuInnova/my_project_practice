package test.com;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person{
     private String name;
     private int age;

     public Person(String name, int age) {
         this.name = name;
         this.age = age;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     @Override
     public String toString() {
         return "Person{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }
public class PracticeTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape", "melon", "watermelon");

        String str = words.stream().filter(element -> element.contains("e")).max(String :: compareTo).get();
        System.out.println(str);
    }
}
