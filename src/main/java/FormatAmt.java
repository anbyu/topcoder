public class FormatAmt {
    public String amount(int dollars, int cents) {
        String s = "";
        int d = dollars;
        int v;
        if (dollars == 0) {
            s += 0;
        } else {
            while (d != 0) {
                v = d % 1000;
                d /= 1000;
                if (d != 0) {
                    s = String.format("%03d%s", v, s);
                    s = "," + s;
                } else {
                    s = v + s;
                }
            }
        }
        s += String.format(".%02d", cents);
        return "$" + s;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(dollars, cents, expected, __case);
            break;

        case 0: {
            int dollars = 123456;
            int cents = 0;
            String __excepted = "$123,456.00";
            doTest(dollars, cents, __excepted, __case);
            break;
        }
        case 1: {
            int dollars = 49734321;
            int cents = 9;
            String __excepted = "$49,734,321.09";
            doTest(dollars, cents, __excepted, __case);
            break;
        }
        case 2: {
            int dollars = 0;
            int cents = 99;
            String __excepted = "$0.99";
            doTest(dollars, cents, __excepted, __case);
            break;
        }
        case 3: {
            int dollars = 249;
            int cents = 30;
            String __excepted = "$249.30";
            doTest(dollars, cents, __excepted, __case);
            break;
        }
        case 4: {
            int dollars = 1000;
            int cents = 1;
            String __excepted = "$1,000.01";
            doTest(dollars, cents, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int dollars, int cents, String __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        FormatAmt instance = new FormatAmt();
        String __result = "";
        try {
            __result = instance.amount(dollars, cents);
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
        System.err.println("FormatAmt (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374012157;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
