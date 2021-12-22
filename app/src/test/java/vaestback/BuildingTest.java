package vaestback;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuildingTest {

    Building classUnderTest = new Building();

    String correctPattern = "100012345A";
    String incorrectPattern = "7000A2345A";

    @Test
    @DisplayName("Building id is null")
    public void testBuildingIdNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setBuildingId(null);
        });
    }

    @Test
    @DisplayName("Building id incorrect pattern starting number")
    public void testBuildingIdIncorrectPatternStart() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setBuildingId(incorrectPattern);
        });
    }

    @Test
    @DisplayName("Building id correct pattern")
    public void testBuildingIdCorrectPattern() {
        assertDoesNotThrow(() -> {
            classUnderTest.setBuildingId(correctPattern);
        });
    }

    // dateOfCompletion
    @Test
    @DisplayName("Date of completion incorrect pattern")
    public void testDateOfCompletionIncorrectPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setDateOfCompletion("12/28/1995");
        });
    }

    @Test
    @DisplayName("Date of completion correct pattern")
    public void testDateOfCompletionCorrectPattern() {
        assertDoesNotThrow(() -> classUnderTest.setDateOfCompletion("28.12.1995"));
    }

    // add appartment

    @Test
    @DisplayName("Add appartments")
    public void testSetAppartments() {
        Appartment newAppt = new Appartment();
        Appartment newAppt2 = new Appartment();

        var appartments = new ArrayList<Appartment>();
        appartments.add(newAppt);
        appartments.add(newAppt2);
        assertDoesNotThrow(() -> classUnderTest.setAppartments(appartments));
        // check that object has same amount of elements as input
        assertEquals(appartments.size(), classUnderTest.getAppartments().size());
    }

    @Test
    @DisplayName("Owner is null")
    public void testOwnerNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setOwner(null);
        });
    }

    @Test
    @DisplayName("Owner is null")
    public void testOwnerTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setOwner("o");
        });
    }

    @Test
    @DisplayName("Owner type is null")
    public void testOwnerTypeNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setOwner(null);
        });
    }

    @Test
    @DisplayName("Owner type too short")
    public void testOwnerTypeTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setOwner("o");
        });
    }

}
