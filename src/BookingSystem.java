import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class BookingSystem {
    private final Event event;

    public BookingSystem(Event event) {
        this.event = event;
    }

    // synchronized ensures only one thread books at a time
    public synchronized void bookSeat(String userName) {
        if (event.getTotalSeats() > 0) {
            System.out.println(userName + " is booking a seat...");
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            event.setTotalSeats(event.getTotalSeats() - 1);
            System.out.println(userName + " successfully booked a seat! Remaining: " + event.getTotalSeats());
            saveBooking(userName);
        } else {
            System.out.println("❌ No seats available for " + userName);
        }
    }

    private void saveBooking(String userName) {
        try (FileWriter writer = new FileWriter("bookings.txt", true)) {
            writer.write(userName + " booked a seat for " + event.getEventName() +
                    " on " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }
}
