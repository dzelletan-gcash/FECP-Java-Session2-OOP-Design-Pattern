package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void testServiceConstructor() {
        Service service = new Service("X-Ray", 1500.0f);
        assertEquals("X-Ray", service.getServiceName());
        assertEquals(1500.0f, service.getCost());
    }

    @Test
    void testServiceConstructorWithZeroCost() {
        Service service = new Service("Free Service", 0.0f);
        assertEquals("Free Service", service.getServiceName());
        assertEquals(0.0f, service.getCost());
    }

    @Test
    void testServiceConstructorWithNegativeCost() {
        Service service = new Service("Discount Service", -100.0f);
        assertEquals("Discount Service", service.getServiceName());
        assertEquals(-100.0f, service.getCost());
    }

    @Test
    void testServiceConstructorWithEmptyName() {
        Service service = new Service("", 500.0f);
        assertEquals("", service.getServiceName());
        assertEquals(500.0f, service.getCost());
    }

    @Test
    void testServiceConstructorWithNullName() {
        Service service = new Service(null, 500.0f);
        assertNull(service.getServiceName());
        assertEquals(500.0f, service.getCost());
    }

    @Test
    void testGetServiceName() {
        Service service = new Service("Consultation", 500.0f);
        assertEquals("Consultation", service.getServiceName());
    }

    @Test
    void testGetCost() {
        Service service = new Service("Surgery", 10000.0f);
        assertEquals(10000.0f, service.getCost());
    }

    @Test
    void testServiceWithLargeCost() {
        Service service = new Service("Premium Service", Float.MAX_VALUE);
        assertEquals("Premium Service", service.getServiceName());
        assertEquals(Float.MAX_VALUE, service.getCost());
    }
}