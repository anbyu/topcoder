public class Excavations2 {
    public long count(int[] kind, int[] found, int K) {
        int occurences[] = new int[found.length];

        for (int i = 0; i < found.length; i++) {
            for (int j = 0; j < kind.length; j++) {
                if (found[i] == kind[j]) {
                    occurences[i]++;
                }
            }
        }

        long result = 1;
        for (int i = 0; i < found.length; i++) {
            result *= occurences[i];
            occurences[i]--;
        }

        int sum = 0;
        for (int o : occurences) {
            sum += o;
        }

        for (int i = found.length; i < K; i++) {
            result *= sum--;
        }

        return result / factorial(found.length - 1);
    }

    private long factorial(long n) {
        if (n < 2) {
            return 1;
        } else {
            while (n != 1) {
                n *= --n;
            }
            return n;
        }
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(kind, found, K, expected, __case);
            break;

        case 0: {
            int kind[] = new int[] { 1, 2, 2, 1 };
            int found[] = new int[] { 1 };
            int K = 2;
            long __excepted = 1L;
            doTest(kind, found, K, __excepted, __case);
            break;
        }
        case 1: {
            int kind[] = new int[] { 1, 2, 2, 1 };
            int found[] = new int[] { 1, 2 };
            int K = 2;
            long __excepted = 4L;
            doTest(kind, found, K, __excepted, __case);
            break;
        }
        case 2: {
            int kind[] = new int[] { 1, 2, 1, 1, 2, 3, 4, 3, 2, 2 };
            int found[] = new int[] { 4, 2 };
            int K = 3;
            long __excepted = 6L;
            doTest(kind, found, K, __excepted, __case);
            break;
        }
        case 3: {
            int kind[] = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
                    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
                    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
            int found[] = new int[] { 50 };
            int K = 21;
            long __excepted = 5567902560L;
            doTest(kind, found, K, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] kind, int[] found, int K, long __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        Excavations2 instance = new Excavations2();
        long __result = 0;
        try {
            __result = instance.count(kind, found, K);
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

    static int nExample = 4;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("Excavations2 (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373457082;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
