import java.io.*;
import java.util.*;
public class AudioVisual extends LibraryItem
{
    // instance variables
    private int playingTime; // creates a variable called playingTime

    /**
     * Constructor for objects of class AudioVisual
     */
    
    public AudioVisual() {
        super(); // calls the super constructor (LibraryItem)
        this.playingTime = 0;
    }
    
    public void readData(Scanner scanner2) // creates a method called readData which takes a scanner as a parameter
    {
        this.playingTime = scanner2.nextInt(); // reads the next integer token and stores it in the playingTime field
        super.readData(scanner2); // calls the super readData method and passes the scanner object to it
    }
    
    public void printDetails() { // creates a method called printDetails
        super.printDetails(); // calls the super print details method first
        System.out.println("The playing time is: " + playingTime + ".");
    }

    public int getPlayingTime() // returns the value of the playingTime field
    {
        return playingTime;
    }
    
    public void setPlayingTime(int playingTime) { // sets the playingTime field to the new specified input
        this.playingTime = playingTime;
    }
}
