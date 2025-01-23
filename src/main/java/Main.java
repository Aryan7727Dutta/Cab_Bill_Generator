import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RideRepository repository = new RideRepository();
        InvoiceGenerator generator = new InvoiceGenerator();

        while (true) {
            Set<String> users = repository.getAllUsers();
            System.out.println("\nAvailable Users:");
            for (String userId : users) {
                System.out.println("- " + userId);
            }
            System.out.println("- Exit (type 'exit')");

            System.out.print("\nEnter User ID to generate invoice (or type 'exit' to quit): ");
            String selectedUser = scanner.nextLine().trim();

            if (selectedUser.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            if (!users.contains(selectedUser)) {
                System.out.println("Invalid User ID! Try again.");
            } else {
                List<Ride> rides = repository.getRides(selectedUser);
                Map<String, Object> invoice = generator.generateInvoice(rides);
                System.out.println("\nInvoice for user: " + selectedUser);
                System.out.println(invoice);
            }
        }
        scanner.close();
    }
}
