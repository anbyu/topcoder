public class EnclosingTriangleColorful {
    public int getNumber(int m, int[] x, int[] y) {
        int triangles = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                if (side(i, 0, 0, j, x, y)) {
                    for (int k = 1; k < m; k++) {
                        if (side(0, j, k, m, x, y) && side(k, m, i, 0, x, y)) {
                            triangles++;
                        }
                    }

                    for (int k = 1; k < m; k++) {
                        if (side(0, j, m, k, x, y) && side(m, k, i, 0, x, y)) {
                            triangles++;
                        }
                    }
                } else {
                    break;
                }
            }

            for (int j = 1; j < m; j++) {
                if (side(i, 0, j, m, x, y)) {
                    for (int k = 1; k < m; k++) {
                        if (side(j, m, m, k, x, y) && side(m, k, i, 0, x, y)) {
                            triangles++;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                if (side(0, i, j, m, x, y)) {
                    for (int k = 1; k < m; k++) {
                        if (side(j, m, m, k, x, y) && side(m, k, 0, i, x, y)) {
                            triangles++;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return triangles;
    }

    private boolean side(int x1, int y1, int x2, int y2, int[] x, int[] y) {
        for (int i = 0; i < y.length; i++) {
            if (cp(x1, y1, x2, y2, x[i], y[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int cp(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(m, x, y, expected, __case);
            break;

        case 0: {
            int m = 4;
            int x[] = new int[] { 1, 2, 3 };
            int y[] = new int[] { 1, 3, 2 };
            int __excepted = 8;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        case 1: {
            int m = 7;
            int x[] = new int[] { 1, 1, 6, 6 };
            int y[] = new int[] { 1, 6, 1, 6 };
            int __excepted = 0;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        case 2: {
            int m = 4;
            int x[] = new int[] { 2 };
            int y[] = new int[] { 2 };
            int __excepted = 72;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        case 3: {
            int m = 10;
            int x[] = new int[] { 2, 6, 7, 6 };
            int y[] = new int[] { 7, 7, 9, 3 };
            int __excepted = 52;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        case 4: {
            int m = 15;
            int x[] = new int[] { 7, 6, 5, 4, 3 };
            int y[] = new int[] { 1, 4, 7, 10, 13 };
            int __excepted = 150;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        case 5: {
            int m = 300;
            int x[] = new int[] { 117, 183, 181, 118, 132, 128, 184, 150, 168,
                    121, 179, 132, 168, 182, 119, 117, 180, 120, 175, 177, 116,
                    175, 128, 163, 181, 178, 123, 118, 172, 143, 163, 157, 179,
                    122, 121, 119, 157, 122, 150, 180, 137, 177, 125, 123, 172,
                    125, 137, 143, 120, 178 };
            int y[] = new int[] { 157, 157, 132, 163, 181, 180, 150, 116, 181,
                    125, 125, 119, 119, 163, 132, 143, 172, 172, 179, 178, 150,
                    121, 120, 118, 168, 123, 178, 137, 120, 117, 182, 117, 175,
                    177, 175, 168, 183, 123, 184, 128, 118, 122, 179, 122, 180,
                    121, 182, 183, 128, 177 };
            int __excepted = 21690886;
            doTest(m, x, y, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(int m, int[] x, int[] y, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        EnclosingTriangleColorful instance = new EnclosingTriangleColorful();
        int __result = 0;
        try {
            __result = instance.getNumber(m, x, y);
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
        System.err.println("EnclosingTriangleColorful (1000 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1374247425;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1000 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
