package org.example.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeniorBillingStrategyTest {
    @Test
    void testCalculateWithZeroCost() {
        BillingStrategy strategy = new SeniorBillingStrategy();
        assertEquals(0.0f, strategy.calculate(0.0f), 0.001, "The cost should be 0.0 when original cost is 0.0");
    }

    @Test
    void testCalculateWithPositiveCost() {
        BillingStrategy strategy = new SeniorBillingStrategy();
        float originalCost = 100.0f;
        assertEquals(85.0f, strategy.calculate(originalCost), 0.001, "The cost should be reduced by 15% for senior citizens.");
    }

    @Test
    void testCalculateWithNegativeCost() {
        BillingStrategy strategy = new SeniorBillingStrategy();
        float originalCost = -50.0f;
        assertEquals(-42.5f, strategy.calculate(originalCost), 0.001, "The cost should be reduced by 15% for senior citizens, even if it's negative.");
    }
}