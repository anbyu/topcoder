public class CeyKaps {
    public String decipher(String typed, String[] switches) {
        int[] dict = new int['Z' - 'A' + 1];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = i;
        }

        int t;
        char a, b;

        for (String s : switches) {
            a = s.charAt(0);
            b = s.charAt(2);

            t = dict[a - 'A'];
            dict[a - 'A'] = dict[b - 'A'];
            dict[b - 'A'] = t;
        }

        int[] rdict = new int[dict.length];
        for (int i = 0; i < rdict.length; i++) {
            rdict[dict[i]] = i;
        }

        char[] typedChars = typed.toCharArray();
        for (int i = 0; i < typedChars.length; i++) {
            typedChars[i] = (char) ('A' + rdict[typedChars[i] - 'A']);
        }

        return new String(typedChars);
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(typed, switches, expected, __case);
            break;

        case 0: {
            String typed = "AAAAA";
            String switches[] = new String[] { "A:B", "B:C", "A:D" };
            String __excepted = "CCCCC";
            doTest(typed, switches, __excepted, __case);
            break;
        }
        case 1: {
            String typed = "ABCDE";
            String switches[] = new String[] { "A:B", "B:C", "C:D", "D:E",
                    "E:A" };
            String __excepted = "AEBCD";
            doTest(typed, switches, __excepted, __case);
            break;
        }
        case 2: {
            String typed = "IHWSIOTCHEDMYKEYCAPSARWUND";
            String switches[] = new String[] { "W:O", "W:I" };
            String __excepted = "WHOSWITCHEDMYKEYCAPSAROUND";
            doTest(typed, switches, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String typed, String[] switches, String __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        CeyKaps instance = new CeyKaps();
        String __result = "";
        try {
            __result = instance.decipher(typed, switches);
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

    static int nExample = 3;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("CeyKaps (600 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373923979;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 600 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
