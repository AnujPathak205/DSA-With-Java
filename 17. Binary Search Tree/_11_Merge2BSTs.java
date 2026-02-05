import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11_Merge2BSTs {
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
        if(root == null)return;
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


    public static Node sortedList2BalancedBST(ArrayList<Integer> list,int i,int j){
        if(i > j) return null;

        int mid = (i+j)/2;
        Node root = new Node(list.get(mid));

        root.left = sortedList2BalancedBST(list, i, mid-1);
        root.right= sortedList2BalancedBST(list, mid+1, j);

        return root;
    }


    public static Node merge2BSTs(Node root1,Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        int size = list1.size() + list2.size();

        list1.add(Integer.MAX_VALUE);
        list2.add(Integer.MAX_VALUE);

        int x = 0;
        int y = 0;

        ArrayList<Integer> mergedList = new ArrayList<>();
        for(int i = 0;i < size;i++){
            if(list1.get(x) < list2.get(y)){
                mergedList.add(list1.get(x));
                x++;
            }else{
                mergedList.add(list2.get(y));
                y++;
            }
        }

        list1.remove(list1.size() - 1);
        list2.remove(list2.size() - 1);

        return sortedList2BalancedBST(mergedList, 0, mergedList.size()-1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right= new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right= new Node(12);

        Node mergedRoot = merge2BSTs(root1, root2);
        printBFS(mergedRoot);
    
    }
}
