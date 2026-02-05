import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class _9_QueueReversal {
    public static <T> void reverseQueue(Queue<T> queue){
        Stack<T> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Character> queue = new ArrayDeque<>();

        queue.add('a');
        queue.add('b');
        queue.add('c');
        queue.add('d');
        queue.add('e');
        queue.add('f');

        System.out.println(queue);

        reverseQueue(queue);

        System.out.println(queue);
    }
}
