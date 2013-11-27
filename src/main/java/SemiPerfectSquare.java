public class SemiPerfectSquare {
    public String check(int N) {
        for (int i = 1; i < 32; ++i) {
            int sq = i * i;
            if (N < sq) {
                break;
            }
            if (N % sq == 0 && N / sq < i) {
                return "Yes";
            }
        }
        return "No";
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(N, expected, __case);
            break;

        case 0: {
            int N = 48;
            String __excepted = "Yes";
            doTest(N, __excepted, __case);
            break;
        }
        case 1: {
            int N = 1000;
            String __excepted = "No";
            doTest(N, __excepted, __case);
            break;
        }
        case 2: {
            int N = 25;
            String __excepted = "Yes";
            doTest(N, __excepted, __case);
            break;
        }
        case 3: {
            int N = 47;
            String __excepted = "No";
            doTest(N, __excepted, __case);
            break;
        }
        case 4: {
            int N = 2;
            String __excepted = "Yes";
            doTest(N, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int N, String __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        SemiPerfectSquare instance = new SemiPerfectSquare();
        String __result = "";
        try {
            __result = instance.check(N);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (__expected.equals(__result)) {
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
        System.err.println("SemiPerfectSquare (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1371208233;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
