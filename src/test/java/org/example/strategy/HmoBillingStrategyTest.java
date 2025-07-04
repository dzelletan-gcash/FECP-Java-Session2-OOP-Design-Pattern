package org.example.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HmoBillingStrategyTest {
    @Test
    void testCalculateWithZeroCost() {
        BillingStrategy strategy = new HmoBillingStrategy();
        assertEquals(0.0f, strategy.calculate(0.0f), 0.001, "The cost should be 0.0 when original cost is 0.0");
    }

    @Test
    void testCalculateWithPositiveCost() {
        BillingStrategy strategy = new HmoBillingStrategy();
        float originalCost = 100.0f;
        assertEquals(80.0f, strategy.calculate(originalCost), 0.001, "The cost should be reduced by 20% for HMO members.");
    }

    @Test
    void testCalculateWithNegativeCost() {
        BillingStrategy strategy = new HmoBillingStrategy();
        float originalCost = -50.0f;
        assertEquals(-40.0f, strategy.calculate(originalCost), 0.001, "The cost should be reduced by 20% for HMO members, even if it's negative.");
    }
}