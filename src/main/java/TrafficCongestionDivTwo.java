import java.util.Arrays;

public class TrafficCongestionDivTwo {
    public long theMinCars(int treeHeight) {
        long[] dp = new long[61];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= treeHeight; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] += 2 * dp[j];
            }
        }

        return dp[treeHeight];
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(treeHeight, expected, __case);
            break;

        case 0: {
            int treeHeight = 1;
            long __excepted = 1L;
            doTest(treeHeight, __excepted, __case);
            break;
        }
        case 1: {
            int treeHeight = 2;
            long __excepted = 3L;
            doTest(treeHeight, __excepted, __case);
            break;
        }
        case 2: {
            int treeHeight = 3;
            long __excepted = 5L;
            doTest(treeHeight, __excepted, __case);
            break;
        }
        case 3: {
            int treeHeight = 10;
            long __excepted = 683L;
            doTest(treeHeight, __excepted, __case);
            break;
        }
        case 4: {
            int treeHeight = 60;
            long __excepted = 768614336404564651L;
            doTest(treeHeight, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int treeHeight, long __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        TrafficCongestionDivTwo instance = new TrafficCongestionDivTwo();
        long __result = 0;
        try {
            __result = instance.theMinCars(treeHeight);
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

    static int nExample = 5;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("TrafficCongestionDivTwo (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374246846;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
