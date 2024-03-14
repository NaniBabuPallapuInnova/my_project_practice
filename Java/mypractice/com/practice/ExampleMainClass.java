package mypractice.com.practice;


 class Student {

    private int id=10;
    private String name="Nani";
    private String email="nanipallapu369@gmail.com";

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }
 }



public class ExampleMainClass{
    public static void main(String[] args) {

        Student student = new Student();


        System.out.println(student.toString());

    }
}



