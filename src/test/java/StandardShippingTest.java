import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardShippingTest {
    @Test
    public void testCalculateCost() {
        ShippingStrategy strategy = new StandardShipping();
        double cost = strategy.calculateCost(10);
        assertEquals(25.0, cost, 0.01);
    }
}