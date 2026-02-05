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

    public boolean startsWith(String prefix){
        Node node = root;
        for(int i = 0;i < prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }
}


public class _4_startsWithProblem {
    public static void main(String[] args) {
        String[] words = {"apple","app","mango","man","woman"};
        Trie trie = new Trie();
        for(String word:words) trie.insert(word);
        System.out.println(trie.startsWith("mango"));
    }
}
