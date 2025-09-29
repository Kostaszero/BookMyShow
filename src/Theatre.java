package src;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Theatre { // a Threate has screens, shows and movies it is playing
    Screen screenList[];
    ArrayList<Show> shows;
    Set<String> movieList;
    String Name, city;

    public Theatre (String Name, String city, int totalScreens) {
        screenList = new Screen[totalScreens+1];
        shows = new ArrayList<>();
        movieList = new HashSet<>();
        this.city = city;
        this.Name = Name;
    }

    public void addScreen (int screenId, int totalSeats) {
        screenList[screenId] = new Screen(totalSeats);
    }

    public Screen getScreen (int screenId) {
        return screenList[screenId];
    }

    public int addShow (String startTime, String endTime, String movieToPlay, int screenId) {
        Show newShow = new Show(startTime, endTime, movieToPlay);

        newShow.setScreen(screenList[screenId]);

        shows.add(newShow);
        movieList.add(movieToPlay);
        return shows.indexOf(newShow);
    }

    public ArrayList<Show> getAllShows () {
        return shows;
    }
    
    public Set<String> getAllMovies () {
        return movieList;
    }

    public String getTheatreName() {
        return Name;
    }
    // boolean removeShow (String startTime, String endTime) {
    //     movieList.remove()
    // }

}
