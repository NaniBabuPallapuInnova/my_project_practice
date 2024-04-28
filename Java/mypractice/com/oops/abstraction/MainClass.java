package mypractice.com.oops.abstraction;
class Order {
    private int orderId;
    private String customerName;
    private double totalAmount;

    public Order(int orderId, String customerName, double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

abstract class OrderProcessor{
    public abstract void processOrder(Order order);

    public void validateOrder(Order order){
        System.out.println("Validating order: " + order.getOrderId());
        // Default validation logic
        if (order.getTotalAmount() > 0) {
            System.out.println("Order is valid.");
        } else {
            System.out.println("Order is invalid.");
        }
    }
}

interface ValidateOrder{
    void validateOrder(Order order);

    // Default method providing default behavior
    default void additionalValidation(Order order) {
        System.out.println("Additional validation for order: " + order.getOrderId());
        // Default additional validation logic
        System.out.println("Performing default additional validation logic...");
        if (order.getCustomerName().length() > 0) {
            System.out.println("Customer name is valid.");
        } else {
            System.out.println("Customer name is not provided.");
        }
    }

    // Static method providing utility functionality
    static void printOrderDetails(Order order) {
        System.out.println("Order details:");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Total Amount: $" + order.getTotalAmount());
    }
}

// Concrete implementation of OrderProcessor
class OnlineOrderProcessor extends OrderProcessor{

    @Override
    public void processOrder(Order order) {
        System.out.println("Processing online order: " + order.getOrderId());
        // Online order processing logic
        System.out.println("Sending confirmation email to " + order.getCustomerName());
    }

}



// Concrete implementation of OrderProcessor
class InStoreOrderProcessor extends OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Processing in-store order: " + order.getOrderId());
        // In-store order processing logic
        System.out.println("Preparing order for pickup by " + order.getCustomerName());
    }
}


class ValidatorOrderImpl implements ValidateOrder{

    @Override
    public void validateOrder(Order order) {
        System.out.println("Custom validation for order: " + order.getOrderId());
        // Custom validation logic
        if (order.getTotalAmount() > 100) {
            System.out.println("Order is a high-value order.");
        } else {
            System.out.println("Order is a low-value order.");
        }
    }
}
public class MainClass {
    public static void main(String[] args) {
        Order onlineOrder = new Order(1001, "John Doe", 150.50);
        Order inStoreOrder = new Order(2001, "Jane Smith", 75.25);

        OnlineOrderProcessor onlineOrderProcessor = new OnlineOrderProcessor();

        InStoreOrderProcessor inStoreOrderProcessor = new InStoreOrderProcessor();
        System.out.println();

        onlineOrderProcessor.processOrder(onlineOrder);
        System.out.println();

        inStoreOrderProcessor.processOrder(inStoreOrder);

        System.out.println();

        ValidateOrder.printOrderDetails(onlineOrder);
        System.out.println();

        ValidateOrder.printOrderDetails(inStoreOrder);

        System.out.println();

        ValidateOrder validatorOrder = new ValidatorOrderImpl();
        validatorOrder.validateOrder(onlineOrder);
        validatorOrder.additionalValidation(onlineOrder);

    }
}
