package src;

import java.util.List;

public class BookSeats {
    /*
        To Book seats, we need theatre, show and the seats information 
    */
    public BookSeats() {}

    public void chooseTickets (String user, Theatre theatre, Show show, List<Integer> seatIds) {
        Seat[] allSeats = show.getSeats();
        for(int seat : seatIds) {
            synchronized (allSeats[seat]) {
                // if (isPaymentCompleted == true)
                    allSeats[seat].bookSeat(user);
                    System.out.println(user+ " successfully booked ticket - "+seat);
            }
        }
    }

}