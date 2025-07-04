package org.example.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

class CashBillingStrategyTest {
    @Test
    void testCalculateWithZeroCost() {
        BillingStrategy strategy = new CashBillingStrategy();
        assertEquals(0.0f, strategy.calculate(0.0f), 0.001, "The cost should be 0.0 when original cost is 0.0");
    }

    @Test
    void testCalculateWithPositiveCost() {
        BillingStrategy strategy = new CashBillingStrategy();
        float originalCost = 100.0f;
        assertEquals(originalCost, strategy.calculate(originalCost), 0.001, "The cost should be equal to the original cost for cash payments.");
    }

    @Test
    void testCalculateWithNegativeCost() {
        BillingStrategy strategy = new CashBillingStrategy();
        float originalCost = -50.0f;
        assertEquals(originalCost, strategy.calculate(originalCost), 0.001, "The cost should be equal to the original cost, even if it's negative.");
    }

}