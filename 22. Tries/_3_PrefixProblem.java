
import java.util.Arrays;

class Trie{
    private Node root = new Node();

    public  class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int freq = 1;
    }

    public Node root(){
        return this.root;
    }

    public void insert(String word){
        Node node = root;
        for(int i = 0;i < word.length();i++){
            int idx = word.charAt(i)-'a';
            if(node.children[idx] == null){
                node.children[idx] = new Node();
            }else{
                node.children[idx].freq++;
            }
            node = node.children[idx];
        }
        node.eow = true;
    }
}

public class _3_PrefixProblem {
    //Approach 1: O(n*L*26)
    public static String[] uniquePrefix(String[] words){
        Trie trie = new Trie();
        for(String word:words) trie.insert(word);

        String[] ans = new String[words.length];
        int idx = 0;
        for(String word:words){
            int i;
            Trie.Node node = trie.root();
            for(i = 0;i < word.length();i++){
                char ch = word.charAt(i);
                boolean isUnique = true;
                for(int j = 0;j < 26;j++){
                    if(j == ch-'a') continue;
                    if(node.children[j] != null){
                        isUnique = false;
                        break;
                    }
                }
                if(isUnique) break;
                node = node.children[ch-'a'];
            }
            ans[idx++] = word.substring(0,i);

        }
        return ans;
    }

    //Approach 2: using freq:
    public static String[] uniquePrefix2(String[] words){
        Trie trie = new Trie();
        for(String word:words) trie.insert(word);
        trie.root().freq = -1;

        String[] ans = new String[words.length];

        int idx = 0;
        for(String word:words){
            Trie.Node node = trie.root();
            for(int i = 0;i < word.length();i++){
                node = node.children[word.charAt(i)-'a'];

                if(node.freq == 1){
                    ans[idx++] = word.substring(0,i+1);
                    break;
                }
            }
        }

        return ans;
    }
    

    public static void main(String[] args) {
        String arr[] = {"zebra","dog","duck","dove"};
        String ans[] = uniquePrefix2(arr);
        Arrays.stream(arr).map(s -> s+" ").forEach(System.out::print);System.out.println();
        Arrays.stream(ans).map(s -> s+" ").forEach(System.out::print);System.out.println();
        
    }
}
