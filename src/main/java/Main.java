import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the weight of the package:");
        double weight = scanner.nextDouble();

        Package pkg = new Package(weight);

        while (!pkg.isDelivered()) {
            System.out.println("Choose shipping method (1 for Standard, 2 for Express):");
            int shippingChoice = scanner.nextInt();

            if (shippingChoice == 1) {
                pkg.setShippingStrategy(new StandardShipping());
            } else if (shippingChoice == 2) {
                pkg.setShippingStrategy(new ExpressShipping());
            } else {
                System.out.println("Invalid choice, please choose again.");
                continue;
            }

            System.out.println("Package cost: " + pkg.calculateCost());

            System.out.println("Enter package status (1 for In Transit, 2 for Delivered):");
            int statusChoice = scanner.nextInt();

            if (statusChoice == 1) {
                pkg.setPackageState(new InTransitState());
            } else if (statusChoice == 2) {
                pkg.setPackageState(new DeliveredState());
            } else {
                System.out.println("Invalid choice, please choose again.");
            }
        }

        System.out.println("Program finished.");
        scanner.close();
    }
}
