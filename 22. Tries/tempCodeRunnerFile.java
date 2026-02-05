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