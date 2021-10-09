import java.io.*;
import java.util.*;
public class DVD extends AudioVisual
{
    // instance variables
    private String director;

    /**
     * Constructor for objects of class DVD
     */
    
    public DVD()
    {
        super(); // calls the super constructor (AudioVisual)
        this.director = "";
    }
    
    public void readData(Scanner scanner3) // creates a method called readData which takes a scanner as a parameter
    {
        while (scanner3.hasNext()) { // while scanner has another token in its input
            this.director = scanner3.next(); // reads the next token and stores it in the director field
            super.readData(scanner3); // calls the super readData method to read the rest of the data
        }
    }
    
    public void printDetails() { // creates a method called printDetails
        super.printDetails(); // calls the super print details method first
        System.out.println("The director is: " + director + ".");
    }

    public String getDirector() // returns the value of the director field
    {
        return director;
    }
    
    public void setDirector(String director) { // sets the director field to the new specified input
        this.director = director;
    }
}
