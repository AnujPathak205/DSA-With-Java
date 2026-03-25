
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class _7_TopologicalSorting{
    public static void printTopologicalSort(ArrayList<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < graph.length;i++){
            if(!visited[i])
                printTopologicalSortUtil(graph, i, visited, stack);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

        System.out.println();
    }

    public static void printTopologicalSortUtil(ArrayList<Integer>[] graph,int curr,boolean[] visited,Stack<Integer> stack){
        visited[curr] = true;

        for(int e:graph[curr]){
            if(!visited[e])
                printTopologicalSortUtil(graph, e, visited, stack);
        }

        stack.push(curr);
    }

    public static void printTopologicalSort2(ArrayList<Integer>[] graph){//Kahn's algorithm
        int[] inDeg = new int[graph.length];
        for(int v = 0;v < graph.length;v++)
            for(int e:graph[v])
                inDeg[e]++;

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0;i < graph.length;i++)
            if(inDeg[i] == 0)
                queue.add(i);

        while(!queue.isEmpty()){
            int v = queue.remove();
            System.out.print(v+" ");

            for(int e:graph[v]){
                inDeg[e]--;
                if(inDeg[e] == 0) queue.add(e);
            }
        }

        System.out.println();
    }
    

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[6];

        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(3);
        graph[3].add(1);
        graph[4].add(0);
        graph[4].add(1);
        graph[5].add(0);
        graph[5].add(2);

        /*
        
                5 ---→ 0 ←--- 4
                |             |
                ↓             ↓
                2 ---→ 3 ---→ 1

        */
       

        printTopologicalSort2(graph);

    }
}