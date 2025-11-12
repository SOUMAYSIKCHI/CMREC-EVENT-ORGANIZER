import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎯 Welcome to CMREC Event Organizer System!");
        Event event = new Event("TechFest 2025", 5);
        BookingSystem bookingSystem = new BookingSystem(event);

        // Create a pool of threads (users trying to book seats)
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            executor.execute(new UserThread("User-" + i, bookingSystem));
        }

        executor.shutdown();
        while (!executor.isTerminated()) { }

        System.out.println("\n✅ All booking requests processed!");
    }
}
