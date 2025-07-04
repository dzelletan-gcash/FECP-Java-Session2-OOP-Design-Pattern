package org.example.model;

public class Service {
    private String serviceName;
    private float cost;

    /**
     * Constructs a new Service with a specified name and cost.
     * @param serviceName The name of the service (e.g., "X-Ray").
     * @param cost The cost of the service.
     */
    public Service(String serviceName, float cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    /**
     * @return The name of the service.
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @return The cost of the service.
     */
    public float getCost() {
        return cost;
    }
}