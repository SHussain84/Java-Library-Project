import java.io.*;
import java.util.Date;
/**
 * Write a description of class Test here.
 *
 * @author Subhaan Hussain
 * @version Part 4
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test() throws FileNotFoundException
    {
        System.out.println("--- Creating a new library object ---");
        Library library = new Library();
        System.out.println("--- Reading item data ---");
        library.readItemData();
        System.out.println("--- Printing all items ---");
        library.printAllItems();
        System.out.println("--- Printing all users ---");
        library.printAllUsers();
        System.out.println("--- Writing user data to user_data.txt ---");
        library.writeUserData();
        System.out.println("--- Reading item reservations ---");
        library.readItemReservation();
        System.out.println("--- Making test item reservation ---");
        library.makeItemReservation(library.getTestUserID(), "LM003698", "20-04-2021", 5);
        System.out.println("--- Writing item reservations ----");
        library.writeItemReservation();
        System.out.println("--- Printing all item reservations ---");
        library.printItemReservations();
        System.out.println("--- Deleting an item reservation ---");
        library.deleteItemReservation("000001");
        System.out.println("--- Printing all item reservations again after deletion of 000001 ---");
        library.printItemReservations();
        System.out.println("--- Test to calculate the amount of days between 4th April and 16th April ---");
        Date today = DateUtil.convertStringToDate("04-04-2021");
        Date next = DateUtil.convertStringToDate("16-04-2021");
        System.out.println(DateUtil.daysBetween(today, next));
        System.out.println("--- Testing complete ---");
    }
}
