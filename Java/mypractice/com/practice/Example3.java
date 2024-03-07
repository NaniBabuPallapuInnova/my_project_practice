package mypractice.com.practice;

import java.util.List;

// Step 1: Define an interface for order processing
interface OrderProcessor {
    void processOrder(Order order);
}

// Step 2: Implement classes for specific order processing tasks

// Class for validating orders
class OrderValidator implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        // Perform order validation logic
        System.out.println("Validating order: " + order.getOrderNumber());
    }
}

// Class for updating inventory
class InventoryUpdater implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        // Update inventory based on the order
        System.out.println("Updating inventory for order: " + order.getOrderNumber());
    }
}

// Class for sending order confirmation emails
class EmailSender implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        // Send order confirmation email
        System.out.println("Sending order confirmation email for order: " + order.getOrderNumber());
    }
}

// Step 3: Create a class that delegates order processing tasks

class OrderProcessorDelegate implements OrderProcessor {
    private final List<OrderProcessor> processors;

    public OrderProcessorDelegate(List<OrderProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void processOrder(Order order) {
        // Delegate processing to each specific order processor
        for (OrderProcessor processor : processors) {
            processor.processOrder(order);
        }
    }
}

// Step 4: Model the Order class
class Order {
    private final String orderNumber;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}

// Step 5: Example usage
public class Example3 {
    public static void main(String[] args) {
        // Create instances of specific order processors
        OrderProcessor validator = new OrderValidator();
        OrderProcessor inventoryUpdater = new InventoryUpdater();
        OrderProcessor emailSender = new EmailSender();

        // Create a delegate with the list of processors
        OrderProcessorDelegate orderProcessorDelegate = new OrderProcessorDelegate(
                List.of(validator, inventoryUpdater, emailSender)
        );

        // Create an example order
        Order exampleOrder = new Order("123");

        // Process the order using the delegate
        orderProcessorDelegate.processOrder(exampleOrder);
    }
}

