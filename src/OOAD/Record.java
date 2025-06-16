package OOAD;

import java.time.LocalDate;

public class Record {

    private String bookID;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String personalData;

    public Record(String bookID, LocalDate borrowDate, LocalDate returnDate, String personalData) {
        this.bookID = bookID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.personalData = personalData;
    }

    @Override
    public String toString(){
        return "record: {" + "borrowDate: " + borrowDate + ", returnDate: " + returnDate + ", personalData: " + personalData + "}";
    }
}
