package src.algorithm.String;

import java.util.Scanner;

public class RightHandString {
    public static void main(String[] args) {
        // 创建Scanner对象以从键盘接收输入
        Scanner in = new Scanner(System.in);
        System.out.println("输入正整数k：");
        // 读取一个整数n
        int n = Integer.parseInt(in.nextLine());
        System.out.println("输入字符串：");
        // 读取一个字符串s
        String s = in.nextLine();

        in.close();
        // 获取字符串的长度
        int len = s.length();
        // 将字符串转换为字符数组，便于处理
        char[] chars = s.toCharArray();

        // 反转字符串的前len-n部分
        reverseString(chars, 0, len - n - 1);
        // 反转字符串的后n部分
        reverseString(chars, len - n, len - 1);
        // 反转整个字符串
        reverseString(chars, 0, len - 1);

        // 输出处理后的字符串
        System.out.println(chars);
    }

    // 一个辅助方法，用于反转字符数组中指定范围的字符
    public static void reverseString(char[] ch, int start, int end) {
        // 使用异或运算交换字符，无需额外的临时变量
        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
}
