



class LinkedList{
    private class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    private void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int... elements){
        for(int e:elements){
            addLast(e);
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("LinkedList is empty");
        }
        Node node = head;
        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println(" null");
    }

    private Node midNode(){
        Node slow,fast;
        slow =  head;
        fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public LinkedList ZigZagLinkedList(){
        if(head == null || head.next == null)return this;

        //1. Finding mid
        Node mid = midNode();

        //2. Reverse Second Half
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //3. filling new LL

        Node rightNode = prev;
        Node leftNode = head;

        LinkedList newList = new LinkedList();

        while(rightNode != null){
            newList.add(leftNode.data);
            if(leftNode != rightNode){
                newList.add(rightNode.data);
            }
            leftNode = leftNode.next;
            rightNode= rightNode.next;
        }

        //4. Restoring second half

        curr = prev;
        prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return newList;


    }

    public void convertLLtoZigZag(){
        //if there are 0 , 1 , 2 elements in LL then return
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        //1. Find Mid and reverse 2nd half

        Node mid = midNode();
        Node nextToMid = mid.next;
        mid.next = null;

        Node prev = null;
        Node curr = nextToMid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //2.

        Node LH = this.head;
        Node RH = prev;

        Node nextL,nextR;

        while(LH != null && RH != null){
            nextL = LH.next;
            nextR = RH.next;
            LH.next = RH;
            RH.next = nextL;

            LH = nextL;
            RH = nextR;
        }
    }
}

public class _7_convertLLtoZigZag {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.add(1,3,5,7,6,4,2);
        ll.printList();


        // LinkedList ZigZagList = ll.ZigZagLinkedList();
        // ZigZagList.printList();
        // ll.printList();

        ll.convertLLtoZigZag();
        ll.printList();
    }
}
