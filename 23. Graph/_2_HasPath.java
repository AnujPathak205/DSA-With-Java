
import java.util.ArrayList;

public class _2_HasPath {
    public static void DFS(ArrayList<Integer>[] graph,int curr,boolean []visited){
        visited[curr] = true;
        System.out.println(curr);

        for(int e:graph[curr]){
            if(!visited[e]){
                DFS(graph,e,visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Integer>[] graph,int src,int dest,boolean []visited){
        if(src == dest) return true;

        visited[src] = true;

        for(int e:graph[src]){
            if(!visited[e] && hasPath(graph, e, dest,visited)) return true;
        }

        return false;
    }  

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[7];

        for(int i = 0;i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
                0
              /  \
             /   \
            1    2
            |    |
            |    |
            3----4
            \   /
             \ /
              5
              |
              |
              6
        
        */

        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(4);

        graph[3].add(1);
        graph[3].add(4);
        graph[3].add(5);

        graph[4].add(2);
        graph[4].add(3);
        graph[4].add(5);

        graph[5].add(3);
        graph[5].add(4);
        graph[5].add(6);

        graph[6].add(5);

        // DFS(graph, 0, new boolean[graph.length]);
        System.out.println(hasPath(graph, 0, 3, new boolean[graph.length]));


        



    }
}
