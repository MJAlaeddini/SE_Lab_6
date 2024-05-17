// ExpressShipping.java
public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return weight * 3.5;
    }
}
