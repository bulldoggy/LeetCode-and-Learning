class Trie {
    Node root;
    
    public Trie() {
        root = new Node();    
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) curr.child[c-'a'] = new Node();
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c-'a'] == null) return false;
            curr = curr.child[c-'a'];
        }
        return curr.isEnd; 
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.child[c-'a'] == null) return false;
            curr = curr.child[c-'a'];
        }
        return true;
    }
}

class Node {
    public Node[] child;
    public boolean isEnd;
    
    public Node() {
        child = new Node[26];
        isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */