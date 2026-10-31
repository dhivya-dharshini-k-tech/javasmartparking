package parkingsystem;

import java.time.LocalDateTime;
public class ParkingRecord {

    private String vehicleNumber;
    private int slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;

    public ParkingRecord(String vehicleNumber,
                         int slotNumber,
                         LocalDateTime entryTime,
                         LocalDateTime exitTime,
                         double amount) {

        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.amount = amount;
    }

    public void displayRecord() {

        System.out.println("-----------------------------");
        System.out.println("Vehicle : " + vehicleNumber);
        System.out.println("Slot    : " + slotNumber);
        System.out.println("Entry   : " + entryTime);
        System.out.println("Exit    : " + exitTime);
        System.out.println("Amount  : Rs." + amount);
    }
}
