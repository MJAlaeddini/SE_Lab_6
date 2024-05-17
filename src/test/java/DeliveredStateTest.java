import org.junit.Test;

public class DeliveredStateTest {
    @Test
    public void testHandleStateChange() {
        Package pkg = new Package(10);
        PackageState state = new DeliveredState();
        state.handleStateChange(pkg);
        // Output is expected, but we do not test System.out here
    }
}