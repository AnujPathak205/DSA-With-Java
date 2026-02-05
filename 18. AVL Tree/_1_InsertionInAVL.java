import java.util.LinkedList;
import java.util.Queue;

class AVLTree{
    static class Node{
        int data,height;
        Node left,right;

        Node(int data){
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null) return 0;
        return root.height;
    }

    public static int getBalance(Node root){
        if(root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root,int key){
        if (root == null) 
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right= insert(root.right, key);
        else 
            return root;

        root.height = 1 + Math.max(height(root.left) , height(root.right));

        int bf = getBalance(root);

        //LL Case
        if (bf > 1 && key < root.left.data)
            return rightRotate(root);


        //RR Case
        if (bf < -1 && key > root.right.data)
            return leftRotate(root);

        //RL Case
        if (bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //LR Case
        if (bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        return root;

    }

    public static Node delete(Node root,int key){
        if(root == null){
            return root;
        }

        if(root.data > key){
            root.left = delete(root.left, key);
        }else if(root.data < key){
            root.right= delete(root.right, key);
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

        root.height = 1 + Math.max(height(root.left) , height(root.right));

        int bf = getBalance(root);

        //LL Case
        if (bf > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);


        //RR Case
        if (bf < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        //RL Case
        if (bf < -1 && getBalance(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //LR Case
        if (bf > 1 && getBalance(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        return root;
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left),height(y.right));
        x.height = 1 + Math.max(height(x.left),height(x.right));

        return x;
    }

    public static Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = 1 + Math.max(height(y.left),height(y.right));
        x.height = 1 + Math.max(height(x.left),height(x.right));

        return x;
    }

    public static void printBFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();
                System.out.print(currNode.data+" ");
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right!= null) queue.add(currNode.right);
            }
            System.out.println();
        }
    }
}

public class _1_InsertionInAVL{
    public static void main(String[] args) {
        int[] nodes = {40,20,10,25,30,22,50};

        AVLTree.Node root = null;

        for(int i = 0;i < nodes.length;i++){
            root = AVLTree.insert(root, nodes[i]);
        }

        AVLTree.printBFS(root);
        root = AVLTree.delete(root, 40);
        System.out.println("------------------------------");
        AVLTree.printBFS(root);
    }
}