
public class _7_MirrorA_BST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node mirror(Node root){
        if(root == null) return null;

        Node temp = mirror(root.left);
        root.left = mirror(root.right);
        root.right= temp;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right = new Node(6);
        root.right.right =  new Node(7);

        /*
                    5                           5
                  /  \                        /  \
                 3    6     ->  MIRROR ->    6    3
                / \    \                    /    / \
               1  4     7                  7    4   1
        */


        root = mirror(root);

        System.out.println(root.right.left.data);
    }
}
