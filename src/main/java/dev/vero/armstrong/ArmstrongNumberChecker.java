package dev.vero.armstrong;

// Amstrong

// Enunciado:
// Se quiere desarrollar un programa que determine si un número es un número de Amstrong. Un número de Amstrong es aquel que es igual a la suma de sus dígitos elevados a la potencia de su número de cifras.

// Por ejemplo, el número 371 es un número que cumple dicha característica ya que tiene tres cifras y:
// 371 = 33 + 73 + 13 = 27 + 343 + 1 = 371

public class ArmstrongNumberChecker {

    public static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int numDigits = (int) Math.floor(Math.log10(number) + 1);
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
      
        int[] testNumbers = { 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084 };

        for (int num : testNumbers) {
            System.out.println(num + " is " + (isArmstrongNumber(num) ? "an" : "not an") + " Armstrong number.");
        }
    }
}
