package deque;

public class ArrayDeque<T> implements Deque<T> {
    final double ratio = 0.25;
    private T[] que;
    private int len,size,head,tail;


    public ArrayDeque() {
        que = (T[]) new Object[8]; //因为泛型！我变成这样。
        size = 0;
        len = 8;
        head = 3;
        tail = head - 1;
    }

    public int getLen() {
        return len;
    }


    private void resize() {
        T[] newQue = (T[]) new Object[2*len];
        System.arraycopy(que,0,newQue,0,tail+1);
        System.arraycopy(que,head,newQue,len + head,len - head);
        que = newQue;
        head = (head + len) % (2 * len);
        len *=2;

    }

    @Override  //重写该方法
    public void addFirst(T item) {
        size ++;
        if (que[(head - 1 + len) % len] != null) {
            resize();
        }
        que[(head - 1 + len) % len] = item;
        head = (head - 1 + len) % len;


    }

    @Override
    public void addLast(T item) {
        size++;
        if (que[(tail + 1 + len) % len] != null) {
            resize();
        }
        que[(tail + 1 + len) % len] = item;
        tail = (tail + 1 + len) % len;

    }

    @Override
    public int size() {
        return size;

    }

    public String dequeToString() {
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans = ans + this.get(i) + " ";
        }
        return ans;

    }

    public void narrow() { //把ArrayDeque变得和LinkedListDeque一模一样（限制）
        T[] newQue = (T[]) new Object[len];
        for (int i = 0;i < size;i++) {
           newQue[i] = que[(head + i) % len];
        }
        que = newQue;
        head = 0;
        tail = size -1;
        len /= 2;

    }

    @Override
    public void printDeque() {
        String ans = dequeToString();
        System.out.println(ans);

    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T x = que[head];
        que[head] = null;
        head = (head + 1)% len;
        if (((double)size/len < ratio)&&(len >= 16)) {
            narrow();
        }
        return x;


    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T x = que[tail];
        que[tail] = null;
        tail = (tail - 1 + len) % len;
        if (((double)size/len < ratio)&&(len >= 16)) {
            narrow();
        }
        return x;
    }
    @Override
    public T get(int index) {
        if (index > size) {
            throw new IllegalArgumentException("IllegalArgumentException !");
        }
        return que[(head + index) % len];

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ArrayDeque<?>)) {
            return false;
        }

        ArrayDeque<T> object = (ArrayDeque<T>) o;
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
