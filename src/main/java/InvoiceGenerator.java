import java.util.*;

class InvoiceGenerator {
    private static final Map<String, Double> COST_PER_KM = Map.of(
            "Normal", 10.0, "Premium", 15.0
    );
    private static final Map<String, Double> COST_PER_MIN = Map.of(
            "Normal", 1.0, "Premium", 2.0
    );
    private static final Map<String, Double> MIN_FARE = Map.of(
            "Normal", 5.0, "Premium", 20.0
    );
    public double calculateFare(Ride ride) {
        double fare = (ride.distance * COST_PER_KM.get(ride.rideType)) +(ride.time * COST_PER_MIN.get(ride.rideType));
        return Math.max(fare, MIN_FARE.get(ride.rideType));
    }
    public Map<String, Object> generateInvoice(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        int totalRides = rides.size();
        double averageFare = totalFare / totalRides;

        return Map.of(
                "Total Rides", totalRides,
                "Total Fare", totalFare,
                "Average Fare per Ride", averageFare
        );
    }
}
