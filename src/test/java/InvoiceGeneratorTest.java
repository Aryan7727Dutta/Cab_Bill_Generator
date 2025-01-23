import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class InvoiceGeneratorTest {
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void testCalculateFare_NormalRide() {
        Ride ride = new Ride(5.0, 10, "Normal");
        double fare = generator.calculateFare(ride);
        assertEquals(60.0, fare, "Incorrect fare for normal ride");
    }

    @Test
    void testCalculateFare_PremiumRide() {
        Ride ride = new Ride(3.0, 5, "Premium");
        double fare = generator.calculateFare(ride);
        assertEquals(55.0, fare, "Incorrect fare for premium ride");
    }

    @Test
    void testGenerateInvoice() {
        List<Ride> rides = Arrays.asList(
                new Ride(2.5, 30, "Normal"),
                new Ride(6.0, 90, "Normal")
        );
        Map<String, Object> invoice = generator.generateInvoice(rides);
        assertEquals(2, invoice.get("Total Rides"));
        assertEquals(205.0, invoice.get("Total Fare"));
        assertEquals(102.5, invoice.get("Average Fare per Ride"));
    }
}
