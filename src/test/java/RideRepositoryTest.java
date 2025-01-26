import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class RideRepositoryTest {
    private RideRepository repository;
    @BeforeEach
    void setUp() {
        repository = new RideRepository(); 
    }

    @Test
    void testGetRidesForExistingUser() {
        List<Ride> rides = repository.getRides("User_1");
        assertEquals(2, rides.size(), "User_1 should have 2 rides");
        assertEquals(2.5, rides.get(0).getDistance(), "First ride distance should be 2.5  ");
    }

    @Test
    void testGetRidesForNonExistentUser() {
        List<Ride> rides = repository.getRides("User_999");
        assertTrue(rides.isEmpty(), "Non-existent user should have no rides");
    }

    @Test
    void testGetAllUsers() {
        Set<String> users = repository.getAllUsers();
        assertTrue(users.contains("User_1"), "User_1 should exist");
        assertTrue(users.contains("User_2"), "User_2 should exist");
    }
}
