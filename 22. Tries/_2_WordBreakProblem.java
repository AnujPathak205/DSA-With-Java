class Trie{
    private final Node root = new Node();

    private class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    public void insert(String word){
        Node curr = root;
        for(int i = 0;i < word.length();i++){
            int idx = word.charAt(i)-'a';
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
            if(curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return curr.eow;
    }
}

public class _2_WordBreakProblem {
    public static boolean wordBreak(String key,Trie trie){
        if(key.isEmpty()) return true;

        for(int i = 1;i <= key.length();i++){
            if(trie.search(key.substring(0,i)) && wordBreak(key.substring(i), trie))
                return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i","like","samsung","mobile","ice"};

        Trie t = new Trie();

        for(String word:words){
            t.insert(word);
        }

        System.out.println(wordBreak("ilikesamsung", t));

    }
}
