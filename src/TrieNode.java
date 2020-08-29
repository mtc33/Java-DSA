import java.util.*;

public class TrieNode {
    char letter;
    int endsHere;
    String word;
    Map<Character, TrieNode> children;

    public TrieNode(char letter) {
        this.letter = letter;
        this.children = new HashMap<>();
    }
}
