/*
    14. Longest Common Prefix
    (easy)

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
*/

public class _3_LongestCommonPrefix {
    // Comparision approach
        public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            if(strs[i].isEmpty()) return "";
            for(int j = 0;j < prefix.length() && j < strs[i].length();j++){
                if(prefix.charAt(j) == strs[i].charAt(j)){
                    if(j == strs[i].length()-1) prefix = strs[i].substring(0,j+1);
                }else{
                    prefix = strs[i].substring(0,j);
                    break;
                }
            }
        }
        return prefix;
    }


    // Trie approach
    public String longestCommonPrefix2(String[] strs) {
        Trie trie = new Trie(strs);
        return trie.prefix(strs.length).toString();
    }

    private class Trie {
        private Node root;

        Trie (String[] strs) {
            root = new Node();

            for (String str:strs) {
                this.add(str);
            }
        }

        private class Node {
            Node[] children;
            int freq;

            Node() {
                children = new Node[26];
                freq = 1;
            }
        }

        void add (String word) {
            Node curr = root;

            for (int i = 0;i < word.length();i++) {
                int idx = word.charAt(i) - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                } else {
                    curr.children[idx].freq++;
                }

                curr = curr.children[idx];
            }
        }

        StringBuilder prefix (int freq) {
            Node curr = root;
            StringBuilder ans = new StringBuilder();
            boolean possible = true;

            while (possible) {
                possible = false;

                for (int i = 0;i < 26;i++) {
                    if (curr.children[i] != null && curr.children[i].freq == freq) {
                        ans.append((char) ('a' + i));
                        possible = true;
                        curr = curr.children[i];
                    }
                }
            }

            return ans;
        }
    }
}
