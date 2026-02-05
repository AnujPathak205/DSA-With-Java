
import java.util.Arrays;
import java.util.PriorityQueue;

public class _7_SlidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(p2.val, this.val);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;//window size

        int[] result = new int[arr.length-k+1];//n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0;i < k-1;i++){
            pq.add(new Pair(arr[i], i));
        }

        for(int i = k-1;i < arr.length;i++){
            while(!pq.isEmpty() && pq.peek().idx <= i-k)
                pq.remove();
            pq.add(new Pair(arr[i], i));
            result[i-k+1] = pq.peek().val;
        }

        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();
        Arrays.stream(result).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();
    }
}
