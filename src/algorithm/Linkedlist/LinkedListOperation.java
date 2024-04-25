package src.algorithm.Linkedlist;

public class LinkedListOperation {
    public static void main(String[] args) {
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        linkedList.printList();//得在插入之后才能输出完整的
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(){}
    ListNode1(int val){
        this.val=val;
    }
}


class MyLinkedList{
    ListNode1 head;
    int size;

    public MyLinkedList(){
        head=new ListNode1(0);
        size=0;
    }

    public int get(int index){
        if (index<0||index>=size){
            return -1;
        }
        ListNode1 current=head;
        for (int i=0;i<index;i++){
            current=current.next;
        }
        return current.val;
    }

    public void addAtHead(int val){
        addAtIndex(0,val);
    }

    public void addAtTail(int val){
        addAtIndex(size,val);
    }

    public void addAtIndex(int index,int val){
        if (index>size){
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode1 pred=head;
        for (int i=0;i<index;i++){
            pred=pred.next;
        }
        ListNode1 toAdd=new ListNode1(val);
        toAdd.next=pred.next;
        pred.next=toAdd;
    }

    public void deleteAtIndex(int index){
        if (index<0||index>=size){
            return;
        }
        size--;
        ListNode1 pred=head;
        for (int i=0;i<index;i++){
            pred=pred.next;
        }
        pred.next=pred.next.next;
    }

    public void printList(){
        ListNode1 current=head;
        while(current !=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
    }
}