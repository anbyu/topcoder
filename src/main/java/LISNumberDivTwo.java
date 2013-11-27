public class LISNumberDivTwo {
    public int calculate(int[] seq) {
        int lis = 1;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] <= seq[i - 1]) {
                lis++;
            }
        }

        return lis;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(seq, expected, __case);
            break;

        case 0: {
            int seq[] = new int[] { 1, 4, 4, 2, 6, 3 };
            int __excepted = 4;
            doTest(seq, __excepted, __case);
            break;
        }
        case 1: {
            int seq[] = new int[] { 5, 8, 9, 12, 16, 32, 50 };
            int __excepted = 1;
            doTest(seq, __excepted, __case);
            break;
        }
        case 2: {
            int seq[] = new int[] { 1, 1, 9, 9, 2, 2, 3, 3 };
            int __excepted = 6;
            doTest(seq, __excepted, __case);
            break;
        }
        case 3: {
            int seq[] = new int[] { 50, 40, 30, 20, 10 };
            int __excepted = 5;
            doTest(seq, __excepted, __case);
            break;
        }
        case 4: {
            int seq[] = new int[] { 42 };
            int __excepted = 1;
            doTest(seq, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] seq, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        LISNumberDivTwo instance = new LISNumberDivTwo();
        int __result = 0;
        try {
            __result = instance.calculate(seq);
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
        System.err.println("LISNumberDivTwo (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374246652;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
