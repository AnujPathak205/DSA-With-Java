
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _9_DijkstraAlgo {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int node,int dist) {
            this.node = node;
            this.dist = dist;

        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }


    public static void dijkstra(ArrayList<Edge>[] graph,int src){
        int dist[] = new int[graph.length];
        for(int i = 0;i < graph.length;i++)
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        

        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                for(Edge e:graph[curr.node]){
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        Arrays.stream(dist).forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];

        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        /*
        //→↑↓←

             2          7          1
        0 -------→ 1 -------→ 3 -------→ 5  
        |          |          ↑          ↑
        |          |1         |2         |
        |          ↓          |          |
        ---------→ 2 -------→ 4 ----------
             4          3           5
        
        */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(  1, 2, 1));
        graph[1].add(new Edge(  1, 3, 7));
        graph[2].add(new Edge(  2, 4, 3));
        graph[3].add(new Edge(  3, 5, 1));
        graph[4].add(new Edge(  4, 3, 2));
        graph[4].add(new Edge(  4, 5, 5));





        dijkstra(graph, 0);




    }
}
