// Assignment: 3 - exercise b
// Author: Liav Lugasi, ID: 213007271


package introtocsHW3;
import java.util.Arrays;

public class HW3b {

    public static String swapCases(String input) {
        String x = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            x += ch;
        }

        return x;
    }


    public static int[] classifyCharacters(String input) {
        int[] counts = new int[4];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                counts[0]++;
            } else if (ch >= 'a' && ch <= 'z') {
                counts[1]++;
            } else if (ch >= '0' && ch <= '9') {
                counts[2]++;
            } else {
                counts[3]++;
            }
        }

        return counts;
    }

    public static int[] findStringInMatrix(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int len = word.length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (j + len <= cols) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (matrix[i][j + k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        int endRow = i;
                        int endCol = j + len - 1;
                        System.out.println("Start: " + i + "," + j + " End: " + endRow + "," + endCol);
                        return new int[]{i, j, endRow, endCol};
                    }
                }

                if (i + len <= rows) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (matrix[i + k][j] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        int endRow = i + len - 1;
                        int endCol = j;
                        System.out.println("Start: " + i + "," + j + " End: " + endRow + "," + endCol);
                        return new int[]{i, j, endRow, endCol};
                    }
                }


                if (i + len <= rows && j + len <= cols) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (matrix[i + k][j + k] != word.charAt(k)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        int endRow = i + len - 1;
                        int endCol = j + len - 1;
                        System.out.println("Start: " + i + "," + j + " End: " + endRow + "," + endCol);
                        return new int[]{i, j, endRow, endCol};
                    }
                }

            }
        }

        return new int[]{-1, -1, -1, -1};
    }


    public static int countWordsBefore(String[] words, String word) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].compareTo(word) < 0) {
                count++;
            }
        }
        return count;
    }


    public static String encryptString(String str, int key) {
        String result = "";
        key = key % 26;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char ch2 = (char) (ch - key);
            if (ch2 < 'a') {
                ch2 = (char) (ch2 + 26);
            }
            result += ch2;
        }
        return result;
    }


    public static boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);

            if (l == '0' && r == '0') {
            }
            else if (l == '1' && r == '1') {
            }
            else if (l == '8' && r == '8') {
            }
            else if (l == '6' && r == '9') {
            }
            else if (l == '9' && r == '6') {
            }
            else {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {


        //--------1--------
        System.out.println("\n=== Test swapCases ===");
        String output=swapCases("aBcdE12");
        System.out.println("Input: aBcdE12 | Expected: AbCDe12 | Actual: " + output
                + " | " + ("AbCDe12".equals(output) ? "PASS test" : "FAIL test"));
        output=swapCases("QWERT");
        System.out.println("Input: QWERT | Expected: qwert | Actual: " + output
                + " | " + ("qwert".equals(output) ? "PASS test" : "FAIL test"));

        //--------2--------
        System.out.println("\n=== Test classifyCharacters ===");
        int[] result = classifyCharacters("ABC12#777#xyD?EHz!555");
        System.out.println("Expected: [6,3,8,4] | Actual: " + Arrays.toString(result)
                + " | " + (Arrays.equals(new int[]{6,3,8,4},result) ? "PASS test" : "FAIL test"));

        //--------3--------
        System.out.println("\n=== Test findStringInMatrix ===");
        char[][] matrix = {
                {'a', 'b', 'q', 'c' , 'c'},
                {'p', 'c', 'n', 't', 'x'},
                {'o', 'j', 'f', 't', 'l'},
                {'h', 'e', 'l', 'l', 'o'},
                {'w', 'i', 'd', 'a', 'y'}
        };

        String str = "hello";
        result = findStringInMatrix(matrix, str);
        System.out.println("Expected: (3, 0), (3, 4) | Actual: (" + result[0] + ", " + result[1] + ")" +
                ", End index: (" + result[2] + ", " + result[3] + ")"
                + " | " + (Arrays.equals(new int[]{3,0,3,4},result) ? "PASS test" : "FAIL test"));

        //--------4--------
        System.out.println("\n=== Test countWordsBefore ===");
        String[] array = {"but", "call", "like", "say", "summer", "world"};
        str = "hello";
        int actual = countWordsBefore(array, str);
        int expected = 2;
        System.out.println("Array: " + Arrays.toString(array)
                + " | Target: \"" + str + "\" | Expected: " + expected
                + " | Actual: " + actual
                + " | " + (actual == expected ? "PASS test" : "FAIL test"));


        //--------5--------
        System.out.println("\n=== Test encryptString ===");

        System.out.println("Original text: bcd, Key: 4 | Expected: \"xyz\" | Actual: "
                + encryptString("bcd", 4)
                + " | " + (encryptString("bcd", 4).equals("xyz") ? "PASS test" : "FAIL test"));

        System.out.println("Original text: khoor, Key: 3 | Expected: \"hello\" | Actual: "
                + encryptString("khoor", 3)
                + " | " + (encryptString("khoor", 3).equals("hello") ? "PASS test" : "FAIL test"));


        //--------6--------
        System.out.println("\n=== Test isStrobogrammatic ===");
        System.out.println("Input: \"88\" | Expected: " + true + " | Actual: " + isStrobogrammatic("88")
                + " | " + (isStrobogrammatic("88") ? "PASS test" : "FAIL test"));
        System.out.println("Input: \"69\" | Expected: " + true + " | Actual: " + isStrobogrammatic("69")
                + " | " + (isStrobogrammatic("69") ? "PASS test" : "FAIL test"));
        System.out.println("Input: \"919\" | Expected: " + false + " | Actual: " + isStrobogrammatic("919")
                + " | " + (!isStrobogrammatic("919") ? "PASS test" : "FAIL test"));

    }
}
