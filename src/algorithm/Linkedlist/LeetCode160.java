package src.algorithm.Linkedlist;

public class LeetCode160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null; // 修改这里，之前的构造函数尝试错误地设置next
        }
    }

    static class Solution160 {
        public ListNode getInterSectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                a = (a == null) ? headB : a.next;
                b = (b == null) ? headA : b.next;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        // 创建两个相交的链表示例
        // 链表A: 1 -> 2 -> 3
        //                 \
        //                  5 -> 6 -> 7
        //                 /
        // 链表B:    4 -> 5
        ListNode common = new ListNode(5);
        common.next = new ListNode(6);
        common.next.next = new ListNode(7);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common;

        ListNode headB = new ListNode(4);
        headB.next = common;

        Solution160 solution160 = new Solution160();
        // 方法调用时去除了类型声明
        ListNode intersectionNode = solution160.getInterSectionNode(headA, headB);
        if (intersectionNode != null) {
            System.out.println("The intersection node's value is " + intersectionNode.val);
        } else {
            System.out.println("No intersection node.");
        }
    }
}