package org.example;

import org.example.factory.ServiceFactory;
import org.example.model.Patient;
import org.example.model.Service;

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
                    addServiceToPatient();
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

    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service to Patient");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }


    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");
        System.out.print("Enter Patient ID (e.g., P101): ");
        String id = scanner.nextLine();

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

    private static void addServiceToPatient() {
        System.out.println("\n--- Add Service to Patient ---");
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }

        System.out.println("Available Services: Consultation, X-Ray, Surgery");
        System.out.print("Select service to add: ");
        String serviceType = scanner.nextLine();

        // Use the factory to create the service object
        Service service = ServiceFactory.getService(serviceType);

        if (service == null) {
            System.out.println("Error: Invalid service type selected.");
            return;
        }

        // Add the created service to the patient's record
        patient.addService(service);
        System.out.println("Service '" + service.getServiceName() + "' added to patient " + patient.getPatientName() + ".");
    }


    public static Patient findPatientById(String id) {
        for (Patient patient : patientList) {
            if (patient.getPatientId().equalsIgnoreCase(id)) {
                return patient;
            }
        }
        return null;
    }
}
