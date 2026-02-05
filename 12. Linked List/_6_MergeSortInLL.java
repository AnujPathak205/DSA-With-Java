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

        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int... elements){
        for(int e: elements){
            addLast(e);
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("Linked List is empty.");
        }

        Node node = head;
        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println(" null");
    }

    private Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //1.  Finding Mid Node
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node midNode = slow;

        //2. divide into two halfs

        Node nextToMid = midNode.next;
        midNode.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(nextToMid);

        //3. Merge left and right

        Node temp = new Node(-1);
        Node mergedLL = temp;

        while(newLeft != null && newRight != null ){
            if(newLeft.data <= newRight.data){
                temp.next = newLeft;
                newLeft = newLeft.next;
            }else{  
                temp.next = newRight;
                newRight = newRight.next;
            }
            temp = temp.next;
        }

        while(newLeft != null){
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }

        while(newRight != null){
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }

        

        return mergedLL.next;



    }

    public void mergeSort(){
        head = mergeSort(head);
    }
}

public class _6_MergeSortInLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1,0,2,9,4,3,5,6,7,8,2,1,2,1,2);

        ll.printList();
        ll.mergeSort();
        ll.printList();
    }
}
