import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressShippingTest {
    @Test
    public void testCalculateCost() {
        ShippingStrategy strategy = new ExpressShipping();
        double cost = strategy.calculateCost(10);
        assertEquals(35.0, cost, 0.01);
    }
}