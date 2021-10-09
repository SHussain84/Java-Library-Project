import java.io.*;
import java.util.*;
/**
 * Write a description of class Periodical here.
 *
 * @author Subhaan Hussain
 * @version Part 4
 */
public class Periodical extends PrintedItem
{
    // instance variables
    private String publicationDate;

    /**
     * Constructor for objects of class Periodical
     */

    public Periodical()
    {
        super(); // calls the super constructor
        this.publicationDate = "";
    }
    
    public void printDetails() { // creates a method called printDetails which prints out all of the details
        super.printDetails(); // calls the super printDetails method to print the other details first
        System.out.println("The publication date is: " + publicationDate + ".");
    }

    public void readData(Scanner scanner3) // creates a method called readData which takes a scanner as a parameter
    {
        while (scanner3.hasNext()) { // while scanner has another token in its input
            this.publicationDate = scanner3.next(); // reads the next token and stores it in the publicationDate field
            super.readData(scanner3); // calls the super readData method and passes the scanner as a parameter
        }
    }

    public String getPublicationDate() { // returns the value of the publicationDate field
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) // sets the publicationDate field to the new specified input
    {
        this.publicationDate = publicationDate;
    }
}
