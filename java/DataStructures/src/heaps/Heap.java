package heaps;

import java.util.Arrays;

/**
 * @author Carlos Piñan
 */
public class Heap implements IHeap {

    private int capacity, size;
    private int[] items;
    private boolean isMaxHeap;

    public Heap(boolean isMaxHeap, int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.isMaxHeap = isMaxHeap;
        this.items = new int[capacity];
    }

    @Override
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    @Override
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    @Override
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    @Override
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    @Override
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    @Override
    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    @Override
    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    @Override
    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    @Override
    public int parent(int index) {
        return items[getParentIndex(index)];
    }

    @Override
    public void swap(int i, int j) {
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    @Override
    public void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    @Override
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    @Override
    public int poll() {
        if (size == 0) throw new IllegalArgumentException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    @Override
    public void add(int item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp();
    }

    @Override
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int childIndex = getLeftChildIndex(index);
            boolean comparator = isMaxHeap ? rightChild(index) > leftChild(index) : rightChild(index) < leftChild(index);
            if (hasRightChild(index) && comparator) {
                childIndex = getRightChildIndex(index);
            }
            boolean isValid = isMaxHeap ? items[index] > items[childIndex] : items[index] < items[childIndex];
            if (isValid) {
                break;
            } else {
                swap(index, childIndex);
                index = childIndex;
            }
        }
    }

    @Override
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index)) {
            boolean comparator = isMaxHeap ? parent(index) < items[index] : parent(index) > items[index];
            if (comparator) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            } else {
                break;
            }
        }
    }
}
