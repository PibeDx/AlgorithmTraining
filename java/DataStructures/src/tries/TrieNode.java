package tries;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlos Piñan
 */
public class TrieNode {

    private int size = 0;
    private char character;
    private boolean isLeaf;
    private Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {

    }

    public TrieNode(char character) {
        this.character = character;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public char getCharacter() {
        return character;
    }

    public int getSize() {
        return size;
    }

    public void increaseSize() {
        size++;
    }
}
