import java.math.BigInteger;
import java.util.Arrays;

public class Lottery {
    class Rules implements Comparable<Rules> {
        String name;
        BigInteger possibilities;

        public Rules(String description) {
            String[] nameRest = description.split(":");
            name = nameRest[0];

            String[] rest = nameRest[1].substring(1).split(" ");
            int n = Integer.valueOf(rest[0]);
            int k = Integer.valueOf(rest[1]);
            boolean sorted = "T".equals(rest[2]);
            boolean unique = "T".equals(rest[3]);

            if (sorted && unique) {
                possibilities = binominalCoefficient(n, k);
            } else if (!sorted && unique) {
                possibilities = divideFactorials(n, n - k);
            } else if (sorted && !unique) {
                possibilities = binominalCoefficient(n + k - 1, k);
            } else {
                possibilities = pow(n, k);
            }
        }

        private BigInteger divideFactorials(int n, int k) {
            BigInteger ans = BigInteger.ONE;

            for (int i = 2; i <= n; i++) {
                ans = ans.multiply(BigInteger.valueOf(i));
            }

            for (int i = 2; i <= k; i++) {
                ans = ans.divide(BigInteger.valueOf(i));
            }

            return ans;
        }

        private BigInteger binominalCoefficient(int n, int k) {
            BigInteger ans = BigInteger.ONE;
            for (int i = k + 1; i <= n; i++) {
                ans = ans.multiply(BigInteger.valueOf(i));
            }

            for (int i = 2; i <= n - k; i++) {
                ans = ans.divide(BigInteger.valueOf(i));
            }

            return ans;
        }

        private BigInteger pow(int n, int k) {
            BigInteger nn = BigInteger.valueOf(n);
            return nn.pow(k);
        }

        @Override
        public int compareTo(Rules o) {
            int cp = possibilities.compareTo(o.possibilities);
            return cp != 0 ? cp : name.compareTo(o.name);
        }
    }

    public String[] sortByOdds(String[] rules) {
        Rules[] rr = new Rules[rules.length];

        for (int i = 0; i < rr.length; i++) {
            rr[i] = new Rules(rules[i]);
        }

        Arrays.sort(rr);

        for (int i = 0; i < rr.length; i++) {
            rules[i] = rr[i].name;
        }

        return rules;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(rules, expected, __case);
            break;

        case 0: {
            String rules[] = new String[] { "PICK ANY TWO: 10 2 F F",
                    "PICK TWO IN ORDER: 10 2 T F",
                    "PICK TWO DIFFERENT: 10 2 F T",
                    "PICK TWO LIMITED: 10 2 T T" };
            String __excepted[] = new String[] { "PICK TWO LIMITED",
                    "PICK TWO IN ORDER", "PICK TWO DIFFERENT", "PICK ANY TWO" };
            doTest(rules, __excepted, __case);
            break;
        }
        case 1: {
            String rules[] = new String[] { "INDIGO: 93 8 T F",
                    "ORANGE: 29 8 F T", "VIOLET: 76 6 F F", "BLUE: 100 8 T T",
                    "RED: 99 8 T T", "GREEN: 78 6 F T", "YELLOW: 75 6 F F" };
            String __excepted[] = new String[] { "RED", "ORANGE", "YELLOW",
                    "GREEN", "BLUE", "INDIGO", "VIOLET" };
            doTest(rules, __excepted, __case);
            break;
        }
        case 2: {
            String rules[] = new String[] {};
            String __excepted[] = new String[] {};
            doTest(rules, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String[] rules, String[] __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        Lottery instance = new Lottery();
        String[] __result = new String[0];
        try {
            __result = instance.sortByOdds(rules);
        } catch (Throwable e) {
            exception = e;
        }
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;

        nAll++;
        System.err.print(String.format("  Testcase #%d ... ", caseNo));

        if (exception != null) {
            System.err.println("RUNTIME ERROR!");
            exception.printStackTrace();
        } else if (equals(__result, __expected)) {
            System.err.println("PASSED! "
                    + String.format("(%.2f seconds)", elapsed));
            nPassed++;
        } else {
            System.err.println("FAILED! "
                    + String.format("(%.2f seconds)", elapsed));
            System.err.println("           Expected: " + toString(__expected));
            System.err.println("           Received: " + toString(__result));
        }
    }

    static int nExample = 3;
    static int nAll = 0, nPassed = 0;

    static boolean equals(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; ++i)
            if (a[i] == null || b[i] == null || !a[i].equals(b[i]))
                return false;
        return true;
    }

    static String toString(String[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0)
                sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString() + " ]";
    }

    public static void main(String[] args) {
        System.err.println("Lottery (550 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374526082;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 550 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
