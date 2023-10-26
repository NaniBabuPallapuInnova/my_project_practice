package com.microservices.project.orderservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    /**
     * @OneToMany(mappedBy = "order", cascade = CascadeType.ALL): This annotation is used to define a one-to-many relationship between the current entity and the OrderLineItems entity.
     * It signifies that one instance of the current entity can have multiple related instances of OrderLineItems.
     *
     * mappedBy = "order": This indicates that the relationship is managed by the "order" field in the OrderLineItems entity.
     * In other words, the "order" field in the OrderLineItems entity is the owning side of the relationship, and it contains the foreign key reference to the current entity.
     *
     * cascade = CascadeType.ALL: This specifies that when an operation (such as persist, merge, remove, etc.) is performed on the current entity,
     * the same operation should be cascaded (propagated) to the related OrderLineItems. The CascadeType.ALL option means that all cascade operations should be applied.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;

    public Order() {
    }

    public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItemsList) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderLineItemsList = orderLineItemsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderLineItems> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderLineItemsList=" + orderLineItemsList +
                '}';
    }
}
