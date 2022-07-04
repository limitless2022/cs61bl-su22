import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void testConstructor() {  //别漏啦！！！
    Measurement a = new Measurement();
    assertEquals(0,a.getFeet());
    assertEquals(0,a.getInches());

    Measurement b = new Measurement(2,26);
    assertEquals(4,b.getFeet());
    assertEquals(2,b.getInches());

    }

    @Test
    public void getFeet() {
        Measurement c = new Measurement(0);
        assertEquals(0,c.getFeet());
        Measurement t = new Measurement(1,0);
        assertEquals(1,t.getFeet());
    }

    @Test
    public void getInches() {
        Measurement t = new Measurement(0,0);
        assertEquals(0,t.getInches());
    }

    @Test
    public void plus() {
        Measurement c = new Measurement(11,12);
        Measurement m2 = new Measurement(1,1);
        c = c.plus(m2); //注意：赋值c
        assertEquals(13,c.getFeet());
        assertEquals(1,c.getInches());

    }

    @Test
    public void minus() {
        Measurement c = new Measurement(3,4);
        Measurement m2 = new Measurement(1,1);
        c = c.minus(m2); //注意赋值c
        assertEquals(2,c.getFeet());
        assertEquals(3,c.getInches());

    }

    @Test
    public void multiple() {
        Measurement c = new Measurement(0,7);
        c = c.multiple(3);
        assertEquals(1,c.getFeet());
        assertEquals(9,c.getInches());
    }

    @Test
    public void testToString() {  //用案例来测试，你想达到的效果！
        Measurement a = new Measurement(1,15);
        assertEquals("2'3\"",a.toString());

        a = new Measurement(0,0);
        assertEquals("0'0\"", a.toString());
    }


}