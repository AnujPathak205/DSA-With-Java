class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    Node tail;

    //Floyd's Cycle Detection Approach
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast )return true;
        }
        return false;
    }
}


public class _4_detectCycle {
   public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(3);
        ll.head.next.next.next = new Node(4);
        ll.head.next.next.next.next = new Node(5);
        ll.head.next.next.next.next.next = new Node(6);
        ll.head.next.next.next.next.next.next = ll.head.next.next;
        /*
            1 → 2 → 3 → 4
                    ↑   ↓
                    6 ← 5
         */

        System.out.println(ll.isCycle());



   } 
}
