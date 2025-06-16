package OOAD;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderCatalog {

    private Map<String, Order> orders = new HashMap<>();

    public void cancelOrder(String orderID, Subscriber subscriber){
        Order order = orders.get(orderID);
        orders.remove(orderID);
        subscriber.removeOrder(order);
        Book book = order.getBook();
        if(order.getStatus() == "ready") {
            book.setStatus("available");
            book.setOrder(null);
        }
        order.getBookDescription().increaseInstances();
        System.out.println("OrderCatalog: orders.size() = " + orders.size());
        System.out.println(subscriber);
        System.out.println(book);
    }

    private String generateOrderID(){
        return UUID.randomUUID().toString();
    }

    public Order getOrder(String orderID){
        return orders.get(orderID);
    }

    public Order makeOrder(Subscriber subscriber, BookDescription bookDescription){
        String orderID = generateOrderID();
        Order order = new Order(orderID, subscriber, bookDescription, LocalDate.now());
        orders.put(orderID, order);
        subscriber.addOrder(order);
        System.out.println("OrderCatalog: orders.size() = " + orders.size() );
        System.out.println(order);
        return order;
    }

    public void removeOrder(String orderID){
        orders.remove(orderID);
    }

}
