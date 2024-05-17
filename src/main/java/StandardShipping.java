// StandardShipping.java
public class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return weight * 2.5;
    }
}