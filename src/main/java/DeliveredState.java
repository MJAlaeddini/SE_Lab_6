public class DeliveredState implements PackageState {
    @Override
    public void handleStateChange(Package pkg) {
        System.out.println("Package has been delivered.");
    }
}