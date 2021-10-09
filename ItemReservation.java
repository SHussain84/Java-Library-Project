import java.util.Date;
import java.util.Scanner;
import java.io.*;
public class ItemReservation
{
    // instance variables
    private String reservationNo;
    private String itemCode;
    private String userID;
    private Date startDate;
    private int noOfDays;

    /**
     * Constructor for objects of class ItemReservation
     */
    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    public ItemReservation()
    {
        this.reservationNo = "";
        this.itemCode = "";
        this.userID = "";
        this.startDate = null;
        this.noOfDays = 0;
    }
    
    public void readData(Scanner scanner) { // creates a method called readData which takes a scanner as a parameter
        while (scanner.hasNext()) { // while scanner has another token in its input
            this.reservationNo = scanner.next(); // reads the next token and stores it in the reservationNo field
            this.itemCode = scanner.next(); // reads the next token and stores it in the itemCode field
            this.userID = scanner.next(); // reads the next token and stores it in the userID field
            this.startDate = DateUtil.convertStringToDate(scanner.next()); // reads the next token, converts it to a Date object, and stores it in the startDate field
            this.noOfDays = scanner.nextInt(); // reads the next token and stores it in the noOfDays field
        }
    }
    
    public void writeData(PrintWriter pWriter, ItemReservation itemReservation) { // creates a method called readData which takes a PrintWriter and ItemReservation object as a parameter
        String delimiter = ", "; 
        String lineOfOutput = reservationNo + delimiter + itemCode + delimiter + userID + delimiter + DateUtil.convertDateToShortString(startDate) + delimiter + noOfDays; // creates a line of output
        pWriter.println(lineOfOutput); // prints the line to the file
    }
    
    public void printDetails() { // creates a method called printDetails which prints out all of the details
        System.out.println("Reservation number: " + reservationNo);
        System.out.println("Item Code: " + itemCode);
        System.out.println("User ID: " + userID);
        System.out.println("Start date: " + DateUtil.convertDateToLongString(startDate));
        System.out.println("Number of days: " + noOfDays);
    }
    
    public String getReservationNo() { // returns the value of the reservationNo field
        return reservationNo;
    }
    
    public void setReservationNo(String reservationNo) { // sets the reservationNo field to the new specified input
        this.reservationNo = reservationNo;
    }
    
    public String getItemCode() { // returns the value of the itemCode field
        return itemCode;
    }
    
    public void setItemCode(String itemCode) { // sets the itemCode field to the new specified input
        this.itemCode = itemCode;
    }
    
    public String getUserID() { // returns the value of the userID field
        return userID;
    }
    
    public void setUserID(String userID) { // sets the userID field to the new specified input
        this.userID = userID;
    }
    
    public Date getStartDate() { // returns the value of the startDate field
        return startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = DateUtil.convertStringToDate(startDate);
    }
    
    public int getNoOfDays() { // returns the value of the noOfDays field
        return noOfDays;
    }
    
    public void setNoOfDays(int noOfDays) { // sets the noOfDays field to the new specified input
        this.noOfDays = noOfDays;
    }
    
    public String toString() { // returns a string of the details of the ItemReservation object
        return "Reservation Number: " + reservationNo + "\nUser ID: " + userID + "\nItem Code: " + itemCode;
    }
}
