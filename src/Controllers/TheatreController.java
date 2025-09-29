package src.Controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import src.Theatre;
import src.BookSeats;
import src.Show;

public class TheatreController { // This is will create a threatre and assign its screen to Show
    
    /* ThreatreController will create threate, 
        threate will create shows to screen and 
        shows will use screens and book seats
    */
    HashMap<String, ArrayList<Theatre>> cityTheatreMap;
    BookSeats bookSeatsController;
    public TheatreController () {
        cityTheatreMap = new HashMap<>();
        bookSeatsController = new BookSeats();
    }

    public Theatre createThreatre (String Name, String city, int totalScreens) {
        Theatre theatre = new Theatre(Name, city, totalScreens);
        ArrayList<Theatre> theatreList = cityTheatreMap.getOrDefault(city, new ArrayList<Theatre>());
        theatreList.add(theatre);
        cityTheatreMap.putIfAbsent(city, theatreList);
        return theatre;
    }

    public Set<String> getMoviesInCity(String city) {
        Set<String> allMovies = new HashSet<>();
        for (Theatre theatre : cityTheatreMap.get(city)) {
            allMovies.addAll(theatre.getAllMovies());
        }
        return allMovies;
    }

    public void bookSeats(String user, Theatre theatre, int showId, List<Integer> seatIds) {
        Show show = this.getAllShowsinTheatre(theatre).get(showId);
        bookSeatsController.chooseTickets(user, theatre, show, seatIds);
    }

    public ArrayList<Show> getAllShowsinTheatre (Theatre theatre) {
        return theatre.getAllShows();
    }

}
