import java.util.LinkedList;
import java.util.Queue;

public class OrderController {
    private Queue<Order> orderQueue;

    public OrderController() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order added");
    }

    public void deliverNextOrder() {
        if(orderQueue.isEmpty()) {
            System.out.println("No orders");
        }
        else {
            Order delivered = orderQueue.poll(); //remove and return first
            System.out.println("order delivered for:\n" + delivered);
        }
    }

    public void viewAllOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("no current orders");
        }
        else {
            System.out.println("current orders: ");
            for (Order order : orderQueue) {
                System.out.println(order);
            }
        }
    }
}
