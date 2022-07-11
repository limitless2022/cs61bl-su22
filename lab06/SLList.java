
/**
 * An SLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class SLList {

    /**
     * IntListNode is a nested class that represents a single node in the
     * SLList, storing an item and a reference to the next IntListNode.
     */
    private static class IntListNode { //祖传秘方！
        /*
         * The access modifiers inside a private nested class are irrelevant:
         * both the inner class and the outer class can access these instance
         * variables and methods.
         */
        public int item;
        public IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntListNode that = (IntListNode) o;
            return item == that.item;
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntListNode sentinel; //哨兵节点
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntListNode(42, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntListNode(42, null);
        sentinel.next = new IntListNode(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SLList slList = (SLList) o;
        if (size != slList.size) return false;

        IntListNode l1 = sentinel.next;
        IntListNode l2 = slList.sentinel.next;

        while (l1 != sentinel && l2 != slList.sentinel) {
            if (!l1.equals(l2)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
	if (l1 != sentinel || l2 != slList.sentinel) {
		return false;
	}
        return true;
    }

    @Override
    public String toString() {
        IntListNode l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /**
     * Returns an SLList consisting of the given values.
     */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;

    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntListNode(x, sentinel.next);
        size += 1;
    }

    /** Return the value at the given index. */
    public int get(int index) {
        IntListNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {
        IntListNode p = sentinel;
        if (index ==0) {
            this.addFirst(x);
        } else if (size < index) {
            this.add(size,x);
        } else {
            while (index > 0) { //find this index
                p = p.next;
                index -= 1;
            }
            size +=1;
            p.next = new IntListNode(x,p.next);
        }
    }

    /** Destructively reverses this list. */
    public void reverse() {
        /**IntListNode pre = null, p = sentinel.next;
        while(p != null) {
            IntListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }*/
        IntListNode L = sentinel.next;
        //IntListNode temp = sentinel;
        reverseHelper(L);
        //sentinel.next = L; //更新sentinel以指向反向链表的前面。
    }

    public IntListNode reverseHelper(IntListNode L) {
        /**if (L == null) { //iterate
            temp.next = sentinel.next; //将返回列表的末尾设置为当前帧的L
            L.next = sentinel;  //当前帧的L尾设置为哨兵，
            return temp; //返回反向列表的前面
        }
        return reverseHelper(L.next,temp.next=L); //让其逆转？？？*/
        if (L.next == sentinel) return L;
        IntListNode last = reverseHelper(L.next); //recursive; magic 翻转！
        L.next.next = L; //2指向1
        //L.next = sentinel; //1指向哨兵
        sentinel.next = last; //更新哨兵指向前面(last)
        return last;
    }
}
