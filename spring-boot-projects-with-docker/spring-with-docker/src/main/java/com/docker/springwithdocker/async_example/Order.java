package com.docker.springwithdocker.async_example;

public class Order {
    private Long id;
    private String productName;
    private int productCount;

    public Order(Long id, String productName, int productCount) {
        this.id = id;
        this.productName = productName;
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCount='" + productCount + '\'' +
                '}';
    }
}
