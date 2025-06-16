package OOAD;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archive {

    private List<Record> records = new ArrayList<>();

    public Archive(){}

    public void archiveOrder(Order order, String bookID, Subscriber subscriber){
        LocalDate borrowDate = order.getBorrowDate();
        LocalDate returnDate = LocalDate.now();
        String personalData = subscriber.getPersonalData();
        Record record = new Record(bookID, borrowDate, returnDate, personalData);
        records.add(record);

        System.out.println(records.size() + " record in Archive.");
        System.out.println(record);
    }

}
