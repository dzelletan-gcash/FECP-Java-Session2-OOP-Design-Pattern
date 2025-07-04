package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Patient class.
 */
class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // This method runs before each test, setting up a fresh Patient object.
        patient = new Patient("P101", "John Doe");
    }

    /**
     * Test 1: Verifies that the constructor correctly initializes a Patient object.
     */
    @Test
    void testPatientCreation() {
        assertNotNull(patient, "Patient object should not be null.");
        assertEquals("P101", patient.getPatientId(), "Patient ID should match.");
        assertEquals("John Doe", patient.getPatientName(), "Patient name should match.");
        assertNotNull(patient.getServices(), "Services list should be initialized, not null.");
        assertTrue(patient.getServices().isEmpty(), "A new patient should have no services.");
    }

    /**
     * Test 2: Verifies that adding a single service works correctly.
     */
    @Test
    void testAddService() {
        Service xrayService = new Service("X-Ray", 1500.0f);
        patient.addService(xrayService);

        assertEquals(1, patient.getServices().size(), "Services list should contain one item after adding.");
        assertEquals("X-Ray", patient.getServices().get(0).getServiceName(), "The added service should be correct.");
    }

    /**
     * Test 3: Verifies that the total cost is calculated correctly for multiple services.
     */
    @Test
    void testGetTotalCost_WithMultipleServices() {
        patient.addService(new Service("Consultation", 500.0f));
        patient.addService(new Service("Surgery", 10000.0f));

        // Expected total cost is 500.0 + 10000.0 = 10500.0
        float expectedCost = 10500.0f;
        assertEquals(expectedCost, patient.getTotalCost(), "Total cost should be the sum of all service costs.");
    }

    /**
     * Test 4: Verifies that the total cost is zero when no services have been added.
     */
    @Test
    void testGetTotalCost_NoServices() {
        assertEquals(0.0f, patient.getTotalCost(), "Total cost should be 0 for a patient with no services.");
    }
}
