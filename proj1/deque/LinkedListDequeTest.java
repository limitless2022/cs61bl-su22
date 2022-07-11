package deque;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;


/** Performs some basic linked list deque tests.
 * 开始编写测试
 * @author Guo
 * */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        lld = new LinkedListDeque<Integer>();
        assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);
        assertFalse("lld1 should now contain 1 item", lld.isEmpty());
        lld.addFirst(1);
        assertFalse(lld.isEmpty());
    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        lld = new LinkedListDeque<Integer>();
        lld.addFirst(0);
        assertFalse(lld.isEmpty());
        lld.removeFirst();
        assertTrue(lld.isEmpty());

        lld.addFirst(0);
        lld.addFirst(1);
        lld.removeFirst();
        assertEquals(1,lld.size());
        //assertEquals(0,lld.get(0));

    }

    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld = new LinkedListDeque<Integer>();
        lld.removeFirst();
        assertTrue(lld.isEmpty());

    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        LinkedListDeque<String> lld = new LinkedListDeque<>();
        lld.addFirst("Perry");
        lld.addFirst("Zhong");
        lld.addFirst("!");
        lld.addLast("cs61blllllll");
        assertEquals(4, lld.size());
        lld.printDeque();
        assertEquals( "cs61blllllll", lld.get(lld.size() - 1));

        lld.removeFirst();
        lld.removeLast();
        assertEquals(2, lld.size());
        lld.printDeque();
        assertEquals( "Perry", lld.get(lld.size() - 1));

    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        lld = new LinkedListDeque<>();
        assertNull(lld.removeFirst());
        assertNull(lld.removeLast());

    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void hugeData() {
        final int NUM_DATA = 1000000;
        lld = new LinkedListDeque<>();
        for (int i=0; i < NUM_DATA; i++) {
            lld.addFirst(i);
        }
        assertEquals(0, (long)lld.get(NUM_DATA - 1));
    }


    @Test
    public void getRecursive() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for (int i=0; i < 10; i++) {
            lld.addFirst(i);
        }
        assertEquals(6, (long)lld.getRecursive((3)));
    }

    @Test
    public void printDeque() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for (int i=0; i < 10; i++) {
            lld.addFirst(i);
        }
        lld.printDeque();
    }

    @Test
    public void testEquals() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        for (int i=0; i < 10; i++) {
            lld.addFirst(i);
        }
        for (int i=0; i < 10; i++) {
            lld2.addFirst(i);
        }
        assertTrue(lld.equals(lld2));
        lld2.addFirst(1);
        assertFalse(lld.equals(lld2));
    }


}
