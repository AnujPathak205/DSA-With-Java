
import java.util.LinkedList;
import java.util.Queue;

public class _8_SortedArrToBalacedBST {
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

    public static Node sortedArrToBalacedBST(int[] sortedArr,int i,int j){
        if(i > j) return null;
        
        int mid = (i+j)/2;
        Node root = new Node(sortedArr[mid]);
        
        root.left = sortedArrToBalacedBST(sortedArr, i, mid-1);
        root.right= sortedArrToBalacedBST(sortedArr, mid+1, j);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,8,10,11,12};
        Node root = sortedArrToBalacedBST(arr, 0, arr.length-1);
        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.right.data);
        printBFS(root);
    }
}
