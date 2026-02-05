class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    public void printLinkedList(){
        Node n = head;
         while(n != null){
            System.out.print(n.data + " -> ");
            n = n.next;
         }
         System.out.println("null");
    }

    public boolean removeCycle(){
        // Detecting Cycle by Floyd's algorithm
        boolean isCycle = false;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

            if(!isCycle){
                return isCycle;
            }

        
        // Removing Cycle

            slow = head;
            Node fastPrev = null;
            
            while(slow != fast){
                slow = slow.next;
                fastPrev = fast;
                fast = fast.next;
            }
            fastPrev.next = null;

        

             return isCycle;
    }

}



public class _5_RemoveCycle {
    public static void main(String[] args) {
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

        ll.removeCycle();
        ll.printLinkedList();




         LinkedList ll2 = new LinkedList();
         ll2.head = new Node(1);
         ll2.head.next = new Node(2);
         ll2.head.next.next = new Node(3);
         ll2.head.next.next.next = new Node(4);
         ll2.head.next.next.next.next = new Node(5);
         ll2.head.next.next.next.next.next = ll2.head.next;

         /*
            1 → 2 → 3
                ↑   ↓
                5 ← 4
          
          */

        ll2.removeCycle();
        ll2.printLinkedList();
         

    }
}
