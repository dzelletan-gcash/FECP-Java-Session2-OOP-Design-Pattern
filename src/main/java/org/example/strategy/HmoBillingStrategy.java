package org.example.strategy;
// Andre will implement this
public class HmoBillingStrategy implements BillingStrategy {
    @Override
    public double computeBill(double[] serviceCosts) {
        double total = 0;
        for (double cost : serviceCosts) {
            total += cost * 0.80; // HMO example - 20% discount
        }
        return total;
    }
}