import java.util.*;

class RideRepository {
    private final Map<String, List<Ride>> rideData = new HashMap<>();
    public RideRepository() {
        rideData.put("User_1", Arrays.asList(
                new Ride(2.5, 45, "Normal"),
                new Ride(6.0, 90, "Normal")
        ));
        rideData.put("User_2", Arrays.asList(
                new Ride(4.2, 60, "Premium"),
                new Ride(3.8, 40, "Normal"),
                new Ride(7.5, 110, "Premium")
        ));
        rideData.put("User_3", Arrays.asList(
                new Ride(1.0, 30, "Normal")
        ));
        rideData.put("User_4", Arrays.asList(
                new Ride(8.5, 100, "Normal"),
                new Ride(5.2, 75, "Premium"),
                new Ride(0.8, 35, "Normal")
        ));
        rideData.put("User_5", Arrays.asList(
                new Ride(9.0, 120, "Premium"),
                new Ride(2.3, 50, "Normal")
        ));
    }
    public List<Ride> getRides(String userId) {
        return rideData.getOrDefault(userId, Collections.emptyList());
    }
    public Set<String> getAllUsers() {
        return rideData.keySet();
    }
}
