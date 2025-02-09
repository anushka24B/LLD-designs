package LLD.AirlineManagementSystem;

public class Seat {
    private int seatNumber;
    private boolean isAvailable;
    private int version; // Version for optimistic locking

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
        this.version = 0;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getVersion() {
        return version;
    }

    public void incrementVersion() {
        this.version++;
    }

    public boolean tryBookSeat(int currentVersion) {
        if (this.version == currentVersion && this.isAvailable) {
            this.isAvailable = false;  // Mark the seat as booked
            this.incrementVersion();   // Increment the version number
            return true;
        }
        return false;
    }
}

