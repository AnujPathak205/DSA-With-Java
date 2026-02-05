class Queue{
    int[] arr;
    int rear;

    public Queue(int size){
        rear = -1;
        arr = new int[size];
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public void add(int data){
        if(rear == arr.length-1){
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        int front = arr[0];
        for(int i = 0;i < rear;i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("front -> [");
        for(int i = 0;i <= rear;i++){
            if(i != rear)System.out.print(arr[i]+" -> ");
            else System.out.print(arr[i]);
        }
        System.out.println(" ] rear");
    }

    @Override
    public String toString(){
        return "Queue";
    }
}

public class _1_ImplementationUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(4);
        q.add(6);
        q.add(2);
        q.add(8);
        
        q.printQueue();

        q.remove();

        q.printQueue();
    }
}
