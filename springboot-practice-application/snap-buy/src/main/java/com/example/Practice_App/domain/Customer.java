package com.example.Practice_App.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String name;

    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @Column(name = "phone_number")
    private String phone;

    public Customer(Long id, String name, String city, String state, String phone) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }

    public Customer(String name, String city, String state, String phone) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.phone = phone;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
