package src;
public class Screen {
    Seat[] seats;
    boolean isScreenInUse;

    Screen(int totalSeatsInScreen) {
        seats = new Seat[totalSeatsInScreen];
        isScreenInUse = false;
    }

    void createSeat(int seatId, String seatType) {
        seats[seatId] = new Seat(seatId, seatType);
    }

    void setScreenToUse() {
        isScreenInUse = true;
    }

    void unSetScreenToUse() {
        isScreenInUse = false;
    }

    Seat[] getSeats() {
        return seats;
    }

}