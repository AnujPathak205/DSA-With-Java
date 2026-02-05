class CircularLinkedList{
    private class Node{
        int data;
        Node next;
        
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int e1,int...elements){
        this.addLast(e1);
        for(int e:elements){
            this.addLast(e);
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("Circular Linked List is empty");
            return;
        }
        Node node = head;
        do { 
            System.out.print(node.data+" -> ");
            node = node.next;
        } while (node != head);
        System.out.println(" back to head ");
    }
}

public class _9_CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(1,2,3,4,5,6,7,8,9,10);
        cll.printList();
    }
}
