package src.algorithm.Linkedlist;

public class LeetCode19 {
    public static void main(String[] args) {
        // 创建链表 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 打印原始链表
        System.out.println("Original List:");
        printList(head);

        // 移除倒数第2个节点
        ListNode result = removeNthFromEnd(head, 2);

        // 打印修改后的链表
        System.out.println("Modified List:");
        printList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 快指针先移动 n+1 步
        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }

        // 快慢指针一起移动，直到快指针到达末尾
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 删除倒数第 n 个节点
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
