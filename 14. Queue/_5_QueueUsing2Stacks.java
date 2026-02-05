import java.util.Stack;

//1st solution:implementation is costly on enqueue : O(n) 
//enqueue: O(n) 
//dequeue: O(1)
//peek:    O(1)
class Queue1<T>{
    private Stack<T> stack1;
    private Stack<T> stack2;

    public Queue1(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public void add(T data){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public T remove(){
        if(stack1.isEmpty()){
            System.out.println("Empty Queue");
            return null;
        }
        return stack1.pop();
    }

    public T peek(){
        return stack1.peek();
    }

    @Override
    public String toString(){
        return stack1.toString();
    }
}



//2nd solution:implementation is costly on dequeue : O(n) 
//enqueue: O(1) 
//dequeue: O(n)
//peek:    O(n)

class Queue2<T>{
    private Stack<T> stack1;
    private Stack<T> stack2;

    public Queue2(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void add(T data){
        stack1.push(data);
    }

    public T remove(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return null;
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        T result = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return result;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return null;
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        T result = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return result;
    }

    @Override
    public String toString(){
        return stack1.toString();
    }
    
}

public class _5_QueueUsing2Stacks {
    public static void main(String[] args) {
        Queue2<Integer> q = new Queue2<>();
        q.add(3);
        q.add(7);
        q.add(9);

        System.out.println(q);

        
    }
}
