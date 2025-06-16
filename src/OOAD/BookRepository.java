package OOAD;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public Book getBook(String bookID){
        return books.get(bookID);
    }

    private String generateBookID(){
        return UUID.randomUUID().toString();
    }

    public String addBook(BookDescription bDesc){
        String bookID = UUID.randomUUID().toString();
        Book book = new Book(bDesc, bookID, "available");
        books.put(bookID, book);
        return bookID;
    }

    public Map<String, Book> getBooks() {
        return books;
    }
}
