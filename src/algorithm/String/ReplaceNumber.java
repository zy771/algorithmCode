package src.algorithm.String;


import java.util.Scanner;

public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for keyboard input
        System.out.println("Enter a string: "); // Prompt the user for input
        String input = scanner.nextLine(); // Read the user input

        String output = replaceNumbersWithRebmun(input); // Process the input
        System.out.println("Transformed string: " + output); // Print the transformed string

        scanner.close(); // Close the scanner
    }

    public static String replaceNumbersWithRebmun(String s) {
        if (s == null || s.isEmpty()) {
            return s; // Return the original string if it's null or empty
        }

        // Calculate the length of the resulting string
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                len += 6; // Add 6 for each numeric character (for "rebmun")
            } else {
                len++; // Add 1 for non-numeric characters
            }
        }

        // Create a new character array to hold the resulting characters
        char[] ret = new char[len];

        // Perform the replacement and reverse copying
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                // Insert "rebmun" in reverse order
                ret[j--] = 'r';
                ret[j--] = 'e';
                ret[j--] = 'b';
                ret[j--] = 'm';
                ret[j--] = 'u';
                ret[j--] = 'n';
            } else {
                // Copy non-numeric characters
                //ret[j--] = s.charAt(i);中先执行ret[j]=s.charAt(i),然后再执行j-1
                //这里，j-- 是一个后缀递减运算符，意味着首先使用 j 的当前值进行赋值操作，
                // 然后 j 的值才会减一。所以，操作执行的顺序不是先将 i 赋给 j，
                // 而是在使用 j 的当前值进行赋值后，j 的值才会递减。
                ret[j--] = s.charAt(i);
            }
        }

        return new String(ret); // Return the new string
    }
}
