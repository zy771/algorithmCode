package src.algorithm.StackAndQueue;

/**
 * @Author：zz
 * @Package：src.algorithm.StackAndQueue
 * @Project：algorithmCode
 * @name：StackImplementationQueueLeetcode232
 * @Date：2024/4/13 12:19
 */

import java.util.Stack;//过时
import java.util.Scanner;

public class StackImplementationQueueLeetcode232 {

    static class MyQueue {
        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }


        //为了用两个栈实现队列先进先出，模拟出队列时需要先判断stackOut是否为空，若不为空
        //先使用dumpstackIn();将stackIn中倒入stackOut中
        public int pop() {
            if (stackOut.isEmpty()) {
                dumpstackIn();
            }
            return stackOut.pop();
        }

        public int peek() {
            if (stackOut.isEmpty()) {
                dumpstackIn();
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        //辅助方法，用于将stackIn中的所有元素倒入stackOut。这个方法在pop和peek操作中被调用
        private void dumpstackIn() {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter commands (1 = push, 2 = pop, 3 = peek, 4 = check if empty, 0 = exit):");
        int command;

        //break会跳过switch运行到while判断，为真就再运行到do
        do {
            System.out.print("Enter command: ");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.print("Enter integer to push: ");
                    int num = scanner.nextInt();
                    queue.push(num);
                    System.out.println(num + " pushed to queue");
                    break;
                case 2:
                    if (!queue.empty()) {
                        System.out.println(queue.pop() + " popped from queue");
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 3:
                    if (!queue.empty()) {
                        System.out.println("Front element: " + queue.peek());
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 4:
                    System.out.println("Is queue empty? " + queue.empty());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                    //在 Java 的 switch 语句中，default: 关键字起着非常重要的作用。它指定了当没有任何 case 语句匹配到 switch 表达式的值时，
                // 将执行的代码块。可以把 default: 看作是一个备选方案，用于处理所有未被前面的 case 语句覆盖的情况。这是为了确保 switch 语句总
                // 是有一个执行路径，即使没有任何 case 与当前的条件值匹配。
                default:
                    System.out.println("Invalid command!");
            }
        } while (command != 0);

        scanner.close();
    }
}
