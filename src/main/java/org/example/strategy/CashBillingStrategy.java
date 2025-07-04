package org.example.strategy;
// Andre will implement this
public class CashBillingStrategy implements BillingStrategy {
    @Override
    public double computeBill(double[] serviceCosts) {
        double total = 0;
        for (double cost : serviceCosts) {
            total += cost; // cash example - no discount
        }
        return total;
    }
}
