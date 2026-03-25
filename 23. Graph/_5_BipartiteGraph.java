import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _5_BipartiteGraph {
    public static boolean isBipartite(ArrayList<Integer>[] graph){
        int[] color = new int[graph.length];
        
        for(int i = 0;i < color.length;i++)                   // 0  -> YELLOW
            color[i] = -1;//no color                          // 1  -> BLUE
                                                              //-1 -> NO 
        for(int v = 0;v < graph.length;v++)
            if(color[v] == -1 && !isBipartiteUtil(graph,color,v))
                return false;

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Integer>[] graph,int[] color,int v){
        color[v] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int curr = queue.remove();

            for(int e:graph[curr])
                if(color[e] == -1){
                    color[e] = color[curr] == 0 ? 1 : 0;
                    queue.add(e);
                }else if(color[e] == color[curr]){
                    return false;//NOT BIPARTITE
                }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[4];

        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        /*
               0---------1
               |         |
               |         |
               2---------3
        
        */

        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);
        graph[1].add(3);

        graph[2].add(0);
        graph[2].add(3);

        graph[3].add(1);
        graph[3].add(2);

        System.out.println(isBipartite(graph));

        ArrayList<Integer>[] graph2 = new ArrayList[5];

        for(int i = 0;i < graph2.length;i++){
            graph2[i] = new ArrayList<>();
        }

         /*
               0---------------1
               |               |
               |               |
               2-------3-------4
        
        */

        graph2[0].add(1);
        graph2[0].add(2);

        graph2[1].add(0);
        graph2[1].add(4);

        graph2[2].add(0);
        graph2[2].add(3);

        graph2[3].add(2);
        graph2[3].add(4);

        graph2[4].add(1);
        graph2[4].add(3);

        System.out.println(isBipartite(graph2));
        

    }
}
