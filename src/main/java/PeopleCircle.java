import java.util.Arrays;

public class PeopleCircle {

    public String order(int numMales, int numFemales, int K) {
        char[] circle = new char[numMales + numFemales];
        Arrays.fill(circle, 'M');
        int pos = circle.length - 1;

        for (int i = 0; i < numFemales; i++) {
            for (int j = 0; j < K;) {
                pos = (pos + 1) % circle.length;
                if (circle[pos] == 'M') {
                    j++;
                }
            }
            circle[pos] = 'F';
        }

        return new String(circle);
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(numMales, numFemales, K, expected, __case);
            break;

        case 0: {
            int numMales = 5;
            int numFemales = 3;
            int K = 2;
            String __excepted = "MFMFMFMM";
            doTest(numMales, numFemales, K, __excepted, __case);
            break;
        }
        case 1: {
            int numMales = 7;
            int numFemales = 3;
            int K = 1;
            String __excepted = "FFFMMMMMMM";
            doTest(numMales, numFemales, K, __excepted, __case);
            break;
        }
        case 2: {
            int numMales = 25;
            int numFemales = 25;
            int K = 1000;
            String __excepted = "MMMMMFFFFFFMFMFMMMFFMFFFFFFFFFMMMMMMMFFMFMMMFMFMMF";
            doTest(numMales, numFemales, K, __excepted, __case);
            break;
        }
        case 3: {
            int numMales = 5;
            int numFemales = 5;
            int K = 3;
            String __excepted = "MFFMMFFMFM";
            doTest(numMales, numFemales, K, __excepted, __case);
            break;
        }
        case 4: {
            int numMales = 1;
            int numFemales = 0;
            int K = 245;
            String __excepted = "M";
            doTest(numMales, numFemales, K, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int numMales, int numFemales, int K, String __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        PeopleCircle instance = new PeopleCircle();
        String __result = "";
        try {
            __result = instance.order(numMales, numFemales, K);
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
        System.err.println("PeopleCircle (600 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1373917744;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 600 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
