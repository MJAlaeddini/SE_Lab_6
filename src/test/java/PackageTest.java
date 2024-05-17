import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PackageTest {
    private Package pkg;
    private double weight = 10.0;

    @Before
    public void setUp() {
        pkg = new Package(weight);
    }

    @Test
    public void testInitialShippingStrategy() {
        assertTrue(pkg.getShippingStrategy() instanceof StandardShipping);
    }

    @Test
    public void testChangeToExpressShipping() {
        pkg.setShippingStrategy(new ExpressShipping());
        assertTrue(pkg.getShippingStrategy() instanceof ExpressShipping);
    }

    @Test
    public void testCalculateCostStandardShipping() {
        double cost = pkg.calculateCost();
        assertEquals(25.0, cost, 0.01);
    }

    @Test
    public void testCalculateCostExpressShipping() {
        pkg.setShippingStrategy(new ExpressShipping());
        double cost = pkg.calculateCost();
        assertEquals(35.0, cost, 0.01);
    }

    @Test
    public void testInitialState() {
        assertTrue(pkg.getPackageState() instanceof InTransitState);
    }

    @Test
    public void testChangeToDeliveredState() {
        pkg.setPackageState(new DeliveredState());
        assertTrue(pkg.getPackageState() instanceof DeliveredState);
    }

    @Test
    public void testIsDelivered() {
        assertFalse(pkg.isDelivered());
        pkg.setPackageState(new DeliveredState());
        assertTrue(pkg.isDelivered());
    }
}
