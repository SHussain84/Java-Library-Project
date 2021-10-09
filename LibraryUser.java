import java.io.*;
import java.util.*;
/**
 * Write a description of class LibraryUser here.
 *
 * @author Subhaan Hussain
 * @version Part 4
 */
public class LibraryUser
{
    // instance variables
    private String userID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    
    public LibraryUser() 
    {
        this.userID = "";
        this.surname = "";
        this.firstName = "";
        this.otherInitials = "";
        this.title = "";
    }
    
    public String getUserID() { // returns the value of the userID field
        return userID;
    }
    
    public void setUserID(String userID) { // sets the userID field to the new specified input
        this.userID = userID;
    }
    
    public String getSurname() { // returns the value of the surname field
        return surname;
    }
    
    public void setSurname(String surname) { // sets the surname field to the new specified input
        this.surname = surname;
    }
    
    public String getFirstName() { // returns the value of the firstName field
        return firstName;
    }
    
    public void setFirstName(String firstNameserID) { // sets the firstName field to the new specified input
        this.firstName = firstName;
    }
    
    public String getOtherInitials() { // returns the value of the otherInitials field
        return otherInitials;
    }
    
    public void setOtherInitials(String otherInitials) { // sets the otherInitials field to the new specified input
        this.otherInitials = otherInitials;
    }
    
    public String getTitle() { // returns the value of the title field
        return title;
    }
    
    public void setTitle(String title) { // sets the title field to the new specified input
        this.title = title;
    }
    
    public void printDetails() { // creates a method called printDetails which prints out all of the details
        System.out.println("The user ID is: " + userID);
        System.out.println("The surname is: " + surname);
        System.out.println("The first name is: " + firstName);
        System.out.println("The other initials are: " + otherInitials);
        System.out.println("The title is: " + title);
    }
    
    public void readData(Scanner scanner) // creates a method called readData which takes a scanner as a parameter
    {
        while (scanner.hasNext()) { // while scanner has another token in its input
            this.userID = scanner.next(); // reads the next token and stores it in the userID field
            this.surname = scanner.next(); // reads the next token and stores it in the surname field
            this.firstName = scanner.next(); // reads the next token and stores it in the firstName field
            this.otherInitials = scanner.next(); // reads the next token and stores it in the otherInitials field
            this.title = scanner.next(); // reads the next token and stores it in the title field
        }
    }
    
    public void writeData(PrintWriter pWriter, LibraryUser libraryUser) { // creates a method called readData which takes a PrintWriter and LibraryUser object as a parameter
        String delimiter = ", ";
        String lineOfOutput = libraryUser.getUserID() + delimiter + libraryUser.getSurname() + delimiter + libraryUser.getFirstName() + delimiter + libraryUser.getOtherInitials() + delimiter + libraryUser.getTitle();  // creates a line of output
        pWriter.println(lineOfOutput); // prints the line to the file
    }
}
