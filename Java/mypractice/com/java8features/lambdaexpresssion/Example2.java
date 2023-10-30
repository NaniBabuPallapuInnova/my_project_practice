package mypractice.com.java8features.lambdaexpresssion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

public class Example2 {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Samsung A5", 17000f));
        list.add(new Product(3, "Iphone 6S", 65000f));
        list.add(new Product(2, "Sony Xperia", 25000f));
        list.add(new Product(4, "Nokia Lumia", 15000f));
        list.add(new Product(5, "Redmi4 ", 26000f));
        list.add(new Product(6, "Lenovo Vibe", 19000f));

        // printing product name from every single product object using statement lambda expression.
        System.out.println("======Product Name using Statement Lambda with forEach =======");
        list.forEach((product) -> {
            System.out.println(product.getName());
        });

        System.out.println();

        // printing product name from every single product object using  lambda expression.
        System.out.println("======= Product Name using Statement Lambda with forEach =======");
        list.forEach(product -> System.out.println(product.getName()));

        System.out.println();

        System.out.println("Sorting on the basis of name...");
        Collections.sort(list, (productName1, productName2) -> {
            return productName1.getName().compareTo(productName2.getName());
        });

        list.forEach(sortedProduct -> {
            System.out.println(sortedProduct.getName());
        });

        System.out.println("Filtered Product Price...");
        List<Product> filterProductList = list.stream().filter((product) -> product.getPrice() > 19000f).collect(Collectors.toList());
        filterProductList.forEach(filterdProduct -> System.out.println(filterdProduct.getPrice()));

        System.out.println();

        System.out.println("===========Filtered Product Price and Printing example 2 ===========");

        // we are fetching and iterating filtered data.
        list.stream().
                filter(product -> product.getPrice() >= 19000f) // filtering price
                // .map(productPrice -> productPrice.getPrice()) // fetching the price
                .map(Product :: getPrice) // replacing the above line with method interface
                .forEach(System.out::println); // printing

        System.out.println("===========Filtered Product Price and Printing example 2 ===========");

        List<Float> values = list.stream()
                .filter(product -> product.getPrice()>=19000f) // filtering the price
                .map(Product :: getPrice)// fetching the price
                .collect(Collectors.toList()); // converting as list

        values.forEach(value -> System.out.println(value)); // printing as single value.
//        values.forEach(System.out::println);// printing as single value
//        System.out.println(values); printing as list

    }
}

