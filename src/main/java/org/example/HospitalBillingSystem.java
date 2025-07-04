package org.example;

import org.example.factory.ServiceFactory;
import org.example.model.Patient;
import org.example.model.Service;
import org.example.strategy.*; // Import all strategies

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalBillingSystem {

    private static final List<Patient> patientList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printHospitalBanner(); // Display the new UI banner
        boolean running = true;

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
                    computeBill();
                    break;
                case 4:
                    running = false;
                    System.out.println("\nThank you for using the system. Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    /**
     * Displays a decorative banner for the hospital.
     */
    private static void printHospitalBanner() {
        System.out.println("  ██████╗  ██████╗ █████╗ ███████╗██╗  ██╗    ███╗   ███╗███████╗██████╗  ██████╗ █████╗ ██████╗ ███████╗");
        System.out.println(" ██╔════╝ ██╔════╝██╔══██╗██╔════╝██║  ██║    ████╗ ████║██╔════╝██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔════╝");
        System.out.println(" ██║  ███╗██║     ███████║███████╗███████║    ██╔████╔██║█████╗  ██║  ██║██║     ███████║██████╔╝█████╗  ");
        System.out.println(" ██║   ██║██║     ██╔══██║╚════██║██╔══██║    ██║╚██╔╝██║██╔══╝  ██║  ██║██║     ██╔══██║██╔══██╗██╔══╝  ");
        System.out.println(" ╚██████╔╝╚██████╗██║  ██║███████║██║  ██║    ██║ ╚═╝ ██║███████╗██████╔╝╚██████╗██║  ██║██║  ██║███████╗");
        System.out.println("  ╚═════╝  ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝    ╚═╝     ╚═╝╚══════╝╚═════╝  ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝");
        System.out.println("\n-----------------------------------------------------");
        System.out.println(" Developed by:");
        System.out.println(" - Kayne Rodrigo");
        System.out.println(" - Dzelle Tan");
        System.out.println(" - Andre Lacra");
        System.out.println("-----------------------------------------------------");
        System.out.println("\nWelcome to the GCash MedCare Billing System!");
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

        Service service = ServiceFactory.getService(serviceType);

        if (service == null) {
            System.out.println("Error: Invalid service type selected.");
            return;
        }

        patient.addService(service);
        System.out.println("Service '" + service.getServiceName() + "' added to patient " + patient.getPatientName() + ".");
    }

    private static void computeBill() {
        System.out.println("\n--- Compute Patient Bill ---");
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }

        float originalCost = patient.getTotalCost();
        if (originalCost == 0) {
            System.out.println("Patient has no services. Total bill is 0.");
            return;
        }

        System.out.print("Enter Insurance Type (hmo/cash/senior): ");
        String insuranceType = scanner.nextLine();

        BillingStrategy strategy;

        switch (insuranceType.toLowerCase()) {
            case "hmo":
                strategy = new HmoBillingStrategy();
                break;
            case "cash":
                strategy = new CashBillingStrategy();
                break;
            case "senior":
                strategy = new SeniorBillingStrategy();
                break;
            default:
                System.out.println("Error: Invalid insurance type. Using cash as default.");
                strategy = new CashBillingStrategy();
                break;
        }

        float finalBill = strategy.calculate(originalCost);

        System.out.println("\n--- Bill Generated ---");
        System.out.printf("Patient: %s (ID: %s)\n", patient.getPatientName(), patient.getPatientId());
        System.out.printf("Original Cost: %.2f\n", originalCost);
        System.out.printf("Final Bill (after discount): %.2f\n", finalBill);
        System.out.println("--------------------");
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
