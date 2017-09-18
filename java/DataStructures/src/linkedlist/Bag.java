package linkedlist;

import java.util.Iterator;

/**
 * @author Carlos Piñan
 */
public class Bag<Item> implements Iterable<Item> {

    private Node node;

    private class Node {
        Item item;
        Node next;
    }

    public Bag() {
        this.node = null;
    }

    public void add(Item item) {
        Node oldNode = node;
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = oldNode;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {

        private Node current = node;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

    }
}
