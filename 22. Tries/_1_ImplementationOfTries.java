class Trie{
    public Node root = new Node();

    private class Node{
        Node children[] = new Node[26];
        boolean eow = false;
    }

    public void insert(String word){
        Node curr = root;
        for(int level = 0;level < word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word){
        Node curr = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        
        return curr.eow;
    }

    public void printAllStrings(Node node,String str){
        if(node == null)return;

        if(node.eow)System.out.println(str);

        for(int i = 0;i < 26;i++){
            if(node.children[i] != null){
                char ch = (char)(i+'a');
                printAllStrings(node.children[i], str+ch);
            }
        }
    }
    
}

public class _1_ImplementationOfTries {
    public static void main(String[] a){
        Trie t = new Trie();
        t.insert("anuj");
        t.insert("aniraj");
        t.insert("aashi");
        t.insert("aashish");
        t.insert("anuska");

        t.printAllStrings(t.root, "");
    }
}
