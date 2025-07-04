package org.example.strategy;

/**
 * A billing strategy for Senior Citizens, which applies a 15% discount.
 */
public class SeniorBillingStrategy implements BillingStrategy {
    private static final float DISCOUNT_RATE = 0.85f; // 15% discount

    @Override
    public float calculate(float originalCost) {
        return originalCost * DISCOUNT_RATE;
    }
}


