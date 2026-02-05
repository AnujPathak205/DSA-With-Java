import java.util.ArrayDeque;
import java.util.Queue;

//1st solution:implementation is costly on dequeue : O(n) 
//enqueue: O(1) 
//dequeue: O(n)
//peek:    O(n)
class Stack1<T>{
    private Queue<T> queue1 = new ArrayDeque<>();
    private Queue<T> queue2 = new ArrayDeque<>();
    private int size = 0;

    public boolean isEmpty(){//O(1)
        return size == 0;
    }

    public void push(T data){//O(1)
        queue1.add(data);
        size++;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Empty Stack");
            return null;
        }

        for(int i = 1;i < size;i++){
            queue2.add(queue1.remove());
        }

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        size--;

        return queue2.remove();
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Empty Stack");
            return null;
        }

        for(int i = 1;i < size;i++){
            queue2.add(queue1.remove());
        }

        T result = queue1.remove();
        queue2.add(result);

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    @Override
    public String toString(){
        return isEmpty()?"Empty Queue": queue1.toString()+"--> top";
    }
}

//1st solution:implementation is costly on dequeue : O(n) <><><><>[In Another way]<><><><>
//enqueue: O(1) 
//dequeue: O(n)
//peek:    O(n)

class Stack2<T>{
    private Queue<T> queue1 = new ArrayDeque<>();
    private Queue<T> queue2 = new ArrayDeque<>();

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public void push(T data){
        if(!queue1.isEmpty()){
            queue1.add(data);
        }else{
            queue2.add(data);
        }
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }

        T top = null;

        if(queue1.isEmpty()){
            while(!queue2.isEmpty()){
                top = queue2.remove();

                if(queue2.isEmpty()){
                    break;
                }                

                queue1.add(top);
            }
        }else{
            while(!queue1.isEmpty()){
                top = queue1.remove();

                if(queue1.isEmpty()){
                    break;
                }                

                queue2.add(top);
            }
        }

        return top;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }

        T top = null;
        if(queue1.isEmpty()){
            while(!queue2.isEmpty()){
                top = queue2.remove();
                queue1.add(top);
            }
        }else{
            while(!queue1.isEmpty()){
                top = queue1.remove();
                queue2.add(top);
            }
        }

        return top;
    }

    @Override
    public String toString(){
        return isEmpty()? "Stack is Empty":(queue1.isEmpty()? queue2.toString(): queue1.toString());
    }
}

public class _6_StackUsing2Queues {
    public static void main(String[] args) {
        Stack2<Character> stack = new Stack2<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');

        System.out.println(stack);

        stack.pop();
        stack.pop();
        
        System.out.println(stack);

        System.out.println("top: "+stack.peek());
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }
}
