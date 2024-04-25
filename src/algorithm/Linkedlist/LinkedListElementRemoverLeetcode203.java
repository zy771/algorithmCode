package src.algorithm.Linkedlist;

import java.util.Scanner;

public class LinkedListElementRemoverLeetcode203 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of numbers (separated by spaces):");
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        System.out.println("Enter the number you want to remove:");
        int numberToRemove = scanner.nextInt();

        ListNode head = null;
        ListNode tail = null;

        // Building the linked list from the input numbers
        //采用尾插法建立单链表，建立的链表与输入的顺序一致，tail 指针在这个过程中起到关键作用，
        // 它始终保持指向链表的最后一个节点，确保新节点可以直接链接到链表的末端。
        /*tail.next = new ListNode(num); 这行代码将新节点链接到链表的末尾。
更新 tail 指针，使其指向新添加的节点：tail = tail.next; 这一步确保 tail 总是指向链表的最后一个节点。*/
        for (String value : values) {
            int num = Integer.parseInt(value);
            if (head == null) {
                head = tail = new ListNode(num);
            } else {
                tail.next = new ListNode(num);
                tail = tail.next;
            }
        }

        head = removeElements(head, numberToRemove);

        printList(head); // Print the modified linked list
    }

    //虚拟头节点，就是王道书里讲的头结点
    /*Java中的单链表删除
在Java中，不需要显式地释放被删除节点的内存。这是因为Java有一个自动垃圾收集机制（Garbage Collector, GC），它负责监控使用的内存，
并自动回收不再被任何引用变量所指向的对象内存。这意味着当一个节点从链表中删除，且没有其他引用指向这个节点时，这块内存就会被垃圾收集器
认定为可回收的，进而在未来某个时刻被自动清理。
C语言中的单链表删除
相比之下，在C语言中，内存管理是手动进行的。C语言提供了malloc或calloc函数用于分配内存，free函数用于释放内存。当你删除链表中的一个
节点时，你需要手动释放那个节点所占用的内存，以避免内存泄漏。内存泄漏是指已分配的内存不再被使用（即没有指针指向该内存），但程序没有释
放它，导致程序占用的内存量随时间不断增加。
*/
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;//java有gc不需要自己释放被删除节点内容
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(); // Ensuring the output ends on a new line
    }

    /*静态内部类的特性
独立性：静态内部类与非静态内部类最大的区别在于，静态内部类不需要引用其外部类的实例。这意味着它可以被创建和使用，而无需创建其外部类的对象。
访问权限：静态内部类可以访问外部类的所有静态成员和静态方法。这是因为静态内容不依赖于类的具体实例。*/

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        /*在Java中，this 关键字是一个非常重要的部分，用于引用当前对象的实例。
        它主要用于访问类内部的成员（变量和方法），特别是当局部变量（如函数参数）
        与类的成员变量同名时，以区分成员变量和局部变量。*/

        /*解释 this 关键字
指向当前对象：this 是对当前正在执行的方法所属对象的自引用。
成员访问：当类的局部变量（例如方法的参数）与成员变量同名时，可以使用 this 来区分成员变量。
构造器调用：在一个构造器中使用 this 可以调用类的其他构造器，通常用于重载构造器。
生动举例说明 this 关键字
假设有一个名为 Car 的类，这个类有两个成员变量：color 和 model。同时，在构造函数中我们也使用了同样名称的参数，这时就可以使用 this 来区分成员变量和参数。

java
public class Car {
    private String color;
    private String model;

    public Car(String color, String model) {
        this.color = color; // 使用 `this.color` 来指向成员变量，而非构造函数的参数
        this.model = model; // 同上
    }

    public void updateModel(String model) {
        this.model = model; // 明确指出`this.model`是成员变量，`model`是方法参数
    }

    public void printDetails() {
        System.out.println("Car color: " + this.color + ", model: " + this.model);
        // 使用 `this` 强调从当前对象的上下文中访问成员变量
    }
}

// 创建Car对象的实例
Car myCar = new Car("Red", "Tesla Model S");
myCar.printDetails(); // 输出：Car color: Red, model: Tesla Model S
在这个例子中，this.color 和 this.model 明确指向了成员变量，而参数 color 和 model 仅在构造函数和方法的局部范围内有效。这样的用法避免了局部变量覆盖成员变量导致的混淆，并且使代码更加清晰和易于维护。

通过这种方式，this 不仅增强了代码的可读性，还保证了变量访问的准确性，是处理类内作用域问题的重要工具。*/
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
