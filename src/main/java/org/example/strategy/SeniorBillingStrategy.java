package org.example.strategy;
// Andre will implement this
public class SeniorBillingStrategy implements BillingStrategy {
    @Override
    public double computeBill(double[] serviceCosts) {
        double total = 0;
        for (double cost : serviceCosts) {
            total += cost * 0.85; // senior example - 15% discount
        }
        return total;
    }
}
