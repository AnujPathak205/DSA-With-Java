
import java.util.ArrayList;

public class _8_AllPaths {
    public static void printAllPaths(ArrayList<Integer>[] graph,int src,int dest,String path){
        if(src == dest){
            System.out.println( path+src);
            return;
        }

        for(int e:graph[src])
            printAllPaths(graph, e, dest, path+src+" ");
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[6];

        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(3);
        graph[2].add(3);
        graph[3].add(1);
        graph[4].add(0);
        graph[4].add(1);
        graph[5].add(0);
        graph[5].add(2);

        
        /*

            5 ---→ 0 ←--- 4
            |      |      |
            |      |      |
            ↓      ↓      ↓
            2 ---→ 3 ---→ 1

            src = 5
            dest = 1

            paths => 5 → 2 → 3 → 1
                  => 5 → 0 → 3 → 1
        
        */

        int src = 5;
        int dest = 1;
        printAllPaths(graph,src,dest,"");
        
    }
    
}

