public class VendingMachine {
    private int[][] machine;
    private int rows, cols;
    private int sumi;

    public int motorUse(String[] prices, String[] purchases) {
        rows = prices.length;
        machine = new int[rows + 1][];
        sumi = prices.length;
        for (int i = 0; i < rows; i++) {
            String[] strVals = prices[i].split(" ");
            machine[i] = new int[strVals.length];
            for (int j = 0; j < strVals.length; j++) {
                machine[i][j] = Integer.valueOf(strVals[j]);
            }
        }
        cols = machine[0].length;
        machine[sumi] = new int[cols];

        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += machine[i][j];
            }
            machine[sumi][j] = sum;
        }

        int max = getMaxColumn();
        int seconds = getRotateTime(0, max);
        int currentColumn = max;
        int lastMinute = Integer.valueOf(purchases[0].split(":")[1]);

        for (int i = 0; i < purchases.length; i++) {
            String[] coordsMinute = purchases[i].split(":");
            String[] coords = coordsMinute[0].split(",");
            int row = Integer.valueOf(coords[0]);
            int col = Integer.valueOf(coords[1]);
            int minute = Integer.valueOf(coordsMinute[1]);

            if (minute - lastMinute >= 5) {
                max = getMaxColumn();
                seconds += getRotateTime(currentColumn, max);
                currentColumn = max;
            }

            if (machine[row][col] == 0) {
                return -1;
            }
            seconds += getRotateTime(currentColumn, col);
            currentColumn = col;
            machine[sumi][col] -= machine[row][col];
            machine[row][col] = 0;
            lastMinute = minute;
        }

        seconds += getRotateTime(currentColumn, getMaxColumn());

        return seconds;
    }

    private int getRotateTime(int currentColumn, int destinationColumn) {
        int abs = Math.abs(destinationColumn - currentColumn);
        return Math.min(abs, cols - abs);
    }

    private int getMaxColumn() {
        int maxi = 0;
        int max = machine[sumi][0];
        for (int i = 1; i < machine[0].length; i++) {
            if (machine[sumi][i] > max) {
                maxi = i;
                max = machine[sumi][i];
            }
        }
        return maxi;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1:
            // doTest(prices, purchases, expected, __case);
            break;

        case 0: {
            String prices[] = new String[] { "100 100 100" };
            String purchases[] = new String[] { "0,0:0", "0,2:5", "0,1:10" };
            int __excepted = 4;
            doTest(prices, purchases, __excepted, __case);
            break;
        }
        case 1: {
            String prices[] = new String[] { "100 200 300 400 500 600" };
            String purchases[] = new String[] { "0,2:0", "0,3:5", "0,1:10",
                    "0,4:15" };
            int __excepted = 17;
            doTest(prices, purchases, __excepted, __case);
            break;
        }
        case 2: {
            String prices[] = new String[] { "100 200 300 400 500 600" };
            String purchases[] = new String[] { "0,2:0", "0,3:4", "0,1:8",
                    "0,4:12" };
            int __excepted = 11;
            doTest(prices, purchases, __excepted, __case);
            break;
        }
        case 3: {
            String prices[] = new String[] { "100 100 100" };
            String purchases[] = new String[] { "0,0:10", "0,0:11" };
            int __excepted = -1;
            doTest(prices, purchases, __excepted, __case);
            break;
        }
        case 4: {
            String prices[] = new String[] { "100 200 300", "600 500 400" };
            String purchases[] = new String[] { "0,0:0", "1,1:10", "1,2:20",
                    "0,1:21", "1,0:22", "0,2:35" };
            int __excepted = 6;
            doTest(prices, purchases, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String[] prices, String[] purchases, int __expected,
            int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        VendingMachine instance = new VendingMachine();
        int __result = 0;
        try {
            __result = instance.motorUse(prices, purchases);
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
        System.err.println("VendingMachine (1100 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1369688383;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 1100 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
