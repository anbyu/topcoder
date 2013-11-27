import java.util.Arrays;

public class GoldenChain {
    public int minCuts(int[] sections) {
        Arrays.sort(sections);

        int start = 0;
        int end = sections.length - 1;

        int count = 1;

        while (start != end) {
            sections[start]--;
            count++;
            if (sections[start] == 0) {
                start++;
            }
            if (start == end) {
                count--;
                break;
            }
            sections[end - 1] += sections[end];
            end--;
        }

        return count;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(sections, expected, __case);
            break;

        case 0: {
            int sections[] = new int[] { 3, 3, 3, 3 };
            int __excepted = 3;
            doTest(sections, __excepted, __case);
            break;
        }
        case 1: {
            int sections[] = new int[] { 2000000000 };
            int __excepted = 1;
            doTest(sections, __excepted, __case);
            break;
        }
        case 2: {
            int sections[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                    28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                    43, 44, 45, 46, 47, 48, 49, 50 };
            int __excepted = 42;
            doTest(sections, __excepted, __case);
            break;
        }
        case 3: {
            int sections[] = new int[] { 20000000, 20000000, 2000000000 };
            int __excepted = 3;
            doTest(sections, __excepted, __case);
            break;
        }
        case 4: {
            int sections[] = new int[] { 10, 10, 10, 10, 10, 1, 1, 1, 1, 1 };
            int __excepted = 5;
            doTest(sections, __excepted, __case);
            break;
        }
        case 5: {
            int sections[] = new int[] { 1, 10 };
            int __excepted = 1;
            doTest(sections, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] sections, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        GoldenChain instance = new GoldenChain();
        int __result = 0;
        try {
            __result = instance.minCuts(sections);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (__result == __expected) {
            System.err.println("PASSED! "
                    + String.format("(%.2f seconds)", elapsed));
            nPassed++;
        } else {
            System.err.println("FAILED! "
                    + String.format("(%.2f seconds)", elapsed));
            System.err.println("           Expected: " + __expected);
            System.err.println("           Received: " + __result);
        }
    }

    static int nExample = 6;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("GoldenChain (950 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373904626;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 950 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
