
import java.util.PriorityQueue;

public class _6_WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldier;
        int idx;

        public Row(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row R2){
            if(this.soldier == R2.soldier)
                return Integer.compare(this.idx, R2.idx);
            else
                return Integer.compare(this.soldier, R2.soldier);
        }
    }

    public static void main(String[] args) {
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}
        };

        PriorityQueue<Row> pq = new PriorityQueue<>();
        int i = 0;
        for(int[] row:army){
            int soldier = 0;
            for(int bit:row){
                soldier += bit == 1? 1 : 0;
            }
            pq.add(new Row(soldier, i++));
        }

        int k = 2;

        for(int j = 0;j < k;j++){
            System.out.println("R"+pq.remove().idx);
        }

    }
}
