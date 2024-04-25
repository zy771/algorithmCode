package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：EvaluateReversePolishNotatonLeetcode150
 * @Date：2024/4/14 13:43
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class EvaluateReversePolishNotatonLeetcode150 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入逆波兰表达式，各元素以空格分隔:");
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");  // 根据空白字符分割字符串
        int result = new Solution().evalRPN(tokens);
        System.out.println("表达式的结果为: " + result);
        scanner.close();
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            //deque双端队列有两种实现方式ArrayDeque和LinkesList
            //@see:https://www.cainiaojc.com/java/java-deque.html
            Deque<Integer> stack = new LinkedList<>();//Deque由LingkedList实现，stack只能实现Deque的方法
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        int right = stack.pop();  // 弹出右操作数
                        int left = stack.pop();   // 弹出左操作数
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int divisor = stack.pop();  // 弹出除数
                        int dividend = stack.pop(); // 弹出被除数
                        stack.push(dividend / divisor); // 计算商
                        break;
                    default://Integer.valueOf(token)：这个方法将字符串 token 不是符号的数字转换为其对应的 Integer 对象。因为逆波兰表达式中的元素可以是整数或运算符
                        stack.push(Integer.valueOf(token));//只接受包装类，包装类是对象
                        break;
                }
            }
            return stack.pop();  // 返回计算结果
        }
    }
}

/*在Java中，Deque 是一个双端队列接口，提供了在队列两端插入和移除元素的方法。实现 Deque
接口的两个主要类是 ArrayDeque 和 LinkedList。下面详细介绍这两个类的特性和使用场景：

1. ArrayDeque
ArrayDeque 是基于可变大小的数组实现的双端队列。它提供了高效的数组动态扩容能力，且可以作为栈或队列使用。

特点：

高性能：大多数操作（如添加和移除）都具有固定的时间复杂度（O(1)）。
无容量限制：自动扩容以适应增加的元素。
不允许插入null元素：使用null作为特殊返回值以表示队列为空。
适用场景：

当需要高效、快速访问的双端队列时，特别是元素数量频繁变动的情况。
作为栈使用时，比Stack类更优，因为Stack类是基于Vector实现，而Vector的每个操作都是同步的，影响性能。
2. LinkedList
LinkedList 实现了List和Deque接口，基于双向链表。可以作为列表、栈或队列使用。

特点：

动态扩展：每个元素作为节点独立存储，通过链接指向前后节点。
允许插入null元素。
元素访问时间复杂度较高：访问任意位置的元素需要时间复杂度为O(n)，因为需要从头或尾遍历。
适用场景：

当需要在列表中间频繁添加或删除元素时。
在实现需要频繁插入和删除的队列或栈时使用，尤其是当操作不限于集合的一端时。
使用示例（作为栈使用）：

java
Deque<Integer> stack = new LinkedList<>();
stack.push(10); // 元素入栈
int top = stack.pop(); // 元素出栈
总结：

ArrayDeque 更适合作为纯栈或队列使用，尤其是在元素数量变化频繁且关注性能时。
LinkedList 提供更多灵活性，适用于需要双向遍历或在列表中间进行操作的场景。
选择哪种实现取决于具体应用的需求和性能考量。在处理大量数据且关注性能时，ArrayDeque
是更佳的选择。如果需要在数据结构中间频繁进行插入和删除操作，LinkedList 可能更适合。*/