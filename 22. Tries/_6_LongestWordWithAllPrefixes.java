class Trie { 
    private Node root = new Node();

    private class Node{
        Node children[] = new Node[26];
        boolean eow = false;
    }

    public void insert(String word){
        Node curr = root;
        for(int i = 0;i < word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    private static String ans = "";

    private void longestWordWithAllPrefixes(Node root,StringBuilder temp){
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow){
                temp.append((char)(i+'a'));

                if(ans.length() < temp.length()) ans = temp.toString();

                longestWordWithAllPrefixes(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String longestWordWithAllPrefixes(){
        Trie.ans = "";
        longestWordWithAllPrefixes(root, new StringBuilder(""));
        return Trie.ans;
    }
}

public class _6_LongestWordWithAllPrefixes {

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};

        Trie trie = new Trie();

        for(String word:words) trie.insert(word);

        System.out.println("----------------------------");
        System.out.println("Result:"+trie.longestWordWithAllPrefixes());
        System.out.println("----------------------------");


    }
}
