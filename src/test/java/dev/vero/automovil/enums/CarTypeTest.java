package dev.vero.automovil.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTypeTest {

    @Test
    void testCarTypeValues() {
        CarType[] expectedTypes = {
                CarType.CITY_CAR,
                CarType.SUBCOMPACT,
                CarType.COMPACT,
                CarType.FAMILY,
                CarType.EXECUTIVE,
                CarType.SUV
        };

        assertArrayEquals(expectedTypes, CarType.values(), "Enum values should match the expected values.");
    }

    @Test
    void testCarTypeValueOf() {
        assertEquals(CarType.SUV, CarType.valueOf("SUV"), "Enum valueOf should return the correct CarType.");
    }

    @Test
    void testInvalidCarType() {
        assertThrows(IllegalArgumentException.class, () -> CarType.valueOf("INVALID_TYPE"),
                "Enum valueOf should throw exception for invalid type.");
    }
}
