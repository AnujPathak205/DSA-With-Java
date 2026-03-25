import java.util.ArrayList;

public class _4_CycleDetection {
    public static boolean detectCycle(ArrayList<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i = 0;i < graph.length;i++){
            if(!visited[i] && detectCycleUtil(graph,visited,i,-1)){
               return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Integer>[] graph,boolean[] visited,int curr,int par){
        visited[curr] = true;

        for(int e:graph[curr]){
            if(!visited[e]){
                if(detectCycleUtil(graph, visited, e, curr)) return true;
            }

            else if(visited[e] && e != par){
                return true;
            }
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
            3    4
            \   
             \ 
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
        // graph[3].add(4);
        graph[3].add(5);

        graph[4].add(2);
        // graph[4].add(3);
        // graph[4].add(5);

        graph[5].add(3);
        // graph[5].add(4);
        graph[5].add(6);

        graph[6].add(5);

        System.out.println(detectCycle(graph));
        System.out.println("---------------");

    }
}
