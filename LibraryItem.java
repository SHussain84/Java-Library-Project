import java.io.*;
import java.util.*;
/**
 * Write a description of class LibraryItem here.
 *
 * @author Subhaan Hussain
 * @version Part 4
 */
abstract class LibraryItem
{
    // instance variables
    private String title;
    private String itemCode;
    private int cost;
    private int timesBorrowed;
    private boolean onLoan;
    
    public LibraryItem(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan) {
        this.title = title;
        this.itemCode = itemCode;
        this.cost = cost;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
    }
    
    public LibraryItem() {
        this.title = "";
        this.itemCode = "";
        this.cost = 0;
        this.timesBorrowed = 0;
        this.onLoan = false;
    }
    
    public void readData(Scanner scanner2) // creates a method called readData which takes a scanner as a parameter
    {
        this.title = scanner2.next(); // reads the next token and stores it in the title field
        this.itemCode = scanner2.next(); // reads the next token and stores it in the itemCode field
        this.cost = scanner2.nextInt(); // reads the next integer token and stores it in the cost field
        this.timesBorrowed = scanner2.nextInt(); // reads the next integer token and stores it in the timesBorrowed field
        this.onLoan = scanner2.nextBoolean(); // reads the next boolean token and stores it in the onLoan field
    }

    public String getTitle() // returns the value of the title field
    {
        return title;
    }

    public void setTitle(String title) // sets the title field to the new specified input
    {
        this.title = title;
    }

    public String getItemCode() // returns the value of the itemCode field
    {
        return itemCode;
    }

    public void setItemCode(String itemCode) // sets the itemCode field to the new specified input
    {
        this.itemCode = itemCode;
    }

    public int getCost() // returns the value of the cost field
    {
        return cost;
    }

    public void setCost(int cost) // sets the cost field to the new specified input
    {
        this.cost = cost;
    }

    public int getTimesBorrowed() // returns the value of the timesBorrowed field
    {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) // sets the timesBorrowed field to the new specified input
    {
        this.timesBorrowed = timesBorrowed;
    }

    public boolean getOnLoan() // returns the value of the onLoan field
    {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) // sets the onLoan field to the new specified input
    {
        this.onLoan = onLoan;
    }

    public void printDetails() { // creates a method called printDetails which prints out all of the details
        System.out.println(title + " with item code " + itemCode + " has been borrowed " + timesBorrowed + " times.");
        if (onLoan == true) {
            System.out.println("This item is at present on loan and when new cost " + cost + " pence.");
        }
        else if (onLoan == false) {
            System.out.println("This item is at present not on loan and when new cost "  + cost + " pence.");
        }
    }

    public void readItemData(Scanner scanner2) { // creates a method called readItemData which takes a scanner as a parameter
        while (scanner2.hasNext()) { // while scanner has another token in its input
            this.title = scanner2.next(); // reads the next token and stores it in the title field
            this.itemCode = scanner2.next(); // reads the next token and stores it in the itemCode field
            this.cost = scanner2.nextInt(); // reads the next integer token and stores it in the cost field
            this.timesBorrowed = scanner2.nextInt(); // reads the next integer token and stores it in the timesBorrowed field
            this.onLoan = scanner2.nextBoolean(); // reads the next boolean token and stores it in the onLoan field
        }
    }
}
