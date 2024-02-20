package javaproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class f2 extends JFrame implements ActionListener {

    private JLabel welcomeLabel;
    private JButton bookHotelButton;
    private JButton bookPackageButton;
    private JButton checkSitesButton;

    private String selectedPlace; // Store the selected place

    public f2() {
        super("Travel and Tourism Management");
        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Welcome to Travel and Tourism Management!");
        add(welcomeLabel, BorderLayout.NORTH);

        bookHotelButton = new JButton("Book Hotel");
        bookHotelButton.addActionListener(this);
        add(bookHotelButton, BorderLayout.WEST);

        bookPackageButton = new JButton("Book Package");
        bookPackageButton.addActionListener(this);
        add(bookPackageButton, BorderLayout.CENTER);

        checkSitesButton = new JButton("Check Sites");
        checkSitesButton.addActionListener(this);
        add(checkSitesButton, BorderLayout.EAST);

        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookHotelButton || e.getSource() == bookPackageButton || e.getSource() == checkSitesButton) {
            // Ask for a place
            selectedPlace = JOptionPane.showInputDialog(this, "Enter a place:");
            if (selectedPlace != null) {
                // If a place is entered, proceed with the respective action
                if (e.getSource() == bookHotelButton) {
                    // Code to book a hotel
                    showHotelBookingDetails();
                } else if (e.getSource() == bookPackageButton) {
                    // Code to book a package
                    showBookedDetails("Package Booking Details");
                } else if (e.getSource() == checkSitesButton) {
                    // Code to check sites
                    showBookedDetails("Sites Checking Details");
                }
            }
        }
    }

    private void showHotelBookingDetails() {
        JFrame hotelBookingFrame = new JFrame("Hotel Booking Details");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        String[] hotelOptions = {"Hotel Taj", "The Oberoi", "Leela Palace"};
        JComboBox<String> hotelComboBox = new JComboBox<>(hotelOptions);
        JTextField numberOfPeopleField = new JTextField();
        JTextField numberOfDaysField = new JTextField();
        JButton confirmButton = new JButton("Confirm");

        panel.add(new JLabel("Select Hotel:"));
        panel.add(hotelComboBox);
        panel.add(new JLabel("Number of People:"));
        panel.add(numberOfPeopleField);
        panel.add(new JLabel("Number of Days:"));
        panel.add(numberOfDaysField);
        panel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedHotel = (String) hotelComboBox.getSelectedItem();
                int numberOfPeople = Integer.parseInt(numberOfPeopleField.getText());
                int numberOfDays = Integer.parseInt(numberOfDaysField.getText());

                int amountPerDay = 0;

                // Assign amount based on selected hotel
                switch (selectedHotel) {
                    case "Hotel Taj":
                        amountPerDay = 5000;
                        break;
                    case "The Oberoi":
                        amountPerDay = 6000;
                        break;
                    case "Leela Palace":
                        amountPerDay = 7000;
                        break;
                    // Add more hotels as needed
                }

                int totalAmount = numberOfDays * amountPerDay;

                String details = "Booking Details:\n" + "Place: " + selectedPlace + "\n" +
                        "Hotel Option: " + selectedHotel + " \t\n" + "Number of People: " + numberOfPeople + " \t\n"
                        + "Number of Days: " + numberOfDays + " \t\n" + "Amount per Day: " + amountPerDay + " \t\n" + "Total Amount: " + totalAmount;

                showBookedDetails(details);
                hotelBookingFrame.dispose();
            }
        });

        hotelBookingFrame.getContentPane().add(panel);
        hotelBookingFrame.setSize(400, 200);
        hotelBookingFrame.setVisible(true);
    }

    private void showBookedDetails(String details) {
        JFrame detailsFrame = new JFrame("Booked Details");
        JLabel detailsLabel = new JLabel(details);
        detailsFrame.getContentPane().add(detailsLabel);
        detailsFrame.setSize(300, 200);
        detailsFrame.setVisible(true);
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new f2();
    }
}
