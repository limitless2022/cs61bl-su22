package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */
    //public static Deque<Integer> ad = new ArrayDeque<Integer>();
    @Test
    public void testaddFirstAndRemoveFirst() {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        assertEquals(1, ad.size());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(0, ad.size());
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        assertEquals(3, ad.size());
        assertEquals(3, ad.removeFirst().intValue());
        assertEquals(2, ad.removeFirst().intValue());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(0, ad.size());
    }

    @Test
    public void testaddLastAndRemoveLast() {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        assertEquals(1, ad.size());
        assertEquals(1, ad.removeLast().intValue());
        assertEquals(0, ad.size());
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertEquals(3, ad.size());
        assertEquals(3, ad.removeLast().intValue());
        assertEquals(2, ad.removeLast().intValue());
        assertEquals(1, ad.removeLast().intValue());
        assertEquals(0, ad.size());
    }

    @Test
    public void testprintDeque() {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.printDeque();
    }


    @Test
    public void testresize() {
        Deque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad.addLast(i);
        }
        ad.printDeque();

        for (int i = 0; i < 50; i++) {
            ad.addFirst(i);
        }
        ad.printDeque();

        Deque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            ad2.addFirst(i);
        }
        ad2.printDeque();
    }

    @Test
    public void testaddFirstAndaddLast() {
        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addLast(2);
        assertEquals(2, ad.size());
        assertEquals(1, ad.removeFirst().intValue());
        assertEquals(2, ad.removeLast().intValue());
        assertEquals(0, ad.size());
    }

    @Test
    public void testnarrow() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 70; i++) {
            ad.addLast(i);
        }
        ad.printDeque();
        for (int i = 0; i < 60; i++) {
            ad.removeFirst();
        }
        assertEquals(32, ad.getLen());
        ad.printDeque();
    }

    @Test
    public void testget() {
        Deque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            ad.addLast(i);
        }
        ad.printDeque();
        for (int i = 0; i < 50; i++) {
            assertEquals(i, ad.get(i).intValue());
            System.out.print(ad.get(i) + " ");
        }
    }

    @Test
    public void testequals() {
        Deque<Integer> ad = new ArrayDeque<>();
        Deque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            ad.addLast(i);
            ad2.addLast(i);
        }
        assertTrue(ad.equals(ad2));
        ad.addLast(1);
        assertFalse(ad.equals(ad2));
        ad2.addLast(1);
        assertTrue(ad.equals(ad2));
    }

    @Test
    public void multipleParamsTest() {
        Deque<String> ad = new ArrayDeque<>();
        ad.addFirst("a");
        ad.addFirst("b");
        ad.addFirst("c");
        assertEquals(3, ad.size());
        assertEquals("c", ad.removeFirst());
        assertEquals("b", ad.removeFirst());
        assertEquals("a", ad.removeFirst());
        assertEquals(0, ad.size());
        assertEquals(null, ad.removeFirst());
        assertEquals(null, ad.removeLast());
    }
    @Test
    public void equalArrayDeque() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            lld.addFirst(i);
            ad.addFirst(i);
        }
        ad.narrow();
        assertEquals(ad.get(1),lld.get(1));
        assertEquals(ad.get(5),lld.get(5));

        assertEquals(ad.size(),lld.size());



    }

}
