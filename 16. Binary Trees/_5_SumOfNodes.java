
public class _5_SumOfNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static int sumOfNodes(Node root){
        if(root == null)return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum= sumOfNodes(root.right);

        return root.data + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.left.left = new Node(8);

        System.out.println(sumOfNodes(root));
    }
}
