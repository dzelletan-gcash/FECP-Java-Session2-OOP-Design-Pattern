package org.example.strategy;

/**
 * A billing strategy for cash payments, which applies no discount.
 */
public class CashBillingStrategy implements BillingStrategy {
    @Override
    public float calculate(float originalCost) {
        // No discount for cash payments.
        return originalCost;
    }
}
