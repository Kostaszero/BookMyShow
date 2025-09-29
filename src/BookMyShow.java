package src;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import src.Controllers.TheatreController;

public class BookMyShow {
    TheatreController theatreController;

    BookMyShow () {
        theatreController = new TheatreController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        List<Theatre> theatreList = bookMyShow.initializePreview();
        
        Set<String> moviesinCity = bookMyShow.theatreController.getMoviesInCity("Hyderabad");
        print(moviesinCity);

        imitateUserBooking(bookMyShow.theatreController, theatreList);


    }
    public List<Theatre> initializePreview() {
        Theatre PVR = theatreController.createThreatre("PVR", "Hyderabad", 2, List.of(5, 10));
        Theatre Inox = theatreController.createThreatre("Inox", "Hyderabad", 2, List.of(5, 10));
        Theatre AMB = theatreController.createThreatre("AMB", "Mumbai", 2, List.of(10, 10));
        Theatre Shiva = theatreController.createThreatre("Shiva Ganga", "Chennai", 1, List.of(5));
        Theatre Miraj = theatreController.createThreatre("Miraj", "Chennai", 1, List.of(5));

        // Add movies
        int showId1 = PVR.addShow("0900", "1230", "Demon Slayer", 1);
        PVR.addShow("1300", "1530", "Fighter", 2);

        Inox.addShow("0900", "1230", "Taxi Driver", 1);
        Inox.addShow("0930", "1300", "War 2", 2);

        AMB.addShow("0800", "1130", "Demon Slayer", 1);
        AMB.addShow("1300", "1530", "Little Hearts", 2);

        Shiva.addShow("0930", "1230", "Ben Hur", 1);
        Miraj.addShow("1000", "1300", "Jawan", 1);
        

        return List.of(PVR, Inox, AMB, Shiva, Miraj);
    }

    public static void print(Object... str) {
        for (Object s : str) {
            System.out.print(s.toString()+" ");
        }
        System.out.println();
    }

    public static void imitateUserBooking(TheatreController theatreController, List<Theatre> theatreList) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 7, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        // Callable<String>
        Runnable user1 = () -> {
            theatreController.bookSeats("user1", theatreList.get(0), 0, List.of(1,2));
        };
        Runnable user2 = () -> {
            theatreController.bookSeats("user2", theatreList.get(0), 0, List.of(1,2));
        };
        Runnable user3 = () -> {
            theatreController.bookSeats("user3", theatreList.get(2), 1, List.of(5,6, 7));
        };
        Runnable user4 = () -> {
            theatreController.bookSeats("user4", theatreList.get(2), 1, List.of(4,5));
        };

        for (Runnable task : List.of(user1, user2, user3, user4)) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            // Wait for all tasks to complete or timeout
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.err.println("Executor did not terminate in time, forcing shutdown.");
                executor.shutdownNow(); // Optionally force shutdown
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.err.println("Shutdown interrupted.");
        }
        System.out.println("\nExecutor shutdown complete.");
    }
}
