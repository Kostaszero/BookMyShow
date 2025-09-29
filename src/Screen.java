package src;
public class Screen {
    Seat[] seats;
    boolean isScreenInUse;

    Screen(int totalSeatsInScreen) {
        seats = new Seat[totalSeatsInScreen+1];
        isScreenInUse = false;
    }

    public void createSeat(int seatId, String seatType) {
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