import java.util.HashSet;
import java.util.Set;

public class TopFox {
    public int possibleHandles(String familyName, String givenName) {
        Set<String> handles = new HashSet<String>();

        for (int i = 1; i <= familyName.length(); ++i) {
            for (int j = 1; j <= givenName.length(); ++j) {
                handles.add(familyName.substring(0, i)
                        + givenName.substring(0, j));
            }
        }

        return handles.size();
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(familyName, givenName, expected, __case);
            break;

        case 0: {
            String familyName = "ab";
            String givenName = "cd";
            int __excepted = 4;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        case 1: {
            String familyName = "abb";
            String givenName = "bbc";
            int __excepted = 7;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        case 2: {
            String familyName = "fox";
            String givenName = "ciel";
            int __excepted = 12;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        case 3: {
            String familyName = "abbbb";
            String givenName = "bbbbbbbc";
            int __excepted = 16;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        case 4: {
            String familyName = "abxy";
            String givenName = "xyxyxc";
            int __excepted = 21;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        case 5: {
            String familyName = "ababababab";
            String givenName = "bababababa";
            int __excepted = 68;
            doTest(familyName, givenName, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String familyName, String givenName, int __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        TopFox instance = new TopFox();
        int __result = 0;
        try {
            __result = instance.possibleHandles(familyName, givenName);
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
        System.err.println("TopFox (250 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373454651;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 250 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
