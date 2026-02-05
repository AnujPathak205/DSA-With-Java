class Stack{
    private class Node{
        int data;
        Node next;

        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if(head == null){
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek(){
        if(head == null){
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }


}

public class _2_ImplementationUsingLInkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
