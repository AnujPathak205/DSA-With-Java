public class _12_KthAncestor {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static Node resultNode;

    private  static int KthAncestorP(Node root,Node n,int k){
        if(root == null) return -1;
        
        if(root == n) return 0;

        int leftDist = KthAncestorP(root.left, n, k);
        int rightDist= KthAncestorP(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist);

        if(max+1 == k) {
            // System.out.println(root.data);
            resultNode = root;
            
        }

        return max + 1;
    }

    public static Node KthAncestor(Node root,Node n,int k) {
        resultNode = null;
        KthAncestorP(root, n, k);
        return resultNode;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(8);
        root.right.right = new Node(5);

        /*
                    1
                  /  \
                 2   3
                /   / \
               6   4   5
                  /
                 8
        */

        Node n = root.right.left.left;//8
        System.out.println(KthAncestor(root,n ,1).data);
    }
}
