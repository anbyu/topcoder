import java.util.Arrays;

public class Pricing {
    public int maxSales(int[] price) {
        int max = 0;

        Arrays.sort(price);
        for (int i = 0; i < price.length; i++) {
            for (int j = i; j < price.length; j++) {
                for (int k = j; k < price.length; k++) {
                    for (int m = k; m < price.length; m++) {
                        int sum = 0;
                        for (int n = 0; n < price.length; n++) {
                            if (price[n] >= price[m]) {
                                sum += price[m];
                            } else if (price[n] >= price[k]) {
                                sum += price[k];
                            } else if (price[n] >= price[j]) {
                                sum += price[j];
                            } else if (price[n] >= price[i]) {
                                sum += price[i];
                            }
                        }
                        if (sum > max) {
                            max = sum;
                        }
                    }
                }
            }
        }

        return max;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(price, expected, __case);
            break;

        case 0: {
            int price[] = new int[] { 9, 1, 5, 5, 5, 5, 4, 8, 80 };
            int __excepted = 120;
            doTest(price, __excepted, __case);
            break;
        }
        case 1: {
            int price[] = new int[] { 17, 50, 2 };
            int __excepted = 69;
            doTest(price, __excepted, __case);
            break;
        }
        case 2: {
            int price[] = new int[] { 130, 110, 90, 13, 6, 5, 4, 3, 0 };
            int __excepted = 346;
            doTest(price, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int[] price, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        Pricing instance = new Pricing();
        int __result = 0;
        try {
            __result = instance.maxSales(price);
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

    static int nExample = 3;
    static int nAll = 0, nPassed = 0;

    public static void main(String[] args) {
        System.err.println("Pricing (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374096302;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
