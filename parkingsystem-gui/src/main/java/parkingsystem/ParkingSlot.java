package parkingsystem;

public class ParkingSlot {

    private int slotNumber;
    private boolean available;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.available = true;
        this.vehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.available = true;
    }
}
