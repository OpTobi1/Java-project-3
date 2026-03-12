// Assignment: 3 - exercise a
// Author: Liav Lugasi, ID: 213007271


package introtocsHW3;
import java.util.Arrays;

public class HW3a {
    public static int octalToDecimal(int octNum) {
        int decNum = 0;
        int base = 1;
        int temp = octNum;

        while (temp > 0) {
            int Digit = temp % 10;
            temp = temp / 10;
            decNum += Digit * base;
            base = base * 8;
        }

        return decNum;
    }


    public static String simplifyFraction(int numerator, int denominator) {
        int a = numerator;
        int b = denominator;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int gcd = a;

        return (numerator / gcd) + "/" + (denominator / gcd);
    }


    public static String tomorrowsDate(int day, int month, int year) {

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                System.out.println("Invalid month");
        }

        day++;

        if (day > days) {
            day = 1;
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return day + "/" + month + "/" + year;
    }


    public static int[] pentagonalNumbers(int n) {
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            int k = i + 1;
            int num = (3 * k * k - k) / 2;
            x[i] = num;
        }

        return x;
    }

    public static void main(String[] args) {
        //--------1--------
        System.out.println("=== Test octalToDecimal ===");
        int actual = octalToDecimal(1263);
        System.out.println("Octal: 1263 | Expected: " + 691
                + " | Actual: " + actual
                + " | " + (actual == 691 ? "PASS test" : "FAIL test"));

        actual = octalToDecimal(10101);
        System.out.println("Octal: 1263 | Expected: " + 4161
                + " | Actual: " + actual
                + " | " + (actual == 4161 ? "PASS test" : "FAIL test"));

        //--------2--------
        System.out.println("\n=== Test simplifyFraction ===");
        String simplified = simplifyFraction(42, 56);
        System.out.println("Simplified 42/56: " + simplified + " (expected: 3/4) | " +
                (simplified.equals("3/4") ? "PASS test" : "FAIL test"));

        //--------3--------
        System.out.println("\n=== Test tomorrowsDate ===");
        System.out.println("Tomorrow of 05/03/2020 (6/3/2020) | "
                + ("6/3/2020".equals(tomorrowsDate(5, 3, 2020)) ? "PASS test" : "FAIL test"));
        System.out.println("Tomorrow of 31/01/2021 (1/2/2021) | "
                +  ("1/2/2021".equals(tomorrowsDate(31, 1, 2021))? "PASS test" : "FAIL test"));
        System.out.println("Tomorrow of 28/02/2020 (29/2/2020) | "
                +  ("29/2/2020".equals(tomorrowsDate(28, 2, 2020))? "PASS test" : "FAIL test"));

        //--------4--------
        System.out.println("\n=== Test pentagonalNumbers ===");
        int[] pentNumbers = {1, 5, 12, 22, 35};
        System.out.println("First 5 pentagonal numbers: [1, 5, 12, 22, 35] | "
                + (Arrays.equals(pentagonalNumbers(5),pentNumbers) ? "PASS test" : "FAIL test"));
        pentNumbers = new int[]{1, 5, 12, 22, 35, 51, 70, 92};
        System.out.println("First 8 pentagonal numbers: [1, 5, 12, 22, 35, 51, 70, 92] | "
                + (Arrays.equals(pentagonalNumbers(8),pentNumbers) ? "PASS test" : "FAIL test"));

    }
}
