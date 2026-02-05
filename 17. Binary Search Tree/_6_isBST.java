
import java.util.ArrayList;

public class _6_isBST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void inorder(Node root,ArrayList<Integer> values){
        if(root == null) return;

        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }

    public static boolean isBST(Node root) {
        ArrayList<Integer> inorderSeq = new ArrayList<>();
        inorder(root, inorderSeq);

        for(int i = 0;i < inorderSeq.size()-1;i++){
            if(inorderSeq.get(i) >= inorderSeq.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isBST2(Node root,int max,int min){
        if(root == null) return true;

        if(root.data >= max || root.data <= min) return false;

        return isBST2(root.left, root.data, min) && 
               isBST2(root.right, max, root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right =  new Node(7);

        /*
                    5
                  /  \
                 3    6
                / \    \
               1  4     7
        */

        ArrayList<Integer> values = new ArrayList<>();
        inorder(root, values);
        System.out.println(values);

        System.out.println(isBST(root));
        System.out.println(isBST2(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

}
