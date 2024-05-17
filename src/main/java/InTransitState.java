// InTransitState.java
public class InTransitState implements PackageState {
    @Override
    public void handleStateChange(Package pkg) {
        System.out.println("Package is now in transit.");
    }
}