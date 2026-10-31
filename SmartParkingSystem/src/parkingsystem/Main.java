package parkingsystem;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ParkingManager parkingManager =
                new ParkingManager(10);

        int choice;

        do {

            System.out.println(
                    "\n======================================");

            System.out.println(
                    "       SMART PARKING SYSTEM");

            System.out.println(
                    "======================================");

            System.out.println("1. Park Vehicle");

            System.out.println("2. Vehicle Exit");

            System.out.println("3. View Parking Slots");

            System.out.println("4. View Parking History");

            System.out.println("5. Exit");

            System.out.print(
                    "\nEnter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

            case 1:

                System.out.print(
                        "Enter Vehicle Number: ");

                String vehicleNumber =
                        scanner.nextLine();

                System.out.print(
                        "Enter Owner Name: ");

                String ownerName =
                        scanner.nextLine();

                System.out.print(
                        "Enter Vehicle Type (Car/Bike): ");

                String vehicleType =
                        scanner.nextLine();

                Vehicle vehicle =
                        new Vehicle(
                                vehicleNumber,
                                ownerName,
                                vehicleType);

                parkingManager
                        .parkVehicle(vehicle);

                break;

            case 2:

                System.out.print(
                        "Enter Vehicle Number: ");

                String exitVehicleNumber =
                        scanner.nextLine();

                parkingManager
                        .exitVehicle(
                                exitVehicleNumber);

                break;

            case 3:

                parkingManager
                        .displaySlots();

                break;

            case 4:

                parkingManager
                        .displayHistory();

                break;

            case 5:

                System.out.println(
                        "\nThank you for using Smart Parking System!");

                break;

            default:

                System.out.println(
                        "\nInvalid choice.");

            }

        } while (choice != 5);

        scanner.close();
    }
}