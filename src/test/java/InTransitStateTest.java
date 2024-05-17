import org.junit.Test;

public class InTransitStateTest {
    @Test
    public void testHandleStateChange() {
        Package pkg = new Package(10);
        PackageState state = new InTransitState();
        state.handleStateChange(pkg);
        // Output is expected, but we do not test System.out here
    }
}