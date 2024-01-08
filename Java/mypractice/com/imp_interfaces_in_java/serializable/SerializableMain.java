package mypractice.com.imp_interfaces_in_java.serializable;

import java.io.*;

class Practice implements Serializable {

    int value =0;
    String text;

    public Practice(int value, String text){
        this.value = value;
        this.text = text;
    }
}
public class SerializableMain {

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {

        Practice practice = new Practice(20, "= \"I am storing this text into file\"");

        String filePath = "C://Users//nanibabu.pallapu//Downloads//hello.txt";
        File file = new File(filePath);

        FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(practice);
//        objectOutputStream.close();

        System.out.println(objectOutputStream);

        FileInputStream fileInputStream = new FileInputStream(file.getName());
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Practice practice1 = (Practice) objectInputStream.readObject();
        System.out.println(practice1.value+"  "+practice1.text);
    }
}

