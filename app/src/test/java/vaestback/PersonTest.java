package vaestback;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person classUnderTest = new Person();

    // Name
    @Test
    @DisplayName("Name cannot be null")
    public void testUsernameIsNull() {
        Throwable exception = assertThrows(
                NullPointerException.class, () -> {
                    classUnderTest.setName(null);
                });

        assertEquals("Name cannot be blank", exception.getMessage());
    }

    @Test
    @DisplayName("Name is too short")
    public void testNameIsLessThanTwoCharacters() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setName("A");
                });

        assertEquals("Name has to be at least 2 letters", exception.getMessage());
    }

    // DOB
    @Test
    @DisplayName("DOB incorrect pattern")
    public void testDateOfBirthIncorrectPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setDateOfBirth("12/28/1995");
        });
    }

    @Test
    @DisplayName("DOB correct pattern")
    public void testDateOfBirthCorrectPattern() {
        assertDoesNotThrow(() -> classUnderTest.setDateOfBirth("28.12.1995"));
    }

    // DOD
    @Test
    @DisplayName("DOD incorrect pattern")
    public void testDateOfDeathIncorrectPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            classUnderTest.setDateOfDeath("12/28/1995");
        });
    }

    @Test
    @DisplayName("DOD correct pattern")
    public void testDateOfDeathCorrectPattern() {
        assertDoesNotThrow(() -> classUnderTest.setDateOfDeath("28.12.1995"));
    }

    // SSN
    @Test
    @DisplayName("SSN is null")
    public void testSetSsnNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setSsn(null);
        });
    }

    @Test
    @DisplayName("SSN is empty")
    public void testSetSsnEmpty() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setSsn("123456-89101112");
                });
        assertEquals("Ssn has to be 11 characters", exception.getMessage());
    }

    @Test
    @DisplayName("SSN is too long")
    public void testSetSsnTooLong() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setSsn("123456-89101112");
                });
        assertEquals("Ssn has to be 11 characters", exception.getMessage());
    }

    @Test
    @DisplayName("SSN does not have century identifier")
    public void testSetSsnNoValidCenturyIdentifier() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setSsn("123456X7890");
                });
        assertEquals("SSN must have correct century identifier, ddmmyyXyyyz, with X being either +, - or A",
                exception.getMessage());
    }

    // Address
    @Test
    @DisplayName("Address is null")
    public void testSetAddressNull() {
        assertThrows(NullPointerException.class, () -> {
            classUnderTest.setAddress(null);
        });
    }

    @Test
    @DisplayName("Address is too short")
    public void testSetAddressTooShort() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setAddress("ovi");
                });
        assertEquals("Address must be between 4-255 characters long",
                exception.getMessage());
    }

    // Main language
    @Test
    @DisplayName("Language is too short")
    public void testSetMotherLanguageTooShort() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setMainLanguage("o");
                });
        assertEquals("Main language must be between 2-50 characters long",
                exception.getMessage());
    }

    // Main language
    @Test
    @DisplayName("setMaritalStatus is too short")
    public void testSetMaritalStatusTooShort() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    classUnderTest.setMaritalStatus("o");
                });
        assertEquals("Marital status must be between 2-50 characters long",
                exception.getMessage());
    }

}
