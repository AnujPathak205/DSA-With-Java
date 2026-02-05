
import java.util.LinkedList;
import java.util.Queue;

public class _3_DeletionInBST {
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

    public static Node delete(Node root,int val){
        if(root == null){
            return root;
        }

        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right= delete(root.right, val);
        }else{
            //Case 1:Leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //Case 2:Single chile
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case 3:Both children
            Node IS = root.right;//Inorder successor
            while(IS.left != null){
                IS = IS.left;
            }
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
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
        System.out.println("-----After Deletion-----");
        root = delete(root, 6);
        printBST(root);
    }
}
