import java.util.Scanner;
public class SeatAndCount{
    public static void getSeats(String id){
        if(id.length()!=10){
            System.out.println("Invalid booking Id ! ");
            return;
        }
        String noOfSeats = id.charAt(5)+""+id.charAt(6);
        int n = Integer.valueOf(noOfSeats);
        if(!noOfSeats.matches("\\d+") || !(n<=10) || !(n>=1)){
            System.out.println("Invalid count ");
            return;
        }
        String initialSeat = id.substring(7);
        if(!initialSeat.matches("\\w\\d{2}")){
            System.out.println("Invalid Seat Number");
        }else{
            int start = Integer.valueOf(initialSeat.charAt(1)+""+initialSeat.charAt(2));
            for(int i=start;i<start+n;i++){
                 System.out.println(String.format("%c%02d", initialSeat.charAt(0),i));
            }
        }
         
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter booking id : ");
        String bookingId = sc.next();
        getSeats(bookingId);
    }
}