class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

class LinkedList{
    Node head;
    Node tail;
    int size = 0;

    public void addLast(int data){
        size++;
        Node node = new Node(data);
        if(tail == null){
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void add(int[] arr){
        for(int i = 0;i < arr.length;i++){
            addLast(arr[i]);
        }
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node node = head;
        while(node != null){
            System.out.print(node.data+" -> ");
            node = node.next;
        }
        System.out.println(" null");
    
    }  
    
    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        Node prev = null;
        Node curr =  tail = head;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }
}

public class _2_ReverseLinkedList{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int arr[] = {1,2,3,4,5,6,7,8,9};
        ll.add(arr);

        ll.printLinkedList();
        ll.reverse();
        ll.printLinkedList();
        System.out.println(ll.tail.next);
    }
}