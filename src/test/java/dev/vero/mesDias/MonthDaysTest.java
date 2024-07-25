package dev.vero.mesDias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonthDaysTest {

    @Test
    void testGetMonthName() {
        assertEquals("January", MonthDays.getMonthName(1));
        assertEquals("December", MonthDays.getMonthName(12));
        assertThrows(IllegalArgumentException.class, () -> MonthDays.getMonthName(0));
        assertThrows(IllegalArgumentException.class, () -> MonthDays.getMonthName(13));
    }

    @Test
    void testGetDaysInMonth() {
        assertEquals(31, MonthDays.getDaysInMonth(1, 2023));
        assertEquals(28, MonthDays.getDaysInMonth(2, 2023));
        assertEquals(31, MonthDays.getDaysInMonth(3, 2023));
        assertEquals(30, MonthDays.getDaysInMonth(4, 2023));
        assertEquals(31, MonthDays.getDaysInMonth(12, 2023));
        assertThrows(IllegalArgumentException.class, () -> MonthDays.getDaysInMonth(0, 2023));
        assertThrows(IllegalArgumentException.class, () -> MonthDays.getDaysInMonth(13, 2023));
    }

    @Test
    void testLeapYear() {
        assertEquals(29, MonthDays.getDaysInMonth(2, 2024));
        assertEquals(28, MonthDays.getDaysInMonth(2, 2023));
        assertEquals(29, MonthDays.getDaysInMonth(2, 2000));
        assertEquals(28, MonthDays.getDaysInMonth(2, 1900));
    }

    @Test
    void testIsLeapYear() {
        assertTrue(MonthDays.isLeapYear(2000));
        assertTrue(MonthDays.isLeapYear(2024));
        assertFalse(MonthDays.isLeapYear(2023));
        assertFalse(MonthDays.isLeapYear(1900));
    }
}