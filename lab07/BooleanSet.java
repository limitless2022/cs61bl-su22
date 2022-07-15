import java.util.Arrays;

/**
 * Represent a set of nonnegative ints from 0 to maxElement for some initially
 * specified maxElement.
 */
public class BooleanSet implements SimpleSet {

    private boolean[] contains;
    private int size;

    /** Initializes a set of ints from 0 to maxElement. */
    public BooleanSet(int maxElement) {
        contains = new boolean[maxElement + 1];
        size = 0;
    }

    /** Adds k to the set. */
    public void add(int k) {
        if (contains(k)) {
            return;
        }
        size++;
        contains[k] = true;
    }

    /** Removes k from the set. */
    public void remove(int k) {
        if (contains(k)) {
            size--;
            contains[k] = false;
        }


    }

    /** Return true if k is in this set, false otherwise. */
    public boolean contains(int k) {
        if (contains[k]) {
            return true;
        }
        return false;
    }

    /** Return true if this set is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the set. */
    public int size() {
        return size;
    }

    /** Returns an array containing all of the elements in this collection. */
    public int[] toIntArray() {
        int[] a = new int[size];
        for (int i = 0;i < size; i++) {
            if (contains(i)) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        return a;
    }
}
