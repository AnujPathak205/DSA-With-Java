import java.util.LinkedList;
import java.util.Queue;


public class _10_SizeOfLargestBST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void printBFS(Node root){
        if(root == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                Node currNode = q.remove();
                System.out.print(currNode.data + " ");
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right!= null) q.add(currNode.right);
            }
            System.out.println();
        }
    }

    public static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info sizeOfLargestBST(Node root){
        if(root == null){
             return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = sizeOfLargestBST(root.left);
        Info rightInfo = sizeOfLargestBST(root.right);

        boolean isBST = leftInfo.isBST &&
                        rightInfo.isBST &&
                        root.data > leftInfo.max &&
                        root.data < rightInfo.min;

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));

        if(isBST){
            maxBST = Math.max(maxBST,size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static int getSizeOfLargestBST(Node root){
        maxBST = 0;
        sizeOfLargestBST(root);
        return maxBST;
    }

    public static int size(Node root){
        return sizeOfLargestBST(root).size;
    }



    
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right= new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /*
                              50
                           /     \
                         30      60 <----Valid BST (max size - 5)
                        /  \    /  \    
                       5   20  45  70   
                                  /  \
                                 65  80


      */

        
        // Info info = sizeOfLargestBST(root);
        // System.out.println(info.isBST);
        // System.out.println(info.size);
        // System.out.println(info.min);
        // System.out.println(info.max);

        System.out.println("-->"+getSizeOfLargestBST(root));
    }
}
