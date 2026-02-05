class DoublyLinkedList{
    private Node head;
    private Node tail;

    private class Node{
        int data;
        Node prev;
        Node next;

        private Node(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void add(int e1,int...elements){
        this.addLast(e1);
        for(int e: elements){
            this.addLast(e);
        }
    }

    
    public void removeFirst(){
        if(head == null){
            System.out.println("Doubly Linked List is already empty");
        }else if(head.next == null){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast(){
        if(head == null){
            System.out.println("Doubly Linked List is already empty");
        }else if(head.next == null){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }

    }


    
    public void printForward(){
        if(head == null){
            System.out.println("Doubly Linked is empty");
            return;
        }
        Node node = head;
        System.out.print("null -> ");
        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println(" null");
    }

    public void printBackward(){
        if(tail == null){
            System.out.println("Doubly Linked is empty");
            return;
        }
        Node node = tail;
        System.out.print("null <- ");
        while(node != null){
            System.out.print(node.data+" <- ");
            node = node.prev;
        }
        System.out.println(" null");
    }

    public void reverseDLL(){
        if(head == null || head.next == null)return;
        Node node = head;
        while(node != null){
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = temp;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }
}





public class _8_DoublyLInkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1,2,3,4,5,6,7,8,9);
        dll.printForward();
        
        dll.reverseDLL();

        dll.printForward();
        


    }
} 