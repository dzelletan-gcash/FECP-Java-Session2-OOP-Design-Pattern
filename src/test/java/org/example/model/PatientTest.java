package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;
    private Service consultationService;
    private Service xrayService;
    private Service surgeryService;

    @BeforeEach
    void setUp() {
        patient = new Patient("P101", "John Doe");
        consultationService = new Service("Consultation", 500.0f);
        xrayService = new Service("X-Ray", 1500.0f);
        surgeryService = new Service("Surgery", 10000.0f);
    }

    @Test
    void testPatientConstructor() {
        Patient testPatient = new Patient("P102", "Jane Smith");
        assertEquals("P102", testPatient.getPatientId());
        assertEquals("Jane Smith", testPatient.getPatientName());
        assertNotNull(testPatient.getServices());
        assertTrue(testPatient.getServices().isEmpty());
    }

    @Test
    void testPatientConstructorWithNullValues() {
        Patient testPatient = new Patient(null, null);
        assertNull(testPatient.getPatientId());
        assertNull(testPatient.getPatientName());
        assertNotNull(testPatient.getServices());
        assertTrue(testPatient.getServices().isEmpty());
    }

    @Test
    void testPatientConstructorWithEmptyValues() {
        Patient testPatient = new Patient("", "");
        assertEquals("", testPatient.getPatientId());
        assertEquals("", testPatient.getPatientName());
        assertNotNull(testPatient.getServices());
        assertTrue(testPatient.getServices().isEmpty());
    }

    @Test
    void testGetPatientId() {
        assertEquals("P101", patient.getPatientId());
    }

    @Test
    void testGetPatientName() {
        assertEquals("John Doe", patient.getPatientName());
    }

    @Test
    void testGetServices() {
        assertNotNull(patient.getServices());
        assertTrue(patient.getServices().isEmpty());
    }

    @Test
    void testAddService() {
        patient.addService(consultationService);
        assertEquals(1, patient.getServices().size());
        assertEquals(consultationService, patient.getServices().get(0));
    }

    @Test
    void testAddMultipleServices() {
        patient.addService(consultationService);
        patient.addService(xrayService);
        patient.addService(surgeryService);

        assertEquals(3, patient.getServices().size());
        assertEquals(consultationService, patient.getServices().get(0));
        assertEquals(xrayService, patient.getServices().get(1));
        assertEquals(surgeryService, patient.getServices().get(2));
    }

    @Test
    void testAddNullService() {
        patient.addService(null);
        assertEquals(1, patient.getServices().size());
        assertNull(patient.getServices().get(0));
    }

    @Test
    void testGetTotalCost_NoServices() {
        assertEquals(0.0f, patient.getTotalCost());
    }

    @Test
    void testGetTotalCost_SingleService() {
        patient.addService(consultationService);
        assertEquals(500.0f, patient.getTotalCost());
    }

    @Test
    void testGetTotalCost_MultipleServices() {
        patient.addService(consultationService);  // 500.0f
        patient.addService(xrayService);          // 1500.0f
        patient.addService(surgeryService);       // 10000.0f

        assertEquals(12000.0f, patient.getTotalCost());
    }

    @Test
    void testGetTotalCost_WithZeroCostService() {
        Service freeService = new Service("Free Service", 0.0f);
        patient.addService(consultationService);  // 500.0f
        patient.addService(freeService);          // 0.0f

        assertEquals(500.0f, patient.getTotalCost());
    }

    @Test
    void testGetTotalCost_WithNegativeCostService() {
        Service discountService = new Service("Discount", -100.0f);
        patient.addService(consultationService);  // 500.0f
        patient.addService(discountService);      // -100.0f

        assertEquals(400.0f, patient.getTotalCost());
    }

    @Test
    void testGetTotalCost_WithNullService() {
        patient.addService(consultationService);  // 500.0f
        patient.addService(null);                 // This should cause NullPointerException

        assertThrows(NullPointerException.class, () -> {
            patient.getTotalCost();
        });
    }

    @Test
    void testAddSameServiceMultipleTimes() {
        patient.addService(consultationService);
        patient.addService(consultationService);
        patient.addService(consultationService);

        assertEquals(3, patient.getServices().size());
        assertEquals(1500.0f, patient.getTotalCost()); // 3 * 500.0f
    }
}