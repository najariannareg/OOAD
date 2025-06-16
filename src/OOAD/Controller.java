package OOAD;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    private SubscriberCatalog subscriberCatalog;
    private OrderCatalog orderCatalog;
    private BookRepository bookRepository;
    private BookDescriptionCatalog bookDescriptionCatalog;
    private Archive archive;
    // temporarily keeps
    private Subscriber subscriber;
    private Order order;


    public Controller(SubscriberCatalog subscriberCatalog, OrderCatalog orderCatalog, BookRepository bookRepository, BookDescriptionCatalog bookDescriptionCatalog, Archive archive) {
        this.subscriberCatalog = subscriberCatalog;
        this.orderCatalog = orderCatalog;
        this.bookRepository = bookRepository;
        this.bookDescriptionCatalog = bookDescriptionCatalog;
        this.archive = archive;
    }

    public void borrowBooks(String cardID){
        System.out.println(">>>>borrowBook");
        Subscriber subscriber = subscriberCatalog.getSubscriber(cardID);
        List<Order> subList = subscriber.getOrders();
        Book book;
        int i = 1;
        for(Order o: subList){
            System.out.println("order: " + i);
            i++;
            if(o.getStatus() == "ready"){
                book = o.getBook();
                book.setStatus("borrowed");
                o.setStatus("complete");
                o.setBorrowDate(LocalDate.now());
                System.out.println(book);
                System.out.println(o);
            }
        }
    }

    public Order cancelOrder(String orderID){
        System.out.println("cancelOrder");
        orderCatalog.cancelOrder(orderID, subscriber);
        setOrder(null);
        return null;
    }

    public String makeRegistration(String personalData){
        System.out.println(">>>>makeRegistration");
        return subscriberCatalog.makeRegistration(personalData);
    }

    public Order makeOrder(String bookDescriptionID){
        System.out.println(">>>>makeOrder");
        BookDescription bookDescription = bookDescriptionCatalog.getBookDescription(bookDescriptionID);
        if(bookDescription.getAvailableInstances() <= 0) {
            System.out.println("There are no available books");
            return null;
        }
        bookDescription.decreaseInstances();
        Order order = orderCatalog.makeOrder(subscriber, bookDescription);
        setOrder(order);
        return order;
    }

    public LocalDate retrieveBook(Order order, String bookID){
        System.out.println(">>>>retrieveBook");
        if(order == null) return null;
        System.out.println(order);
        Book book = bookRepository.getBook(bookID);
        book.setStatus("ordered");
        book.setOrder(order);
        order.setStatus("ready");
        order.setDeadlineToBorrow(LocalDate.now().plusWeeks(1));
        order.setBook(book);
        LocalDate deadline = order.getDeadlineToBorrow();
        setOrder(null);
        System.out.println(book);
        System.out.println(order);
        return deadline;
    }

    public void returnBook(String bookID){
        System.out.println(">>>>returnBook");
        Book book = bookRepository.getBook(bookID);
        Order order = book.getOrder();
        if(order == null) return;
        System.out.println(book);
        book.setStatus("available");
        System.out.println(order);
        Subscriber subscriber = order.getSubscriber();
        archive.archiveOrder(order, bookID, subscriber);
        String orderID = order.getOrderID();
        orderCatalog.removeOrder(orderID);
        subscriber.removeOrder(order);
    }


    public void setSubscriber(Subscriber subscriber){
        this.subscriber = subscriber;
    }

    public void signIn(String cardID){
        Subscriber subscriber = subscriberCatalog.getSubscriber(cardID);
        setSubscriber(subscriber);
    }

    public void signOut(){
        this.subscriber = null;
    }


    // description adding, book adding
    public void addBookDescription(BookDescription bDesc){
        bookDescriptionCatalog.addBookDescription(bDesc);
    }

    public String addBook(String bDescID){
        BookDescription bDesc = bookDescriptionCatalog.getBookDescription(bDescID);
        bDesc.increaseInstances();
        return bookRepository.addBook(bDesc);
    }

    public void setOrder(Order order){
        this.order = order;
    }




    // to be deleted later on
    public SubscriberCatalog getSubscriberCatalog() {
        return subscriberCatalog;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public BookDescriptionCatalog getBookDescriptionCatalog() {
        return bookDescriptionCatalog;
    }

    public Archive getArchive() {
        return archive;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }



}
