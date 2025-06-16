package OOAD;

public class Demo {

    public static void main(String[] args) {

        Library library = new Library("Bodleian", "Yerevan");
        Controller controller = library.getController();


        // Adding Book Descriptions
        BookDescription bDesc1 = new BookDescription("HarryPotter1","Joanne Rowling", 30,
                "4th edition", "fantastic", "Bloomsbury","Harry Potter and the Philosopher's Stone");

        BookDescription bDesc2 = new BookDescription("HarryPotter2","Joanne Rowling", 30,
                "2nd edition", "fantastic", "Bloomsbury","Harry Potter and The Chamber of Secrets");


        System.out.println("\nPrinting out Book Descriptions:");
        System.out.println(bDesc1);
        System.out.println(bDesc2);
        System.out.print( "\n" );

        controller.addBookDescription(bDesc1);
        controller.addBookDescription(bDesc2);

        //Adding Books
        String bookID1 = controller.addBook("HarryPotter1");
        String bookID2 = controller.addBook("HarryPotter1");
        String bookID3 = controller.addBook("HarryPotter2");
        String bookID4 = controller.addBook("HarryPotter2");
        String bookID5 = controller.addBook("HarryPotter2");



        System.out.println("There are " + controller.getBookDescriptionCatalog().getBookDescriptions().size() + " descriptions in Book Description Catalog.");
        System.out.println("There are " + controller.getBookRepository().getBooks().size() + " books in Book Repository.");
        System.out.print( "\n\n" );
        
        //Adding a subscriber
        String cardID1 = controller.makeRegistration("Arevik Harmandayan");
        System.out.print( "\n\n" );

        //Signing in
        controller.signIn(cardID1);

        //making orders
        Order order1 = controller.makeOrder("HarryPotter1");
        Order order2 = controller.makeOrder("HarryPotter2");
        System.out.print( "\n\n" );



        //retrieving books
        controller.retrieveBook(order1, bookID1);
        controller.retrieveBook(order2, bookID3);
        System.out.print( "\n\n" );

        //cancelling order
        order1 = controller.cancelOrder(order1.getOrderID());
        System.out.print( "\n\n" );

        //signing out
        controller.signOut();


        //borrowing books
        controller.borrowBooks(cardID1);
        System.out.print( "\n\n" );

        //returning books
        controller.returnBook(bookID1);
        controller.returnBook(bookID3);
        System.out.print( "\n\n" );

    }

}
