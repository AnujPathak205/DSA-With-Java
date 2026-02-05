public class _11_MinDistanceBetweenTwoNodes {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node LCA(Node root,Node n1,Node n2){
        if(root == null || root == n1 || root == n2) return root;

        Node left = LCA(root.left, n1, n2);
        Node right= LCA(root.right, n1, n2);

        if(left != null && right != null) return root;

        return (left != null)? left : right;
    }

    public static int distance(Node root, Node n) {
        if(root == null) return -1;

        if(root == n) return 0;

        int left = distance(root.left, n);
        int right= distance(root.right, n);

        if(left == -1 && right == -1) return -1;
        else if(left == -1) return right + 1;
        else return left + 1;
    }

    public static int minDist(Node root,Node n1,Node n2){
        Node lca = LCA(root, n1, n2);

        int dist1 = distance(lca,n1);
        int dist2 = distance(lca,n2);

        return dist1 + dist2;
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

        Node n1 = root.right.left.left;//8
        Node n2 = root.right.right;//5

        System.out.println(minDist(root, n1, n2));//3

        Node n3 = root.left;//2
        Node n4 = root.right.left;//4

        System.out.println(minDist(root, n3, n4));//3
    }
}
