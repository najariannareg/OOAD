package OOAD;

public class BookDescription {

    private String author;
    private int availableInstances;
    private int borrowTime;
    private String bookDescriptionID;
    private String edition;
    private String genre;
    private String publisher;
    private String title;

    public BookDescription(String bDescID, String author, int borrowTime, String edition, String genre, String publisher, String title) {
        this.author = author;
        this.availableInstances = 0;
        this.borrowTime = borrowTime;
        this.bookDescriptionID = bDescID;
        this.edition = edition;
        this.genre = genre;
        this.publisher = publisher;
        this.title = title;
    }

    public void decreaseInstances(){
        this.availableInstances--;
    }

    public void increaseInstances(){
        this.availableInstances++;
    }

    public String getBookDescriptionID() { return bookDescriptionID; }

    public int getAvailableInstances(){
        return availableInstances;
    }


    @Override
    public String toString(){
        return "BookDescription: {bookDescriptionID: " + bookDescriptionID + ", availableInstances: " + availableInstances + "}";
    }

}
