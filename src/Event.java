public class Event {
    private String eventName;
    private int totalSeats;

    public Event(String eventName, int totalSeats) {
        this.eventName = eventName;
        this.totalSeats = totalSeats;
    }

    public String getEventName() {
        return eventName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}
