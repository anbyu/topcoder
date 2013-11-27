import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeTest {
    private final Time t = new Time();

    private void test(String expected, int in) {
        String result = t.whatTime(in);
        assertEquals(expected, result);
    }

    @Test
    public void test0() {
        int in = 0;
        String expected = "0:0:0";
        test(expected, in);
    }

    @Test
    public void test1() {
        int in = 3661;
        String expected = "1:1:1";
        test(expected, in);
    }

    @Test
    public void test2() {
        int in = 5436;
        String expected = "1:30:36";
        test(expected, in);
    }

    @Test
    public void test3() {
        int in = 86399;
        String expected = "23:59:59";
        test(expected, in);
    }
}
