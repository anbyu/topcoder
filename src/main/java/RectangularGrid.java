public class RectangularGrid {
    public long countRectangles(int width, int height) {
        long sum = width * (width + 1) / 2;
        sum *= height * (height + 1) / 2;

        int n = Math.min(width, height);
        for (int i = 0; i < n; i++) {
            sum -= (width - i) * (height - i);
        }
        return sum;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(width, height, expected, __case);
            break;

        case 0: {
            int width = 3;
            int height = 3;
            long __excepted = 22L;
            doTest(width, height, __excepted, __case);
            break;
        }
        case 1: {
            int width = 5;
            int height = 2;
            long __excepted = 31L;
            doTest(width, height, __excepted, __case);
            break;
        }
        case 2: {
            int width = 10;
            int height = 10;
            long __excepted = 2640L;
            doTest(width, height, __excepted, __case);
            break;
        }
        case 3: {
            int width = 1;
            int height = 1;
            long __excepted = 0L;
            doTest(width, height, __excepted, __case);
            break;
        }
        case 4: {
            int width = 592;
            int height = 964;
            long __excepted = 81508708664L;
            doTest(width, height, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int width, int height, long __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        RectangularGrid instance = new RectangularGrid();
        long __result = 0;
        try {
            __result = instance.countRectangles(width, height);
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
        System.err.println("RectangularGrid (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1371158789;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
