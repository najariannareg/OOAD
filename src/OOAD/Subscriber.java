package OOAD;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {

    private List<Order> orders = new ArrayList<>();
    private String cardID;
    private String personalData;
    private String status;

    public Subscriber(String cardID, String personalData) {
        this.cardID = cardID;
        this.personalData = personalData;
        this.status = "eligible";
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public void addOrder(Order order){ orders.add(order); }

    public String getPersonalData(){
        return personalData;
    }

    public String getCardID(){
        return cardID;
    }

    @Override
    public String toString(){
        return "subscriber: {" + "personalData: " + personalData + ", status: " + status + ", orders.size(): " + orders.size() + "}";
    }

}
