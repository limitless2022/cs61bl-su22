
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a set of ints.
 */
public class ListSet implements SimpleSet {

    List<Integer> elems;
    private int size;

    public ListSet() {
        elems = new ArrayList<Integer>();
        size = 0;
    }

    /** Adds k to the set. */
    public void add(int k) {
        if (contains(k)) {
            return;
        }
        elems.add(k);
        size++;
    }

    /** Removes k from the set. */
    public void remove(int k) {
        /**List<Integer> L = new ArrayList<>();
        for (int i = 0;i < size;i++) {
            if (elems.get(i) != k ) {
                L.add(elems.get(i));
            }
        }
        elems = L;*/
        /*自动拆箱int-->Integer
        * 这里需要remove(Object item)
        * 而不是remove(index k)*/

        Integer toString = k; //toString 一个对象
        elems.remove(toString);
        size--;
    }

    /** Return true if k is in this set, false otherwise. */
    public boolean contains(int k) {
        for (int i = 0;i < size;i++){
            if (elems.get(i) == k) {
                return true;
            }
        }
        return false;
    }

    /** Return true if this set is empty, false otherwise. */
    public boolean isEmpty() {
      return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    public int size() {
        return size;
    }

    /** Returns an array containing all of the elements in this collection. */
    public int[] toIntArray() {
        //多此一举？？？
        int[] L = new int[size];
        for (int i = 0;i < size; i++) {
            L[i] = elems.get(i);
        }
        return L;
    }
}
