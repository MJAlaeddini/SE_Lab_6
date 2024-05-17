public class Package {
    private double weight;
    private ShippingStrategy shippingStrategy;
    private PackageState packageState;

    public Package(double weight) {
        this.weight = weight;
        this.shippingStrategy = new StandardShipping(); // Default shipping strategy
        this.packageState = new InTransitState(); // Default state
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public PackageState getPackageState() {
        return packageState;
    }

    public void setPackageState(PackageState packageState) {
        this.packageState = packageState;
        this.packageState.handleStateChange(this);
    }

    public double calculateCost() {
        return this.shippingStrategy.calculateCost(this.weight);
    }

    public boolean isDelivered() {
        return this.packageState instanceof DeliveredState;
    }
}
