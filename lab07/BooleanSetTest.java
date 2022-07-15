import org.junit.Test;
import static org.junit.Assert.*;

public class BooleanSetTest {

    @Test
    public void testBasics() {
        BooleanSet aSet = new BooleanSet(100);
        assertEquals(0, aSet.size());
        for (int i = 0; i < 100; i += 2) {
            aSet.add(i);
            assertTrue(aSet.contains(i));
        }
        assertEquals(50, aSet.size());

        for (int i = 0; i < 100; i += 2) {
            aSet.remove(i);
            assertFalse(aSet.contains(i));
        }
        assertTrue(aSet.isEmpty());
        assertEquals(0, aSet.size());
    }

    @Test
    public void toIntArray() {
        BooleanSet t = new BooleanSet(100);
        assertEquals(0,t.size());
        for (int i = 0; i < 3; i ++) {
            t.add(i);
            assertTrue(t.contains(i));
        }

        int[] a = t.toIntArray();
        assertTrue(a[0] == 1);
        assertTrue(a[1] == 1);
        //assertEquals(0,t.toIntArray()[23]);

    }
}
