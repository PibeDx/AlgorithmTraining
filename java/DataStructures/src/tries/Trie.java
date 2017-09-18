package tries;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Carlos Piñan
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode trieNode;
            if (children.containsKey(character)) {
                trieNode = children.get(character);
            } else {
                trieNode = new TrieNode(character);
                children.put(character, trieNode);
            }
            trieNode.increaseSize();
            children = trieNode.getChildren();
            if (i == word.length() - 1) {
                trieNode.setLeaf(true);
            }
        }
    }

    public boolean find(String word) {
        TrieNode trieNode = findNode(word);
        return trieNode != null && trieNode.isLeaf();
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    public int startsWithResults(String prefix) {
        TrieNode trieNode = findNode(prefix);
        return trieNode != null ? findNode(prefix).getSize() : 0;
    }

    public TrieNode findNode(String str) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode trieNode = null;
        for (char character : str.toCharArray()) {
            if (children.containsKey(character)) {
                trieNode = children.get(character);
                children = trieNode.getChildren();
            } else {
                return null;
            }
        }
        return trieNode;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scanner.next();
            String contact = scanner.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.startsWithResults(contact));
            }
        }
        scanner.close();
    }

}
