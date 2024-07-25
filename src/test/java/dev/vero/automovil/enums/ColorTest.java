package dev.vero.automovil.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testColorValues() {
        Color[] expectedColors = {
                Color.WHITE,
                Color.BLACK,
                Color.RED,
                Color.ORANGE,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                Color.VIOLET
        };

        assertArrayEquals(expectedColors, Color.values(), "Enum values should match the expected values.");
    }

    @Test
    void testColorValueOf() {
        assertEquals(Color.BLUE, Color.valueOf("BLUE"), "Enum valueOf should return the correct Color.");
    }

    @Test
    void testInvalidColor() {
        assertThrows(IllegalArgumentException.class, () -> Color.valueOf("INVALID_COLOR"),
                "Enum valueOf should throw exception for invalid color.");
    }
}
