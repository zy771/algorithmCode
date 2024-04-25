package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：ValidParenthesesLeetcode20
 * @Date：2024/4/13 16:24
 */

//在Java中使用Deque接口而不是Stack类来实现栈的功能主要是出于性能和设计原则的考虑。这里有几个关键点说明为什么在现代Java编程中推荐使用Deque而不
// 是Stack：
//性能优势：Stack类是基于Vector实现的，而Vector是同步的，这意味着它在每个操作上都有同步开销，即使在单线程应用中也是如此。相比之下，LinkedList
// 实现的Deque没有这种同步开销，因此在非多线程环境下性能更好。
//更灵活的API：Deque接口提供了更加丰富和灵活的API，支持在双端队列的两端进行元素的插入和移除。这为数据结构的使用提供了更多的可能性，如可以轻易地切
// 换为队列使用。
//推荐的实践：自从Java 1.6以来，官方文档推荐使用Deque来实现栈的功能。这是因为Deque接口及其实现（如ArrayDeque和LinkedList）提供了一种更加现
//避免遗留问题：Stack类属于Java早期的遗留类，其设计和某些实现细节不如新的Deque接口那样符合现代Java集合框架的规范。使用Deque可以避免一些潜在的
// 遗留问题，使代码更加清晰和规范。
//这些原因导致在现代Java编程中，当你需要一个栈的实现时，通常会选择实现Deque接口的类（如ArrayDeque或LinkedList），而不是使用老旧的Stack类。
// 这样不仅提高了性能，也使得数据结构的使用更加符合现代Java编程的最佳实践。

/*在Java中，Deque<Character> 既可以用作栈也可以用作队列，因为它是一个双端队列接口，支持两端元素的快速插入和删除。这就意味着你可以通过不同的方法
调用来实现栈的行为（后进先出）或队列的行为（先进先出）。
在上述例子中，LinkedList 实现了 Deque 接口。虽然 LinkedList 本质上是一个双端队列，它被用作栈来存放期望匹配的右括号。这是通过使用 push 方法添
加元素到列表的开头，以及使用 pop 方法从列表开头移除元素来实现的。这些操作符合栈的特性，即后进的元素会先出来（LIFO，Last In First Out）。
总结来说，LinkedList 被用作栈，是通过在 Deque 接口的基础上调用特定的方法来控制数据的输入和输出方式，使其符合栈的操作模式。在处理括号匹配的问题时
这种用法非常有用，因为你只需要跟踪最近未匹配的左括号，然后检查接下来的右括号是否与之匹配。*/

import java.util.Deque;//双端队列
import java.util.LinkedList;
import java.util.Scanner;

public class ValidParenthesesLeetcode20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string with parentheses to validate:");
        String input = scanner.nextLine();
        scanner.close();

        boolean valid = isValid(input);
        System.out.println("The parentheses in the string \"" + input + "\" are " + (valid ? "correctly" : "incorrectly") + " matched.");
    }

    public static boolean isValid(String s) {
        /*LinkedList 是一种常见的数据结构，它由一系列的节点组成，每个节点包含数据部分和指向列表中下一个节点的指针。与数组不同，
        链表的元素不是连续存储的，这使得插入和删除节点的操作可以更加快速，因为这些操作不需要重新排列整个数据结构。
链表可以有几种不同的类型：
单向链表：每个节点只包含指向下一个节点的链接。
双向链表：每个节点都有两个链接，一个指向下一个节点，另一个指向前一个节点。
循环链表：链表中的最后一个节点指向第一个节点，形成一个环。
链表在需要动态内存分配时特别有用，因为它可以在运行时灵活地增减节点。它常用于实现各种高级数据结构，如队列、栈和某些图形结构。*/
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
                //deque.isEmpty() 检查 deque 是否为空。如果为空，则表示没有预期的右括号匹配当前的右括号，字符串无效。
                //deque.peek() != ch 检查栈顶的字符是否与当前的右括号匹配。如果不匹配，返回 false。 如果通过了检查，则从 deque 中移除栈顶元素。
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
               /*在处理括号匹配问题时，这一步else { deque.pop(); }是至关重要的，因为它代表了括号匹配成功的情形。

逻辑解析
当遍历到一个闭合括号（如), }, ]）时，我们首先检查两件事：

Deque是否为空：如果Deque为空，这意味着没有对应的开放括号（(, {, [）可以与当前的闭合括号匹配，因此字符串立即判定为无效。
栈顶的元素是否与当前闭合括号匹配：使用deque.peek()查看栈顶元素（最后一个被推入的期待匹配的闭合括号），检查它是否与当前字符匹配。如果不匹配，这意味
着括号的顺序错误或类型不匹配，因此返回false。
功能说明
如果以上两个检查都通过了（即Deque不为空，且栈顶元素与当前闭合括号匹配），则执行deque.pop()操作。这一步的作用是：

移除栈顶元素：这表示当前的闭合括号已经找到了与之对应的开放括号，并且匹配成功。pop()操作移除了栈顶的元素（即预期的闭合括号），这是因为此闭合括号已经
在文本中出现并与一个开放括号成功配对。
结果
通过这种方式，每次遇到闭合括号时，我们都会尝试从Deque中移除一个对应的开放括号。如果在遍历结束时Deque为空，这意味着所有的括号都成功找到了匹配的对应项，
字符串有效。如果Deque中还有未被匹配的开放括号，这意味着有一些开放括号没有找到对应的闭合括号，字符串无效。

因此，deque.pop()是确保每次成功匹配后，移除对应的预期闭合括号，维持Deque的正确性和匹配完整性的关键步骤。*/