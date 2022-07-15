import org.junit.Test;
import static org.junit.Assert.*;

public class ListSetTest {

    @Test
    public void testBasics() {
        ListSet aSet = new ListSet();
        assertEquals(0, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }
    @Test
    public void testAdd() {
        ListSet aSet = new ListSet();
        aSet.add(1);
        aSet.add(1);
        assertTrue(aSet.contains(1));
    }
    @Test
    public void testRemove() {
        ListSet a = new ListSet();
        a.add(1);
        a.add(3);
        assertTrue(a.contains(1));
        a.remove(1);
        assertFalse(a.contains(1));
    }
    @Test
    public void testToIntArray() {
        ListSet t = new ListSet();
        t.add(1);
        t.add(2);
        t.add(3);
        int[] e = new int[3];
        e[0] = 1;
        e[1] = 2;
        e[2] = 3;
        assertEquals(e[0],t.toIntArray()[0]);
        assertEquals(e[1],t.toIntArray()[1]);
        assertEquals(e[2],t.toIntArray()[2]);
    }

}
