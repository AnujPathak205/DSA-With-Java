import java.util.LinkedList;
import java.util.Queue;

public class _7_isSubtree {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static boolean isEqual(Node root,Node subNode){
        if(root == null && subNode == null)return true;
        if(root == null || subNode == null)return false;

        boolean isCurrEqual = root.data == subNode.data;
        boolean isLeftEqual = isEqual(root.left, subNode.left);
        boolean isRightEqual = isEqual(root.right,subNode.right);

        return isCurrEqual && isLeftEqual && isRightEqual;
    }

    public static boolean isSubtree(Node root,Node subNode){//traversal by BFS and iteratively
       if(subNode == null)return true;
       if(root == null)return false;
       
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);

       while(!queue.isEmpty()){
            Node currNode = queue.remove();

            if(currNode.data == subNode.data){
                if(isEqual(currNode,subNode)){
                    return true;
                }
            }
            
            if(currNode.left != null)queue.add(currNode.left);
            if(currNode.right != null)queue.add(currNode.right);
       }

       return false;
    }

    public static boolean isSubtree2(Node root,Node subNode){//traversal by DFS and recursively
        if(subNode == null)return true;
        if(root == null)return false;

        if(root.data == subNode.data){
            if(isEqual(root, subNode)){
                return true;
            }
        }

        return isSubtree2(root.left, subNode) || isSubtree2(root.right, subNode);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree2(root, subRoot));
    }
}
