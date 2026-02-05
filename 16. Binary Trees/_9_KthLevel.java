
import java.util.LinkedList;
import java.util.Queue;

public class _9_KthLevel {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();

                System.out.print(currNode.data+" ");

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            
            System.out.println();
        }
    }


    //By BFS (Iteratively)
    public static void KthLevel(Node root,int k){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();

                if(level == k) System.out.print(currNode.data+" ");

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right!= null) queue.add(currNode.right);

            }

            if(level == k){
                System.out.println();
                return;
            }

            level++;
        }
    }

    //BY DFS (recursively)
    public static void KthLevel2(Node root,int k,int level){
        if(root == null)return;

        if(level == k) System.out.print(root.data+" ");

        KthLevel2(root.left, k,level+1);
        KthLevel2(root.right, k,level+1);
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2  3
                  \  /\
                   4 5 6
                       \
                        7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right.right = new Node(7);

        // BFS(root);
        KthLevel2(root,3,1);

        System.out.println("DONE");
    }
}
