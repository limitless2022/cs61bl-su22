package deque;

/* The Deque interface defines the expected behavior for any
* Deque, whether it is an ArrayDeque or LinkedListDeque. A
* Deque is a doubly-ended queue, that allows you to quickly add
* and remove items from the front and back. */
public interface Deque<T> {
    /**return size of list*/
    int size();
    /**
     * Adds an item of type T to the front of the deque. You can assume that item is never null.*/
    void addFirst(T item);

    /**
     * add an item of type T to the last of the deque.
     */
    void addLast(T item);

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items
     * have been printed, print out a new line.
     */
    void printDeque();

    /**
     * remove the first element.
     * @return
     */

    T removeFirst();

    /**
     * remove the last element.
     * @return
     */
    T removeLast();

    /**
     * 获取index 位置的值
     * @param index
     * @return
     */
    T get(int index);

    boolean equals(Object o);

    default boolean isEmpty() {
        return size()==0;
    }

}


