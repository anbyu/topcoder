import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerOutageTest {
    private final PowerOutage o = new PowerOutage();

    private void test(int expected, int[] in0, int[] in1, int[] in2) {
        int result = o.estimateTimeOut(in0, in1, in2);
        assertEquals(expected, result);
    }

    @Test
    public void test0() {
        int[] in0 = { 0 };
        int[] in1 = { 1 };
        int[] in2 = { 10 };
        int expected = 10;
        test(expected, in0, in1, in2);
    }

    @Test
    public void test1() {
        int[] in0 = { 0, 1, 0 };
        int[] in1 = { 1, 2, 3 };
        int[] in2 = { 10, 10, 10 };
        int expected = 40;
        test(expected, in0, in1, in2);
    }

    @Test
    public void test2() {
        int[] in0 = { 0, 0, 0, 1, 4 };
        int[] in1 = { 1, 3, 4, 2, 5 };
        int[] in2 = { 10, 10, 100, 10, 5 };
        int expected = 165;
        test(expected, in0, in1, in2);
    }

    @Test
    public void test3() {
        int[] in0 = { 0, 0, 0, 1, 4, 4, 6, 7, 7, 7, 20 };
        int[] in1 = { 1, 3, 4, 2, 5, 6, 7, 20, 9, 10, 31 };
        int[] in2 = { 10, 10, 100, 10, 5, 1, 1, 100, 1, 1, 5 };
        int expected = 281;
        test(expected, in0, in1, in2);
    }

    @Test
    public void test4() {
        int[] in0 = { 0, 0, 0, 0, 0 };
        int[] in1 = { 1, 2, 3, 4, 5 };
        int[] in2 = { 100, 200, 300, 400, 500 };
        int expected = 2500;
        test(expected, in0, in1, in2);
    }

}
