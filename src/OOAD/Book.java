package OOAD;

import java.util.UUID;

public class Book {

    private Order order;
    private BookDescription bookDescription;
    private String bookID;
    private String status;

    public Book(BookDescription bookDescription, String bookID, String status) {
        this.bookDescription = bookDescription;
        this.bookID = bookID;
        this.status = status;
    }


    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order) { this.order = order; }

    public void setStatus(String status){
        this.status = status;
    }

    public String getBookID(){
        return bookID;
    }

    @Override
    public String toString(){
        return "book: {" + bookDescription + ", status: " + status + "}";
    }

}
