
import java.util.ArrayList;

public class _6_CycleDetectionInDirectedGraph {
    public static boolean isCycle(ArrayList<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i = 0;i < graph.length;i++){
            if(!visited[i] && isCycleUtil(graph,i,visited,stack)) return true;
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Integer>[] graph,int curr,boolean[] visited,boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;

        for(int e:graph[curr]){
            if(stack[e]) return true;//cycle
            if(!visited[e] && isCycleUtil(graph, e, visited, stack)) return true;
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[4];

        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(3);
        graph[3].add(0);

        /*
                0 ---> 1 ---> 2 ---> 3
                ^                    |
                |____________________|
                
        */

        System.out.println(isCycle(graph));



        ArrayList<Integer>[] graph2 = new ArrayList[4];

        for(int i = 0;i < graph2.length;i++){
            graph2[i] = new ArrayList<>();
        }

        
        graph2[0].add(1);
        graph2[2].add(1);
        graph2[2].add(3);
        graph2[3].add(0);

        /*
                0 ---> 1 <---- 2 ---> 3
                ^                     |
                |____________________|
                
        */

        System.out.println(isCycle(graph2));
    }
}
