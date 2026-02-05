
class binaryTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static int idx = -1;
    
    private static Node buildTreeP(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);

        newNode.left = buildTreeP(nodes);
        newNode.right = buildTreeP(nodes);

        return newNode;
        
    }

    public static Node buildTree(int nodes[]){
        idx = -1;
        return buildTreeP(nodes);
    }
    
}

public class _1_TreeCreation {
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        binaryTree.Node root = binaryTree.buildTree(nodes);
        System.out.println(root.left.right.data);
       

    }
}
