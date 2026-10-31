package parkingsystem;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingManager {

    private ParkingSlot[] slots;

    private LocalDateTime[] entryTimes;

    private ArrayList<ParkingRecord> history;

    public ParkingManager(int totalSlots) {

        slots = new ParkingSlot[totalSlots];

        entryTimes = new LocalDateTime[totalSlots];

        history = new ArrayList<>();

        for (int i = 0; i < totalSlots; i++) {

            slots[i] = new ParkingSlot(i + 1);
        }
    }

    // Park vehicle
    public void parkVehicle(Vehicle vehicle) {

        // Check duplicate vehicle
        for (ParkingSlot slot : slots) {

            if (!slot.isAvailable()
                    && slot.getVehicle()
                    .getVehicleNumber()
                    .equalsIgnoreCase(vehicle.getVehicleNumber())) {

                System.out.println("\nVehicle is already parked!");

                return;
            }
        }

        // Find available slot
        for (int i = 0; i < slots.length; i++) {

            if (slots[i].isAvailable()) {

                slots[i].parkVehicle(vehicle);

                entryTimes[i] = LocalDateTime.now();

                System.out.println("\n================================");
                System.out.println("     PARKING CONFIRMED");
                System.out.println("================================");

                System.out.println(
                        "Vehicle Number : "
                                + vehicle.getVehicleNumber());

                System.out.println(
                        "Allocated Slot : "
                                + slots[i].getSlotNumber());

                System.out.println(
                        "Entry Time     : "
                                + entryTimes[i]);

                System.out.println(
                        "\nNotification: Vehicle parked successfully.");

                return;
            }
        }

        System.out.println("\nSorry! Parking is full.");
    }

    // Vehicle Exit
    public void exitVehicle(String vehicleNumber) {

        for (int i = 0; i < slots.length; i++) {

            if (!slots[i].isAvailable()
                    && slots[i]
                    .getVehicle()
                    .getVehicleNumber()
                    .equalsIgnoreCase(vehicleNumber)) {

                LocalDateTime exitTime =
                        LocalDateTime.now();

                LocalDateTime entryTime =
                        entryTimes[i];

                long minutes =
                        Duration
                        .between(entryTime, exitTime)
                        .toMinutes();

                /*
                 * For demonstration:
                 * Minimum parking charge = Rs.20
                 * Every hour = Rs.20
                 */

                long hours =
                        (minutes / 60) + 1;

                double amount =
                        hours * 20;

                ParkingRecord record =
                        new ParkingRecord(
                                vehicleNumber,
                                slots[i].getSlotNumber(),
                                entryTime,
                                exitTime,
                                amount);

                history.add(record);

                System.out.println("\n================================");
                System.out.println("        PARKING BILL");
                System.out.println("================================");

                System.out.println(
                        "Vehicle Number : "
                                + vehicleNumber);

                System.out.println(
                        "Parking Slot   : "
                                + slots[i].getSlotNumber());

                System.out.println(
                        "Entry Time     : "
                                + entryTime);

                System.out.println(
                        "Exit Time      : "
                                + exitTime);

                System.out.println(
                        "Duration       : "
                                + minutes
                                + " minutes");

                System.out.println(
                        "Parking Fee    : Rs."
                                + amount);

                slots[i].removeVehicle();

                entryTimes[i] = null;

                System.out.println(
                        "\nNotification: Payment successful.");

                System.out.println(
                        "Notification: Vehicle exit completed.");

                return;
            }
        }

        System.out.println("\nVehicle not found.");
    }

    // View parking status
    public void displaySlots() {

        System.out.println("\n================================");
        System.out.println("       PARKING DASHBOARD");
        System.out.println("================================");

        int available = 0;
        int occupied = 0;

        for (ParkingSlot slot : slots) {

            if (slot.isAvailable()) {

                available++;

                System.out.println(
                        "Slot "
                                + slot.getSlotNumber()
                                + " : AVAILABLE");

            } else {

                occupied++;

                System.out.println(
                        "Slot "
                                + slot.getSlotNumber()
                                + " : OCCUPIED - "
                                + slot
                                .getVehicle()
                                .getVehicleNumber());
            }
        }

        System.out.println("\nTotal Slots     : "
                + slots.length);

        System.out.println(
                "Available Slots : "
                        + available);

        System.out.println(
                "Occupied Slots  : "
                        + occupied);
    }

    // Parking history
    public void displayHistory() {

        System.out.println("\n================================");
        System.out.println("        PARKING HISTORY");
        System.out.println("================================");

        if (history.isEmpty()) {

            System.out.println(
                    "No parking history available.");

            return;
        }

        for (ParkingRecord record : history) {

            record.displayRecord();
        }
    }
}
