import java.io.*;
import java.util.*;
public class PrintedItem extends LibraryItem
{
    // instance variables - replace the example below with your own
    private int noOfPages;
    private String publisher;

    /**
     * Constructor for objects of class PrintedItem
     */
    
    public PrintedItem() {
        super(); // calls the super constructor
        this.noOfPages = 0;
        this.publisher = "";
    }
    
    public void printDetails() { // creates a method called printDetails which prints out all of the details
        super.printDetails(); // calls the super printDetails method to print all of the other details
        System.out.println("There are " + noOfPages + " pages in this book.");
        System.out.println("The publisher is: " + publisher);
    }

    public void readData(Scanner scanner2) // creates a method called readData which takes a scanner as a parameter
    {
        this.noOfPages = scanner2.nextInt(); // reads the next token and stores it in the noOfPages field
        this.publisher = scanner2.next(); // reads the next token and stores it in the publisher field
        super.readData(scanner2); // calls the super readData method and passes the scanner as a parameter
    }

    public int getNoOfPages() { // returns the value of the noOfPages field
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) { // sets the noOfPages field to the new specified input
        this.noOfPages = noOfPages;
    }

    public String getPublisher() { // returns the value of the publisher field
        return publisher;
    }

    public void setPublisher(String publisher) { // sets the publisher field to the new specified input
        this.publisher = publisher;
    }
}
