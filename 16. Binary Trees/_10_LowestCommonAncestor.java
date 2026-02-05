
import java.util.ArrayList;

public class _10_LowestCommonAncestor {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static boolean getPath(Node root,Node node,ArrayList<Node> path) {
        if(root == null)return false;

        path.add(root);

        if(root == node) return true;

        if(getPath(root.left, node, path) ||
           getPath(root.right, node, path)) return true; 
        
        path.remove(path.size()-1);
        return false;
    }

    //Approach 1:
    public static Node LowestCommonAncestor(Node root,Node n1,Node n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if(!(getPath(root, n1, path1) && getPath(root, n2, path2))){
            return null;
        }

        Node LCA = root;

        for(int i = 0;i < path1.size();i++){
            if(path1.get(i) == path2.get(i)){
                LCA = path1.get(i);
            }else{
                break;
            }
        }

        return LCA;
    }

    //Approach 2:
    public static Node LCA(Node root, Node n1, Node n2) {
        if (root == null || root == n1 || root == n2) return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2  3
                  \  /\
                   4 5 6
                       \
                        7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right.right = new Node(7);

        ArrayList<Node> path = new ArrayList<>();
        System.out.println(getPath(root, root.right.left, path));

        for(int i = 0;i < path.size();i++){
            System.out.println(path.get(i).data);
        }

        Node n1 = root.right.left;//5
        Node n2 = root.right.right.right;//7
        System.out.println("Lowest Common Ancestor: "+LowestCommonAncestor(root, n1, n2).data);
        System.out.println(LCA(root, n1, n2).data);
    }
}
