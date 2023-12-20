import org.example.Cinema;
import org.example.SelectingSeatsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bookSeatsTest {
    private Cinema cinema;

    @BeforeEach
    public void setUp ()
    {
        cinema= new Cinema();
    }
    @Test
    void testBookIsAvailable() throws SelectingSeatsException {
        int [] numberOfSeats= {3,4};
        Assertions.assertDoesNotThrow(() -> {
            cinema.bookSeats(3, 2, numberOfSeats); // booking seats in hall 3, row 2 with seat numbers 3 and 4
        }, "Seats are already taken");
    }
    @Test
    void testBookIsNotAvailable() throws SelectingSeatsException {
        int [] firstOrder= {3,4,6};
        cinema.bookSeats(3,2,firstOrder);
        int [] secondOrder= {3,4,5};
        assertThrows(SelectingSeatsException.class, () -> {
            cinema.bookSeats(3,2,secondOrder); // Attempting to book seats that are already taken
        },"Seats are already taken");
    }
}