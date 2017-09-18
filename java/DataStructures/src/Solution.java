import java.util.*;

public class Solution {

    static class Trie {

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
    }

    static class TrieNode {

        private int size = 0;
        private char character;
        private boolean isLeaf;
        private Map<Character, Solution.TrieNode> children = new HashMap<>();

        public TrieNode() {

        }

        public TrieNode(char character) {
            this.character = character;
        }

        public Map<Character, Solution.TrieNode> getChildren() {
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
    }
}

