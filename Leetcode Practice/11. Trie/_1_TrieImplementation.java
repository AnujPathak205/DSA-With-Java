/*
    208. Implement Trie (Prefix Tree)
    (Medium)
*/

class Trie {
    private Node root;

    public Trie () {
        root = new Node();
    }

    private class Node {
        Node children[];
        boolean eow;

        public Node() {
            this.children = new Node[26];
            this.eow = false;
        }
    }

    public void insert(String word) {
        Node curr = root;

        for (int i = 0;i < word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0;i < word.length();i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }
        
        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0;i < prefix.length();i++) {
            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }
        
        return true;
    }
}

public class _1_TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("anuj");
        trie.insert("anu");

        System.out.println(trie.search("anu"));
        System.out.println(trie.startsWith("a"));
    }
}
