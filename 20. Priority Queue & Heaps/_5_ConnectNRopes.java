
import java.util.PriorityQueue;

public class _5_ConnectNRopes {
    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int rope:ropes){
            pq.add(rope);
        }

        int cost = 0;

        while(pq.size() > 1){
            int currCost = pq.remove()+pq.remove();
            cost += currCost;
            pq.add(currCost);
        }

        System.out.println(cost);
    }
}
