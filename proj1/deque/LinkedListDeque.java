package deque;


public class LinkedListDeque<T> implements Deque<T>{

    private IntListNode sentinel;
    private IntListNode last;
    private int size;
    public class IntListNode {
        public IntListNode prev;
        private T item;
        private IntListNode next;

        public IntListNode (T i,IntListNode n) {
            item = i;
            next = n;
            /**IntListNode last = this.next;
               IntListNode prv = last.next;
               prv.next = last;
             */

        }

        public IntListNode() {
        }

    }
    public LinkedListDeque() {
        sentinel = new IntListNode();
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new IntListNode(item, sentinel.next);
        sentinel.next.prev = sentinel.next;
        /**sentinel.next.next = sentinel.next;//断了，病句。
        sentinel.next.prev = sentinel.next.next;*/
        size++;
        if (size == 1) {
            last = sentinel.next;
        } /**else if (size > 1) { 循环哨兵(不行？)
            last.next = sentinel.next.next;
            sentinel.next.prev = last.next;  //撞车啦！

        }*/


    }
    @Override
    public void addLast(T item) {
        size++;
        last.next = new IntListNode(item,null);
        last.next.prev = last;
        last = last.next;

        /**sentinel.next.next = new IntListNode(item,null);
        sentinel.next.next.prev = sentinel.next;
        sentinel.next.next.next = sentinel.next; //last -->first
        //first's prev --> last's next
        sentinel.next.prev = sentinel.next.next;*/


    }
    @Override
    public int size() {
        return size;

    }
    @Override
    public void printDeque() {
        for (int i=0;i < this.size();i++) {
            System.out.println(this.get(i) + " ");
        }
        System.out.println();

    }
    @Override
    public T removeFirst() {
        if (size() == 0) {
            return null;
        } else if (size == 1) {
            sentinel.next = null;
            size--;
            return null;
        } else {
            sentinel.next = sentinel.next.next;
            size--;
            return sentinel.next.item;
        }
    }
    @Override
    public T removeLast() {
        if (last == null) {
            return sentinel.item;
        } else {
            last.next = last.prev;
            size--;
            return last.next.item;
        }
    }
    @Override
    public T get(int index) { //使用迭代。
        IntListNode p = sentinel;
        while (index >= 0&&p.next!=null) {
            index--;
            p = p.next;
        }
        return p.item;
    }

    /**与get相同，
     * 但使用递归。
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        IntListNode p = sentinel;
        return helper(index-1,p.next);

    }

    private T helper(int index, IntListNode p) {
        if (index < 0) {
            return p.item;
        }
        return helper(index-1,p.next);
    }

    public boolean equals(Object o) { //自己完善equals
        if (o == null || !(o instanceof LinkedListDeque<?>)) {
            return false;
        }

        LinkedListDeque<T> object = (LinkedListDeque<T>) o;
        if (this.size() != object.size()) {
            return false;
        }
        for (int i = 0; i < object.size(); i++) {
            if (!this.get(i).equals(object.get(i))) {
                return false;
            }
        }
        return true;
    }

}


