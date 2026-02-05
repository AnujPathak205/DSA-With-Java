// import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class BST{
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

    //Iteratively : 
    public static Node buildBST(int[] nodes){
        Node root = new Node(nodes[0]);


        for(int i = 1;i < nodes.length;i++){
            Node node = new Node(nodes[i]);
            Node tempNode = root;

            while(true){
                if(node.data < tempNode.data){
                    if(tempNode.left == null){
                        tempNode.left = node;
                        break;
                    }

                    tempNode = tempNode.left;
                }else{
                    if(tempNode.right == null){
                        tempNode.right = node;
                        break;
                    }
                    tempNode = tempNode.right;

                }
            }
        }

        return root;
    }

    //Recursively : 

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else{
            //Right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static Node buildBST2(int[] nodes){
        Node root = null;
        for(int i = 0;i < nodes.length;i++){
            root = insert(root, nodes[i]);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}


public class _1_BuildBST {
    public static void main(String[] args) {
        int[] nodes = {4,2,1,3,6};

        BST.Node root = BST.buildBST2(nodes);

        BST.printBFS(root);

        BST.inorder(root);
    }
}

