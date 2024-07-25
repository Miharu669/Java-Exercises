package dev.vero.automovil.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuelTypeTest {

    @Test
    void testFuelTypeValues() {
        FuelType[] expectedTypes = {
                FuelType.GASOLINE,
                FuelType.BIOETHANOL,
                FuelType.DIESEL,
                FuelType.BIODIESEL,
                FuelType.NATURAL_GAS
        };

        assertArrayEquals(expectedTypes, FuelType.values(), "Enum values should match the expected values.");
    }

    @Test
    void testFuelTypeValueOf() {
        assertEquals(FuelType.BIODIESEL, FuelType.valueOf("BIODIESEL"),
                "Enum valueOf should return the correct FuelType.");
    }

    @Test
    void testInvalidFuelType() {
        assertThrows(IllegalArgumentException.class, () -> FuelType.valueOf("INVALID_FUEL_TYPE"),
                "Enum valueOf should throw exception for invalid fuel type.");
    }
}
