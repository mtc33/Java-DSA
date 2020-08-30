/**
 * An implementation of a Trie that supports operations on Strings of ASCII characters.
 * This trie supports insert, search, and hasPrefix operations.
 *
 * The insert operation inserts a word into the Trie.
 * The search operation returns true if the given word exists in the Trie.
 * The hasPrefix operation checks if there is any word that has the given prefix.
 *
 * @author Mark Chen, chenmark33@gmail.com
 */

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
