package OOAD;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SubscriberCatalog {

    private Map<String, Subscriber> subscribers = new HashMap<>();

    private String generateCardID(){
        return UUID.randomUUID().toString();
    }

    public Subscriber getSubscriber(String cardID){
        return subscribers.get(cardID);
    }

    public String makeRegistration(String personalData) {
        String cardID = generateCardID();
        Subscriber subscriber = new Subscriber(cardID, personalData);
        subscribers.put(cardID, subscriber);
        System.out.println("SubscriberCatalog: subscribers.size() = " + subscribers.size());
        System.out.println(subscriber);
        return cardID;
    }

}
