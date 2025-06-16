package OOAD;

import java.time.LocalDate;

public class Order {

    private Book book;
    private Subscriber subscriber;
    private BookDescription bookDescription;
    private String orderID;
    private LocalDate orderDate;
    private LocalDate borrowDate;
    private LocalDate deadlineToBorrow;
    private String status;

    public Order(String orderID, Subscriber subscriber, BookDescription bookDescription, LocalDate orderDate){
        this.orderID = orderID;
        this.subscriber = subscriber;
        this.bookDescription = bookDescription;
        this.orderDate = orderDate;
        this.status = "incomplete";
    }

    public BookDescription getBookDescription() {
        return bookDescription;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book){ this.book = book; }

    public String getOrderID() {
        return orderID;
    }

    public LocalDate getBorrowDate() {return borrowDate; }

    private void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDeadlineToBorrow() { return deadlineToBorrow; }

    public void setDeadlineToBorrow(LocalDate deadlineToBorrow) {
        this.deadlineToBorrow = deadlineToBorrow;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public String getStatus() {
        return status;
    }

    public void setBookDescription(BookDescription bookDescription){
        this.bookDescription = bookDescription;
    }


    @Override
    public String toString(){
        return "order: {borrowDate: " + borrowDate + ", deadlineToBorrow: " + deadlineToBorrow + ", status: " + status + "}";
    }

}
