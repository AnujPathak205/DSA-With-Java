/*
    139. Word Break
    (Medium)

    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated 
    sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/

import java.util.ArrayList;
import java.util.List;

public class _2_WordBreak {
    private class Trie {
        private Node root;

        private class Node {
            Node[] children;
            boolean endOfWord;

            public Node() {
                this.children = new Node[26];
                this.endOfWord = false;
            }
        }

        Trie() {
            root = new Node();
        }

        Trie(List<String> words) {
            root = new Node();

            for (String word:words) {
                this.add(word);
            } 
        }

        void add(String word) {
            Node curr = root;

            for (int i = 0;i < word.length();i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.endOfWord = true;
        }

        boolean search(String word) {
            Node curr = root;

            for (int i = 0;i < word.length();i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }

            return curr.endOfWord;
        }

        boolean search(String word,int i,int j) {
            Node curr = root;

            for (int x = i;x < j;x++) {
                int idx = word.charAt(x) - 'a';

                if (curr.children[idx] == null) {
                    return false;
                }

                curr = curr.children[idx];
            }

            return curr.endOfWord;
        }
    }

    // Time Limit exceeding
    private boolean wordBreak(String s, int i, Trie trie) {
        if (i == s.length()) return true;

        for (int x = i + 1; x <= s.length(); x++) {
            if (trie.search(s, i, x) && wordBreak(s, x, trie)) {
                return true;
            }
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie(wordDict);

        return wordBreak(s,0, trie);
    }

    // Optimal sol : Store repetative results
    private Boolean[] memo;

    private boolean wordBreak2 (String s,int start,Trie trie) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start];

        for (int end = start + 1;end <= s.length();end++) {
            if (trie.search(s,start,end) && wordBreak2(s, end,trie)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public boolean wordBreak2(String s,List<String> wordDict) {
        Trie trie = new Trie(wordDict);
        memo = new Boolean[s.length()];
        return wordBreak(s,0, trie);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(new _2_WordBreak().wordBreak(s, wordDict));
    }
}
