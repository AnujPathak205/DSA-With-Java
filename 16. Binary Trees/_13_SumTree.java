
import java.util.LinkedList;
import java.util.Queue;

public class _13_SumTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int TransformToSumTree(Node root){
        if(root == null) return 0;

        int left = TransformToSumTree(root.left);
        int right= TransformToSumTree(root.right);

        int sum = left + right + root.data;

        root.data = left + right;

        return sum;
    }

    public static void printBFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("---Binary Tree--");

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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(8);
        root.right.right = new Node(5);

        /*
                    1
                  /  \
                 2   3
                /   / \
               6   4   5
                  /
                 8
        */

        // printBFS(root);
        // TransformToSumTree(root);

        // printBFS(root);

        int sum = 0;


        for(long i = 0; i < 10000000000l;i++){
            // System.out.print(".");
            System.console();
            // if(i%10000 == 0)System.out.print(".");
            sum += i;
        }

        System.out.println("-------------------------------DONE--------------------------"+sum);
    }
}
