
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

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right= insert(root.right, val);
        }

        return root;
    }

    public static Node buildBST(int[] nodes){
        Node root = null;
        for(int i = 0;i < nodes.length;i++){
            root = insert(root, nodes[i]);
        }
        return root;
    }

    public static void printBFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();

                System.out.print(currNode.data + " ");

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }

            System.out.println();
        }
    }

    //Recursive:
    public static boolean search(Node root,int key){
        if(root == null) return false;

        if(root.data == key) return true;

        if(root.data > key) return search(root.left, key);
        else return search(root.right, key);
    }

    //Iterative:
    public static boolean search2(Node root,int key){
        Node tempNode = root;
        
        while(tempNode != null){
            if(tempNode.data == key)return true;

            // if(tempNode.data > key){
            //     tempNode = tempNode.left;
            // }else{
            //     tempNode = tempNode.right;
            // }
            tempNode = (tempNode.data > key)? tempNode.left: tempNode.right;
        }

        return false;
    }
}

public class _2_SearchInBST {
    public static void main(String[] args) {
        clearScreen();
        int[] nodes = {4,2,1,3,6,5};
        BST.Node root = BST.buildBST(nodes);
        /*

                     4
                   /  \
                  2    6
                 /\   /
                1  3 5

        */
       BST.printBFS(root);
       System.out.println(BST.search2(root, 6));
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
