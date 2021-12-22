package vaestback;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppartmentTest {
    Appartment classUnderTest = new Appartment();

    String correctPattern = "100012345A";
    String incorrectPattern = "7000A2345A1231234";

    @Test
    @DisplayName("Appartment id is null")
    public void testAppartmentIdNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setAppartmentId(null);
        });
    }

    @Test
    @DisplayName("Appartment id incorrect pattern")
    public void testAppartmentTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setAppartmentId(incorrectPattern);
        });
    }

    @Test
    @DisplayName("Qty of rooms is negative")
    public void testSetRoomsQtyNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setRoomsQty(-3);
        });
    }

    @Test
    @DisplayName("Qty of rooms is valid")
    public void testSetRoomsQty() {
        assertDoesNotThrow(() -> {
            classUnderTest.setRoomsQty(3);
        });
    }

    @Test
    @DisplayName("Surface area is negative")
    public void testSetSurfaceAreaNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setSurfaceArea(-1.2);
        });
    }

    @Test
    @DisplayName("Surface area is valid")
    public void testSetSurfaceArea() {
        assertDoesNotThrow(() -> {
            classUnderTest.setSurfaceArea(67.2);
        });
    }

    @Test
    @DisplayName("Add building")
    public void testSetBuilding() {
        Building building = new Building();
        assertDoesNotThrow(() -> classUnderTest.setBuilding(building));
    }

}
