
import java.util.PriorityQueue;

public class _4_NearbyPoints {
    static int count = 0;

    static class Point implements Comparable<Point>{
        int x;
        int y;
        double dist;
        int idx;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.hypot(x,y);
            this.idx = count++;
        }

        @Override
        public int compareTo(Point p2){
            return Double.compare(this.dist, p2.dist);
        }
    }

    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1},{-2,4}};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int p[]:points){
            pq.add(new Point(p[0], p[1]));
        }

        int k = 2;

        for(int i = 0;i < k;i++){
            System.out.println("C"+pq.poll().idx);
        }
    }
}
