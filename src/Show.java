package src;

public class Show {
    String startTime, endTime;
    String moviePlaying;
    Screen screen;

    Show (String startTime, String endTime, String moviePlaying) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.moviePlaying = moviePlaying;
    }

    public String getShowTime() {
        return startTime;
    }

    void setScreen (Screen screen) {
        this.screen = screen;
        this.screen.setScreenToUse();
    }

    Seat[] getSeats() {
        return this.screen.getSeats();
    }


}
