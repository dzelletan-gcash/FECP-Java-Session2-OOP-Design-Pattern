package org.example.strategy;

/**
 * A billing strategy for HMO members, which applies a 20% discount.
 */
public class HmoBillingStrategy implements BillingStrategy {
    private static final float DISCOUNT_RATE = 0.80f; // 20% discount

    @Override
    public float calculate(float originalCost) {
        return originalCost * DISCOUNT_RATE;
    }
}
