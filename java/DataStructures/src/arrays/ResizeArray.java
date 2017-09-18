package arrays;

/**
 * @author Carlos Piñan
 */
public class ResizeArray<Item> {

    private int size;
    private Item[] array;

    public ResizeArray(int size) {
        this.size = size;
        this.array = (Item[]) new Object[size];
    }

    public static void main(String[] args) {

    }

}
