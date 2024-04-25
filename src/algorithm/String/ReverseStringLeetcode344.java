package src.algorithm.String;

import java.util.Scanner;

//原地算法，不新建数组
public class ReverseStringLeetcode344 {
    public static void main(String[] args) {
        // 创建 Scanner 对象以读取用户的输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");

        // 读取用户输入的字符串
        String input = scanner.nextLine();
        scanner.close();

        // 将输入字符串转换为字符数组
        char[] charArray = input.toCharArray();

        // 调用 reverseString 方法反转字符数组
        reverseString(charArray);

        // 将反转后的字符数组转换回字符串
        String reversed = new String(charArray);

        // 打印反转后的字符串
        System.out.println("Reversed string: " + reversed);
    }

    // 反转字符数组的方法
    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }
}
//执行 s[l] ^= s[r]; 这一步时，对字符 'h' 和 'o' 进行异或操作，其ASCII码分别为104和111，
//结果确实是7，其二进制表示为 00000111。这个结果对应于ASCII表中的控制字符 BEL（响铃字符），
// 通常表示为 \x07。因此，在这个步骤之后，数组的第一个元素被更新为这个控制字符，即数组变为 ['\x07', 'e', 'l', 'l', 'o']。
//这个操作展示了如何使用异或（XOR）操作来交换两个字符的值而不使用额外的存储空间。这种技巧是基于异或操作的几个性质：任何数和自己异或的结果是0，
// 任何数和0异或是其自身，以及异或操作的可逆性。通过连续三次异或操作，可以在不引入临时变量的情况下交换两个变量的值。