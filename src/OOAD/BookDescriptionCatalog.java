package OOAD;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookDescriptionCatalog {

    private Map<String, BookDescription> bookDescriptions = new HashMap();

    public BookDescription getBookDescription(String bookDescriptionID){
        return bookDescriptions.get(bookDescriptionID);
    }

    public void addBookDescription(BookDescription bDesc){
        bookDescriptions.put(bDesc.getBookDescriptionID(), bDesc);
    }


    public Map<String, BookDescription> getBookDescriptions() {
        return bookDescriptions;
    }
}
