public class ExerciseMachine {
    public int getPercentages(String time) {
        String[] split = time.split(":");
        int h = Integer.valueOf(split[0]);
        int m = Integer.valueOf(split[1]);
        int s = Integer.valueOf(split[2]);

        int seconds = s + 60 * m + 3600 * h;

        int sum = 0;
        for (int i = 1; i < seconds; i++) {
            if (i * 100 % seconds == 0) {
                sum++;
            }
        }

        return sum;
    }

    // CUT begin
    static void runTestcase(int __case) {
        switch (__case) {
        // Your custom testcase goes here
        case -1: {
            String time = "11:31:40";
            int __expected = 99;
            doTest(time, __expected, __case);
            break;
        }
        case 0: {
            String time = "00:30:00";
            int __excepted = 99;
            doTest(time, __excepted, __case);
            break;
        }
        case 1: {
            String time = "00:28:00";
            int __excepted = 19;
            doTest(time, __excepted, __case);
            break;
        }
        case 2: {
            String time = "23:59:59";
            int __excepted = 0;
            doTest(time, __excepted, __case);
            break;
        }
        case 3: {
            String time = "00:14:10";
            int __excepted = 49;
            doTest(time, __excepted, __case);
            break;
        }
        case 4: {
            String time = "00:19:16";
            int __excepted = 3;
            doTest(time, __excepted, __case);
            break;
        }
        default:
            break;
        }
    }

    static void doTest(String time, int __expected, int caseNo) {
        long startTime = System.currentTimeMillis();
        Throwable exception = null;
        ExerciseMachine instance = new ExerciseMachine();
        int __result = 0;
        try {
            __result = instance.getPercentages(time);
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
        System.err.println("ExerciseMachine (500 Points)");
        System.err.println();
        if (args.length == 0)
            for (int i = -1; i < nExample; ++i)
                runTestcase(i);
        else
            for (int i = 0; i < args.length; ++i)
                runTestcase(Integer.parseInt(args[i]));
        System.err.println(String.format("%nPassed : %d/%d cases", nPassed,
                nAll));

        int T = (int) (System.currentTimeMillis() / 1000) - 1369687955;
        double PT = T / 60.0, TT = 75.0;
        System.err.println(String.format(
                "Time   : %d minutes %d secs%nScore  : %.2f points", T / 60,
                T % 60, 500 * (0.3 + (0.7 * TT * TT)
                        / (10.0 * PT * PT + TT * TT))));
    }
    // CUT end
}
