package src.algorithm.Linkedlist;

public class LeetCode142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            // 第一阶段：判断链表是否有环
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) { // 发现环
                    // 第二阶段：找到环的入口
                    ListNode slow2 = head;
                    while (slow2 != slow) {
                        slow = slow.next;
                        slow2 = slow2.next;
                    }
                    return slow; // 或 slow2
                }
            }
            // 如果没有环
            return null;
        }
    }

    public static void main(String[] args) {
        // 构建链表: 1->2->3->4->5->2...
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // 创建环
        head.next.next.next.next.next = head.next; // 5指向2，形成环

        Solution solution = new Solution();
        ListNode entrance = solution.detectCycle(head);
        if (entrance != null) {
            System.out.println("环的入口节点值为: " + entrance.val);
        } else {
            System.out.println("链表无环");
        }
    }
}
