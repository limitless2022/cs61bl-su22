/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */
public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        int i=0;
        IntList p = this; //指针；
        if (position < 0) {
            throw new IllegalArgumentException("IllegalArgumentException for negative indices");
        }
        while (i < position&&p.next!=null) {
            p = p.next;
            i++;
        }
        if (i < position) {
            throw new IllegalArgumentException("IllegalArgumentException for negative indices");
        } else {
            return p.item;
        }
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        IntList p = this;
        String s = ""; //""表示空。
        String k = " ";
        for (;p!=null;p=p.next) {
            s += Integer.toString(p.item); //将整数，转化成字符串。
            if (p.next!=null) { //特殊情况。
                s += k;
            }
        }
        return s;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parenthesis. An example of this is on line 84.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntList)) {
            return false;
        }
        IntList otherLst = (IntList) obj;
        //比较长度是否一致和相应的值是否相等。
        String str1 = this.toString(),str2 = otherLst.toString();
        if (str1.equals(str2)) {
            System.out.println(str1 + " " + str2);
            return true;
        } else return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        IntList p = this;
        while (p.next!=null) {
            p = p.next;
        }
        p.next = new IntList(value);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() { //两两相比，最后得出最小值，并返回it。
        IntList p = this;
        int min = 0x3f3f3f3f; //无穷大！！！
        while (p!=null) {
            min = Math.min(min,p.item);
            p = p.next;
        }
        return min;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        int powtotal = 0;
        IntList p= this;
        while (p!=null) {
            powtotal += p.item * p.item;
            p = p.next;
        }
        return powtotal;
    }

    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }


    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        IntList i = A,j = B;
            while (i.next!=null) {
                i = i.next;
            }
            i.next = new IntList(j.item,j.next);
        return A;  //magric???123——>123456 破坏版
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
     public static IntList catenate(IntList A, IntList B) {
         IntList copy_a = IntListCopy(A);
         IntList copy_b = IntListCopy(B);
         IntList ans = copy_a;

         /**while (copy_a.next!=null) {
             copy_a = copy_a.next;
         }
         copy_a.next = copy_b; //指针。
         return ans;
          */
         if (copy_b==null) { //尾递归!
             return ans;
         } else if (copy_b!=null) {
             ans.add(copy_b.item);
         }
         return catenate(copy_a,copy_b.next);


     }


    public static IntList IntListCopy(IntList L){ //recursive;
        if (L == null) return null;
        return new IntList(L.item, IntListCopy(L.next));
    }

}