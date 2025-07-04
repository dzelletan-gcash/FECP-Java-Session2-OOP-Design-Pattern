package org.example.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CashBillingStrategyTest {

    @Test
    void testCalculate_NormalCost() {
        CashBillingStrategy strategy = new CashBillingStrategy();
        float result = strategy.calculate(1000.0f);
        assertEquals(1000.0f, result);
    }

    @Test
    void testCalculate_ZeroCost() {
        CashBillingStrategy strategy = new CashBillingStrategy();
        float result = strategy.calculate(0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    void testCalculate_NegativeCost() {
        CashBillingStrategy strategy = new CashBillingStrategy();
        float result = strategy.calculate(-100.0f);
        assertEquals(-100.0f, result);
    }

    @Test
    void testCalculate_LargeCost() {
        CashBillingStrategy strategy = new CashBillingStrategy();
        float result = strategy.calculate(Float.MAX_VALUE);
        assertEquals(Float.MAX_VALUE, result);
    }

    @Test
    void testCalculate_SmallDecimalCost() {
        CashBillingStrategy strategy = new CashBillingStrategy();
        float result = strategy.calculate(0.01f);
        assertEquals(0.01f, result, 0.001f);
    }
}

class HmoBillingStrategyTest {

    @Test
    void testCalculate_NormalCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(1000.0f);
        assertEquals(800.0f, result, 0.001f); // 20% discount
    }

    @Test
    void testCalculate_ZeroCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    void testCalculate_NegativeCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(-100.0f);
        assertEquals(-80.0f, result, 0.001f);
    }

    @Test
    void testCalculate_SmallCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(100.0f);
        assertEquals(80.0f, result, 0.001f);
    }

    @Test
    void testCalculate_LargeCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(10000.0f);
        assertEquals(8000.0f, result, 0.001f);
    }

    @Test
    void testCalculate_DecimalCost() {
        HmoBillingStrategy strategy = new HmoBillingStrategy();
        float result = strategy.calculate(150.75f);
        assertEquals(120.6f, result, 0.001f);
    }
}

class SeniorBillingStrategyTest {

    @Test
    void testCalculate_NormalCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(1000.0f);
        assertEquals(850.0f, result, 0.001f); // 15% discount
    }

    @Test
    void testCalculate_ZeroCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(0.0f);
        assertEquals(0.0f, result);
    }

    @Test
    void testCalculate_NegativeCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(-100.0f);
        assertEquals(-85.0f, result, 0.001f);
    }

    @Test
    void testCalculate_SmallCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(100.0f);
        assertEquals(85.0f, result, 0.001f);
    }

    @Test
    void testCalculate_LargeCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(10000.0f);
        assertEquals(8500.0f, result, 0.001f);
    }

    @Test
    void testCalculate_DecimalCost() {
        SeniorBillingStrategy strategy = new SeniorBillingStrategy();
        float result = strategy.calculate(200.50f);
        assertEquals(170.425f, result, 0.001f);
    }
}

// Test for BillingStrategy interface implementation
class BillingStrategyInterfaceTest {

    @Test
    void testAllStrategiesImplementInterface() {
        BillingStrategy cashStrategy = new CashBillingStrategy();
        BillingStrategy hmoStrategy = new HmoBillingStrategy();
        BillingStrategy seniorStrategy = new SeniorBillingStrategy();

        assertNotNull(cashStrategy);
        assertNotNull(hmoStrategy);
        assertNotNull(seniorStrategy);

        // Test that all strategies can be used polymorphically
        float testCost = 1000.0f;
        assertEquals(1000.0f, cashStrategy.calculate(testCost));
        assertEquals(800.0f, hmoStrategy.calculate(testCost), 0.001f);
        assertEquals(850.0f, seniorStrategy.calculate(testCost), 0.001f);
    }
}