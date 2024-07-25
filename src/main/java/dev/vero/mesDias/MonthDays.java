package dev.vero.mesDias;

import java.util.Calendar;
import java.util.Scanner;


// Meses y días

// Enunciado:
// Hacer un programa que, dado el número de un mes (1,2,3,4…12), presente el nombre del mes y determine la cantidad de días que tiene.


public class MonthDays {
    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static String getMonthName(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Invalid month number. It must be a number between 1 and 12.");
        }
        return MONTH_NAMES[monthNumber - 1];
    }

    public static int getDaysInMonth(int monthNumber, int year) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Invalid month number. It must be a number between 1 and 12.");
        }

        if (isLeapYear(year) && monthNumber == 2) {
            return 29;
        }

        return DAYS_IN_MONTH[monthNumber - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a month number (1-12): ");
        int numMonth = scanner.nextInt();

        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String monthName = getMonthName(numMonth);
            int days = getDaysInMonth(numMonth, year);

            System.out.println("Month: " + monthName);
            System.out.println("Number of days: " + days);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}