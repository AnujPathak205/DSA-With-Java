import java.util.ArrayDeque;
import java.util.Deque;

class Stack<T>{
    private Deque<T> deque = new ArrayDeque<>();

    public void push(T data){
        deque.addLast(data);
    }

    public T pop(){
        return deque.removeLast();
    }

    public T peek(){
        return deque.getLast();
    }
}

public class _11_ImplementationOfStackUsingDeque {
    public static void main(String[] args) {
        
    }
}
