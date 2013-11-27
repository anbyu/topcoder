import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BinaryCodeTest {
    private final BinaryCode o = new BinaryCode();

    private void test(String[] expected, String in) {
        String[] result = o.decode(in);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test0() {
        String in = "123210122";
        String[] expected = new String[] { "011100011", "NONE" };
        test(expected, in);
    }

    @Test
    public void test1() {
        String in = "11";
        String[] expected = new String[] { "01", "10" };
        test(expected, in);
    }

    @Test
    public void test2() {
        String in = "22111";
        String[] expected = new String[] { "NONE", "11001" };
        test(expected, in);
    }

    @Test
    public void test3() {
        String in = "123210120";
        String[] expected = new String[] { "NONE", "NONE" };
        test(expected, in);
    }

    @Test
    public void test4() {
        String in = "3";
        String[] expected = new String[] { "NONE", "NONE" };
        test(expected, in);
    }

    @Test
    public void test5() {
        String in = "12221112222221112221111111112221111";
        String[] expected = new String[] {
                "01101001101101001101001001001101001",
                "10110010110110010110010010010110010" };
        test(expected, in);
    }

}
