public class PrefixCode {
    public String isOne(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i) {
                    if (words[j].startsWith(words[i])) {
                        return String.format("No, %d", i);
                    }
                }
            }
        }
        return "Yes";
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(words, expected, __case);
            break;

        case 0: {
            String words[] = new String[] { "trivial" };
            String __excepted = "Yes";
            doTest(words, __excepted, __case);
            break;
        }
        case 1: {
            String words[] = new String[] { "10001", "011", "100", "001", "10" };
            String __excepted = "No, 2";
            doTest(words, __excepted, __case);
            break;
        }
        case 2: {
            String words[] = new String[] { "no", "nosy", "neighbors", "needed" };
            String __excepted = "No, 0";
            doTest(words, __excepted, __case);
            break;
        }
        case 3: {
            String words[] = new String[] { "1010", "11", "100", "0", "1011" };
            String __excepted = "Yes";
            doTest(words, __excepted, __case);
            break;
        }
        case 4: {
            String words[] = new String[] { "No", "not" };
            String __excepted = "Yes";
            doTest(words, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String[] words, String __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        PrefixCode instance = new PrefixCode();
        String __result = "";
        try {
            __result = instance.isOne(words);
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
        System.err.println("PrefixCode (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374177990;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
