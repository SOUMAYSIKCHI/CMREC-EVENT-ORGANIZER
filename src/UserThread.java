public class UserThread extends Thread {
    private final String userName;
    private final BookingSystem bookingSystem;

    public UserThread(String userName, BookingSystem bookingSystem) {
        this.userName = userName;
        this.bookingSystem = bookingSystem;
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(userName);
    }
}
