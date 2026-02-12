import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _1_AdjacencyList{
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int curr = queue.remove();
            System.out.println(curr);
               
            for(Edge e:graph[curr]){
                if(!visited[e.dest]){
                    queue.add(e.dest);
                    visited[e.dest] = true;
                }
            }
            
        }
    }

    public static void DFS(ArrayList<Edge>[] graph,int node,boolean[] visited){
        System.out.println(node);
        visited[node] = true;

        for(Edge e:graph[node]){
            if(!visited[e.dest]){
                DFS(graph,e.dest,visited);
            }
        }
    }

    public static void main(String args[]){
        /*
                       (5)
                   0--------1   
                           / \
                      (1) /   \ (3)
                         /     \
                        2-------3
                        |  (1)
                     (2)|
                        |
                        4
                        
        */
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0;i < V;i++){
            graph[i] = new ArrayList<>();
        }

        // 0 -Vertex 
        graph[0].add(new Edge(0, 1, 5));

        // 1 -Vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1,3 ,3 ));

        //2 -Vertex
        graph[2].add(new Edge(2,1 ,1 ));
        graph[2].add(new Edge(2,3 , 1));
        graph[2].add(new Edge(2, 4,2 ));

        //3 -Vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3,2 ,1 ));

        //4 -Vertex
        graph[4].add(new Edge(4, 2,2 ));


        // All adjacent nodes of vertex 2:
        for(Edge e:graph[2]){
            System.out.println("2 -> "+e.dest+"(wt = "+e.wt+")");
        }

        DFS(graph,0,new boolean[graph.length]);
    }
}