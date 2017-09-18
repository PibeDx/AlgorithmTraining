package stacks;

import java.util.Iterator;

/**
 * @author Carlos Piñan
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        this.first = null;
        this.size = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }

    public static void main(String[] args) {

    }

}
