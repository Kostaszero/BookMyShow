package src;
public class Seat {
    String seatType, owner;
    int seatId;
    boolean isBooked;

    Seat(int seatId, String seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        isBooked = false;
    }

    void bookSeat(String owner) {
        isBooked = true;
        this.owner = owner;
    }
}
