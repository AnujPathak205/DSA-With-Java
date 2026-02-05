
import java.util.LinkedList;
import java.util.Queue;

public class _4_CountOfNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void BFS(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node currNode = queue.remove();

            if(currNode == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");

                if(currNode.left != null)queue.add(currNode.left);
                if(currNode.right != null)queue.add(currNode.right);
            }
        }
    }
    //Recursive approach
    public static int countOfNodes(Node root){
        if(root == null)return 0;

        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);

        return 1+leftCount+rightCount;
    }

    //Iterative approach:(By BFS)
    public static int countOfNodes2(Node root){
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while(!queue.isEmpty()){
            count++;
            Node currNode = queue.remove();

            if(currNode != null){

                if(currNode.left != null)queue.add(currNode.left);
                if(currNode.right != null)queue.add(currNode.right);
            }
        }

        return count;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.left.left = new Node(8);

        BFS(root);
        System.out.println("Total Nodes:"+countOfNodes2(root));
    }
}
