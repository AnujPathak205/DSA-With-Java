class CircularQueue{
    private int arr[];
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int n){
        arr = new int[n];
        size = n;
        front = rear = -1;
    }

    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    public boolean isFull(){
        return (rear +1 )%size == front;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        return arr[front]; 
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }

        if(front == -1)front = 0;
        rear = (rear+1)%size;
        arr[rear] = data;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }

        int result = arr[front];
        if(rear == front)front = rear = -1;
        else front = (front+1)%size;
        return result;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return;
        }
        int i = front;
        while (true) { 
            System.out.print(arr[i]+" ");
            if(i == rear)break;
            i = (i+1)%size;
        }
        System.out.println();
    }
}

public class _2_CircularQueueUsingArray {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(3);
        q.enqueue(6);
        q.enqueue(5);
        q.enqueue(11);
        q.enqueue(9);

        q.printQueue();
        
        q.dequeue();
        q.dequeue();

        q.printQueue();

        q.enqueue(8);
        q.enqueue(55);

        q.printQueue();
    }
}
