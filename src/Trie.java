public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ptr.children.containsKey(c)) {
                ptr.children.put(c, new TrieNode(c));
            }
            ptr = ptr.children.get(c);
        }
        ptr.endsHere++;
        ptr.word = word;
    }

    public boolean search(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ptr.children.containsKey(c)) {
                ptr.children.put(c, new TrieNode(c));
            }
            ptr = ptr.children.get(c);
        }
        return ptr.endsHere > 0;
    }

    public boolean hasPrefix(String prefix) {
        TrieNode ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!ptr.children.containsKey(c)) {
                return false;
            }
            ptr = ptr.children.get(c);
        }
        return true;
    }
}
