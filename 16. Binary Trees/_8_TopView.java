
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



public class _8_TopView {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info{
        Node node;
        int hd;

        Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void TopView(Node root) {
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = 0,max = 0;
        queue.add(new Info(root, 0));
        // queue.add(null);

        while(!queue.isEmpty()){
            Info currInfo = queue.remove();

            if(currInfo.node.left != null){
                int hd = currInfo.hd-1;
                queue.add(new Info(currInfo.node.left, hd));
            }

            if(currInfo.node.right != null){
                int hd = currInfo.hd + 1;
                queue.add(new Info(currInfo.node.right, hd));
            }

            if(!map.containsKey(currInfo.hd)){
                min = Math.min(min,currInfo.hd);
                max = Math.max(max,currInfo.hd);
                map.put(currInfo.hd, currInfo.node.data);
            }
        }

        for(int i = min;i <= max;i++){
            if(map.containsKey(i)){
                System.out.print(map.get(i)+" ");
            }
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right.right = new Node(7);

        TopView(root);
    }
}
