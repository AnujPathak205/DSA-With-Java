
import java.util.LinkedList;
import java.util.Queue;

public class _4_printInRange {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        
        return root;
    }

    public static void printBST(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();

                System.out.print(currNode.data + " ");

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right!= null) queue.add(currNode.right);
            }

            System.out.println();
        }
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root == null) return;

        printInRange(root.left, k1, k2);

        if(root.data >= k1 && root.data <= k2){
            System.out.print(root.data + " ");
        }

        printInRange(root.right, k1, k2);
    }

    public static void printInRange2(Node root,int k1,int k2){
        if(root == null) return;

        if(root.data >= k1 && root.data <= k2){
            printInRange2(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange2(root.right, k1, k2);
        }else if(root.data < k1){
            printInRange2(root.right, k1, k2);
        }else{
            printInRange2(root.left, k1, k2);
        }
    }



    public static void main(String[] args) {
        int[] nodes = {4,2,1,3,6,5,7,8};
        Node root = null;

        for(int i = 0;i < nodes.length;i++){
            root = insert(root, nodes[i]);
        }

        /*

                     4
                   /  \
                  2    6
                 /\   / \
                1  3 5  7
                        \
                         8

        */

        printBST(root);
        System.out.println("--------------------");
        printInRange2(root, 3, 6);
    }
}
