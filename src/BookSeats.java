package src;

import java.util.List;

public class BookSeats {
    /*
        To Book seats, we need theatre, show and the seats information 
    */
    public BookSeats() {}

    public boolean chooseTickets (String user, String theatreName, Show show, List<Integer> seatIds) {
        Seat[] allSeats = show.getSeats();

        for(int seat : seatIds) {
            synchronized (allSeats[seat]) {
                // if (isPaymentCompleted == true)
                    if (allSeats[seat].isBooked) return false;
                    allSeats[seat].bookSeat(user);
                    // System.out.println(user+ " successfully booked ticket - "+seat+" at "+theatreName+" of show "+show.getShowTime());
            }
        }
        return true;
    }

    public boolean areChoosenTicketsBooked(Show show, List<Integer> seatIds) {
        Seat[] allSeats = show.getSeats();
        for (Seat seat : allSeats)
            if (seat != null && seat.isBooked) return true;

        return false;
    }

}