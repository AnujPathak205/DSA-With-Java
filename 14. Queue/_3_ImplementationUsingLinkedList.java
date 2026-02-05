
class Queue{
    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Queue(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }

        return head.data;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }

        int result = head.data;
        head = head.next;

        if(head == null)tail = null;

        return result;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return;
        }
        Node tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}

public class _3_ImplementationUsingLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);

        q.printQueue();

        q.dequeue();
        q.dequeue();

        q.printQueue();

        
    }
}
