public class BigBurger {
    public int maxWait(int[] arrival, int[] service) {
        int clock = 0;
        int wait, maxWait = 0;

        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] < clock) {
                wait = clock - arrival[i];
                if (wait > maxWait) {
                    maxWait = wait;
                }
            } else {
                clock = arrival[i];
            }

            clock += service[i];
        }

        return maxWait;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(arrival, service, expected, __case);
            break;

        case 0: {
            int arrival[] = new int[] { 3, 3, 9 };
            int service[] = new int[] { 2, 15, 14 };
            int __excepted = 11;
            doTest(arrival, service, __excepted, __case);
            break;
        }
        case 1: {
            int arrival[] = new int[] { 182 };
            int service[] = new int[] { 11 };
            int __excepted = 0;
            doTest(arrival, service, __excepted, __case);
            break;
        }
        case 2: {
            int arrival[] = new int[] { 2, 10, 11 };
            int service[] = new int[] { 3, 4, 3 };
            int __excepted = 3;
            doTest(arrival, service, __excepted, __case);
            break;
        }
        case 3: {
            int arrival[] = new int[] { 2, 10, 12 };
            int service[] = new int[] { 15, 1, 15 };
            int __excepted = 7;
            doTest(arrival, service, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] arrival, int[] service, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        BigBurger instance = new BigBurger();
        int __result = 0;
        try {
            __result = instance.maxWait(arrival, service);
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
        System.err.println("BigBurger (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374095363;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
