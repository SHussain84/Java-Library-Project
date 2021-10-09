import java.io.*;
import java.util.*;
/**
 * Write a description of class Book here.
 *
 * @author Subhaan Hussain
 * @version Part 4
 */
public class Book extends PrintedItem
{
    // instance variables
    private String author;
    private String isbn;

    /**
     * Constructor for objects of class Book
     */

    public Book()
    {
        super(); // calls the super constructor (PrintedItem)
        this.author = "";
        this.isbn = "";
    }

    public void readData(Scanner scanner2) // creates a method called readData which takes a scanner as a parameter
    {
        while (scanner2.hasNext()) { // while scanner has another token in its input
            this.author = scanner2.next(); // reads the next token and stores it in the author field
            this.isbn = scanner2.next(); // reads the next token and stores it in the isbn field
            super.readData(scanner2); // calls the super readData method to read the rest of the data
        }
    }
    
    public void printDetails() { // creates a method called printDetails
        super.printDetails(); // calls the super print details method first
        System.out.println("The author is: " + author + ".");
        System.out.println("The ISBN is: " + isbn + ".");
    }

    public String getAuthor() { // returns the value of the author field
        return author;
    }

    public void setAuthor(String author) // sets the author field to the new specified input
    {
        this.author = author;
    }

    public String getIsbn() { // returns the value of the isbn field
        return isbn;
    }

    public void setIsbn(String isbn) // sets the isbn field to the new specified input
    {
        this.isbn = isbn;
    }
}
