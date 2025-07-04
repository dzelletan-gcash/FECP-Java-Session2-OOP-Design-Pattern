package org.example;

import org.example.model.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HospitalBillingSystem {

    // A list to store all patient records in the system.
    private static final List<Patient> patientList = new ArrayList<>();
    // A scanner to read input from the user.
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Hospital Billing System ===");
        boolean running = true;

        // Main application loop
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    // To be implemented by the team member handling Service Management
                    System.out.println("Feature 'Add Service' is not yet implemented.");
                    break;
                case 3:
                    // To be implemented by the team member handling Billing Computation
                    System.out.println("Feature 'Compute Bill' is not yet implemented.");
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the system. Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); // Add a blank line for better readability
        }
        scanner.close();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service to Patient");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }

    /**
     * Handles the logic for registering a new patient.
     * It prompts for patient details and adds them to the system.
     */
    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");
        System.out.print("Enter Patient ID (e.g., P101): ");
        String id = scanner.nextLine();

        // Check if patient ID already exists
        if (findPatientById(id) != null) {
            System.out.println("Error: A patient with this ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        Patient newPatient = new Patient(id, name);
        patientList.add(newPatient);

        System.out.println("Patient registered successfully!");
    }

    /**
     * Finds a patient in the patientList by their ID.
     *
     * @param id The ID of the patient to find.
     * @return The Patient object if found, otherwise null.
     */
    public static Patient findPatientById(String id) {
        for (Patient patient : patientList) {
            if (patient.getPatientId().equalsIgnoreCase(id)) {
                return patient;
            }
        }
        return null;
    }
}
