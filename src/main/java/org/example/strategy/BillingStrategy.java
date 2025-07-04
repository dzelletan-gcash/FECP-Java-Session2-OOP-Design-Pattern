package org.example.strategy;

/**
 * The interface for a billing strategy.
 * Defines the contract for calculating the final cost of a bill.
 */
public interface BillingStrategy {
    /**
     * Calculates the final bill amount based on an original cost.
     *
     * @param originalCost The total cost before any discounts.
     * @return The final, calculated cost.
     */
    float calculate(float originalCost);
}
