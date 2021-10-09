import java.io.*;
import java.util.*;
public class CD extends AudioVisual
{
    // instance variables - replace the example below with your own
    private String artist;
    private int noOfTracks;

    /**
     * Constructor for objects of class CD
     */
    
    public CD()
    {
        super(); // calls the super constructor (AudioVisual)
        this.artist = "";
        this.noOfTracks = 0;
    }
    
    public void readData(Scanner scanner3) // creates a method called readData which takes a scanner as a parameter
    {
        while (scanner3.hasNext()) { // while scanner has another token in its input
            this.artist = scanner3.next(); // reads the next token and stores it in the artist field
            this.noOfTracks = scanner3.nextInt(); // reads the next token and stores it in the noOfTracks field
            super.readData(scanner3); // calls the super readData method to read the rest of the data
        }
    }
    
    public void printDetails() { // creates a method called printDetails
        super.printDetails(); // calls the super printDetails method to print the other details first
        System.out.println("The artist is: " + artist + "."); // prints the artist
        System.out.println("The number of tracks are: " + noOfTracks + "."); // prints the number of tracks
    }

    public String getArtist() // returns the value stored in the artist field
    {
        return artist;
    }
    
    public void setArtist(String artist) { // sets the artist field to the new specified input
        this.artist = artist;
    }
    
    public int getNoOfTracks() // returns the value stored in the noOfTracks field
    {
        return noOfTracks;
    }
    
    public void setNoOfTracks(int noOfTracks) { // sets the noOfTracks field to the new specified input
        this.noOfTracks = noOfTracks;
    }
}
