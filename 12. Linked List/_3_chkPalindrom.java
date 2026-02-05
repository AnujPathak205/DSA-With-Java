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
    Node tail;
    int size;

    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        
        if(tail == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int[] arr){
        for(int element: arr){
            addLast(element);
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.data+" -> ");
            tempNode = tempNode.next;
        }
        System.out.println(" null");
    }

    //Slow-Fast approach
    public Node midNode(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrom(){
        if(head == null || head.next == null){
            return true;
        }
        //1. Find mid node
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

        //3. compare left half and right half
        Node rightNode = prev;
        Node leftNode = head;

        boolean isPalindrom = true;
    
        while(rightNode != null){
            if(leftNode.data != rightNode.data){
                isPalindrom = false;
                break;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;

        }

        //4. Restoring the second half

        curr = prev;
        prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return isPalindrom;

    }
}

public class _3_chkPalindrom {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int arr[] = {1,2,3,4,5,4,3,2,1};
        ll.add(arr);

        ll.printList();

        Node mid = ll.midNode();
        System.out.println(ll.isPalindrom());

        ll.printList();

    }
}
