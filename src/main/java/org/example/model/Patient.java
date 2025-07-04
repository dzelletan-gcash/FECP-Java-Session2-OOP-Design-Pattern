package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patient in the hospital system.
 * This class holds patient information and a list of services they have received.
 */
public class Patient {
    private String patientId;
    private String patientName;
    private List<Service> services;

    /**
     * Constructor to create a new Patient object.
     * Initializes the list of services.
     *
     * @param patientId   The unique ID for the patient.
     * @param patientName The full name of the patient.
     */
    public Patient(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.services = new ArrayList<>(); // Initialize the list to avoid NullPointerException
    }

    // --- Getters ---
    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public List<Service> getServices() {
        return services;
    }


    public void addService(Service service) {
        this.services.add(service);
    }

    public float getTotalCost() {
        float totalCost = 0.0f;
        for (Service service : services) {
            totalCost += service.getCost();
        }
        return totalCost;
    }
}
