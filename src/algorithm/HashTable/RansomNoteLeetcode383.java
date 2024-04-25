package src.algorithm.HashTable;


import java.util.Scanner;

public class RansomNoteLeetcode383 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 从键盘接收赎金信字符串
        System.out.println("Enter the ransom note:");
        String ransomNote = scanner.nextLine();

        // 从键盘接收杂志字符串
        System.out.println("Enter the magazine content:");
        String magazine = scanner.nextLine();

        // 检查是否可以构造
        boolean canConstruct = canConstruct(ransomNote, magazine);
        if (canConstruct) {
            System.out.println("Yes, the ransom note can be constructed from the magazine.");
        } else {
            System.out.println("No, the ransom note cannot be constructed from the magazine.");
        }

        scanner.close();
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // 杂志中的字符串中字符数量比ransomNote大
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] record = new int[26];

        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
            // 如果数组中存在负数，说明ransomNote字符串中存在magazine中没有的字符
            if (record[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
