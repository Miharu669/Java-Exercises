package dev.vero.elementosComunes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonElementsTest {

    private CommonElements commonElements;

    @BeforeEach
    public void setUp() {
        commonElements = new CommonElements();
    }

    @Test
    public void testFindCommonElementsWithCommonElements() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);

        ArrayList<Integer> result = commonElements.findCommonElements(list1, list2);
        assertEquals(expected, result);
    }

    @Test
    public void testFindCommonElementsWithNoCommonElements() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> expected = new ArrayList<>();

        ArrayList<Integer> result = commonElements.findCommonElements(list1, list2);
        assertEquals(expected, result);
    }

    @Test
    public void testFindCommonElementsWithEmptyLists() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        ArrayList<Integer> expected = new ArrayList<>();

        ArrayList<Integer> result = commonElements.findCommonElements(list1, list2);
        assertEquals(expected, result);
    }

    @Test
    public void testFindCommonElementsWithOneEmptyList() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        ArrayList<Integer> expected = new ArrayList<>();

        ArrayList<Integer> result = commonElements.findCommonElements(list1, list2);
        assertEquals(expected, result);
    }

    @Test
    public void testFindCommonElementsWithDuplicates() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);

        list2.add(2);
        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(4);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        ArrayList<Integer> result = commonElements.findCommonElements(list1, list2);
        assertEquals(expected, result);
    }
}
