import java.util.ArrayDeque;
import java.util.Queue;

public class _8_Interleave2HalvesOfQueue{
    public static <T> void Interleave2HalvesOfQueue(Queue<T> queue){
        if (queue.size() % 2 != 0) {
                System.out.println("Queue size must be even!");
                return;
        }

        int half = queue.size()/2;

        Queue<T> firstHalf = new ArrayDeque<>();
        
        for(int i = 0;i < half;i++){
            firstHalf.add(queue.remove());
        }

        Queue<T> secondHalf = new ArrayDeque<>();

        for(int i = 0;i < half;i++){
            secondHalf.add(queue.remove());
        }

        // for(int i = 0;i < 2*half;i++){
        //     if(i%2 == 0){
        //         queue.add(firstHalf.remove());
        //     }else{
        //         queue.add(secondHalf.remove());
        //     }
        // }

        while(!firstHalf.isEmpty()){
            queue.add(firstHalf.remove());
            queue.add(secondHalf.remove());
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

        Interleave2HalvesOfQueue(queue);

        System.out.println(queue);

    }
}
