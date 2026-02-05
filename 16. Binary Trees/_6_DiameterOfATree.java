import java.util.LinkedList;
import java.util.Queue;

public class _6_DiameterOfATree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void printTreeBFS(Node root){
        if(root == null)return;

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

    public static int heightOfTree(Node root){
        if(root == null)return 0;

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        return Math.max(lh,rh)+1;
    }

    //Brute force approach:O(n^2)
    public static int diameterOfATree(Node root){
        if(root == null)return 0;

        int leftDia = diameterOfATree(root.left);
        int rightDia = diameterOfATree(root.right);

        int selfDia = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(selfDia,Math.max(leftDia,rightDia));
    }

    private static class Info{
        int diameter;
        int height;

        Info(int diameter,int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameterOfATree2(Node root){
        if(root == null)return new Info(0,0);

        Info LeftInfo = diameterOfATree2(root.left);
        Info rightInfo = diameterOfATree2(root.right);

        int leftDia = LeftInfo.diameter;
        int rightDia = rightInfo.diameter;
        int selfDia = LeftInfo.height + rightInfo.height + 1;

        int height = Math.max(LeftInfo.height,rightInfo.height)+1;
        
        int maxDia = Math.max(selfDia,Math.max(leftDia,rightDia));

        return new Info(maxDia,height);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(9);
        root.left.left.left.left = new Node(10);
        root.left.right = new Node(5); 
        root.left.right.right = new Node(6); 
        root.left.right.right.right = new Node(7); 
        root.right = new Node(3);
        
        printTreeBFS(root);
        System.out.println("Diameter of Tree: "+diameterOfATree2(root).diameter);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right = new Node(3);
        root2.right.right = new Node(6);

        System.out.println("---/---/---/---/---");

        printTreeBFS(root2);
        System.out.println("Diameter of Tree: "+diameterOfATree2(root2).diameter);
    }
}
