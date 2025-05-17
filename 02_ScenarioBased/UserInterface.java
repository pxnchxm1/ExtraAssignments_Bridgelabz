

// Requirement 1: Filter the bookingIds based on the date of booking.
// Type
// (Class)

// Methods Responsibilities

// BookCabMai
// n

// public
// List<String> findCabBookingIdsForTheBookingDate
// (Date date)

// This method filters
// the booking and
// returns the list of
// booking Ids that
// have been booked
// on the given
// date. Condition: T
// he date format

// must be (yyyy-
// MM-dd).

// In the UserInterface class, within the main method, get the date to search for bookings.
// Invoke the findCabBookingIdsForTheBookingDate method, passing the date as an
// argument, and display the booking IDs as shown in the sample output.
// Note:
// • In the Sample Input / Output provided, the highlighted text in bold corresponds
// to the input given by the user, and the rest of the text represents the output.
// • Ensure to follow the object-oriented specifications provided in the question
// description.

// • Ensure to provide the names for the classes, attributes, and methods as
// specified in the question description.
// • Adhere to the code template, if provided.

// Sample Input/Output 1:
// Enter number of bookings to be added
// 3
// Enter the Booking details (Booking Id:Date of Booking)
// AIONM:2022-09-23
// BCIUS:2022-07-12
// CDJJD:2022-09-23
// Enter the date to check the booking
// 2022-09-23
// Booking Ids booked on the 2022-09-23 are by
// AIONM
// CDJJD

// Sample Input/Output 2:
// Enter number of bookings to be added
// 2
// Enter the Booking details (Booking Id:Date of Booking)
// AHJNK:2024-06-12
// LIKNM:2024-06-18
// Enter the date to check the booking
// 2024-06-19
// No bookings were booked


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class BookCabMain{
    private Map<String,Date> bookingMap;
    public BookCabMain(){
        bookingMap = new HashMap<>();
    }
    void bookCab(String id,Date date){
        this.bookingMap.put(id,date);
    }
    Date getBookingDate(String id){
        return bookingMap.get(id);
    }
    public List<String> findCabBookingIdsForTheBookingDate(Date date){
        List<String> bookingIds = new ArrayList<>();
        for(String id : bookingMap.keySet()){
            if(bookingMap.get(id).equals(date)){
                bookingIds.add(id);
            }
        }
        return bookingIds;
    }
}
public class UserInterface{
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BookCabMain carPro = new BookCabMain();
        Scanner sc = new Scanner(System.in);

        System.out.println(" Enter number of bookings to be added : ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Booking details (Booking Id:Date of Booking(yyyy-mm-dd))");
        for(int i=0;i<num;i++){
            String s = sc.nextLine();
            String bookingID = s.split(":")[0];
            try{
                Date bookingDate = df.parse(s.split(":")[1]);
                carPro.bookCab(bookingID, bookingDate);
            }catch(ParseException p){
                System.out.println("error parsing date ");
            }
        }
        System.out.println("Enter the date to check the booking(yyyy-mm-dd)");
        try {
            Date checkingdate = df.parse(sc.nextLine());
            System.out.println("Booking Ids booked on the 2022-09-23 are by");
            List<String> ids = carPro.findCabBookingIdsForTheBookingDate(checkingdate);
            for(int idx=0;idx<ids.size();idx++){
                System.out.println(ids.get(idx)); 
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}