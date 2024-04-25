package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：RemoveAllAdjacentDuplicatesInStringLeetcode1047
 * @Date：2024/4/14 13:17
 */


import java.util.ArrayDeque;
import java.util.Scanner;

public class RemoveAllAdjacentDuplicatesInStringLeetcode1047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String input = scanner.nextLine();
        Solution solution = new Solution();
        String result = solution.removeDuplicates(input);
        System.out.println("去重后的字符串为: " + result);
        scanner.close();
    }
    static class Solution {
        public String removeDuplicates(String S) {
            ArrayDeque<Character> deque = new ArrayDeque<>();
            char ch;
            for (int i = 0; i < S.length(); i++) {
                ch = S.charAt(i);
                if (deque.isEmpty() || deque.peek() != ch) {
                    deque.push(ch);
                } else {
                    deque.pop();
                }
            }
            String str = "";
            while (!deque.isEmpty()) {
                str = deque.pop() + str;
            }
            return str;
        }
    }
}

/*在Java中，使用 static 关键字来定义一个类作为另一个类的静态内部类意味着这个内部类与外部类的实例无关，而是与外部类本身相关联。具体来说：

静态内部类 (static class)
与外部类的实例无关：静态内部类不需要外部类的实例就可以被创建。这意味着你可以在没有创建外部类实例的情况下，创建静态内部类的实例。
访问限制：静态内部类只能直接访问外部类的静态成员（变量和方法），它不能直接访问外部类的实例变量或实例方法。
用途：这种类经常用于当你需要使用内部类，而这个内部类又不应该与外部类的实例相关联时。例如，当内部类的行为不依赖于外部类实例的状态时，或者当你想要组织相
关的类在一起以便维护时。*/

