package org.example.factory;

import org.example.model.Service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {

    @Test
    void testCreateConsultationService() {
        Service consultation = ServiceFactory.getService("consultation");
        assertNotNull(consultation, "Service should not be null for valid type 'consultation'.");
        assertEquals("Consultation", consultation.getServiceName());
        assertEquals(500.0f, consultation.getCost());
    }

    @Test
    void testCreateXRayService() {
        Service xray = ServiceFactory.getService("x-ray");
        assertNotNull(xray, "Service should not be null for valid type 'x-ray'.");
        assertEquals("X-Ray", xray.getServiceName());
        assertEquals(1500.0f, xray.getCost());
    }

    @Test
    void testCreateSurgeryService() {
        Service surgery = ServiceFactory.getService("surgery");
        assertNotNull(surgery, "Service should not be null for valid type 'surgery'.");
        assertEquals("Surgery", surgery.getServiceName());
        assertEquals(10000.0f, surgery.getCost());
    }

    @Test
    void testInvalidServiceTypeReturnsNull() {
        Service invalid = ServiceFactory.getService("blood test");
        assertNull(invalid, "Service should be null for an unknown service type.");
    }

    @Test
    void testNullServiceTypeReturnsNull() {
        Service invalid = ServiceFactory.getService(null);
        assertNull(invalid, "Service should be null for a null service type.");
    }
}