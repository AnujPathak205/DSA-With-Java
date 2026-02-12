import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _3_ConnectedComponents {
    public static void BFS(ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0;i < graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph,i,visited);
                System.out.println("-----------");
            }
        }
    }

    public static void bfsUtil(ArrayList<Integer>[] graph,int curr,boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(curr);
        visited[curr] = true;

        while(!queue.isEmpty()){
            int edge = queue.remove();
            System.out.println(edge);

            for(int e:graph[edge]){
                if(!visited[e]){
                    queue.add(e);
                    visited[e] = true;
                }
            }
        }
    }

    public static void DFS(ArrayList<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];

        for(int i = 0;i < graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph,i,visited);
                System.out.println("------------");
            }
        }
    }
    
    public static void dfsUtil(ArrayList<Integer>[] graph,int curr,boolean[] visited){
        System.out.println(curr);
        visited[curr] = true;

        for(int e:graph[curr]){
            if(!visited[e]) bfsUtil(graph, e, visited);
            
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[13];

        for(int i = 0;i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
                0
              /  \
             /   \
            1    2          7
            |    |         / \
            |    |        /   \
            3----4       8----9     10------11-------12
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

        graph[7].add(8);
        graph[7].add(9);

        graph[8].add(7);
        graph[8].add(9);

        graph[9].add(7);
        graph[9].add(8);

        graph[10].add(11);

        graph[11].add(10);
        graph[11].add(12);

        graph[12].add(11);

        DFS(graph);


    }
}
