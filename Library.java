// imports the required packages
import java.io.*;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Library
{
    // private ArrayList<LibraryItem> itemList;
    // private ArrayList<LibraryUser> userList;
    HashMap<String, LibraryItem> itemMap; // creates a new HashMap with String keys and LibraryItem objects 
    HashMap<String, LibraryUser> userMap; // creates a new HashMap with String keys and LibraryUser objects 
    HashMap<String, ItemReservation> itemReservationMap; // creates a new HashMap with String keys and ItemReservation objects 
    Diary diary; 
    private int reservationCounter = 0;
    private Frame myFrame;
    private String testUserID;
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // itemList = new ArrayList<LibraryItem>();
        // userList = new ArrayList<LibraryUser>();
        itemMap = new HashMap<String, LibraryItem>();
        userMap = new HashMap<String, LibraryUser>();
        itemReservationMap = new HashMap<String, ItemReservation>();
        diary = new Diary();
    }

    public void storeItemReservation(ItemReservation itemReservation) { // method to store item reservations
        itemReservationMap.put(itemReservation.getReservationNo(), itemReservation); // adds an item reservation to the itemReservationMap with a reservation number as the key and ItemReservation object as the value
        diary.addReservation(itemReservation); // adds the item reservation to the diary
    }

    public ItemReservation getItemReservation(String reservationNo) { // returns the ItemReservation object using the HashMap itemReservationMap
        return itemReservationMap.get(reservationNo);
    }

    public void printItemReservations() { // iterates through the itemReservationMap and uses the printDetails method to print all of the details with that ItemReservation object
        for (ItemReservation itemReservation : itemReservationMap.values()) {
            itemReservation.printDetails();
        }
    }

    public void printDiaryEntries(String startDate, String endDate) { // prints the diary entries within a specified startDate and endDate
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
    }

    public void readItemReservation() { // creates a new method called readItemReservation
        String lineOfText = "";
        File dataFile = null; // creates a new file called dataFile and initialises it to null
        try { // tries the following code, if an error occurs then it is caught by the accompanying catch
            FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD); // creates a new FileDialog in "Open" mode
            fileBox.setDirectory("data"); // sets the directory to the data folder
            fileBox.setVisible(true); // makes the file dialog visible
            String path = fileBox.getDirectory() + fileBox.getFile(); // creates the path by concatenating the directory and file
            dataFile = new File(path); // sets the file to the path
        }
        catch ( NullPointerException ex) { // catches the null pointer exception ex
            System.out.println("You have not selected a file.");
        }
        if (dataFile != null) { // if dataFile is set to something
            Scanner typeScanner = null;
            try {
                typeScanner = new Scanner(dataFile); // tries to set typeScanner to the dataFile
            }
            catch ( FileNotFoundException ex ) { // if the file is not found, output the following message
                System.out.println("There is a problem with the file you selected.");
            }
            if (typeScanner != null) { // if typeScanner is not null
                while (typeScanner.hasNextLine()) { // while there is a next line
                    lineOfText = typeScanner.nextLine().trim(); // trims the next line and sets it to lineOfText
                    if (! lineOfText.startsWith("//") && (! lineOfText.isEmpty())) { // checks to ensure lineOfText does not start with // or is empty
                        Scanner textScanner = new Scanner(lineOfText); // creates a new scanner called textScanner and sets it to the lineOfText
                        textScanner.useDelimiter(" *, *"); // uses the following regex delimiter
                        ItemReservation itemReservation = new ItemReservation(); // creates a new ItemReservation object
                        itemReservation.readData(textScanner); // uses the readData method in itemReservation
                        storeItemReservation(itemReservation); // calls the storeItemReservation method to store the item reservation
                        textScanner.close(); // closes the textScanner
                        reservationCounter++; // increments the reservationCounter by 1
                    }
                }     
                typeScanner.close(); // closes the typeScanner
            }
        }
    }

    public void writeItemReservation() { // creates a new method called writeItemReservation
        File dataFile = null;
        try {
            FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD); // creates a new FileDialog in "Open" mode
            fileBox.setDirectory("data"); // sets the directory to the data folder
            fileBox.setVisible(true); // makes the file dialog visible
            String path = fileBox.getDirectory() + fileBox.getFile(); // creates the path by concatenating the directory and file
            dataFile = new File(path); // sets the file to the path
        }
        catch ( NullPointerException ex) { // catches the null pointer exception ex
            System.out.println("You have not selected a file.");
        }
        if (dataFile != null) { // if dataFile is set to something 
            PrintWriter pWriter = null; // creates a new PrintWriter and sets it to null
            try {
                pWriter = new PrintWriter(dataFile); // tries to set it to the data file, if not catches the exception
            }
            catch (IOException ex) { 
                System.out.println("An error occurred.");
            }
            for (ItemReservation itemReservation : itemReservationMap.values()) { // iterates through the itemReservationMap HashMap
                itemReservation.writeData(pWriter, itemReservation); // calls the writeData method in itemReservation and passes the required parameters
            }
            pWriter.close(); // closes the print writer
        }
    }

    public Boolean makeItemReservation(String userID, String itemCode, String stringStartDate, int noOfDays) { // creates a new method called makeItemReservation
        Date startDate;
        if (!userMap.containsKey(userID)) { // if userMap does not contain the userID key, then execute the following code
            System.out.println("User with " + userID + " does not exist.");
            return false;
        }
        if (!itemMap.containsKey(itemCode)) { // if itemMap does not contain the itemCode key, then execute the following code
            System.out.println("Item with " + itemCode + " does not exist.");
            return false;
        }
        try { // tries to convert the date input
            startDate = DateUtil.convertStringToDate(stringStartDate);
        }
        catch (Exception ex) { // if the above code cannot execute, catches the error and outputs the following line
            System.out.println("Invalid start date. The date should be entered in the format dd-mm-yyyy");
            return false;
        }
        if (noOfDays <= 0) { // checks to ensure the number of days is above 0
            System.out.println("The number of days must be greater than 0.");
            return false;
        }
        Date endDate = DateUtil.incrementDate(startDate, noOfDays); // calculates the endDate by using the incrementDate method to add the noOfDays to the startDate
        if (isItemReserved(itemCode, startDate, endDate)) { // uses the isItemReserved method to check if the item is reserved during the specified time
            System.out.println("This item is reserved during " + stringStartDate + " and " + DateUtil.convertDateToShortString(endDate) + ".");
            System.out.println("Your reservation has not been made, please try again during a different time period.");
            return false;
        }
        String reservationNo = generateReservationNo(); // creates a new variable called reservationNo and sets the value of it to a generated one using the generateReservationNo method
        ItemReservation itemReservation = new ItemReservation(reservationNo, itemCode, userID, stringStartDate, noOfDays); // creates a new ItemReservation object with the specified parameters
        storeItemReservation(itemReservation); // uses the storeItemReservation method to add the itemReservation to the HashMap and diary
        reservationCounter++; // increments reservationCounter by 1
        return true;
    }

    private boolean isItemReserved(String itemCode, Date startDate, Date endDate) { // creates a method called isItemReserved which returns a boolean value
        for (ItemReservation itemReservation : itemReservationMap.values()) { // iterates through the itemReservationMap and checks if the corresponding item is reserved
            if (itemReservation.getItemCode().equals(itemCode) && dateCheck(startDate,endDate,itemReservation.getStartDate(),DateUtil.incrementDate(itemReservation.getStartDate(),itemReservation.getNoOfDays()))) {
                return true;
            }
        }
        return false;
    }

    private boolean dateCheck(Date userStartDate, Date userEndDate, Date itemStartDate, Date itemEndDate) { // creates a method called dateCheck which returns a boolean value
        return (userStartDate.before(itemEndDate) || userStartDate.equals(itemEndDate)) && (userEndDate.after(itemStartDate) || userEndDate.equals(itemStartDate)); // checks if the user start date is before or on the end date, and if the user end date is after or on the start date
    } 

    private String generateReservationNo() { // creates a method called generateReservationNo
        Boolean unique = false;
        Boolean flag = false;
        String reservationNo = "";
        int num = 0;
        if (reservationCounter == 0) { // if the reservationCounter is 0, set the value to 000001
            reservationNo = "000001";
        }
        else {
            reservationCounter = reservationCounter + 1; 
            for (int i = (Integer.toString(reservationCounter)).length(); i < 6; i++) {
                    reservationNo = reservationNo + "0";
            }
            reservationNo = reservationNo + String.valueOf(reservationCounter);
        }
        return reservationNo;
    }

    public void storeItem(LibraryItem libraryItem) // creates a new method called storeItem which stores a libraryItem in the itemMap
    {
        // itemList.add(libraryItem);
        itemMap.put(libraryItem.getItemCode(), libraryItem);
    }

    public void storeUser(LibraryUser libraryUser) { // creates a new method called storeUser which stores a libraryUser in the userMap
        // userList.add(libraryUser);
        String ID = libraryUser.getUserID();
        if (ID.equals("unknown")) {
            libraryUser.setUserID(generateUserID("AB-", 6));
        }
        userMap.put(libraryUser.getUserID(), libraryUser);
        testUserID = libraryUser.getUserID(); // for testing purposes only, gets a libraryUserID to use in the Test class
    }
    
    public String getTestUserID() { // getter for the testUserID field which returns testUserID
        return testUserID;
    }

    public void printAllItems() 
    {
        // for (LibraryItem libraryItem : itemList) {
        for (LibraryItem libraryItem : itemMap.values()) { // iterates through the itemMap and prints the details of each libraryItem
            libraryItem.printDetails();
        }
    }

    public void printAllUsers()
    {
        // for (LibraryUser libraryUser : userList) {
        for (LibraryUser libraryUser : userMap.values()) { // iterates through the userMap and prints the details of each libraryUser
            libraryUser.printDetails();
        }
    }

    public void writeUserData() throws FileNotFoundException {
        String filename = "data\\user_data.txt";
        PrintWriter pWriter = new PrintWriter(filename); // creates a new PrintWriter with the filename
        // for (LibraryUser libraryUser: userList) {
        for (LibraryUser libraryUser: userMap.values()) { // iterates through the userMap
            libraryUser.writeData(pWriter, libraryUser); // calls the writeData method in libraryUser and passes the required parameters
        }
        pWriter.close(); // closes the PrintWriter
    }

    private String generateUserID(String prefix, int length) {
        boolean flag = true;
        String userID = "";
        while (flag == true) { // while the flag is set to true
            int min = (int)Math.pow(10, length - 1); // uses Math.pow to get a minimum value
            int randomNum = min + new Random().nextInt(9 * min); // generates a random number and adds it onto the minimum value
            userID = prefix + Integer.toString(randomNum); // concatenates the prefix and random number to create the userID 
            if (!userMap.containsKey(userID)) { // checks if the userMap does not contain the newly generated userID
                flag = false; // sets the flag to false to exit the loop
            }
        }
        return userID; // returns the newly generated userID
    }
    
    public void deleteItemReservation(String reservationNo) { // deletes the itemReservation using the reservationNo
        diary.deleteReservation(itemReservationMap.get(reservationNo));
        itemReservationMap.remove(reservationNo);
    }
    
    public int getReservationCounter() { // returns the reservationCounter
        return reservationCounter;
    }
    
    public void setReservationCounter(int reservationCounter) { // sets the reservationCounter to the input specified
        this.reservationCounter = reservationCounter;
    }

    public void readItemData() { // creates a new method called readItemData
        String lineOfText = "";
        File dataFile = null;
        try {
            FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD); // creates a new FileDialog in "Open" mode
            fileBox.setDirectory("data"); // sets the directory to the data folder
            fileBox.setVisible(true); // makes the file dialog visible
            String path = fileBox.getDirectory() + fileBox.getFile(); // creates the path by concatenating the directory and file
            dataFile = new File(path); // sets the file to the path
        }
        catch ( NullPointerException ex) { // catches the null pointer exception ex
            System.out.println("You have not selected a file.");
        }
        if (dataFile != null) { // if dataFile is set to something
            Scanner typeScanner = null;
            try {
                typeScanner = new Scanner(dataFile);
            }
            catch ( FileNotFoundException ex ) { 
                System.out.println("There is a problem with the file you selected.");
            }
            if (typeScanner != null) {
                String typeOfData = "";
                while (typeScanner.hasNextLine()) {
                    lineOfText = typeScanner.nextLine().trim();
                    if (lineOfText.startsWith("[")) { // if lineOfText starts with [
                        typeOfData = lineOfText.toLowerCase(); // set the type of data to the lineOfText
                        continue; // breaks one iteration in the loop and continues with the next iteration
                    }
                    if (! lineOfText.startsWith("//") && (! lineOfText.isEmpty())) { // if the lineOfText does not start with // and is not empty
                        Scanner textScanner = new Scanner(lineOfText);
                        textScanner.useDelimiter(" *, *"); // uses the following regex delimiter
                        switch(typeOfData) { // uses a switch statement on the typeOfData
                            case "[book data]": // if the type of data is book data, execute the following code
                            Book newBook = new Book();
                            newBook.readData(textScanner);
                            storeItem(newBook);
                            break;
                            case "[cd data]": // if the type of data is cd data, execute the following code
                            CD newCD = new CD();
                            newCD.readData(textScanner);
                            storeItem(newCD);
                            break;
                            case "[dvd data]": // if the type of data is dvd data, execute the following code
                            DVD newDVD = new DVD();
                            newDVD.readData(textScanner);
                            storeItem(newDVD);
                            break;
                            case "[periodical data]": // if the type of data is periodical data, execute the following code
                            Periodical newPeriodical = new Periodical();
                            newPeriodical.readData(textScanner);
                            storeItem(newPeriodical);
                            break;
                            case "[library user data]": // if the type of data is library user data, execute the following code
                            LibraryUser libraryUser = new LibraryUser();
                            libraryUser.readData(textScanner);
                            storeUser(libraryUser);
                            break;
                            default: // if none of the conditions are met, output the following line
                            System.out.println("Unexpected data in the data file!"); 
                            continue; 
                        }
                        textScanner.close(); // close the textScanner
                    }
                }     
                typeScanner.close(); // close the typeScanner
            }
        }
    }
}
