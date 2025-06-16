package OOAD;

public class Library {

    private SubscriberCatalog subscriberCatalog;
    private OrderCatalog orderCatalog;
    private BookRepository bookRepository;
    private BookDescriptionCatalog bookDescriptionCatalog;
    private Archive archive;
    private Controller controller;
    private String name;
    private String address;


    public Library(String name, String address){
        subscriberCatalog = new SubscriberCatalog();
        orderCatalog = new OrderCatalog();
        bookRepository = new BookRepository();
        bookDescriptionCatalog = new BookDescriptionCatalog();
        archive = new Archive();
        controller = new Controller(subscriberCatalog, orderCatalog, bookRepository, bookDescriptionCatalog, archive);
        this.name = name;
        this.address = address;
    }

    public BookRepository getBookRepository(){
        return bookRepository;
    }

    public BookDescriptionCatalog getBookDescriptionCatalog(){
        return bookDescriptionCatalog;
    }

    public Controller getController() { return controller; }

}
