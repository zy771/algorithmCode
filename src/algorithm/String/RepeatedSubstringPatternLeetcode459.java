package src.algorithm.String;


import java.util.Scanner;

public class RepeatedSubstringPatternLeetcode459 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check for repeated substring pattern:");
        String input = scanner.nextLine();

        boolean result = repeatedSubstringPattern(input);
        if (result) {
            System.out.println("The string '" + input + "' is made up of a repeating substring.");
        } else {
            System.out.println("The string '" + input + "' is NOT made up of a repeating substring.");
        }
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;

        int len = s.length();
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            if (chars[i] == chars[j + 1]) j++;
            next[i] = j;
        }

        if (next[len] > 0 && len % (len - next[len]) == 0) {
            System.out.println(s.substring(1,len-next[len]+1));
            return true;
        }
        return false;
    }
}
