package org.example.factory;

import org.example.model.Service;

public class ServiceFactory {

    /**
     * Creates and returns a Service object based on the specified service type.
     * This method encapsulates the creation logic for different services.
     *
     * @param serviceType The type of service to create (e.g., "consultation", "x-ray").
     * @return A new {@link Service} object if the type is valid, otherwise null.
     */
    public static Service getService(String serviceType) {
        if (serviceType == null) {
            return null;
        }

        switch (serviceType.toLowerCase()) {
            case "consultation":
                return new Service("Consultation", 500.0f);
            case "x-ray":
                return new Service("X-Ray", 1500.0f);
            case "surgery":
                return new Service("Surgery", 10000.0f);
            default:
                return null; // Return null for unknown service types
        }
    }
}