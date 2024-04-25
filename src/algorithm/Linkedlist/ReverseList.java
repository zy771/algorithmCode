package src.algorithm.Linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1,new ListNode2(2,new ListNode2(3,new ListNode2(4,new ListNode2(5)))));
        Solution s=new Solution();
        ListNode2 rhead=s.rList(head);
        ListNode2 cur=rhead;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}

class ListNode2{
    int val;
    ListNode2 next;

    public  ListNode2(int val){
        this.val=val;
        this.next=null;
    }

    public ListNode2(int val,ListNode2 next){
        this.val=val;
        this.next=next;
    }
}



class Solution {
    public ListNode2 rList(ListNode2 head) {
        ListNode2 prev = null;
        ListNode2 cur = head;
        ListNode2 temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
