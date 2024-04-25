package src.algorithm.String;


import java.util.Scanner;

public class ReverseString2Leetcode541 {

    public static void main(String[] args) {
        // 创建 Scanner 对象以读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入字符串
        System.out.println("Enter a string:");
        String s = scanner.nextLine();

        // 提示用户输入 k 的值
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // 调用 reverseStr 方法并打印结果
        String result = reverseStr(s, k);
        System.out.println("Resulting string: " + result);
        scanner.close();
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);//如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
