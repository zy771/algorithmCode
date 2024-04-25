package src.algorithm.Linkedlist;

public class SwapPairs {
    public static void main(String[] args) {
        // 创建链表 1->2->3->4
        ListNodeSwapPairs head = new ListNodeSwapPairs(1);
        head.next = new ListNodeSwapPairs(2);
        head.next.next = new ListNodeSwapPairs(3);
        head.next.next.next = new ListNodeSwapPairs(4);

        System.out.println("原始链表:");
        printList(head);

        SolutionSwapPairs solution = new SolutionSwapPairs();
        ListNodeSwapPairs swappedHead = solution.swapPairs(head);

        System.out.println("交换后的链表:");
        printList(swappedHead);
    }

    // 辅助方法，用于打印链表
    public static void printList(ListNodeSwapPairs node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println(); // 确保在打印完列表后有换行
    }
}
class ListNodeSwapPairs{
    int val;
    ListNodeSwapPairs next;

    public ListNodeSwapPairs(int val){
        this.val=val;
        this.next=null;
    }
}

class SolutionSwapPairs{
    public ListNodeSwapPairs swapPairs(ListNodeSwapPairs head){
        ListNodeSwapPairs dummyhead =new ListNodeSwapPairs(-1);
        dummyhead.next=head;
        ListNodeSwapPairs cur=dummyhead;
        ListNodeSwapPairs temp;
        ListNodeSwapPairs firstnode;
        ListNodeSwapPairs secondnode;
        while (cur.next!=null && cur.next.next!=null){
            temp=cur.next.next.next;
            firstnode=cur.next;
            secondnode=cur.next.next;
            cur.next=secondnode;
            secondnode.next=firstnode;
            firstnode.next=temp;
            cur=firstnode;
        }
        return dummyhead.next;
    }
}