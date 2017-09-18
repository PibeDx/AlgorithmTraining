package stacks;

import java.util.Iterator;

/**
 * @author Carlos Piñan
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {

    private int size;
    private Item[] array;

    public FixedCapacityStack(int capacity) {
        this.size = 0;
        this.array = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size++] = item;
    }

    public Item pop() {
        if (size <= 0) {
            return null;
        }
        Item item = array[--size];
        array[size] = null; // Avoid loitering.
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = size - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            return array[i--];
        }
    }

    public static void main(String[] args) {

        FixedCapacityStack<Integer> fixedCapacityStack = new FixedCapacityStack<>(100);

        for (Integer i : fixedCapacityStack) {

        }

    }

}
