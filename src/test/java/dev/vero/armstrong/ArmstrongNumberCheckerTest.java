package dev.vero.armstrong;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArmstrongNumberCheckerTest {

    @Test
    void testArmstrongNumbers() {
        int[] validArmstrongNumbers = {153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084};
        for (int number : validArmstrongNumbers) {
            assertTrue(ArmstrongNumberChecker.isArmstrongNumber(number),
                    number + " should be recognized as an Armstrong number.");
        }
    }

    @Test
    void testNonArmstrongNumbers() {
        int[] nonArmstrongNumbers = {10, 100, 1000, 10000, 100000};
        for (int number : nonArmstrongNumbers) {
            assertFalse(ArmstrongNumberChecker.isArmstrongNumber(number),
                    number + " should not be recognized as an Armstrong number.");
        }
    }

    @Test
    void testZero() {
        assertTrue(ArmstrongNumberChecker.isArmstrongNumber(0),
                "0 should be recognized as an Armstrong number.");
    }

    @Test
    void testOne() {
        assertTrue(ArmstrongNumberChecker.isArmstrongNumber(1),
                "1 should be recognized as an Armstrong number.");
    }

    @Test
    void testNegativeNumber() {
        assertFalse(ArmstrongNumberChecker.isArmstrongNumber(-153),
                "-153 should not be recognized as an Armstrong number.");
    }

    @Test
    void testLargeNumber() {
        assertTrue(ArmstrongNumberChecker.isArmstrongNumber(146511208),
                "146511208 should be recognized as an Armstrong number.");
    }

    @Test
    void testVeryLargeNonArmstrongNumber() {
        assertFalse(ArmstrongNumberChecker.isArmstrongNumber(Integer.MAX_VALUE),
                "Integer.MAX_VALUE should not be recognized as an Armstrong number.");
    }
}
