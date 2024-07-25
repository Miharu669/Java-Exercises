package dev.vero.elementosComunes;

import java.util.ArrayList;

public class CommonElements {

    public ArrayList<Integer> findCommonElements(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        ArrayList<Integer> commonElements = new ArrayList<>();

        for (Integer element : list1) {

            if (list2.contains(element) && !commonElements.contains(element)) {

                commonElements.add(element);
            }
        }

        return commonElements;
    }

    public static void main(String[] args) {

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

        CommonElements ce = new CommonElements();

        ArrayList<Integer> commonElements = ce.findCommonElements(list1, list2);

        System.out.println("Common elements: " + commonElements);
    }
}
