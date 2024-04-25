package src.algorithm.HashTable;

import java.util.Scanner;

public class ValidAnagramLeetcode242 {
    public static void main(String[] args) {
        // 创建Scanner对象以从键盘接收输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first string:");
        String s = scanner.nextLine(); // 读取用户输入的第一个字符串

        System.out.println("Enter second string:");
        String t = scanner.nextLine(); // 读取用户输入的第二个字符串

        // 创建Solution对象并调用isAnagram方法
        Solution solution = new Solution();
        boolean result = solution.isAnagram(s, t);

        // 输出结果
        if (result) {
            System.out.println("The strings are anagrams of each other.");
        } else {
            System.out.println("The strings are not anagrams of each other.");
        }

        // 关闭scanner
        scanner.close();
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] record = new int[26];
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                record[t.charAt(i) - 'a']--;
            }
            for (int count : record) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
