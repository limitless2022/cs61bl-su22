import org.junit.Test;

import static org.junit.Assert.*;

public class ModCounterTest {

    @Test
    public void increment() {
        ModCounter c = new ModCounter(0);
        c.increment();
        assertEquals(0,c.value());

    }

    @Test
    public void reset() {
        ModCounter c = new ModCounter(1);
        c.increment();
        c.reset();
        assertEquals(0,c.value());
    }

    @Test
    public void testConstructor() {
        ModCounter c = new ModCounter(0);
        assertEquals(0,c.value());
    }

    @Test
    public void ModCounter(){
        ModCounter a = new ModCounter(1);

    }
    @Test
    public void testIncrement() {
        ModCounter c = new ModCounter(1);
        assertEquals(0,c.value());
        c.increment();
        assertEquals(1,c.value());
        c.increment();
        assertEquals(0,c.value());
        c.increment();
        assertEquals(1,c.value());
    }
}