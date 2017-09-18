package heaps;

/**
 * @author Carlos Piñan
 */
public interface IHeap {

    int getLeftChildIndex(int parentIndex);

    int getRightChildIndex(int parentIndex);

    int getParentIndex(int childIndex);

    boolean hasLeftChild(int index);

    boolean hasRightChild(int index);

    boolean hasParent(int index);

    int leftChild(int index);

    int rightChild(int index);

    int parent(int index);

    void swap(int i, int j);

    void ensureExtraCapacity();

    int peek();

    int poll();

    void add(int item);

    void heapifyDown();

    void heapifyUp();


}
