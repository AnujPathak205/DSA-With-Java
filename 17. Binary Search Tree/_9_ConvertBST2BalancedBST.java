
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _9_ConvertBST2BalancedBST {
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
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                Node currNode = q.remove();
                System.out.print(currNode.data + " ");
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right!= null) q.add(currNode.right);
            }
            System.out.println();
        }
    }

    public static void inorder(Node root,ArrayList<Integer> inorderSeq){
        if(root == null) return;

        inorder(root.left,inorderSeq);
        inorderSeq.add(root.data);
        inorder(root.right,inorderSeq);
    }

    public static Node sortedArrToBalacedBST(ArrayList<Integer> sortedArr,int i,int j){
        if(i > j) return null;
        
        int mid = (i+j)/2;
        Node root = new Node(sortedArr.get(mid));
        
        root.left = sortedArrToBalacedBST(sortedArr, i, mid-1);
        root.right= sortedArrToBalacedBST(sortedArr, mid+1, j);

        return root;
    }



    public static Node ConvertBST2BalancedBST(Node root){
        ArrayList<Integer> inorderSeq = new ArrayList<>();
        
        inorder(root,inorderSeq);

        return sortedArrToBalacedBST(inorderSeq, 0, inorderSeq.size()-1);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        System.out.println("---------------------------------");
        printBFS(root);

        System.out.println("---------------------------------");
        root = ConvertBST2BalancedBST(root);
        printBFS(root);



    }   
}
