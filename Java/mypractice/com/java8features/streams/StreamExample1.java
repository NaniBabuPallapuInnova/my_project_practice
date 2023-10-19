package mypractice.com.java8features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}

public class StreamExample1 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Soap", 55.67));
        products.add(new Product(2, "Oil", 120.4));
        products.add(new Product(3, "Shampoo", 25.56));
        products.add(new Product(4, "Shirt", 500.66));
        products.add(new Product(5, "Jeans", 999.86));

        /*
            //Without using Java Stream
                List<Double> productPrices = new ArrayList<>();

                for(Product product : products){
                    if(product.getPrice()>150){
                        productPrices.add(product.getPrice());
                    }
                }
                System.out.println(productPrices);
        */

/*

        //With using Java Stream using lambda expression to specify the mapping operation
        List<Double> productPriceList = products.stream() // creating stream
                .filter(product -> product.getPrice() > 150) // filtering data
                .map(product -> product.getPrice())//fetching price
                .collect(Collectors.toList()); //collecting as a list

        System.out.println(productPriceList);
*/


        // With using Java Stream using method reference that directly refers to the getPrice() method of the Product class
        List<Double> productPriceList = products.stream()
                .filter(product -> product.getPrice() > 150)
                .map(Product::getPrice)
                .collect(Collectors.toList());
        System.out.println(productPriceList);


        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);



    }
}
