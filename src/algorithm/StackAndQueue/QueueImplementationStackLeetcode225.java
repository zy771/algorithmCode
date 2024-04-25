package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：QueueImplementationStackLeetcode225
 * @Date：2024/4/13 15:24
 */

import java.util.Scanner;
import java.util.Deque;//double end queue,栈和队列尽量用双端队列
import java.util.ArrayDeque;

public class QueueImplementationStackLeetcode225 {

    static class MyStack {
        Deque<Integer> que1;

        public MyStack() {
            que1 = new ArrayDeque<>();
        }

        public void push(int x) {
            que1.addLast(x);
        }


        //示例演示
        //假设que1最初包含元素[1, 2, 3]，其中3是最后进入的元素（栈顶元素）。
        //
        //调用pop()方法:
        //size初始为3，经过size--后变为2。
        //循环两次，每次将前端的元素移至后端，队列变化如下：
        //第一次：从[1, 2, 3]变为[2, 3, 1]
        //第二次：从[2, 3, 1]变为[3, 1, 2]
        //最后，pollFirst()调用结果为3，此时队列状态为[1, 2]。
        //因此，pop()方法的调用结果是弹出栈顶元素3，并且队列（模拟栈）现在的状态是[1, 2]，其中2成为新的栈顶元素。
        public int pop() {
            int size = que1.size();
            size--;
            while (size-- > 0) {
                que1.addLast(que1.peekFirst());
                que1.pollFirst();
            }
            return que1.pollFirst();
        }

        public int top() {
            return que1.peekLast();
        }

        public boolean empty() {
            return que1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Stack Simulator");
        System.out.println("Commands:");
        System.out.println("push <integer> - 输入push再空格输入数字");
        System.out.println("pop - Pop the top element from the stack");
        System.out.println("top - Get the top element of the stack");
        System.out.println("empty - Check if the stack is empty");
        System.out.println("exit - Exit the program");

        while (true) {

            //在 Java 中，String 类型可以包含字符、数字、符号等任何 Unicode 字符。当你需要在一个字符串中包含数字时，你可以直接将数字作为文本
            // 插入到字符串中，或者通过连接操作将数字变量与字符串结合起来。这里是两种常见的方式：
            //1. 直接在字符串中包含数字2. 将数字变量与字符串连接

            System.out.print("> ");
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            //检查参数数量：if (commands.length == 2)。这行代码检查用户输入的命令是否恰好有两个部分：一个是命令本身（"push"），另一个是要推入栈的整数。这是确保用户输入格式正确的必要步骤。
            //
            //解析并推入元素：
            //
            //int num = Integer.parseInt(commands[1]); 这行代码尝试将用户输入的第二个部分（即整数）解析为int类型。如果用户输入的不是有效的整数（例如，输入的是字母或特殊字符），这里会抛出一个NumberFormatException。
            //stack.push(num); 如果解析成功，这行代码将解析得到的整数num推入栈中。
            //反馈操作结果：System.out.println("Pushed " + num); 这行代码输出一条消息，告诉用户指定的整数已经成功推入栈中。
            //
            //处理错误输入：
            //
            //else 这部分代码在commands.length不等于2时执行，即当用户没有按正确格式输入数据时（例如只输入了"push"或者"push"后跟了多个参数）。
            //System.out.println("Error: Invalid arguments for 'push'"); 输出一条错误消息，提示用户输入的参数无效。
            try {
                switch (commands[0]) {
                    case "push":
                        if (commands.length == 2) {
                            int num = Integer.parseInt(commands[1]);
                            stack.push(num);
                            System.out.println("Pushed " + num);
                        } else {
                            System.out.println("Error: Invalid arguments for 'push'");
                        }
                        break;
                    case "pop":
                        System.out.println("Popped " + stack.pop());
                        break;
                    case "top":
                        System.out.println("Top element is " + stack.top());
                        break;
                    case "empty":
                        System.out.println("Stack is " + (stack.empty() ? "empty" : "not empty"));
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Error: Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
