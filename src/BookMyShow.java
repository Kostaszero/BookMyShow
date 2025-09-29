package src;
import java.util.Set;
import src.Controllers.TheatreController;

public class BookMyShow {
    TheatreController theatreController;

    BookMyShow () {
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initializePreview();
        
        Set<String> moviesinCity = bookMyShow.theatreController.getMoviesInCity("Hyderabad");
        print(moviesinCity);

    }
    public void initializePreview() {
        Theatre PVR = theatreController.createThreatre("PVR", "Hyderabad", 2);
        Theatre Inox = theatreController.createThreatre("Inox", "Hyderabad", 2);
        Theatre AMB = theatreController.createThreatre("AMB", "Mumbai", 2);
        Theatre Shiva = theatreController.createThreatre("Shiva Ganga", "Chennai", 1);
        Theatre Miraj = theatreController.createThreatre("Miraj", "Chennai", 1);

        // Add movies
        int showId1 = PVR.addShow("0900", "1230", "Demon Slayer", 1, 10);
        PVR.addShow("1300", "1530", "Fighter", 2, 10);

        Inox.addShow("0900", "1230", "Taxi Driver", 1, 10);
        Inox.addShow("0930", "1300", "War 2", 2, 10);

        AMB.addShow("0800", "1130", "Demon Slayer", 1, 10);
        AMB.addShow("1300", "1530", "Little Hearts", 2, 10);

        Shiva.addShow("0930", "1230", "Ben Hur", 1, 10);
        Miraj.addShow("1000", "1300", "Jawan", 1, 10);
        
        print(showId1);
    }

    public static void print(Object... str) {
        for (Object s : str) {
            System.out.print(s.toString()+" ");
        }
        System.out.println();
    }
}
