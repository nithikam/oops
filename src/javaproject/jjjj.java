package javaproject;
import java.util.ArrayList;
import java.util.Scanner;

class TravelPackage {
    private String destination;
    private double price;
    private int numberOfDays;

    public TravelPackage(String destination, double price, int numberOfDays) {
        this.destination = destination;
        this.price = price;
        this.numberOfDays = numberOfDays;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}

class TravelBooking {
    private TravelPackage selectedPackage;
    private int numberOfPeople;
    private int numberOfDays;

    public void bookPackage(TravelPackage travelPackage, int numberOfPeople, int numberOfDays) {
        this.selectedPackage = travelPackage;
        this.numberOfPeople = numberOfPeople;
        this.numberOfDays = numberOfDays;
    }

    public double calculateTotalAmount() {
        return selectedPackage.getPrice() * numberOfPeople * numberOfDays;
    }

    public String getBookingDetails() {
        return "Booking confirmed for " + numberOfPeople + " people to " +
                selectedPackage.getDestination() + " for " + numberOfDays + " days. Total Amount: $" + calculateTotalAmount();
    }
}

public class jjjj {

    private static ArrayList<TravelPackage> travelPackages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeTravelPackages();

        while (true) {
            System.out.println("\n1. View Travel Packages");
            System.out.println("2. Book a Travel Package");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayTravelPackages();
                    break;
                case 2:
                    bookTravelPackage();
                    break;
                case 3:
                    System.out.println("Thank you for using our Travel and Tourism program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeTravelPackages() {
        travelPackages.add(new TravelPackage("Paris", 1500.00, 5));
        travelPackages.add(new TravelPackage("Tokyo", 2000.00, 7));
        travelPackages.add(new TravelPackage("New York", 1800.00, 4));
    }

    private static void displayTravelPackages() {
        System.out.println("Available Travel Packages:");
        for (int i = 0; i < travelPackages.size(); i++) {
            TravelPackage travelPackage = travelPackages.get(i);
            System.out.println((i + 1) + ". " + travelPackage.getDestination() +
                    " - $" + travelPackage.getPrice() +
                    " - " + travelPackage.getNumberOfDays() + " days");
        }
    }

    private static void bookTravelPackage() {
        System.out.print("Enter the index of the package you want to book: ");
        int packageIndex = scanner.nextInt() - 1;

        if (packageIndex >= 0 && packageIndex < travelPackages.size()) {
            TravelPackage selectedPackage = travelPackages.get(packageIndex);

            System.out.print("Enter the number of people traveling: ");
            int numberOfPeople = scanner.nextInt();

            System.out.print("Enter the number of days for the trip: ");
            int numberOfDays = scanner.nextInt();

            TravelBooking booking = new TravelBooking();
            booking.bookPackage(selectedPackage, numberOfPeople, numberOfDays);

            System.out.println(booking.getBookingDetails());
        } else {
            System.out.println("Invalid package index.");
        }
    }
}



	