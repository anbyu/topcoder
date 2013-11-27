import java.util.LinkedList;
import java.util.List;

public class InterestingDigits {
    public int[] digits(int base) {
        int m;
        int[] digits;
        boolean interesting;
        List<Integer> interestingNums = new LinkedList<Integer>();
        for (int i = 2; i < base; ++i) {
            interesting = true;
            m = 2;
            digits = convert(i * m, base);
            while (digits.length < 4) {
                if (sum(digits) % i != 0) {
                    interesting = false;
                    break;
                }
                m++;
                digits = convert(i * m, base);
            }
            if (interesting) {
                interestingNums.add(i);
            }
        }

        return toArray(interestingNums);
    }

    private int[] convert(int i, int base) {
        List<Integer> list = new LinkedList<Integer>();
        while (i != 0) {
            list.add(i % base);
            i /= base;
        }
        return toArray(list);
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }

    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        int i = 0;
        for (int n : list) {
            array[i++] = n;
        }
        return array;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(base, expected, __case);
            break;

        case 0: {
            int base = 10;
            int __excepted[] = new int[] { 3, 9 };
            doTest(base, __excepted, __case);
            break;
        }
        case 1: {
            int base = 3;
            int __excepted[] = new int[] { 2 };
            doTest(base, __excepted, __case);
            break;
        }
        case 2: {
            int base = 9;
            int __excepted[] = new int[] { 2, 4, 8 };
            doTest(base, __excepted, __case);
            break;
        }
        case 3: {
            int base = 26;
            int __excepted[] = new int[] { 5, 25 };
            doTest(base, __excepted, __case);
            break;
        }
        case 4: {
            int base = 30;
            int __excepted[] = new int[] { 29 };
            doTest(base, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int base, int[] __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        InterestingDigits instance = new InterestingDigits();
        int[] __result = new int[0];
        try {
            __result = instance.digits(base);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (equals(__result, __expected)) {
            System.err.println("PASSED! "
                    + String.format("(%.2f seconds)", elapsed));
            nPassed++;
        } else {
            System.err.println("FAILED! "
                    + String.format("(%.2f seconds)", elapsed));
            System.err.println("           Expected: " + toString(__expected));
            System.err.println("           Received: " + toString(__result));
        }
    }

    static int nExample = 5;
    static int nAll = 0, nPassed = 0;

    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; ++i)
            if (a[i] != b[i])
                return false;
        return true;
    }

    static String toString(int[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0)
                sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString() + " ]";
    }

    public static void main(String[] args) {
        System.err.println("InterestingDigits (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374097803;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
